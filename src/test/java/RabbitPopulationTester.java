import com.spartaglobal.RabbitSimulator.Breeder.RabbitBreeder;
import com.spartaglobal.RabbitSimulator.Population.RabbitPopulation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class RabbitPopulationTester {

    @BeforeEach
    void reset() {
        RabbitPopulation.resetAllArrayDequeues();
        showPopulationData();
    }

    @Test
    void test() {

        RabbitPopulation.addNextGeneration(BigInteger.valueOf(500), BigInteger.valueOf(1));
        showPopulationData();
        BigInteger populationBeforeRemove = RabbitPopulation.getTotalAnimals();
        RabbitPopulation.removeEatenRabbits(BigInteger.valueOf(100));

        System.out.println("After subtraction: "+RabbitPopulation.getTotalAnimals());
        System.out.println("Initial minus 100: "+populationBeforeRemove.subtract(BigInteger.valueOf(100)));
        Assertions.assertEquals(RabbitPopulation.getTotalAnimals(), populationBeforeRemove.subtract(BigInteger.valueOf(100)));
    }


    @Test
    void testStartsWithOneMaleRabbit() {
        String totalMales = RabbitPopulation.getTotalMales().toString();
        Assertions.assertTrue(totalMales.compareTo("0") > 0);
    }

    @Test
    void testStartsWithOneFemaleRabbit() {
        String totalFemales = RabbitPopulation.getTotalFemales().toString();
        Assertions.assertTrue(totalFemales.compareTo("0") > 0);

    }

    @Test
    void testDoesKillRabbitsAfter80Generations() {
        for (int i = 0;i < 80;i++) {
            RabbitBreeder.makeNewAnimals();
        }
        String deadRabbits = RabbitPopulation.getDeadAnimals().toString();
        Assertions.assertTrue(deadRabbits.compareTo("0") > 0);
    }


    @Test
    void testFourMonthCycle() {
        for (int i = 0;i < 4;i++) {
            RabbitBreeder.makeNewAnimals();
        }
    }

    @Test
    void test4MonthEligibleMales(){

        for (int i = 0;i < 5;i++) {
            RabbitPopulation.addNextGeneration(BigInteger.ONE, BigInteger.ONE);
        }
        System.out.println("Total number of eligible males "+RabbitPopulation.getEligibleMales());
    }

    @AfterEach
    void showPopulationData() {
        System.out.println("ArrayDeque of males with size: "+RabbitPopulation.getAliveMales().size()+"\n"+RabbitPopulation.getAliveMales().toString());
        System.out.println("ArrayDeque of females with size: "+RabbitPopulation.getAliveFemales().size()+"\n"+RabbitPopulation.getAliveFemales().toString());
        System.out.println("Number of dead rabbits: "+RabbitPopulation.getDeadAnimals().toString());
    }

}
