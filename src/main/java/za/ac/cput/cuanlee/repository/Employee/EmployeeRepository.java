package za.ac.cput.cuanlee.repository.Employee;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.cuanlee.domain.Employee.Employee;

/**
 * Created by User on 2016/07/26.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
