/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 *
 * @author MaxK
 */
public class BinaryServer extends Thread {

    private Socket client;

    public BinaryServer(Socket client) {
        this.client = client;
    }

    public static void main(String[] args) throws IOException {
        int port = 4444;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            for (;;) {
                Socket clientSocket = serverSocket.accept();
                BinaryServer server = new BinaryServer(clientSocket);
                server.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        try {
            System.out.println("Connected!");
            boolean check = false;
            VmStorage storage = new VmStorage();
            VmCmdProcessor cmd = new VmCmdProcessor(storage);
            VmStorageOperator storageOperator = new VmStorageOperator(storage);
            storageOperator.load();
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            while (check == false) {
                try {
                    String command = in.readUTF();
                    String[] com = command.split(" ");
                    switch (com[0]) {
                        case "addVM": {
                            if (checkName(com[1])) {
                                String name = com[1];
                                String description = com[2];
                                String nameDescriptor = com[3];
                                cmd.addVM(name, description, nameDescriptor);
                                out.writeUTF("It's OK");
                                out.flush();
                            } else {
                                throw new InvalidNameException();
                            }
                        }
                        break;
                        case "removeVM": {
                            if (checkName(com[1])) {
                                String name = com[1];
                                cmd.removeVM(name);
                                out.writeUTF("It's OK");
                                out.flush();
                            } else {
                                throw new InvalidNameException();
                            }
                        }
                        break;
                        case "getVM": {
                            if (checkName(com[1])) {
                                String name = com[1];
                                VM virtualMachine = cmd.getVM(name);
                                out.writeUTF(virtualMachine.toString());
                                out.flush();
                            } else {
                                throw new InvalidNameException();
                            }
                        }
                        break;
                        case "get": {
                            if (Pattern.matches("\\d*", com[1])) {
                                int number = Integer.parseInt(com[1]);
                                HashMap<String, VM> map = cmd.listVM(number);
                                StringBuilder vms = new StringBuilder();
                                for (HashMap.Entry<String, VM> element : map.entrySet()) {
                                    vms.append(map.get(element.getKey()).toString());
                                }
                                out.writeUTF(vms.toString());
                            } else {
                                out.writeUTF("Не верно введен параметр");
                            }
                            out.flush();
                        }
                        break;
                        case "exit": {
                            storageOperator.save();
                            check = true;
                            out.close();
                            in.close();
                            client.close();
                        }
                        break;
                        default: {
                            out.writeUTF("Команда не распознана!!!!");
                            out.flush();
                        }
                        break;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    out.writeUTF("Введены не все параметры");
                } catch (VmStorageAddedException e) {
                    out.writeUTF(e.getMessage().toString());
                } catch (InvalidNameException e) {
                    out.writeUTF("Имя введено не корректно");
                } catch (FileNotFoundException e) {
                    out.writeUTF(e.getMessage().toString());
                } catch (Exception e) {
                    out.writeUTF(e.getMessage().toString());
                } finally {
                    out.flush();
                }
            }
            System.out.println("End connection!");
            in.close();
            out.close();
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkName(String name) {
        return (Pattern.matches("[\\w]*[_]*[\\w]*", name));// Нужно придумать регулярное выражение
    }
}
