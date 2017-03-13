/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author 000
 */
public class XmlDescriptor {

    private String nameOS;
    private String vendor;
    private String version;
    private int cpuCore;
    private int ram;
    private int capacityHdd;

    public XmlDescriptor(String nameOS, String vendor, String version, int cpuCore, int ram, int capacityHdd) {
        this.nameOS = nameOS;
        this.vendor = vendor;
        this.version = version;
        this.capacityHdd = capacityHdd;
        this.cpuCore = cpuCore;
        this.ram = ram;
    }

    public String getNameOS() {
        return nameOS;
    }

    public void setNameOS(String nameOS) {
        this.nameOS = nameOS;
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
}
