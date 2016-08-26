package za.ac.cput.cuanlee.services.Employee;

import za.ac.cput.cuanlee.domain.Employee.Employee;
import za.ac.cput.cuanlee.domain.PC.RAM;
import za.ac.cput.cuanlee.services.Service;

/**
 * Created by CuanL on 22/08/2016.
 */
public interface EmployeeService extends Service<Employee, Long> {
    boolean ValidLogin(String username,String password);
}
