package org.JesacaLin;

import java.util.Arrays;

public class Establishment implements ReadableWriteableWithID {
    private String name;
    private String address;
    private String id;
    private double[] coordinates;

    public Establishment(String name, String address) {
        this.id = getId();
        this.name = name;
        this.address = address;
        this.coordinates = getCoordinates();
    }

    @Override
    public String getId() {
        id = IDGenerator.generateID("establishment");
        return id;
    }

    public double[] getCoordinates() {

        return AddressConverter.convertAddressToCoordinates(address);
    }

    public String getName() {return name;}
    public String getAddress() {
        return address;
    }
    public void setName(String name) {this.name = name;}
    public void setAddress(String address) {this.address = address; }

    @Override
    public String toString() {
        return id + "," + name + "," + address + "," + Arrays.toString(coordinates);
    }
}
