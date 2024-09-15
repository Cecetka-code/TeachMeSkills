package repository;

import entity.Employees;

import java.util.List;

public interface EmployeesRepository extends BaseRepository<Employees> {
    List<Employees> joinLeft();
}
