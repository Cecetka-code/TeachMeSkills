package service.impl;

import entity.Employees;
import repository.BaseRepository;
import repository.EmployeesRepository;
import service.EmployeesService;

import java.util.List;

public class EmployeesServiceImpl implements EmployeesService {

    private EmployeesRepository repository;

    public EmployeesServiceImpl(EmployeesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employees find(int id) {
        return repository.find(id);
    }

    @Override
    public List<Employees> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public boolean update(Employees entity) {
        return repository.update(entity);
    }

    @Override
    public boolean save(Employees entity) {
        return repository.save(entity);
    }

    @Override
    public List<Employees> joinLeft() {
        return repository.joinLeft();
    }
}
