package com.spartaglobal.RabbitSimulator.Breeder;

import com.spartaglobal.RabbitSimulator.Population.FoxPopulation;
import com.spartaglobal.RabbitSimulator.Population.Population;
import com.spartaglobal.RabbitSimulator.Population.RabbitPopulation;
import com.spartaglobal.RabbitSimulator.Utilities.RandomGenerator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class FoxBreeder implements Breeder {

    public static void makeNewAnimals() {

        BigInteger currentEligibleMales = FoxPopulation.getEligibleMales();
        BigInteger currentEligibleFemales = FoxPopulation.getEligibleFemales();


        BigInteger foxCouples = currentEligibleFemales.min(currentEligibleMales);
        System.out.println("Fox couples: "+foxCouples.toString());

        BigInteger numberOfSuccessfulBirths = new BigDecimal(foxCouples).divide(BigDecimal.valueOf((double)1/ RandomGenerator.getRandomDistribution(0,1,1000)), RoundingMode.HALF_UP).toBigInteger();

        BigInteger numberOfBabies = new BigDecimal(numberOfSuccessfulBirths).divide(BigDecimal.valueOf((double)1/RandomGenerator.getRandomDistribution(1,10,1000)), RoundingMode.HALF_UP).toBigInteger();

        BigInteger numberOfMales = new BigDecimal(numberOfBabies).divide(BigDecimal.valueOf((double)1/ RandomGenerator.getRandomDistribution(0,1,1000)), RoundingMode.HALF_UP).toBigInteger();

        BigInteger numberOfFemales = numberOfBabies.subtract(numberOfMales);

        RabbitPopulation.addNextGeneration(numberOfMales, numberOfFemales);

    }

}
