package tests.runners;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.junit.JunitDemo2;
import tests.junit.JunitDemo3;


// Runner classes are the classes that can run a specific number of tests.
//ex: choose only tests for smoke
//ex: choose tests only for cart(amazon)
//ex: choose tests on;y for login(amazon)

// @RunWith --> we need provide Suite.class from Junit
@RunWith(Suite.class)
@Suite.SuiteClasses({
        // List of test classes you want to run in this group
        // Test classes come from our project
        JunitDemo3.class, // all tests within JunitDemo3 are going to be run, unless they are ignored
        JunitDemo2.class, // all tests within JunitDemo2 are going to be run, unless a test is ignored
})


public class SmokeTestRunner {

}
