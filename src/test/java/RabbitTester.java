import com.spartaglobal.RabbitSimulator.Rabbit.Rabbit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RabbitTester {
    Rabbit rabbit = new Rabbit();

    @Test
    void testForEligibleRabbit(){
        rabbit.setAge(2);
        Assertions.assertEquals(false, rabbit.isEligible());
        rabbit.incrementAge();
        Assertions.assertEquals(true, rabbit.isEligible());
    }

    @Test
    void testForDeadRabbit(){
        rabbit.setAge(61);
        Assertions.assertEquals(true, rabbit.isExpired());
        Assertions.assertEquals(false, rabbit.isEligible());
    }
}
