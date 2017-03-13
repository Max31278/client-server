/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 000
 */
public class VmStorageOperator {

    private VmStorage storage;

    public VmStorageOperator(VmStorage storage) {
        this.storage = storage;
    }

    public void save() throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("VirtualMachine"));
        out.writeObject(storage.getVms());
        out.close();
    }

    public void load() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("VirtualMachine"));
        HashMap<String, VM> map = (HashMap<String, VM>) in.readObject();
        storage.setVms(map);
    }
}
