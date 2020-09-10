import com.spartaglobal.RabbitSimulator.Breeder.FoxBreeder;
import com.spartaglobal.RabbitSimulator.Population.FoxPopulation;
import com.spartaglobal.RabbitSimulator.Population.RabbitPopulation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class FoxPopulationTester {

    @BeforeEach
    void resetArrayDequeues() {
        FoxPopulation.initArrayDequeues();
        showPopulationData();
    }

    @Test
    void test4Years() {
        for (int i = 0;i < 50;i++) {
            FoxBreeder.makeNewAnimals();
        }
    }

    @Test
    void testWhatCompareDoes() {

    }

    @AfterEach
    void showPopulationData() {
        System.out.println("ArrayDeque of males with size: "+ FoxPopulation.getAliveMales().size()+"\n"+FoxPopulation.getAliveMales().toString());
        System.out.println("ArrayDeque of females with size: "+FoxPopulation.getAliveFemales().size()+"\n"+FoxPopulation.getAliveFemales().toString());
        System.out.println("Number of dead foxes: "+FoxPopulation.getDeadAnimals().toString());
    }



}
