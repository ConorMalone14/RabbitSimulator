package com.spartaglobal.RabbitSimulator.Predator;

import com.spartaglobal.RabbitSimulator.Population.FoxPopulation;
import com.spartaglobal.RabbitSimulator.Population.RabbitPopulation;
import com.spartaglobal.RabbitSimulator.Utilities.RandomGenerator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Eater {

    public static void foxesEatRabbits(int numGenerations) {
        BigInteger totalFoxes = FoxPopulation.getTotalAnimals();

        if (numGenerations <= 5){
            totalFoxes = totalFoxes.subtract(BigInteger.valueOf(2));
        }

        BigInteger numOfRabbitsEat = new BigDecimal(totalFoxes).divide(BigDecimal.valueOf((double)1/ RandomGenerator.getRandomDistribution(0,20,1000)), RoundingMode.HALF_UP).toBigInteger();

        if (numOfRabbitsEat.compareTo(BigInteger.ZERO) > 0) {
            RabbitPopulation.removeEatenRabbits(numOfRabbitsEat);
        }
    }

}