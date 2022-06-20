package ua.roman.springmvcpr2.models;

public class Avto {

    private String marka;
    private int id;
    private int number;
    private float price;
    private int currency;

    public Avto(){

    }

    public Avto(String marka, int id, int number, float price, int currency) {
        this.marka = marka;
        this.id = id;
        this.number = number;
        this.price = price;
        this.currency = currency;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }
}
