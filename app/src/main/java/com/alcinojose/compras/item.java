package com.alcinojose.compras;

public class item {
    private int id;
    private String name;
    private String hora;

    public item(int id, String name, String hora) {
        this.id = id;
        this.name = name;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}