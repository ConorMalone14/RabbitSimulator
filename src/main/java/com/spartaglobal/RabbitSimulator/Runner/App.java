package com.spartaglobal.RabbitSimulator.Runner;

public class App {


    public static void main( String[] args ){
        try{
            Simulation.startSimulation();
        } catch (Exception e){
            System.out.println("Writing to report file failed");
        }
    }
}
