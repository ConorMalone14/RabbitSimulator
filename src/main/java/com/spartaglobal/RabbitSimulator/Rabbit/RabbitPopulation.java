package com.spartaglobal.RabbitSimulator.Rabbit;

import java.util.ArrayList;

public class RabbitPopulation {

    private static ArrayList<Rabbit> aliveMales = new ArrayList<>();
    private static ArrayList<Rabbit> aliveFemales = new ArrayList<>();
    private static ArrayList<Rabbit> deadRabbits = new ArrayList<>();

    public static int getTotalRabbits() {
        return (aliveMales.size() + aliveFemales.size());
    }

    public static int getTotalMales() {
        return aliveMales.size();
    }

    public static int getTotalFemales() {
        return aliveFemales.size();
    }

    public static int getTotalDead() {
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
        aliveFemales.remove(rabbit);
        aliveMales.remove(rabbit);
        deadRabbits.add(rabbit);
    }

    // for testing use
    public static void resetAllArrayLists() {
        aliveMales.clear();
        aliveFemales.clear();
        deadRabbits.clear();
    }

}
