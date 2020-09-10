package com.spartaglobal.RabbitSimulator.Predator;

import com.spartaglobal.RabbitSimulator.Population.FoxPopulation;
import com.spartaglobal.RabbitSimulator.Population.RabbitPopulation;

import java.math.BigInteger;

public class Eater {

    public static void foxesEatRabbits() {
        BigInteger totalFoxes = FoxPopulation.getTotalAnimals();

        int rabbitsPerFox = (int) Math.round(Math.random() * 20);

        BigInteger rabbitsToBeEaten = totalFoxes.multiply(new BigInteger(Integer.toString(rabbitsPerFox)));

        RabbitPopulation.removeEatenRabbits(rabbitsToBeEaten);
    }

}