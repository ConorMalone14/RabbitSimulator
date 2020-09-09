package com.spartaglobal.RabbitSimulator.Factory;

import com.spartaglobal.RabbitSimulator.Rabbit.RabbitPopulation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BreederFactory {



    //Makes calls to makeNewRabbit()
    public static void makeNewRabbits() {

        BigInteger currentEligibleMales = RabbitPopulation.getEligibleMales();
        BigInteger currentEligibleFemales = RabbitPopulation.getEligibleFemales();

        BigInteger rabbitCouples = currentEligibleFemales.min(currentEligibleMales);

        BigInteger numberOfSuccessfulBirths = new BigDecimal(rabbitCouples).divide(BigDecimal.valueOf((double)1/getRandomDistribution(0,1,1000)), RoundingMode.HALF_UP).toBigInteger();

        BigInteger numberOfBabies = new BigDecimal(numberOfSuccessfulBirths).divide(BigDecimal.valueOf((double)1/getRandomDistribution(1,14,1000)), RoundingMode.HALF_UP).toBigInteger();

        BigInteger numberOfMales = new BigDecimal(numberOfBabies).divide(BigDecimal.valueOf((double)1/getRandomDistribution(0,1,1000)), RoundingMode.HALF_UP).toBigInteger();

        BigInteger numberOfFemales = numberOfBabies.subtract(numberOfMales);

        RabbitPopulation.addNextGeneration(numberOfMales, numberOfFemales);


        //50% chance for successful birth
        //--> n couples means n coin flips (hard way)
        //--> divide by 2 (easy way)
        //1-14 roll for amount of rabbits
        //50/50 male or female
    }

    public static double getRandomDistribution(int lowerBound, int upperBound, int instances) {

        double total = 0;

        for (int i = 0;i < instances;i++) {
            double difference = (double) upperBound - lowerBound;
            total += (Math.random()*difference) + lowerBound;
        }

        double averages = total/instances;


        return averages;
    }

}
