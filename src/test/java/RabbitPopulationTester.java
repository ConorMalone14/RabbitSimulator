import com.spartaglobal.RabbitSimulator.Rabbit.Rabbit;
import com.spartaglobal.RabbitSimulator.Rabbit.RabbitPopulation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RabbitPopulationTester {

    @BeforeEach
    void reset() {
        RabbitPopulation.resetAllArrayLists();
    }


    @Test
    void testAddOneMaleRabbit() {
        Rabbit maleRabbit = new Rabbit();
        maleRabbit.setMale(true);
        RabbitPopulation.addRabbit(maleRabbit);
        Assertions.assertTrue(RabbitPopulation.getTotalMales() == 1);
    }

    @Test
    void testAddOneFemaleRabbit() {
        // default gender female
        Rabbit femaleRabbit = new Rabbit();
        RabbitPopulation.addRabbit(femaleRabbit);
        Assertions.assertTrue(RabbitPopulation.getTotalFemales() == 1);
    }

    @Test
    void testKillMaleRabbit() {
        Rabbit maleRabbit = new Rabbit();
        maleRabbit.setMale(true);
        RabbitPopulation.addRabbit(maleRabbit);
        RabbitPopulation.moveToDead(maleRabbit);
        Assertions.assertTrue(RabbitPopulation.getTotalMales() == 0 && RabbitPopulation.getTotalDead() == 1);
    }

    @Test
    void testKillFemaleRabbit() {
        Rabbit femaleRabbit = new Rabbit();
        RabbitPopulation.addRabbit(femaleRabbit);
        RabbitPopulation.moveToDead(femaleRabbit);
        Assertions.assertTrue(RabbitPopulation.getTotalFemales() == 0 && RabbitPopulation.getTotalDead() == 1);
    }

    @Test
    void testTotalPopulationUpdatesCorrectly() {
        Rabbit maleRabbit = new Rabbit();
        maleRabbit.setMale(true);
        Rabbit femaleRabbit = new Rabbit();
        RabbitPopulation.addRabbit(maleRabbit);
        RabbitPopulation.addRabbit(femaleRabbit);
        Assertions.assertTrue(RabbitPopulation.getTotalRabbits() == 2);
    }

}
