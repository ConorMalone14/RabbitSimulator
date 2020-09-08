package com.spartaglobal.RabbitSimulator.Rabbit;

import java.util.ArrayList;
import java.util.Iterator;

public class RabbitPopulation {

    public static ArrayList<Rabbit> getAliveMales() {
        return aliveMales;
    }

    public static ArrayList<Rabbit> getAliveFemales() {
        return aliveFemales;
    }

    public static ArrayList<Rabbit> getDeadRabbits() {
        return deadRabbits;
    }

    private static ArrayList<Rabbit> aliveMales = new ArrayList<>();
    private static ArrayList<Rabbit> aliveFemales = new ArrayList<>();
    private static ArrayList<Rabbit> deadRabbits = new ArrayList<>();

    public static long getTotalRabbits() {
        return (aliveMales.size() + aliveFemales.size());
    }

    public static long getTotalMales() {
        return aliveMales.size();
    }

    public static long getTotalFemales() {
        return aliveFemales.size();
    }

    public static long getTotalDead() {
        return deadRabbits.size();
    }

    public static void addRabbit(Rabbit rabbit) {
        if (rabbit.isMale()) {
            aliveMales.add(rabbit);
        } else {
            aliveFemales.add(rabbit);
        }
    }

    public static void moveToDead(Rabbit rabbit) {
        Iterator<Rabbit> maleRabbitIterator = aliveMales.iterator();
        Iterator<Rabbit> femaleRabbitIterator = aliveFemales.iterator();

        while (maleRabbitIterator.hasNext()) {
            Rabbit currentRabbit = maleRabbitIterator.next();
            if (currentRabbit.equals(rabbit)) {
                maleRabbitIterator.remove();
                break;
            }
        }

        while (femaleRabbitIterator.hasNext()) {
            Rabbit currentRabbit = femaleRabbitIterator.next();
            if (currentRabbit.equals(rabbit)) {
                maleRabbitIterator.remove();
                break;
            }
        }

        deadRabbits.add(rabbit);
    }

    // for testing use
    public static void resetAllArrayLists() {
        aliveMales.clear();
        aliveFemales.clear();
        deadRabbits.clear();
    }

}
