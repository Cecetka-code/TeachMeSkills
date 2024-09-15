package repository.impl;

import entity.Employees;
import jdbc_connection.JdbcConnection;
import repository.EmployeesRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesRepositoryImpl implements EmployeesRepository {

    private static final String INSERT = "INSERT INTO employees (first_name, last_name, position_id) VALUES (?, ?, ?)";

    private static final String DELETE = "DELETE FROM employees WHERE id=?";

    private static final String SELECT_ALL = "SELECT * FROM employees";

    private static final String SELECT_BY_ID = "SELECT * FROM employees WHERE id=?";


    private static final String UPDATE = "UPDATE employees SET first_name=?, last_name=?, position_id=? WHERE id=?";

    private static final String JOIN_LEFT="SELECT first_name, last_name, post, experience FROM employees LEFT JOIN posit ON employees.position_id = posit.id";

    private final JdbcConnection connection;

    public EmployeesRepositoryImpl(JdbcConnection connection) {
        this.connection = connection;
    }


    @Override
    public Employees find(int id) {
        Employees employees = new Employees();
        try (Connection con = connection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
              employees.setFirstName(resultSet.getString("first_name"));
              employees.setLastName(resultSet.getString("last_name"));
              employees.setPositionId(resultSet.getInt("position_id"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }

    @Override
    public List<Employees> findAll() {
        List<Employees> list = new ArrayList<>();
        try (Connection con = connection.getConnection();
             Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);

            while (resultSet.next()) {
                Employees employees= new Employees();
                employees.setFirstName(resultSet.getString(1));
                employees.setLastName(resultSet.getString(2));
                employees.setPositionId(resultSet.getInt(3));
                list.add(employees);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean delete(int id) {
        try (Connection con = connection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate()!=0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Employees entity) {
        try (Connection con = connection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setInt(3, entity.getPositionId());
            return preparedStatement.executeUpdate()!=0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean save(Employees entity) {
        try (Connection con = connection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(INSERT)) {
            preparedStatement.setString(1,  entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setInt(3, entity.getPositionId());
            return preparedStatement.executeUpdate()!=0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Employees> joinLeft() {
        List<Employees> list = new ArrayList<>();
        try (Connection con = connection.getConnection();
             Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery(JOIN_LEFT);

            while (resultSet.next()) {
                Employees employees= new Employees();
                employees.setFirstName(resultSet.getString(1));
                employees.setLastName(resultSet.getString(2));
                employees.setPost(resultSet.getString(3));
                employees.setExperience(resultSet.getInt(4));
                list.add(employees);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }
}
