package com.spartaglobal.RabbitSimulator.Factory;

import com.spartaglobal.RabbitSimulator.Rabbit.Rabbit;

public class BreederFactory {

    //Makes calls to makeNewRabbit()
    public void makeNewRabbits() {

    }

    public Rabbit makeNewRabbit() {

        return new Rabbit();
    }

    //Generates random number between 1-14
    public int getOffspringNumber() {
        return 0;
    }

    //Return random boolean true or false
    public boolean isBornMale() {
        return true;
    }

    public Rabbit getStartingMale() {
        return new Rabbit();
    }

    public Rabbit getStartingFemale() {
        return new Rabbit();
    }

}
