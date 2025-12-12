package com.dam.mgr.buffet;

import java.util.Random;

public class Comensal extends Thread {
    private Buffet buffet;
    private Random random;

    public Comensal(Buffet buffet) {
        this.buffet = buffet;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                buffet.cogerPlato();

                int tiempoComer = 1 + random.nextInt(3);
                Thread.sleep(tiempoComer);

                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}