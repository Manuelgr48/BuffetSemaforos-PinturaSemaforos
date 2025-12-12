package com.dam.mgr.buffet;

import java.util.concurrent.Semaphore;

public class Contenedor {
    private int platos;
    private Semaphore semPlatos;
    private Semaphore semHuecos;
    private Semaphore mutex;

    public Contenedor(int capacidad) {
        this.platos = 0;
        this.semPlatos = new Semaphore(0);
        this.semHuecos = new Semaphore(capacidad);
        this.mutex = new Semaphore(1);
    }

    public void reponer(int cantidad) throws InterruptedException {
        semHuecos.acquire(cantidad);
        mutex.acquire();

        platos += cantidad;
        System.out.println("Cocinero ha repuesto " + cantidad + " platos. Total: " + platos);

        mutex.release();
        semPlatos.release(cantidad);
    }

    public void coger() throws InterruptedException {
        semPlatos.acquire();
        mutex.acquire();

        platos--;
        System.out.println("Comensal ha cogido un plato. Quedan: " + platos);

        mutex.release();
        semHuecos.release();
    }
}