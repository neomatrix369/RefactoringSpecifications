import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses ({
        acceptance_tests.WordsFrequencyReporterBehaviours.class,
        unit_tests.WordsFrequencyReporterBehaviours.class
})
public class TestSuite {
}
