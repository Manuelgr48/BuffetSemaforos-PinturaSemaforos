package com.dam.mgr.pintura;

public class Principal {
    public static void main(String[] args) {
        Deposito cian = new Deposito(1, "Cian");
        Deposito magenta = new Deposito(2, "Magenta");
        Deposito amarillo = new Deposito(3, "Amarillo");

        Persona personaRojo = new Persona("Persona A", "Rojo", amarillo, magenta);
        Persona personaAzul = new Persona("Persona B", "Azul", magenta, cian);
        Persona personaVerde = new Persona("Persona C", "Verde", amarillo, cian);

        personaRojo.start();
        personaAzul.start();
        personaVerde.start();
    }
}