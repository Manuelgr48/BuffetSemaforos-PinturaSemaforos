package com.dam.mgr.buffet;

import java.util.Random;

public class Comensal extends Thread {
    private Contenedor contenedor;
    private Random random;

    public Comensal(Contenedor contenedor) {
        this.contenedor = contenedor;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                contenedor.coger();

                int tiempoComer = 1 + random.nextInt(3);
                Thread.sleep(tiempoComer);

                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}