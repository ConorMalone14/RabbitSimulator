package com.spartaglobal.RabbitSimulator.Rabbit;

import com.spartaglobal.RabbitSimulator.Factory.BreederFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class PopulationIncrement {

    private static boolean breedingMale;

    public static void runIncrement() {

        for (Rabbit rabbit : RabbitPopulation.getAliveMales()) {
            if (rabbit.isEligible()) {
                breedingMale = true;
            }

        }

        ArrayList<Rabbit> babyRabbits = new ArrayList<>();
        for (Rabbit femaleRabbit : RabbitPopulation.getAliveFemales()) {

            if (femaleRabbit.isEligible() && breedingMale) {
                ArrayList<Rabbit> tempBabies = BreederFactory.makeNewRabbits();
                for (Rabbit baby : tempBabies) {
                    babyRabbits.add(baby);
                }
            }
        }

        for (Rabbit baby : babyRabbits) {
            RabbitPopulation.addRabbit(baby);
        }

        incrementAge(RabbitPopulation.getAliveMales());
        incrementAge(RabbitPopulation.getAliveFemales());

        breedingMale = false;
    }

    public static void incrementAge(ArrayList<Rabbit> rabbitList) {
        for (Rabbit rabbit : rabbitList) {
            rabbit.incrementAge();
            killIfOld(rabbit);
        }
    }

    public static void killIfOld(Rabbit rabbit) {
        if (rabbit.isExpired()) {
            RabbitPopulation.moveToDead(rabbit);

        }
    }

}
