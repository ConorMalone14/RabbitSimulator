package com.spartaglobal.RabbitSimulator.Population;

import java.math.BigInteger;

public class FoxPopulation extends Population {

    static {

    }

    public static void addNextGeneration() {

    }

    public static BigInteger getEligibleMales() {

        BigInteger eligibleMales = BigInteger.ZERO;
        int generation = 1;

        for (BigInteger i : getAliveMales()) {
            if (generation >= 12) {
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
            if (generation >= 13) {
                eligibleFemales = eligibleFemales.add(i);
            }
            generation++;
        }
        return eligibleFemales;
    }

    public static void initialiseArrayDequeues() {

    }


}
