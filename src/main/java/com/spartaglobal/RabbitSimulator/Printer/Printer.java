package com.spartaglobal.RabbitSimulator.Printer;

import com.spartaglobal.RabbitSimulator.Rabbit.RabbitPopulation;
import com.spartaglobal.RabbitSimulator.Runner.Simulation;

import java.io.BufferedWriter;
import java.io.IOException;

public class Printer {

    public static void printCurrentMonthData(BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write("-------------------------------");
        bufferedWriter.write("\nMonthly Report for Month " + Simulation.getElapsedTime());
        bufferedWriter.write("\nTotal population of rabbits: " + RabbitPopulation.getTotalRabbits());
        bufferedWriter.write("\nPopulation of females: " + RabbitPopulation.getTotalFemales());
        bufferedWriter.write("\nPopulation of males: " + RabbitPopulation.getTotalMales());
        bufferedWriter.write("\nPopulation of total expired rabbits: " + RabbitPopulation.getTotalDead());
        bufferedWriter.write("\n-------------------------------");
    }

    public static void printPopulation() {
        System.out.println("-------------------------------");
        System.out.println("Final Report for Simulation");
        System.out.println("Total population of rabbits: " + RabbitPopulation.getTotalRabbits());
        System.out.println("Total population of females: " + RabbitPopulation.getTotalFemales());
        System.out.println("Total population of males: " + RabbitPopulation.getTotalMales());
        System.out.println("Total population of expired rabbits: " + RabbitPopulation.getTotalDead());
        System.out.println("-------------------------------");
    }

    public static void printTotalTimeElapsed() {
        System.out.println("Time elapsed in months: " + Simulation.getElapsedTime());
    }

    public static void printSimulationMenu() {
        System.out.println("Welcome to the Rabbit Simulator");
        System.out.println("-------------------------------");
        System.out.println("Please enter the simulation duration (months): ");
    }

    public static void askReportFormat(){
        System.out.println("Please choose between the two options below:");
        System.out.println("Option 1 - Retrieve report per month");
        System.out.println("Option 2 - Retrieve report at the end of the simulation");
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
