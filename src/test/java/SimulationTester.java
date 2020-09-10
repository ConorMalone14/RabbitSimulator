import com.spartaglobal.RabbitSimulator.Runner.Simulation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SimulationTester {

    @Test
    void testTimeElapsedIncrements() throws IOException {
        Simulation.runSimulationForTime(3);
        Assertions.assertEquals(3, Simulation.getElapsedTime());
    }
}
