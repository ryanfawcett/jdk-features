package org.example.lambda;

public class FilterByEmployeeAge implements FilterPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
