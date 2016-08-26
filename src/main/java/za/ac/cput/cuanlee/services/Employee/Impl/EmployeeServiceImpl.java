package za.ac.cput.cuanlee.services.Employee.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.cuanlee.domain.Employee.Employee;
import za.ac.cput.cuanlee.domain.PC.Chassis;
import za.ac.cput.cuanlee.repository.Employee.EmployeeRepository;
import za.ac.cput.cuanlee.services.Employee.EmployeeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CuanL on 22/08/2016.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Override
    public Employee add(Employee entity) {
        return repository.save(entity);
    }

    @Override
    public Employee update(Employee entity) {
        return repository.save(entity);
    }

    @Override
    public boolean ValidLogin(String username, String password) {
        List<Employee> result = new ArrayList<>();

        Iterable<Employee> employeeIterable = repository.findAll();
        for (Employee employee: employeeIterable)
        {
            if(employee.getUsername() == username && employee.getPassword() == password)
                return true;
        }
        return false;
    }

    @Override
    public Employee getById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> result = new ArrayList<>();

        Iterable<Employee> employeeIterable = repository.findAll();
        for (Employee employee: employeeIterable)
        {
            result.add(employee);
        }
        return result;
    }

    @Override
    public List<Employee> getAllActive() {
        List<Employee> result = new ArrayList<>();

        Iterable<Employee> employeeIterable = repository.findAll();
        for (Employee employee: employeeIterable)
        {
            if(employee.getLoggedIn().intValue() == 1)
                result.add(employee);
        }
        return result;
    }

    @Override
    public int getTotalStock() {
        return 0;
    }

    @Override
    public void delete(Employee entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
