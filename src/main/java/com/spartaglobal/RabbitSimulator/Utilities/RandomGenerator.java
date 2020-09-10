package com.spartaglobal.RabbitSimulator.Utilities;

public class RandomGenerator {

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
