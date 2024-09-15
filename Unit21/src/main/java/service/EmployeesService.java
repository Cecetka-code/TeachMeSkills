package service;

import entity.Employees;

import java.util.List;

public interface EmployeesService extends BaseService<Employees> {
    List<Employees> joinLeft();
}
