/**
 * Programa para realizar a conversão de números decimais para romanos e
 * vice-versa (intervalo permitido para a conversão dos
 * números somente entre 1 e 3998).
 */
package com.romano;
import java.util.Scanner;

/**
 * Classe para realizar a conversão entre numerais romanos e decimais.
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
    public static String decimalParaRomano(int numeroDecimal) {
        StringBuilder romano = new StringBuilder();
        if (numeroDecimal > 0 && numeroDecimal < 3999) {
            for (int i = 0; i < numeraisRomanos.length; i++) {
                if (numeroDecimal != 0) {
                    while (numeroDecimal >= numeraisDecimais[i]) {
                        romano.append(numeraisRomanos[i]);
                        numeroDecimal -= numeraisDecimais[i];
                    }
                } else {
                    break;
                }
            }
            return romano.toString();
        }else {
            throw new IllegalArgumentException("O número informado deve estar contido no intervalo entre 0 e 3999.");
        }

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
        return switch (caracterRomano) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> -1; // Caracter romano inválido
        };
    }

    private static boolean romanoValido(String romano) {
        return romano.matches("^[IVXLCDM]*$");
    }
}
