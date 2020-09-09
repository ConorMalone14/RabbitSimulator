package com.spartaglobal.RabbitSimulator.Rabbit;

import java.math.BigInteger;
import java.util.ArrayDeque;

public class RabbitPopulation {



    public static ArrayDeque<BigInteger> getAliveMales() {
        return aliveMales;
    }

    public static ArrayDeque<BigInteger> getAliveFemales() {
        return aliveFemales;
    }

    public static BigInteger getDeadRabbits() {
        return deadRabbits;
    }

    private static ArrayDeque<BigInteger> aliveMales = new ArrayDeque<>(60);
    private static ArrayDeque<BigInteger> aliveFemales = new ArrayDeque<>(60);
    private static BigInteger deadRabbits = BigInteger.ZERO;

    public static BigInteger getTotalRabbits() {
        return getTotalMales().add(getTotalFemales());
    }

    public static BigInteger getTotalMales() {

        BigInteger malePopulation = BigInteger.ZERO;
        for (BigInteger i : aliveMales) {
            malePopulation = malePopulation.add(i);
        }
        return malePopulation;
    }

    public static BigInteger getTotalFemales() {

        BigInteger femalePopulation = BigInteger.ZERO;
        for (BigInteger i : aliveFemales) {
            femalePopulation = femalePopulation.add(i);
        }
        return femalePopulation;
    }

    public static BigInteger getTotalDead() {
        return deadRabbits;
    }

    public static BigInteger getEligibleMales() {

        BigInteger eligibleMales = BigInteger.ZERO;
        int generation = 1;

        for (BigInteger i : aliveMales) {
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

        for (BigInteger i : aliveFemales) {
            if (generation >= 4) {
                eligibleFemales = eligibleFemales.add(i);
            }
            generation++;
        }
        return eligibleFemales;
    }

    public static void addNextGeneration(BigInteger newMaleRabbits, BigInteger newFemaleRabbits) {
        deadRabbits = deadRabbits.add(aliveFemales.pollLast());
        deadRabbits = deadRabbits.add(aliveMales.pollLast());

        aliveMales.addFirst(newMaleRabbits);
        aliveFemales.addFirst(newFemaleRabbits);
    }

    // for testing use
    public static void resetAllArrayDequeues() {
        aliveMales.clear();
        aliveFemales.clear();
        initialiseArrayDequeues();
    }

    //Initialising the ArrayDeque
    public static void initialiseArrayDequeues() {
        for (int i = 0;i < 59;i++) {
            aliveMales.add(BigInteger.ZERO);
            aliveFemales.add(BigInteger.ZERO);
        }
        aliveMales.addFirst(BigInteger.ONE);
        aliveFemales.addFirst(BigInteger.ONE);
    }

    static {
        initialiseArrayDequeues();
    }

}
