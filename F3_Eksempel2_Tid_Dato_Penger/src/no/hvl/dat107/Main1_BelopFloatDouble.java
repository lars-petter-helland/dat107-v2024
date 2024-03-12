package no.hvl.dat107;

public class Main1_BelopFloatDouble {

    public static void main(String[] args) {
    	
    	String printformat = "%.17f%n";

        System.out.printf("4.2f        => " + printformat, 4.2f);
        System.out.printf("0.2f        => " + printformat, 0.2f);
        System.out.println();
        
        System.out.printf("4.0f        => " + printformat, 4.0f);
        System.out.printf("4.2f - 0.2f => " + printformat, 4.2f - 0.2f);
        System.out.println();
        
        System.out.printf("3.0         => " + printformat, 3.0);
        System.out.printf("6.1 - 3.1   => " + printformat, 6.1 - 3.1);
        System.out.println();
        
        System.out.printf("0.3         => " + printformat, 0.3);
        System.out.printf("3 * 0.1     => " + printformat, 3 * 0.1);
        System.out.println();
        
        System.out.printf("0.1f        => " + printformat, 0.1f);
    	


    }

}
