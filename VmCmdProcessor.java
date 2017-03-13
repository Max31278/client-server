/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author 000
 */
public class VmCmdProcessor {

    private VmStorage vm;
    private VmAdder adder;

    public VmCmdProcessor(VmStorage vm) {
        this.vm = vm;
        adder = new VmAdder(this.vm);
    }

    public void addVM(String name, String description, String nameDescriptor) throws SAXException, IOException, ParserConfigurationException, VmStorageAddedException {
        adder.addVM(name, description, nameDescriptor);
    }

    public void removeVM(String name) throws VmStorageAddedException {
        vm.removeVm(name);
    }

    public HashMap<String, VM> listVM(int number) {
        return vm.listVms(number);
    }

    public VM getVM(String name) throws VmStorageAddedException {
        return vm.getVm(name);
    }

}
