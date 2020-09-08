package com.spartaglobal.RabbitSimulator.Factory;

import com.spartaglobal.RabbitSimulator.Rabbit.Rabbit;
import com.spartaglobal.RabbitSimulator.Rabbit.RabbitPopulation;

import java.util.ArrayList;

public class BreederFactory {

    public static Rabbit makeNewRabbit() {
        Rabbit rabbit = new Rabbit();
        rabbit.setMale(isBornMale());

        return rabbit;
    }

    //Makes calls to makeNewRabbit()
    public static ArrayList<Rabbit> makeNewRabbits() {
        int numberOfRabbits = getOffspringNumber();
        ArrayList<Rabbit> rabbits = new ArrayList<>();
        for (int i = 0; i < numberOfRabbits; i++) {
            rabbits.add(makeNewRabbit());
        }
        return rabbits;
    }

    //Generates random number between 1-14
    public static int getOffspringNumber() {
        int numberOfOffspring = (int) Math.ceil(Math.random() * 14);
        return numberOfOffspring;
    }

    //Return random boolean true or false
    public static boolean isBornMale() {
        // Math.random() by default is between 0 and 1
        int randomNumber = (int) Math.round(Math.random());
        boolean isMale = (randomNumber == 0) ? false : true;

        return isMale;
    }

    public static Rabbit getStartingMale() {
        Rabbit rabbit = new Rabbit();
        rabbit.setMale(true);

        return rabbit;
    }

    public static Rabbit getStartingFemale() {
        Rabbit rabbit = new Rabbit();
        rabbit.setMale(false);

        return rabbit;
    }

}
