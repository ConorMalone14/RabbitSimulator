package com.spartaglobal.RabbitSimulator.Population;

import java.math.BigInteger;
import java.util.ArrayDeque;

public abstract class Population {

    private static ArrayDeque<BigInteger> aliveMales = new ArrayDeque<>(60);
    private static ArrayDeque<BigInteger> aliveFemales = new ArrayDeque<>(60);
    private static BigInteger deadRabbits = BigInteger.ZERO;

    public static BigInteger getEligibleMales() {

        return BigInteger.ZERO;
    }

    public static BigInteger getEligibleFemales() {

        return BigInteger.ZERO;
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

    public static ArrayDeque<BigInteger> getAliveMales() {
        return aliveMales;
    }

    public static ArrayDeque<BigInteger> getAliveFemales() {
        return aliveFemales;
    }

    public static BigInteger getDeadRabbits() {
        return deadRabbits;
    }

    public static void setAliveMales(ArrayDeque<BigInteger> aliveMales) {
        Population.aliveMales = aliveMales;
    }

    public static void setAliveFemales(ArrayDeque<BigInteger> aliveFemales) {
        Population.aliveFemales = aliveFemales;
    }

    public static void setDeadRabbits(BigInteger deadRabbits) {
        Population.deadRabbits = deadRabbits;
    }
}
