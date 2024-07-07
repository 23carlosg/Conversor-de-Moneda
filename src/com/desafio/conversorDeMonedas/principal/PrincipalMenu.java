package com.desafio.conversorDeMonedas.principal;

import com.desafio.conversorDeMonedas.modelo.DatosRatioConversion;
import com.desafio.conversorDeMonedas.servicio.CalculoRatio;
import com.desafio.conversorDeMonedas.servicio.ConsumoApi;

import java.util.Scanner;

public class PrincipalMenu {
    Scanner lectura;
    boolean seguir;

    public PrincipalMenu() {
        this.lectura = new Scanner(System.in);
        this.seguir = true;
    }

    public void menu() {
        while(seguir) {
            System.out.println("**********************************************");
            System.out.println("Sea bienvenido/a al Conversor de Monedas\n");
            System.out.println("1) Dolar ->> Peso argentino");
            System.out.println("2) Peso argentino ->> Dolar");
            System.out.println("3) Dolar ->> Real brasileño");
            System.out.println("4) Real brasileño ->> Dolar");
            System.out.println("5) Dolar ->> Peso colombiano");
            System.out.println("6) Peso colombiano ->> Dolar");
            System.out.println("7) Salir");
            System.out.println("Elija una opción válida:");
            var opcion = lectura.nextInt();
            String base, objetivo;
            switch (opcion) {
                case 1:
                    base = "USD";
                    objetivo = "ARS";
                    mostrarCalculo(base, objetivo);
                    break;
                case 2:
                    base = "ARS";
                    objetivo = "USD";
                    mostrarCalculo(base, objetivo);
                    break;
                case 3:
                    base = "USD";
                    objetivo = "BRL";
                    mostrarCalculo(base, objetivo);
                    break;
                case 4:
                    base = "BRL";
                    objetivo = "USD";
                    mostrarCalculo(base, objetivo);
                    break;
                case 5:
                    base = "USD";
                    objetivo = "COP";
                    mostrarCalculo(base, objetivo);
                    break;
                case 6:
                    base = "COP";
                    objetivo = "USD";
                    mostrarCalculo(base, objetivo);
                    break;
                case 7:
                    seguir = false;
                    System.out.println("Saliendo del programa...");
                    System.out.println("**********************************************\n");
                    break;
                default:
                    System.out.println("Opción no válida\n");
                    break;
            }
        }
    }

    public static void mostrarCalculo(String base, String objetivo) {
        Scanner lectura = new Scanner(System.in);
        double monto;
        DatosRatioConversion drc = ConsumoApi.consumir(base, objetivo);
        System.out.println("Ingrese el valor que desea convertir:");
        monto = lectura.nextDouble();
        var resultado = CalculoRatio.calcular(monto, drc);
        System.out.println("El valor " + monto + " " + base
                + " corresponde al valor final de ->>> " + resultado + " " + objetivo);
    }
}


