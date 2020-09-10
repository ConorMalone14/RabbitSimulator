package com.spartaglobal.RabbitSimulator.Printer;

import com.spartaglobal.RabbitSimulator.Population.FoxPopulation;
import com.spartaglobal.RabbitSimulator.Population.RabbitPopulation;
import com.spartaglobal.RabbitSimulator.Runner.Simulation;

import java.io.BufferedWriter;
import java.io.IOException;

public class Printer {

    public static void printCurrentMonthData(BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write("\n\n==============================================================");
        bufferedWriter.write("\nMonthly Report for Month " + Simulation.getElapsedTime());
        bufferedWriter.write("\n==============================================================");
        bufferedWriter.write("\n == RABBIT REPORT == ");
        bufferedWriter.write("\nTotal population of rabbits: " + RabbitPopulation.getTotalAnimals());
        bufferedWriter.write("\nTotal population of female rabbits: " + RabbitPopulation.getTotalFemales());
        bufferedWriter.write("\nTotal population of male rabbits: " + RabbitPopulation.getTotalMales());
        bufferedWriter.write("\n-------------------------------");
        bufferedWriter.write("\n == FOX REPORT == ");
        bufferedWriter.write("\nTotal population of foxes: " + FoxPopulation.getTotalAnimals());
        bufferedWriter.write("\nTotal population of female foxes: " + FoxPopulation.getTotalFemales());
        bufferedWriter.write("\nTotal population of male foxes: " + FoxPopulation.getTotalMales());
        bufferedWriter.write("\n-------------------------------");
        bufferedWriter.write("\n == DEATH REPORT == ");
        bufferedWriter.write("\nTotal population of expired rabbits: " + RabbitPopulation.getTotalDead());
//bufferedWriter.write("\nTotal population of eaten rabbits: " + RabbitPopulation.getEatenRabbits());
        bufferedWriter.write("\n==============================================================");
    }

    public static void printPopulation() {
        System.out.println("==============================================================");
        System.out.println("Final Report for Simulation");
        System.out.println("==============================================================");
        System.out.println(" == RABBIT REPORT == ");
        System.out.println("Total population of rabbits: " + RabbitPopulation.getTotalAnimals());
        System.out.println("Total population of female rabbits: " + RabbitPopulation.getTotalFemales());
        System.out.println("Total population of male rabbits: " + RabbitPopulation.getTotalMales());
        System.out.println("-------------------------------");
        System.out.println(" == FOX REPORT == ");
        System.out.println("Total population of foxes: " + FoxPopulation.getTotalAnimals());
        System.out.println("Total population of female foxes: " + FoxPopulation.getTotalFemales());
        System.out.println("Total population of male foxes: " + FoxPopulation.getTotalMales());
        System.out.println("-------------------------------");
        System.out.println(" == DEATH REPORT == ");
        System.out.println("Total population of expired rabbits: " + RabbitPopulation.getTotalDead());
//System.out.println("Total population of eaten rabbits: " + RabbitPopulation.getEatenRabbits());
        System.out.println("==============================================================");
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