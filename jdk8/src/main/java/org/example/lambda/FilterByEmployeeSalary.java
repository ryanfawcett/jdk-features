package org.example.lambda;

public class FilterByEmployeeSalary implements FilterPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= 5000;
    }
}
