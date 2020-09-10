package com.spartaglobal.RabbitSimulator.Runner;

import com.spartaglobal.RabbitSimulator.Breeder.FoxBreeder;
import com.spartaglobal.RabbitSimulator.Breeder.RabbitBreeder;
import com.spartaglobal.RabbitSimulator.Predator.Eater;
import com.spartaglobal.RabbitSimulator.Printer.Printer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Simulation {

    private static int timeElapsed;
    static int reportChoice = 0;
    static int numGenerations = 0;
    public static void runOneMonth() {
        RabbitBreeder.makeNewAnimals();
        if ((timeElapsed % 12) == 0) {
            FoxBreeder.makeNewAnimals();
            numGenerations++;
        }
        if (timeElapsed >= 12) {
            Eater.foxesEatRabbits(numGenerations);
        }
        timeElapsed++;
    }

    public static void runSimulationForTime(int timeToRun) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/monthlyReport.txt"));
        for (int i=1; i<= timeToRun; i++){
            runOneMonth();
            if(reportChoice == 1){
                Printer.printCurrentMonthData(bufferedWriter);
            }
        }
        bufferedWriter.close();
    }

    public static void startSimulation() throws IOException {
        int runtimeLength = 0;
        do {
            try {
                Printer.printSimulationMenu();
                Scanner scanner = new Scanner(System.in);
                runtimeLength = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please input a valid positive time in months.");
            }
        } while (runtimeLength <= 0);

        do {
            try {
                Printer.askReportFormat();
                Scanner scanner = new Scanner(System.in);
                reportChoice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please input either 1 or 2 as your preferred choice");
            }
        } while (reportChoice != 1 && reportChoice != 2);

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