package com.spartaglobal.RabbitSimulator.Population;

import com.spartaglobal.RabbitSimulator.Utilities.RandomGenerator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;

public class RabbitPopulation implements Population{

    private static int generationsPerLifeSpan = 60;
    private static ArrayDeque<BigInteger> aliveMales = new ArrayDeque<>(generationsPerLifeSpan);
    private static ArrayDeque<BigInteger> aliveFemales = new ArrayDeque<>(generationsPerLifeSpan);
    private static BigInteger deadAnimals = BigInteger.ZERO;
    private static BigInteger eatenRabbits = BigInteger.ZERO;

    public static void removeEatenRabbits(BigInteger rabbitsToBeEaten) {

        BigInteger maleRabbitsToBeEaten = new BigDecimal(rabbitsToBeEaten).divide(BigDecimal.valueOf((double)1/ RandomGenerator.getRandomDistribution(0,1,1000)), RoundingMode.HALF_UP).toBigInteger();

        BigInteger femaleRabbitsToBeEaten = rabbitsToBeEaten.subtract(maleRabbitsToBeEaten);

        BigInteger minimumPopulation = maleRabbitsToBeEaten.min(femaleRabbitsToBeEaten);
        BigInteger maleDiff = BigInteger.ZERO;
        BigInteger totalMales = getTotalMales();
        if (maleRabbitsToBeEaten.compareTo(totalMales) > 0) {
            maleDiff = maleRabbitsToBeEaten.subtract(totalMales);
        }

        BigInteger femaleDiff = BigInteger.ZERO;
        BigInteger totalFemales = getTotalFemales();
        if (femaleRabbitsToBeEaten.compareTo(totalFemales) > 0) {
            femaleDiff = femaleRabbitsToBeEaten.subtract(totalFemales);
        }

        femaleRabbitsToBeEaten = femaleRabbitsToBeEaten.add(maleDiff);
        maleRabbitsToBeEaten = maleRabbitsToBeEaten.add(femaleDiff);

                ArrayList<BigInteger> aliveMalesArray = new ArrayList<>();
        Iterator<BigInteger> maleItr = aliveMales.descendingIterator();
        BigInteger tempEatenRabbits = BigInteger.ZERO;
        while (maleItr.hasNext()) {
            BigInteger currentGeneration = maleItr.next();


            if (currentGeneration.compareTo(maleRabbitsToBeEaten) >= 0) {
                currentGeneration = currentGeneration.subtract(maleRabbitsToBeEaten);
                tempEatenRabbits = tempEatenRabbits.add(maleRabbitsToBeEaten);
            } else {
                maleRabbitsToBeEaten = maleRabbitsToBeEaten.subtract(currentGeneration);
                tempEatenRabbits = tempEatenRabbits.add(currentGeneration);
                currentGeneration = BigInteger.ZERO;

            }
            aliveMalesArray.add(currentGeneration);

        }

        ArrayList<BigInteger> aliveFemalesArray = new ArrayList<>();
        Iterator<BigInteger> femaleItr = aliveFemales.descendingIterator();
        while (femaleItr.hasNext()) {
            BigInteger currentGeneration = femaleItr.next();


            if (currentGeneration.compareTo(femaleRabbitsToBeEaten) >= 0) {
                currentGeneration = currentGeneration.subtract(femaleRabbitsToBeEaten);
                tempEatenRabbits = tempEatenRabbits.add(femaleRabbitsToBeEaten);
            } else {
                femaleRabbitsToBeEaten = femaleRabbitsToBeEaten.subtract(currentGeneration);
                tempEatenRabbits = tempEatenRabbits.add(currentGeneration);
                currentGeneration = BigInteger.ZERO;
            }
            aliveFemalesArray.add(currentGeneration);

        }

        Collections.reverse(aliveMalesArray);
        aliveMales = new ArrayDeque<BigInteger>(aliveMalesArray);
        Collections.reverse(aliveFemalesArray);
        aliveFemales = new ArrayDeque<BigInteger>(aliveFemalesArray);



        setEatenRabbits(getEatenRabbits().add(tempEatenRabbits));

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

    public static int getGenerationsPerLifeSpan() {
        return generationsPerLifeSpan;
    }

    public static void setGenerationsPerLifeSpan(int generationsPerLifeSpan) {
        RabbitPopulation.generationsPerLifeSpan = generationsPerLifeSpan;
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

    static {
        initialiseArrayDequeues();
    }

    public static BigInteger getEatenRabbits() {
        return eatenRabbits;
    }

    public static void setEatenRabbits(BigInteger eatenRabbits) {
        RabbitPopulation.eatenRabbits = eatenRabbits;
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
        RabbitPopulation.aliveMales = aliveMales;
    }

    public static void setAliveFemales(ArrayDeque<BigInteger> aliveFemales) {
        RabbitPopulation.aliveFemales = aliveFemales;
    }

    public static void setDeadAnimals(BigInteger deadAnimals) {
        RabbitPopulation.deadAnimals = deadAnimals;
    }

}
