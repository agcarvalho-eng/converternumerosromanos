package com.romano;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class TesteSoftware {

    @Test
    public void testeSoma() {
        assertEquals("I", ConverterRomano.decimalParaRomano(1));
        assertEquals("II", ConverterRomano.decimalParaRomano(2));
        assertEquals("III", ConverterRomano.decimalParaRomano(3));
        assertEquals("IV", ConverterRomano.decimalParaRomano(4));
        assertEquals("V", ConverterRomano.decimalParaRomano(5));
        assertEquals("VI", ConverterRomano.decimalParaRomano(6));
        assertEquals("VII", ConverterRomano.decimalParaRomano(7));
        assertEquals("VIII", ConverterRomano.decimalParaRomano(8));
        assertEquals("IX", ConverterRomano.decimalParaRomano(9));
        assertEquals("X", ConverterRomano.decimalParaRomano(10));

        // Testes para verificar que não é permitida a repetição de caracteres maiores que três
        assertEquals("L", ConverterRomano.decimalParaRomano(50));
        assertEquals("CCC", ConverterRomano.decimalParaRomano(300));
        assertEquals("D", ConverterRomano.decimalParaRomano(500));
        assertEquals("MMM", ConverterRomano.decimalParaRomano(3000));
    }

    @Test
    public void testeSubtracao() {
        assertEquals("IV", ConverterRomano.decimalParaRomano(4));
        assertEquals("IX", ConverterRomano.decimalParaRomano(9));
        assertEquals("XL", ConverterRomano.decimalParaRomano(40));
        assertEquals("XC", ConverterRomano.decimalParaRomano(90));
        assertEquals("CD", ConverterRomano.decimalParaRomano(400));
        assertEquals("CM", ConverterRomano.decimalParaRomano(900));
        assertEquals("XLIV", ConverterRomano.decimalParaRomano(44));
        assertEquals("XCIII", ConverterRomano.decimalParaRomano(93));
        assertEquals("CMXCIV", ConverterRomano.decimalParaRomano(994));
        assertEquals("CMXCIX", ConverterRomano.decimalParaRomano(999));
    }

    @Test
    public void testeRepeticaoCaracteres() {
        // Teste de repetição de caracteres (soma)
        assertEquals("III", ConverterRomano.decimalParaRomano(3));
        assertEquals("VIII", ConverterRomano.decimalParaRomano(8));
        assertEquals("XIII", ConverterRomano.decimalParaRomano(13));
        assertEquals("XXII", ConverterRomano.decimalParaRomano(22));
        assertEquals("XXX", ConverterRomano.decimalParaRomano(30));

        // Teste de repetição de caracteres (subtração)
        assertEquals("CM", ConverterRomano.decimalParaRomano(900));
        assertEquals("MMMCM", ConverterRomano.decimalParaRomano(3900));
    }

    @Test
    public void testeSimbolosEspeciais() {
        // Teste de símbolos especiais (soma)
        assertEquals("V", ConverterRomano.decimalParaRomano(5));
        assertEquals("X", ConverterRomano.decimalParaRomano(10));
        assertEquals("L", ConverterRomano.decimalParaRomano(50));

        // Teste de símbolos especiais (subtração)
        assertEquals("IV", ConverterRomano.decimalParaRomano(4));
        assertEquals("IX", ConverterRomano.decimalParaRomano(9));
        assertEquals("XC", ConverterRomano.decimalParaRomano(90));
        assertEquals("CM", ConverterRomano.decimalParaRomano(900));
    }

    @Test
    public void testeValorZero() {
        // Teste para verificar se um valor decimal zero não pode ser convertido para romano.
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ConverterRomano.decimalParaRomano(0));
        assertEquals("O número informado deve estar contido no intervalo entre 0 e 3999.", exception.getMessage());
    }

    @Test
    public void testeMaiorValorDecimal() {
        // Teste para verificar se um valor decimal é maior que o maior valor correspondente em algarismos romanos
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ConverterRomano.decimalParaRomano(4000));
        assertEquals("O número informado deve estar contido no intervalo entre 0 e 3999.", exception.getMessage());
    }

}

