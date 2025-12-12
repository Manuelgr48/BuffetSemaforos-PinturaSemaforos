package com.dam.mgr.buffet;

import java.util.Random;

public class Cocinero extends Thread {
    private Contenedor contenedor;
    private Random random;

    public Cocinero(Contenedor contenedor) {
        this.contenedor = contenedor;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                int tiempoReponer = 1 + random.nextInt(5);
                Thread.sleep(tiempoReponer);

                contenedor.reponer(10);

                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}