package ua.roman.springmvcpr2.models;

public class Manager {
    private String name;
    private int id;

    public Manager(String name, int id_manager) {
        this.name = name;
        this.id = id_manager;
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

    public void enterAvtoNewCourse(){

    }

    public void enterManuallyNewCourse(){
        float euro;
        float dollar;
    }
}
