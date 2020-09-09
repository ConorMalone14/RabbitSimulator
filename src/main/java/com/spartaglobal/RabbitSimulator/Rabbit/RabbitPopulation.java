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

    public static ArrayDeque<BigInteger> getDeadRabbits() {
        return deadRabbits;
    }

    private static ArrayDeque<BigInteger> aliveMales = new ArrayDeque<>();
    private static ArrayDeque<BigInteger> aliveFemales = new ArrayDeque<>();
    private static ArrayDeque<BigInteger> deadRabbits = new ArrayDeque<>();

    public static BigInteger getTotalRabbits() {
        return null;
    }

    public static BigInteger getTotalMales() {
        return null;
    }

    public static BigInteger getTotalFemales() {
        return null;
    }

    public static BigInteger getTotalDead() {
        return null;
    }

    public static void addNextGeneration(BigInteger newRabbits) {

    }

    // for testing use
    public static void resetAllArrayLists() {
        aliveMales.clear();
        aliveFemales.clear();
        deadRabbits.clear();
    }

}
