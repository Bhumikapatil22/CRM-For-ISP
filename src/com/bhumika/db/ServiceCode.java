package com.bhumika.db;

import java.util.Random;

public class ServiceCode {
    public static String generateServiceCode() {
        Random random = new Random();
        int serviceCode = 1000 + random.nextInt(9000); // Generates a number between 1000 and 9999
        return String.valueOf(serviceCode);
    }

    public static void main(String[] args) {
        // Example usage
        String serviceCode = generateServiceCode();
//        System.out.println("Generated Service Code: " + serviceCode);
       
    }
}
