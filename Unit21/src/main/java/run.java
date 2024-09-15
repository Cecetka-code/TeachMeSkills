import entity.Employees;
import jdbc_connection.JdbcConnection;
import repository.BaseRepository;
import repository.EmployeesRepository;
import repository.impl.EmployeesRepositoryImpl;
import service.EmployeesService;
import service.impl.EmployeesServiceImpl;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

class IO {
    private Scanner sc = new Scanner(System.in);

    public int getInt(int min, int max) {
        sc = new Scanner(System.in);
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.println("Ошибка ввода. Введите число:");
                sc.next();
            }
            int number = sc.nextInt();
            if (number >= min && number <= max) {
                return number;
            } else {
                System.out.println("Ошибка ввода. Число меньше чем  " + min + " или больше чем " + max);
            }
        }
    }

    public String getString() {
        sc = new Scanner(System.in);
        while (true) {
            while (!sc.hasNextLine()) {
                sc.next();
            }
            String str = sc.nextLine();

            if (Pattern.matches("(^[A-ZА-Я]\\s?([a-zа-я]\\s?)*(\\d*\\s?)*)", str)) {
                return str;
            } else {
                System.out.println("Ошибка ввода.");
            }
        }
    }
}


public class run {
    public static void main(String[] args) {
        IO io = new IO();


        JdbcConnection jdbcCon = new JdbcConnection();
        EmployeesRepository repository = new EmployeesRepositoryImpl(jdbcCon);
        EmployeesService service = new EmployeesServiceImpl(repository);

        do {
            System.out.print(
                    " **************************************" +"\n"+
                            "|_1)_Сохранить запись в БД___________|" +"\n"+
                            "|_2)_Удалить запись из БД____________|" +"\n"+
                            "|_3)_Найти запись по id______________|" +"\n"+
                            "|_4)_Обновить запись в БД____________|" +"\n"+
                            "|_5)_Вывести записи из БД____________|" +"\n"+
                            "|_6)_Добавить запись в БД____________|" +"\n"+
                            "|_7)_JOIN LEFT_______________________|" +"\n"+
                            "**************************************" +"\n"+
                            " |->"
            );

            switch (io.getInt(0,7)){
                case 1 :{
                    Employees employees = new Employees();
                    System.out.println("Введите имя: ");
                    employees.setFirstName(io.getString());
                    System.out.println("Введите фамилию: ");
                    employees.setLastName(io.getString());
                    System.out.println("Введите positionId: ");
                    employees.setPositionId(io.getInt(Integer.MIN_VALUE,Integer.MAX_VALUE));

                    System.out.println(service.save(employees));
                    break;
                }

                case 2:{
                    System.out.println("Введите Id удаляемой записи:");
                    System.out.println(service.delete(io.getInt(Integer.MIN_VALUE, Integer.MAX_VALUE)));
                    break;
                }

                case 3 :{
                    System.out.println("Введите Id искомой записи:");
                    System.out.println(service.find(io.getInt(Integer.MIN_VALUE, Integer.MAX_VALUE)));
                    break;
                }

                case 4 :{
                    Employees employees = new Employees();
                    System.out.println("Введите имя: ");
                    employees.setFirstName(io.getString());
                    System.out.println("Введите фамилию: ");
                    employees.setLastName(io.getString());
                    System.out.println("Введите positionId: ");
                    employees.setPositionId(io.getInt(Integer.MIN_VALUE,Integer.MAX_VALUE));

                    System.out.println(service.update(employees));
                    break;
                }

                case 5:{
                    List<Employees> allEmployees = service.findAll();
                    for (Employees employees : allEmployees) {
                        System.out.println(employees);
                    }
                    break;
                }

                case 6 :{
                    Employees employees = new Employees();
                    System.out.println("Введите имя: ");
                    employees.setFirstName(io.getString());
                    System.out.println("Введите фамилию: ");
                    employees.setLastName(io.getString());
                    System.out.println("Введите positionId: ");
                    employees.setPositionId(io.getInt(Integer.MIN_VALUE,Integer.MAX_VALUE));

                    System.out.println(service.save(employees));
                }

                case 7:{
                    List<Employees> employeesList = service.joinLeft();
                    for (Employees employees : employeesList) {
                        System.out.println(employees);
                    }
                    break;
                }
            }

        }while (true);
    }
}
