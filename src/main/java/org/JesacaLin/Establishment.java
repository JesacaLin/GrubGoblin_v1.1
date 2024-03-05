package org.JesacaLin;

public class Establishment implements ReadableWriteableWithID {
    private String name;
    private String address;
    private String id;
    private double coordinates;

    public Establishment(String name, String address) {
        this.id = getId();
        this.name = name;
        this.address = address;
        this.coordinates = getCoordinates();
    }

    @Override
    public String getId() {
        return IDGenerator.generateID("establishment");
    }

    public double getCoordinates() {
        return AddressConverter.getLatitude() + AddressConverter.getLongitude();
    }

    public String getName() {return name;}
    public String getAddress() {
        return address;
    }
    public void setName(String name) {this.name = name;}
    public void setAddress(String address) {this.address = address; }

    @Override
    public String toString() {
        return id + " , " + name + " , " + address + " , " + coordinates;
    }
}
