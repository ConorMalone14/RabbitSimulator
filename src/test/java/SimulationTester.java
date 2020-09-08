import com.spartaglobal.RabbitSimulator.Runner.Simulation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimulationTester {

    @Test
    void testTimeElapsedIncrements() {
        Simulation simulation = new Simulation();
        simulation.runSimulationForTime(3);
        Assertions.assertEquals(3, Simulation.getElapsedTime());
    }
}
