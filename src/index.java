//Restricciones del programa:
//Alto: Peso Ropa = 18 lb agua 25 litros tiempo = 4seg
//Medio: Peso Ropa = entre 10 y 17 lb, Agua = entre 15 y 24 litros, tiempo = 3seg
//Bajo: peso ropa = menor a 10 Agua = 12 litros, tiempo = 2 seg

import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ciclo (Alto, Medio, Bajo): ");
        String ciclo = scanner.nextLine();

        System.out.print("Ingrese el peso de la ropa: ");
        int pesoRopa = scanner.nextInt();

        System.out.print("Ingrese el nivel de agua: ");
        int nivelAgua = scanner.nextInt();

        Lavadora lavadora = new Lavadora(pesoRopa, nivelAgua, ciclo);
        lavadora.iniciarCiclo();
        scanner.close();
    }

}
