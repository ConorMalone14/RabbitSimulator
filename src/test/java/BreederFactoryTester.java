import com.spartaglobal.RabbitSimulator.Factory.BreederFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BreederFactoryTester {
    BreederFactory breederFactory = new BreederFactory();

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

    }

    @Test
    public void testGetStartingMale() {

    }

    @Test
    public void testGetStartingFemale() {

    }
}
