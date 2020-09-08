import com.spartaglobal.RabbitSimulator.Factory.BreederFactory;
import com.spartaglobal.RabbitSimulator.Rabbit.PopulationIncrement;
import com.spartaglobal.RabbitSimulator.Rabbit.Rabbit;
import com.spartaglobal.RabbitSimulator.Rabbit.RabbitPopulation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PopulationIncrementTester {

    @BeforeEach
    void resetPopulation() {
        RabbitPopulation.resetAllArrayLists();
    }

    @Test
    void checkRabbitsAfter4Months() {
        RabbitPopulation.addRabbit(BreederFactory.getStartingMale());
        RabbitPopulation.addRabbit(BreederFactory.getStartingFemale());

        PopulationIncrement.runIncrement();
        PopulationIncrement.runIncrement();
        PopulationIncrement.runIncrement();
        PopulationIncrement.runIncrement();

        Assertions.assertTrue(RabbitPopulation.getTotalRabbits() > 2);
    }

    @Test
    void testRabbitsDie() {
        Rabbit femaleRabbit = BreederFactory.getStartingFemale();
        femaleRabbit.setAge(60);
        Rabbit maleRabbit = BreederFactory.getStartingMale();
        maleRabbit.setAge(59);
        RabbitPopulation.addRabbit(femaleRabbit);
        RabbitPopulation.addRabbit(maleRabbit);

        PopulationIncrement.runIncrement();

        Assertions.assertEquals(1, RabbitPopulation.getTotalDead());


    }

    @Test
    void testSimulationFor10Weeks() {
        RabbitPopulation.addRabbit(BreederFactory.getStartingMale());
        RabbitPopulation.addRabbit(BreederFactory.getStartingFemale());

        for (int i = 1;i <= 10;i++) {
            PopulationIncrement.runIncrement();
        }

        int population = RabbitPopulation.getTotalRabbits();
        System.out.println(population);

        Assertions.assertTrue(population > 2);
    }

}
