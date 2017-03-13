/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.Serializable;

/**
 *
 * @author 000
 */
public class VM implements Serializable {

    private String name;
    private String nameOS;
    private String vendor;
    private String version;
    private String path;
    private String description;
    private int cpuCore;
    private int ram;
    private int capacityHdd;

    public VM(String name, String nameOS, String vendor, String version, String description, String path, int cpuCore, int ram, int capacityHdd) {
        this.name = name;
        this.nameOS = nameOS;
        this.vendor = vendor;
        this.version = version;
        this.description = description;
        this.path = path;
        this.capacityHdd = capacityHdd;
        this.cpuCore = cpuCore;
        this.ram = ram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOS() {
        return nameOS;
    }

    public void setNameOS(String nameOS) {
        this.nameOS = nameOS;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getCpuCore() {
        return cpuCore;
    }

    public void setCpuCore(int cpuCore) {
        this.cpuCore = cpuCore;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getCapacityHdd() {
        return capacityHdd;
    }

    public void setCapacityHdd(int capacityHdd) {
        this.capacityHdd = capacityHdd;
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("************************" + "\n");
        buf.append("name: " + name + "\n");
        buf.append("nameOS: " + nameOS + "\n");
        buf.append("vendor: " + vendor + "\n");
        buf.append("version: " + version + "\n");
        buf.append("path: " + path + "\n");
        buf.append("************************" + "\n");
        return buf.toString();
    }
}
