package main;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Converter converter = new Converter();

        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 7){
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija una opción valida");

            option = scanner.nextInt();

            switch (option){
                case 1:
                    System.out.println("Ingrese el valor en dolares");
                    double dolar = scanner.nextDouble();
                    System.out.println("El valor en pesos argentinos es: "+converter.convert(dolar, "USD", "ARS") );
                    break;
                case 2:
                    System.out.println("Ingrese el valor en pesos argentinos");
                    double pesos = scanner.nextDouble();
                    System.out.println("El valor en dolares es: " + converter.convert(pesos, "ARS", "USD"));
                    break;
                case 3:
                    System.out.println("Ingrese el valor en dolares");
                    double dolar2 = scanner.nextDouble();
                    System.out.println("El valor en reales es: "+converter.convert(dolar2, "USD", "BRL"));
                    break;
                case 4:
                    System.out.println("Ingrese el valor en reales");
                    double reales = scanner.nextDouble();
                    System.out.println("El valor en dolares es: "+converter.convert(reales, "BRL", "USD"));
                    break;
                case 5:
                    System.out.println("Ingrese el valor en dolares");
                    double dolar3 = scanner.nextDouble();
                    System.out.println("El valor en pesos colombianos es: "+converter.convert(dolar3, "USD", "COP"));
                    break;
                case 6:
                    System.out.println("Ingrese el valor en pesos colombianos");
                    double colombianos = scanner.nextDouble();
                    System.out.println("El valor en dolares es: "+converter.convert(colombianos, "COP", "USD"));
                    break;
                case 7:
                    System.out.println("Gracias por usar el programa");
                    System.exit(0);
                    break;
            }

        }

    }
}
