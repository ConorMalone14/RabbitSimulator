package com.spartaglobal.RabbitSimulator.Runner;

import com.spartaglobal.RabbitSimulator.Printer.Printer;
import com.spartaglobal.RabbitSimulator.Rabbit.PopulationIncrement;

import java.util.Scanner;

public class Simulation {

    private static int timeElapsed;

    public static void runOneMonth() {
        PopulationIncrement.runIncrement();
        timeElapsed++;
    }

    public static void runSimulationForTime(int timeToRun) {
        for (int i = 1; i <= timeToRun; i++) {
            runOneMonth();
        }
    }

    public static void startSimulation() {
        Printer.printSimulationMenu();
        Scanner scanner = new Scanner(System.in);
        int runtimeLength = scanner.nextInt();
        Printer.startMessage();
        runSimulationForTime(runtimeLength);
        Printer.victoryMessage();
        getReport();
    }

    public static int getElapsedTime() {
        return timeElapsed;
    }

    public static void getReport() {
        Printer.printPopulation();
        Printer.printTotalTimeElapsed();
    }

}
