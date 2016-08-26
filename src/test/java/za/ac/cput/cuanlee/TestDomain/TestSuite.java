package za.ac.cput.cuanlee.TestDomain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import za.ac.cput.cuanlee.TestDomain.Employee.TestContactDetailsFactory;
import za.ac.cput.cuanlee.TestDomain.Employee.TestEmployeeFactory;
import za.ac.cput.cuanlee.TestDomain.Employee.TestGeographicalDetailsFactory;
import za.ac.cput.cuanlee.TestDomain.PC.*;


/**
 * Created by CuanL on 14/04/2016. Testing Commits
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestChassisFactory.class,
        TestContactDetailsFactory.class,
        TestCPUFactory.class,
        TestEmployeeFactory.class,
        TestGeographicalDetailsFactory.class,
        TestGPUFactory.class,
        TestHDDFactory.class,
        TestMotherboardFactory.class,
        TestPSUFactory.class,
        TestRAMFactory.class
})
public class TestSuite {
}
