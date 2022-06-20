package ua.roman.springmvcpr2.models;

public class Currency {
    int id;
    float value;
    String name;

    public Currency() {
    }

    public Currency(int id, float value, String name) {
        this.id = id;
        this.value = value;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
