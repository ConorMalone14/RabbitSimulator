package com.spartaglobal.RabbitSimulator.Breeder;

import com.spartaglobal.RabbitSimulator.Population.Population;
import com.spartaglobal.RabbitSimulator.Population.RabbitPopulation;
import com.spartaglobal.RabbitSimulator.Utilities.RandomGenerator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class RabbitBreeder implements Breeder{


    public static void makeNewAnimals() {

        BigInteger currentEligibleMales = RabbitPopulation.getEligibleMales();
        BigInteger currentEligibleFemales = Population.getEligibleFemales();

        BigInteger rabbitCouples = currentEligibleFemales.min(currentEligibleMales);

        BigInteger numberOfSuccessfulBirths = new BigDecimal(rabbitCouples).divide(BigDecimal.valueOf((double)1/RandomGenerator.getRandomDistribution(0,1,1000)), RoundingMode.HALF_UP).toBigInteger();

        BigInteger numberOfBabies = new BigDecimal(numberOfSuccessfulBirths).divide(BigDecimal.valueOf((double)1/RandomGenerator.getRandomDistribution(1,14,1000)), RoundingMode.HALF_UP).toBigInteger();

        BigInteger numberOfMales = new BigDecimal(numberOfBabies).divide(BigDecimal.valueOf((double)1/ RandomGenerator.getRandomDistribution(0,1,1000)), RoundingMode.HALF_UP).toBigInteger();

        BigInteger numberOfFemales = numberOfBabies.subtract(numberOfMales);

        RabbitPopulation.addNextGeneration(numberOfMales, numberOfFemales);


        //50% chance for successful birth
        //--> n couples means n coin flips (hard way)
        //--> divide by 2 (easy way)
        //1-14 roll for amount of rabbits
        //50/50 male or female
    }



}
