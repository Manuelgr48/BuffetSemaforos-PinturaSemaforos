package com.dam.mgr.buffet;

import java.util.Random;

public class Cocinero extends Thread {
    private Buffet buffet;
    private Random random;

    public Cocinero(Buffet buffet) {
        this.buffet = buffet;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                int tiempoReponer = 1 + random.nextInt(5);
                Thread.sleep(tiempoReponer);

                buffet.reponerPlatos(10);

                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}