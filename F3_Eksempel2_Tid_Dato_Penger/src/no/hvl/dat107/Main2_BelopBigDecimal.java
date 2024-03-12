package no.hvl.dat107;

import java.math.BigDecimal;

public class Main2_BelopBigDecimal {

    public static void main(String[] args) {

    	String printformat = "%.17f%n";
    	
        // IKKE OK BigDecimal fireKronerOgTiOre = new BigDecimal(4.10);
        // OK      BigDecimal fireKronerOgTiOre = new BigDecimal("4.10");
        // OK      BigDecimal fireKronerOgTiOre = BigDecimal.valueOf(4.10);

        BigDecimal fireKronerOgTiOre = BigDecimal.valueOf(4.10);
        BigDecimal tiOre = BigDecimal.valueOf(0.10);

        BigDecimal fireKroner = fireKronerOgTiOre.subtract(tiOre);

        // Hva blir skrevet ut på skjermen?
        System.out.printf("BD(4.10)    => " + printformat, fireKronerOgTiOre);
        System.out.printf("BD(0.10)    => " + printformat, tiOre);
        System.out.printf("BD(4.1-0.1) => " + printformat, fireKroner);
    }

}
