package br.unb.cic.test.unit;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

/**
 * A JUnit test case for the <code>DefaultRunner</code>> class.
 */
public class DefaultRunnerTest {

    @Test
    public void listTestCases() {
        DefaultRunner runner = new DefaultRunner();
        String packagePath = "br.unb.cic.test.unit.samples";
        
        Assert.assertTrue(!runner.listTestCases("br.unb.cic.test.unit.samples").isEmpty());
        Assert.assertEquals(2, runner.listTestCases("br.unb.cic.test.unit.samples").size());
    }


    @Test
    public void executeSampleTestes() {
        DefaultRunner runner = new DefaultRunner();

        Set<TestResult> results = runner.runAllTests("br.unb.cic.test.unit.samples");

        int success = results.stream().map(result -> result.getSuccesses().size()).reduce(Integer::sum).get();
        int failures = results.stream().map(result -> result.getFailures().size()).reduce(Integer::sum).get();
        int errors = results.stream().map(result -> result.getErrors().size()).reduce(Integer::sum).get();

        Assert.assertEquals(3, success);
        Assert.assertEquals(1, failures);
        Assert.assertEquals(0, errors);
    }
}
