package com.dam.mgr.buffet;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Contenedor {
    private Queue<Integer> platos;

    private Semaphore semPlatos;
    private Semaphore semHuecos;
    private Semaphore mutex;

    private int contadorIdPlato = 0;

    public Contenedor(int capacidad) {
        this.platos = new LinkedList<>();
        this.semPlatos = new Semaphore(0);
        this.semHuecos = new Semaphore(capacidad);
        this.mutex = new Semaphore(1);
    }

    public void reponer(int cantidad) throws InterruptedException {
        semHuecos.acquire(cantidad);

        mutex.acquire();
        for (int i = 0; i < cantidad; i++) {
            contadorIdPlato++;
            platos.add(contadorIdPlato);
        }
        System.out.println("Cocinero ha repuesto " + cantidad + " platos. Mostrador: " + platos);
        mutex.release();

        semPlatos.release(cantidad);
    }

    public void coger() throws InterruptedException {
        semPlatos.acquire();

        mutex.acquire();
        Integer platoComido = platos.poll();
        System.out.println("Comensal  ha comido el plato #" + platoComido + " Quedan: " + platos.size());
        mutex.release();
        semHuecos.release();
    }
}