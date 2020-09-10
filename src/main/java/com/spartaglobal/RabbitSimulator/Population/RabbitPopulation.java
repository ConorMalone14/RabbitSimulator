package com.spartaglobal.RabbitSimulator.Population;

import java.math.BigInteger;

public class RabbitPopulation extends Population{

    BigInteger eatenRabbits = BigInteger.ZERO;

    public static void removeEatenRabbits() {

    }

    public static BigInteger getEligibleMales() {

        BigInteger eligibleMales = BigInteger.ZERO;
        int generation = 1;

        for (BigInteger i : getAliveMales()) {
            if (generation >= 3) {
                eligibleMales = eligibleMales.add(i);
            }
            generation++;
        }
        return eligibleMales;
    }

    public static BigInteger getEligibleFemales() {

        BigInteger eligibleFemales = BigInteger.ZERO;
        int generation = 1;

        for (BigInteger i : getAliveFemales()) {
            if (generation >= 4) {
                eligibleFemales = eligibleFemales.add(i);
            }
            generation++;
        }
        return eligibleFemales;
    }

}
