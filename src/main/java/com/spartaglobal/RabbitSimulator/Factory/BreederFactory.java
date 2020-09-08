package com.spartaglobal.RabbitSimulator.Factory;

import com.spartaglobal.RabbitSimulator.Rabbit.Rabbit;

public class BreederFactory {

    public Rabbit makeNewRabbit() {
        Rabbit rabbit = new Rabbit();
        rabbit.setMale(isBornMale());

        return rabbit;
    }

    //Makes calls to makeNewRabbit()
    public void makeNewRabbits(int numberOfRabbits) {
        for (int i = 0; i < numberOfRabbits; i++) {
            makeNewRabbit();
        }
    }

    //Generates random number between 1-14
    public int getOffspringNumber() {
        int numberOfOffspring = (int) Math.ceil(Math.random() * 14);
        return numberOfOffspring;
    }

    //Return random boolean true or false
    public boolean isBornMale() {
        // Math.random() by default is between 0 and 1
        int randomNumber = (int) Math.round(Math.random());
        boolean isMale = (randomNumber == 0) ? false : true;

        return isMale;
    }

    public Rabbit getStartingMale() {
        Rabbit rabbit = new Rabbit();
        rabbit.setMale(true);

        return rabbit;
    }

    public Rabbit getStartingFemale() {
        Rabbit rabbit = new Rabbit();
        rabbit.setMale(false);

        return rabbit;
    }

}
