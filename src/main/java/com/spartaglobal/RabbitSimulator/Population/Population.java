package com.spartaglobal.RabbitSimulator.Population;

import java.math.BigInteger;
import java.util.ArrayDeque;

public interface Population {

    static int getGenerationsPerLifeSpan(){return 0;}

    static void setGenerationsPerLifeSpan(int generationsPerLifeSpan){}


    static BigInteger getEligibleMales(){return null;}

    static BigInteger getEligibleFemales(){return null;}

    static void addNextGeneration(BigInteger newMaleRabbits, BigInteger newFemaleRabbits){}

    // for testing use
    static void resetAllArrayDequeues(){}

    //Initialising the ArrayDeque
    static void initialiseArrayDequeues(){}

    static BigInteger getTotalAnimals(){return null;}

    static BigInteger getTotalMales(){return null;}

    static BigInteger getTotalFemales(){return null;}

    static BigInteger getTotalDead(){return null;}

    static ArrayDeque<BigInteger> getAliveMales(){return null;}

    static ArrayDeque<BigInteger> getAliveFemales(){return null;}

    static BigInteger getDeadAnimals(){return null;}

    static void setAliveMales(ArrayDeque<BigInteger> aliveMales){}

    static void setAliveFemales(ArrayDeque<BigInteger> aliveFemales){}

    static void setDeadAnimals(BigInteger deadAnimals){}
}
