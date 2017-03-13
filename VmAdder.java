/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author 000
 */
public class VmAdder {

    private VmStorage storage;

    public VmAdder(VmStorage storage) {
        this.storage = storage;
    }

    public void addVM(String name, String description, String nameDescriptor) throws ParserConfigurationException, SAXException, IOException, VmStorageAddedException {
        XmlDescriptorReader descriptor = new XmlDescriptorReader();
        XmlDescriptor xmlDescriptor = descriptor.getDescriptor(nameDescriptor);
        VM virtualMachine = new VM(name, xmlDescriptor.getNameOS(), xmlDescriptor.getVendor(), xmlDescriptor.getVersion(),
                description, nameDescriptor, xmlDescriptor.getCpuCore(), xmlDescriptor.getRam(), xmlDescriptor.getCapacityHdd());
        storage.addVm(virtualMachine);
    }
}
