package com.dam.mgr.pintura;

import java.util.Random;

public class Persona extends Thread {
    private String nombre;
    private String colorSecundario;
    private Deposito deposito1;
    private Deposito deposito2;
    private Random random;

    public Persona(String nombre, String colorSecundario, Deposito d1, Deposito d2) {
        this.nombre = nombre;
        this.colorSecundario = colorSecundario;
        this.random = new Random();

        if (d1.getId() < d2.getId()) {
            this.deposito1 = d1;
            this.deposito2 = d2;
        } else {
            this.deposito1 = d2;
            this.deposito2 = d1;
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                deposito1.ocupar();
                deposito2.ocupar();

                System.out.println(nombre + " mezclando " + deposito1.getColor() + " y " + deposito2.getColor() + " para hacer " + colorSecundario);

                int tiempoMezcla = 100 + random.nextInt(401);
                Thread.sleep(tiempoMezcla);

                deposito2.liberar();
                deposito1.liberar();

                System.out.println(nombre + " terminó de mezclar. Descansando.");

                int tiempoEspera = 1000 + random.nextInt(1001);
                Thread.sleep(tiempoEspera);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}