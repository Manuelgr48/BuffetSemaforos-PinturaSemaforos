package com.dam.mgr.buffet;

public class Principal {
    public static void main(String[] args) {
        Contenedor contenedor = new Contenedor(20);

        Cocinero cocinero = new Cocinero(contenedor);
        cocinero.start();

        for (int i = 0; i < 5; i++) {
            new Comensal(contenedor).start();
        }
    }
}