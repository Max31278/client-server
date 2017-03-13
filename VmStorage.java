/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author 000
 */
public class VmStorage {

    private HashMap<String, VM> map = new HashMap<String, VM>();

    public void addVm(VM virtualMachine) throws VmStorageAddedException {
        Set keys = map.keySet();
        if (keys.contains(virtualMachine.getName())) {
            throw new VmStorageAddedException("Виртуальная машина с таким именем уже существует");
        } else {
            map.put(virtualMachine.getName(), virtualMachine);
        }

    }

    public VM getVm(String name) throws VmStorageAddedException {
        Set keys = map.keySet();
        if (keys.contains(name)) {
            return map.get(name);
        } else {
            throw new VmStorageAddedException("Виртуальной машины с таким именем не существует");
        }
    }

    public HashMap<String, VM> listVms(int number) {
        HashMap newMap = new HashMap<String, VM>();
        int i = 0;
        if (map.size() <= number) {
            return map;
        } else {
            for (HashMap.Entry<String, VM> element : map.entrySet()) {
                newMap.put(element.getKey(), element.getValue());
                i++;
                if (i == number) {
                    break;
                }
            }
            return newMap;
        }
    }

    public void removeVm(String name) throws VmStorageAddedException {
        Set keys = map.keySet();
        if (keys.contains(name)) {
            map.remove(name);
        } else {
            throw new VmStorageAddedException("Виртуальной машины с таким именем не существует");
        }
    }

    public void setVms(HashMap<String, VM> map) {
        this.map = map;
    }

    public HashMap<String, VM> getVms() {
        return map;
    }
}
