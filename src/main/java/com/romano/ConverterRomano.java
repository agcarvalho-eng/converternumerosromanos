package com.romano;

import java.util.Scanner;

/**
 * Classe para realizar a conversão entre numerais Romanos e Decimais.
 */
public class ConverterRomano {
    private static final String[] numeraisRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] numeraisDecimais = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    //Método main.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Escolha uma opção (1 - Decimal para Romano, 2 - Romano para Decimal): ");
        int escolha = scanner.nextInt();

        if (escolha == 1) {
            System.out.print("Digite um número decimal: ");
            int decimal = scanner.nextInt();
            String romano = decimalParaRomano(decimal);
            System.out.println("Número Romano: " + romano);
        } else if (escolha == 2) {
            System.out.print("Digite um número Romano: ");
            String romano = scanner.next();
            int decimal = romanoParaDecimal(romano);
            if (decimal == -1) {
                System.out.println("Número Romano inválido.");
            } else {
                System.out.println("Número Decimal: " + decimal);
            }
        } else {
            System.out.println("Escolha inválida. Use 1 para Decimal para Romano e 2 para Romano para Decimal.");
        }

        scanner.close();
    }

    //Método para converter Decimal para Romano.
    public static String decimalParaRomano(int decimal) {
        if (decimal <= 0 || decimal > 3999) {
            return "Não é possível converter o número decimal informado para algarismos romanos.";
        }

        StringBuilder romano = new StringBuilder();
        int i = 0;
        while (decimal > 0) {
            if (decimal >= numeraisDecimais[i]) {
                romano.append(numeraisRomanos[i]);
                decimal -= numeraisDecimais[i];
            } else {
                i++;
            }
        }
        return romano.toString();
    }

    //Método para converter Romano para Decimal.
    public static int romanoParaDecimal(String romano) {
        if (romano == null || !romanoValido(romano)) {
            return -1; // Valor decimal inválido
        }

        int decimal = 0;
        int valorPrevio = 0;

        for (int i = romano.length() - 1; i >= 0; i--) {
            char caracterCorrente = romano.charAt(i);
            int valorCorrente = pegarValorDecimal(caracterCorrente);

            if (valorCorrente < valorPrevio) {
                decimal -= valorCorrente;
            } else {
                decimal += valorCorrente;
            }
            valorPrevio = valorCorrente;
        }

        return decimal;
    }

    //Método para pegar o valor em decimal.
    private static int pegarValorDecimal(char caracterRomano) {
        switch (caracterRomano) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1; // Caracter romano inválido
        }
    }

    private static boolean romanoValido(String romano) {
        return romano.matches("^[IVXLCDM]*$");
    }
}