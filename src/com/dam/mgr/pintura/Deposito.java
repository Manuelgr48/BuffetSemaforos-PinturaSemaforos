package com.dam.mgr.pintura;

import java.util.concurrent.Semaphore;

public class Deposito {
    private int id;
    private String color;
    private Semaphore semaforo;

    public Deposito(int id, String color) {
        this.id = id;
        this.color = color;
        this.semaforo = new Semaphore(1);
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public void ocupar() throws InterruptedException {
        semaforo.acquire();
    }

    public void liberar() {
        semaforo.release();
    }
}