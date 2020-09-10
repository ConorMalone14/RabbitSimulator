package com.spartaglobal.RabbitSimulator.Population;

import java.math.BigInteger;
import java.util.ArrayDeque;

public interface Population {

    public static int getGenerationsPerLifeSpan(){return 0;}

    public static void setGenerationsPerLifeSpan(int generationsPerLifeSpan){}


    public static BigInteger getEligibleMales(){return null;}

    public static BigInteger getEligibleFemales(){return null;}

    public static void addNextGeneration(BigInteger newMaleRabbits, BigInteger newFemaleRabbits){}

    // for testing use
    public static void resetAllArrayDequeues(){}

    //Initialising the ArrayDeque
    public static void initialiseArrayDequeues(){}

    public static BigInteger getTotalAnimals(){return null;}

    public static BigInteger getTotalMales(){return null;}

    public static BigInteger getTotalFemales(){return null;}

    public static BigInteger getTotalDead(){return null;}

    public static ArrayDeque<BigInteger> getAliveMales(){return null;}

    public static ArrayDeque<BigInteger> getAliveFemales(){return null;}

    public static BigInteger getDeadAnimals(){return null;}

    public static void setAliveMales(ArrayDeque<BigInteger> aliveMales){}

    public static void setAliveFemales(ArrayDeque<BigInteger> aliveFemales){}

    public static void setDeadAnimals(BigInteger deadAnimals){}
}
