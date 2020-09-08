import com.spartaglobal.RabbitSimulator.Factory.BreederFactory;
import com.spartaglobal.RabbitSimulator.Rabbit.Rabbit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BreederFactoryTester {
    BreederFactory breederFactory = new BreederFactory();
    Rabbit maleRabbit;
    Rabbit femaleRabbit;

    @Test
    public void testMakeNewRabbit() {

    }

    @Test
    public void testMakeNewRabbits() {

    }

    @Test
    public void testIsBornMale() {
        Assertions.assertEquals(false, breederFactory.isBornMale());
        Assertions.assertEquals(true, breederFactory.isBornMale());
    }

    @Test
    public void testGetOffspringNumber() {
        int number = breederFactory.getOffspringNumber();

        Assertions.assertEquals(true, number >= 1);
        Assertions.assertEquals(true, number <= 14);
    }

    @Test
    public void testGetStartingMale() {
        maleRabbit = breederFactory.getStartingMale();
        Assertions.assertEquals(true, maleRabbit.isMale());
    }

    @Test
    public void testGetStartingFemale() {
        femaleRabbit = breederFactory.getStartingFemale();
        Assertions.assertEquals(false, femaleRabbit.isMale());
    }
}
