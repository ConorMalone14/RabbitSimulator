package com.spartaglobal.RabbitSimulator.Population;

import java.math.BigInteger;
import java.util.ArrayDeque;

public class FoxPopulation implements Population {

    private static int generationsPerLifeSpan = 5;
    private static ArrayDeque<BigInteger> aliveMales = new ArrayDeque<>(generationsPerLifeSpan);
    private static ArrayDeque<BigInteger> aliveFemales = new ArrayDeque<>(generationsPerLifeSpan);
    private static BigInteger deadAnimals = BigInteger.ZERO;

    static {
        initArrayDequeues();
    }

    public static BigInteger getEligibleMales() {

        BigInteger eligibleMales = BigInteger.ZERO;
        int generation = 0;

        for (BigInteger i : getAliveMales()) {
            if (generation >= 1) {
                eligibleMales = eligibleMales.add(i);
            }
            generation++;
        }
        return eligibleMales;
    }

    public static BigInteger getEligibleFemales() {

        BigInteger eligibleFemales = BigInteger.ZERO;
        int generation = 0;

        for (BigInteger i : getAliveFemales()) {
            if (generation >= 2) {
                eligibleFemales = eligibleFemales.add(i);
            }
            generation++;
        }
        return eligibleFemales;
    }
    public static int getGenerationsPerLifeSpan() {
        return generationsPerLifeSpan;
    }

    public static void setGenerationsPerLifeSpan(int generationsPerLifeSpan) {
        FoxPopulation.generationsPerLifeSpan = generationsPerLifeSpan;
    }

    public static void addNextGeneration(BigInteger newMaleRabbits, BigInteger newFemaleRabbits) {
        deadAnimals = deadAnimals.add(aliveFemales.pollLast());
        deadAnimals = deadAnimals.add(aliveMales.pollLast());

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
        for (int i = 0;i < generationsPerLifeSpan-1;i++) {
            aliveMales.add(BigInteger.ZERO);
            aliveFemales.add(BigInteger.ZERO);
        }
        aliveMales.addFirst(BigInteger.ONE);
        aliveFemales.addFirst(BigInteger.ONE);
    }

    public static BigInteger getTotalAnimals() {
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
        return deadAnimals;
    }

    public static ArrayDeque<BigInteger> getAliveMales() {
        return aliveMales;
    }

    public static ArrayDeque<BigInteger> getAliveFemales() {
        return aliveFemales;
    }

    public static BigInteger getDeadAnimals() {
        return deadAnimals;
    }

    public static void setAliveMales(ArrayDeque<BigInteger> aliveMales) {
        FoxPopulation.aliveMales = aliveMales;
    }

    public static void setAliveFemales(ArrayDeque<BigInteger> aliveFemales) {
        FoxPopulation.aliveFemales = aliveFemales;
    }

    public static void setDeadAnimals(BigInteger deadAnimals) {
        FoxPopulation.deadAnimals = deadAnimals;
    }


    public static void initArrayDequeues() {
        setGenerationsPerLifeSpan(6);
        setAliveMales(new ArrayDeque<>(getGenerationsPerLifeSpan()));
        setAliveFemales(new ArrayDeque<>(getGenerationsPerLifeSpan()));
        setDeadAnimals(BigInteger.ZERO);
        resetAllArrayDequeues();
    }


}
