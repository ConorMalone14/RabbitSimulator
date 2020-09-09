package com.spartaglobal.RabbitSimulator.Printer;

import com.spartaglobal.RabbitSimulator.Rabbit.RabbitPopulation;
import com.spartaglobal.RabbitSimulator.Runner.Simulation;

public class Printer {

    public static void printDeadPopulation(){

    }

    public static void printCurrentMonthData() {

    }

    public static void printPopulation() {
        System.out.println("Total population of rabbits: " + RabbitPopulation.getTotalRabbits());
        System.out.println("Population of females: " + RabbitPopulation.getTotalFemales());
        System.out.println("Population of males: " + RabbitPopulation.getTotalMales());
    }

    public static void printTotalTimeElapsed() {
        System.out.println("Time elapsed in months: " + Simulation.getElapsedTime());
    }

    public static void printSimulationMenu() {
        System.out.println("Welcome to the Rabbit Simulator");
        System.out.println("-------------------------------");
        System.out.println("Please enter the simulation duration (months): ");
    }

    public static void startMessage() {
        System.out.println("Simulation is commencing...");
        System.out.println("-------------------------------");
    }

    public static void victoryMessage() {
        System.out.println("Simulation complete.");
        System.out.println("-------------------------------");

    }
}
