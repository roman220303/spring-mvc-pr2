package ua.roman.springmvcpr2.models;

public class Seller {
    private String name;
    private int id;

    public Seller(){

    }

    public Seller(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addAvto(){

    }

    public void changeAvto(){

    }

    public void deleteAvto(){

    }

}
