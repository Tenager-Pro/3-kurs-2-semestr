import models.*;
import services.*;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static EmployeeService employeeService = new EmployeeService();
    public static ClientsService clientsService = new ClientsService();
    public static ContractService contractService = new ContractService();
    public static RealEstateObjectService realEstateObjectService = new RealEstateObjectService();

    public static void SystemPause() {
        System.out.println();
        System.out.println("Нажмите для продолжения ...");
        new java.util.Scanner(System.in).nextLine();
    }

    public static void printRealEstateObjects(List<RealEstateObjectEntity> realEstateObjects) {
        System.out.println("Текущие объекты недвижимости");
        System.out.print(String.join("", Collections.nCopies(200, "-")));
        System.out.println();
        System.out.printf("%10s %50s %20s %40s %30s",
                "ID",
                "Название",
                "Жилая площадь",
                "Цена за квадратный метр",
                "Статус");
        System.out.println();
        System.out.print(String.join("", Collections.nCopies(200, "-")));
        System.out.println();
        for (RealEstateObjectEntity realEstateObject : realEstateObjects) {
            System.out.printf("%10s %50s %20s %40s %30s",
                    realEstateObject.getObjId(),
                    realEstateObject.getName(),
                    realEstateObject.getLivingSpace(),
                    realEstateObject.getPricePerSquareMeter(),
                    realEstateObject.getStatus());
            System.out.println();
        }
    }

    public static void printClients(List<ClientsEntity> clients) {
        System.out.println("Текущие клиенты");
        System.out.print(String.join("", Collections.nCopies(200, "-")));
        System.out.println();
        System.out.printf("%10s %40s %20s %20s",
                "ID",
                "ФИО",
                "Данные паспорта",
                "Номер телефона");
        System.out.println();
        System.out.print(String.join("", Collections.nCopies(200, "-")));
        System.out.println();
        for (ClientsEntity client : clients) {
            System.out.printf("%10s %40s %20s %20s",
                    client.getClientId(),
                    client.getFio(),
                    client.getPassport(),
                    client.getPhone());
            System.out.println();
        }
    }

    public static void printEmployees(List<EmployeeEntity> employees) {
        System.out.println("Текущие сотрудники");
        System.out.print(String.join("", Collections.nCopies(150, "-")));
        System.out.println();
        System.out.printf("%10s %40s %20s %20s",
                "ID",
                "ФИО",
                "Должность",
                "Номер телефона");
        System.out.println();
        System.out.print(String.join("", Collections.nCopies(150, "-")));
        System.out.println();
        for (EmployeeEntity employee : employees) {
            System.out.printf("%10s %40s %20s %20s",
                    employee.getEmpId(),
                    employee.getFio(),
                    employee.getPost(),
                    employee.getPhone());
            System.out.println();
        }
    }

    public static void printContracts(List<ContractEntity> contracts) {
        System.out.println("Текущие договоры");
        System.out.print(String.join("", Collections.nCopies(150, "-")));
        System.out.println();
        System.out.printf("%10s %10s %10s %15s %20s %20s %20s %20s",
                "ID",
                "Клиент",
                "Работник",
                "Объект недвижимости",
                "Начало аренды",
                "Конец аренды",
                "Дней аренды",
                "Стоимость");
        System.out.println();
        System.out.print(String.join("", Collections.nCopies(150, "-")));
        System.out.println();
        for (ContractEntity contract : contracts) {
            System.out.printf("%10s %10s %10s %15s %20s %20s %20s %20s",
                    contract.getContractId(),
                    contract.getClient().getClientId(),
                    contract.getEmployee().getEmpId(),
                    contract.getRealEstateObject().getObjId(),
                    contract.getRentalStartDate().toString().substring(0, 10),
                    contract.getRentalEndDate().toString().substring(0, 10),
                    contract.getRentalDaysNumber(),
                    contract.getAmount());
            System.out.println();
        }
    }

    public static int intInput() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static String stringInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static boolean printMenu() throws ParseException {
        System.out.println();
        System.out.println();
        System.out.println("Агентство недвижимости");
        System.out.println();
        System.out.println("1 - Просмотр таблиц");
        System.out.println("2 - Добавление данных");
        System.out.println("3 - Обновление данных");
        System.out.println("4 - Удаление данных");
        System.out.println("0 - Выход");
        System.out.println();
        System.out.print(">>> ");
        int menuSelector = intInput();
        System.out.println();
        switch (menuSelector) {
            case 1:
                printMainMenu();
                break;
            case 2:
                printInsertMenu();
                break;
            case 3:
                printUpdateMenu();
                break;
            case 4:
                printDeleteMenu();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Ошибка. Нужный пункт меню не найден.");
                break;

        }
        return false;
    }

    public static void printMainMenu() throws ParseException {
        System.out.println();
        System.out.println();
        System.out.println("Вывод таблицы");
        System.out.println();
        System.out.println("1 - Объекты недвижимости");
        System.out.println("2 - Клиенты");
        System.out.println("3 - Сотрудники");
        System.out.println("4 - Договоры");
        System.out.println("0 - Вернуться назад");
        System.out.println();
        System.out.print(">>> ");
        int menuSelector = intInput();
        System.out.println();
        switch (menuSelector) {
            case 1:
                List<RealEstateObjectEntity> realEstateObjects = realEstateObjectService.findAllRealEstateObjects();
                System.out.println();
                printRealEstateObjects(realEstateObjects);
                SystemPause();
                break;

            case 2:
                List<ClientsEntity> clients = clientsService.findAllClients();
                System.out.println();
                printClients(clients);
                SystemPause();
                break;

            case 3:
                List<EmployeeEntity> employees = employeeService.findAllEmployees();
                System.out.println();
                printEmployees(employees);
                SystemPause();
                break;

            case 4:
                List<ContractEntity> contracts = contractService.findAllContracts();
                System.out.println();
                printContracts(contracts);
                SystemPause();
                break;

            case 0:
                printMenu();
                break;

            default:
                System.out.println("Ошибка. Нужный пункт меню не найден.");
                break;

        }
    }

    public static void printDeleteMenu() throws ParseException {
        System.out.println();
        System.out.println();
        System.out.println("Удалить данные из таблицы");
        System.out.println();
        System.out.println("1 - Объекты недвижимости");
        System.out.println("2 - Клиенты");
        System.out.println("3 - Сотрудники");
        System.out.println("4 - Договоры");
        System.out.println("0 - Вернуться назад");
        System.out.println();
        System.out.print(">>> ");
        int menuSelector = intInput();
        System.out.println();
        switch (menuSelector) {
            case 1:
                List<RealEstateObjectEntity> realEstateObjects = realEstateObjectService.findAllRealEstateObjects();
                System.out.println("Удаление объекта недвижимости");
                System.out.println("Выберите объект недвижимости для удаления");
                printRealEstateObjects(realEstateObjects);
                System.out.println();
                System.out.print("Введите ID объекта недвижимости: ");
                int realEstateObject_ID = intInput();
                RealEstateObjectEntity realEstateObject = new RealEstateObjectEntity();
                for (RealEstateObjectEntity value : realEstateObjects)
                    if (value.getObjId() == realEstateObject_ID)
                        realEstateObject = value;

                realEstateObjectService.deleteRealEstateObject(new RealEstateObjectEntity(
                        realEstateObject.getObjId(),
                        realEstateObject.getName(),
                        realEstateObject.getLivingSpace(),
                        realEstateObject.getPricePerSquareMeter(),
                        realEstateObject.getStatus()
                ));
                SystemPause();
                break;

            case 2:
                List<ClientsEntity> clients = clientsService.findAllClients();
                System.out.println("Удаление клиента");
                System.out.println("Выберите клиента для удаления");
                printClients(clients);
                System.out.println();
                System.out.print("Введите ID клиента: ");
                int client_ID = intInput();
                ClientsEntity client = new ClientsEntity();
                for (ClientsEntity value : clients)
                    if (value.getClientId() == client_ID)
                        client = value;

                clientsService.deleteClient(new ClientsEntity(
                        client.getClientId(),
                        client.getFio(),
                        client.getPassport(),
                        client.getPhone()
                ));
                SystemPause();
                break;

            case 3:
                List<EmployeeEntity> employees = employeeService.findAllEmployees();
                System.out.println("Удаление сотрудника");
                System.out.println("Выберите сотрудника для удаления");
                printEmployees(employees);
                System.out.println();
                System.out.print("Введите ID сотрудника: ");
                int employee_ID = intInput();
                EmployeeEntity employee = new EmployeeEntity();
                for (EmployeeEntity value : employees)
                    if (value.getEmpId() == employee_ID)
                        employee = value;

                employeeService.deleteEmployee(new EmployeeEntity(
                        employee.getEmpId(),
                        employee.getFio(),
                        employee.getPost(),
                        employee.getPhone()
                ));
                SystemPause();
                break;

            case 4:
                List<ContractEntity> contracts = contractService.findAllContracts();
                //printContracts(contracts);
                System.out.println();
                System.out.println();
                System.out.println("Удаление договора");
                System.out.println("Выберите договор для удаления");
                printContracts(contracts);
                System.out.println();
                System.out.print("Введите ID договора: ");
                int contract_ID = intInput();
                ContractEntity contract = new ContractEntity();
                for (ContractEntity value : contracts)
                    if (value.getContractId() == contract_ID)
                        contract = value;

                contractService.deleteContract(new ContractEntity(
                        contract.getContractId(),
                        contract.getClient(),
                        contract.getEmployee(),
                        contract.getRealEstateObject(),
                        contract.getRentalStartDate(),
                        contract.getRentalEndDate(),
                        contract.getRentalDaysNumber(),
                        contract.getAmount()
                ));
                SystemPause();
                break;
            case 0:
                printMenu();
                break;
            default:
                System.out.println("Ошибка. Нужный пункт меню не найден.");
                break;

        }
    }

    public static void printInsertMenu() throws ParseException {
        System.out.println();
        System.out.println();
        System.out.println("Добавление данных в таблицу");
        System.out.println();
        System.out.println("1 - Объекты недвижимости");
        System.out.println("2 - Клиенты");
        System.out.println("3 - Сотрудники");
        System.out.println("4 - Договоры");
        System.out.println("0 - Вернуться назад");
        System.out.println();
        System.out.print(">>> ");
        int menuSelector = intInput();
        System.out.println();
        switch (menuSelector) {
            case 1:
                System.out.println("Добавление нового объекта недвижимости");
                System.out.print("Введите название(наименование): ");
                String name = stringInput();
                System.out.print("Введите жилую площадь в м2: ");
                int livingSpace = intInput();
                System.out.print("Введите цену за квадратный метр: ");
                int pricePerSquareMeter = intInput();
                System.out.print("Введите статус(занят/свободен): ");
                String status = stringInput();
                RealEstateObjectEntity realEstateObject = new RealEstateObjectEntity(name, livingSpace, pricePerSquareMeter, status);
                realEstateObjectService.saveRealEstateObject(realEstateObject);
                break;

            case 2:
                System.out.println("Добавление нового клиента");
                System.out.print("Введите ФИО: ");
                String fio = stringInput();
                System.out.print("Введите серию и номер паспорта: ");
                String passport = stringInput();
                System.out.print("Введите номер телефона: ");
                String phone_number = stringInput();
                ClientsEntity client = new ClientsEntity(fio, passport, phone_number);
                clientsService.saveClient(client);
                break;

            case 3:
                System.out.println("Добавление нового сотрудника");
                System.out.print("Введите ФИО: ");
                fio = stringInput();
                System.out.print("Введите должность сотрудника: ");
                String post = stringInput();
                System.out.print("Введите номер телефона: ");
                phone_number = stringInput();
                EmployeeEntity employee = new EmployeeEntity(fio, post, phone_number);
                employeeService.saveEmployee(employee);
                break;

            case 4:
                List<ClientsEntity> clients = clientsService.findAllClients();
                List<EmployeeEntity> employees = employeeService.findAllEmployees();
                List<RealEstateObjectEntity> realEstateObjects = realEstateObjectService.findAllRealEstateObjects();
                System.out.println("Добавление нового договора");

                System.out.println("Выберите клиента");
                printClients(clients);
                System.out.print("Введите ID клиента: ");
                int client_ID = intInput();
                ClientsEntity contract_client = new ClientsEntity();
                for (ClientsEntity value : clients)
                    if (value.getClientId() == client_ID)
                        contract_client = value;

                System.out.println("Выберите сотрудника");
                printEmployees(employees);
                System.out.print("Введите ID сотрудника: ");
                int employee_ID = intInput();
                EmployeeEntity contract_employee = new EmployeeEntity();
                for (EmployeeEntity value : employees)
                    if (value.getEmpId() == employee_ID)
                        contract_employee = value;

                System.out.println("Выберите объект недвижимости");
                printRealEstateObjects(realEstateObjects);
                System.out.print("Введите ID объекта недвижимости: ");
                int realEstateObject_ID = intInput();
                RealEstateObjectEntity contract_realEstateObject = new RealEstateObjectEntity();
                for (RealEstateObjectEntity value : realEstateObjects)
                    if (value.getObjId() == realEstateObject_ID)
                        contract_realEstateObject = value;

                System.out.print("Введите дату начала аренды (dd.MM.yyyy): ");
                Date rental_start_date = new SimpleDateFormat("dd.MM.yyyy").parse(stringInput());

                System.out.print("Введите дату завершения аренды (dd.MM.yyyy): ");
                Date rental_end_date = new SimpleDateFormat("dd.MM.yyyy").parse(stringInput());

                int rental_days_number = Days.daysBetween(new LocalDate(rental_start_date), new LocalDate(rental_end_date)).getDays();

//              Стоимость аренды: жил.площадь * цена_за_кв_метр * coeff
//              если меньше 15 дней, то coeff = 2.5
//              если меньше 30 дней, то coeff = 2
//              если меньше 90 дней, то coeff = 1.5
//              иначе coeff = 1.0
                int rental_cost = contract_realEstateObject.getLivingSpace() * contract_realEstateObject.getPricePerSquareMeter() / (365*5);

                if (rental_days_number < 15)
                    rental_cost *= 2.5;
                if (rental_days_number < 30)
                    rental_cost *= 2;
                if (rental_days_number < 90)
                    rental_cost *= 1.5;

                rental_cost *= rental_days_number;

                ContractEntity contract = new ContractEntity(
                        contract_client,
                        contract_employee,
                        contract_realEstateObject,
                        rental_start_date,
                        rental_end_date,
                        rental_days_number,
                        rental_cost);
                contractService.saveContract(contract);
                break;
            case 0:
                printMenu();
                break;
            default:
                System.out.println("Ошибка. Нужный пункт меню не найден.");
                break;
        }
    }

    public static void printUpdateMenu() throws ParseException {
        List<RealEstateObjectEntity> realEstateObjects = realEstateObjectService.findAllRealEstateObjects();
        List<ClientsEntity> clients = clientsService.findAllClients();
        List<EmployeeEntity> employees = employeeService.findAllEmployees();
        List<ContractEntity> contracts = contractService.findAllContracts();
        System.out.println();
        System.out.println();
        System.out.println("Обновление данных таблицы");
        System.out.println();
        System.out.println("1 - Объекты недвижимости");
        System.out.println("2 - Клиенты");
        System.out.println("3 - Сотрудники");
        System.out.println("4 - Контракты");
        System.out.println("0 - Вернуться назад");
        System.out.println();
        System.out.print(">>> ");
        int menuSelector = intInput();
        System.out.println();
        switch (menuSelector) {
            case 1:
                System.out.println("Обновление текущих объектов недвижимости");
                System.out.println("Выберите объект недвижимости для обновления");
                printRealEstateObjects(realEstateObjects);
                System.out.println();
                System.out.print("Введите ID объекта недвижимости: ");
                int realEstateObject_ID = intInput();
                RealEstateObjectEntity realEstateObject = new RealEstateObjectEntity();
                for (RealEstateObjectEntity value : realEstateObjects)
                    if (value.getObjId() == realEstateObject_ID)
                        realEstateObject = value;

                System.out.print("Введите параметр, который хотите обновить: ");
                String realEstateObject_parameter = stringInput();
                if (realEstateObject_parameter.equals("Наименование")) {
                    System.out.print("Введите новое наименование: ");
                    realEstateObject.setName(stringInput());
                }
                if (realEstateObject_parameter.equals("Жилая площадь")) {
                    System.out.print("Введите новую жилую площадь: ");
                    realEstateObject.setLivingSpace(intInput());
                }
                if (realEstateObject_parameter.equals("Цена за квадратный метр")) {
                    System.out.print("Введите новую цену за квадратный метр: ");
                    realEstateObject.setPricePerSquareMeter(intInput());
                }
                if (realEstateObject_parameter.equals("Статус")) {
                    System.out.print("Введите новый статус: ");
                    realEstateObject.setStatus(stringInput());
                }

                realEstateObjectService.updateRealEstateObject(new RealEstateObjectEntity(
                        realEstateObject.getObjId(),
                        realEstateObject.getName(),
                        realEstateObject.getLivingSpace(),
                        realEstateObject.getPricePerSquareMeter(),
                        realEstateObject.getStatus()
                ));
                SystemPause();
                break;

            case 2:
                System.out.println("Обновление текущих клиентов");
                System.out.println("Выберите клиента для обновления");
                printClients(clients);
                System.out.println();
                System.out.print("Введите ID клиента: ");
                int client_ID = intInput();
                ClientsEntity client = new ClientsEntity();
                for (ClientsEntity value : clients)
                    if (value.getClientId() == client_ID)
                        client = value;

                System.out.print("Введите параметр, который хотите обновить: ");
                String client_parameter = stringInput();
                if (client_parameter.equals("ФИО")) {
                    System.out.print("Введите новое ФИО: ");
                    client.setFio(stringInput());
                }
                if (client_parameter.equals("Серия и номер паспорта")) {
                    System.out.print("Введите новые серию и номер: ");
                    client.setPassport(stringInput());
                }
                if (client_parameter.equals("Номер телефона")) {
                    System.out.print("Введите новый номер телефона: ");
                    client.setPhone(stringInput());
                }

                clientsService.updateClient(new ClientsEntity(
                        client.getClientId(),
                        client.getFio(),
                        client.getPassport(),
                        client.getPhone()
                ));
                SystemPause();
                break;

            case 3:
                System.out.println("Обновление текущих сотрудников");
                System.out.println("Выберите сотрудника для обновления");
                printEmployees(employees);
                System.out.println();
                System.out.print("Введите ID сотрудника: ");
                int employee_ID = intInput();
                EmployeeEntity employee = new EmployeeEntity();
                for (EmployeeEntity value : employees)
                    if (value.getEmpId() == employee_ID)
                        employee = value;

                System.out.print("Введите параметр, который хотите обновить: ");
                String employee_parameter = stringInput();
                if (employee_parameter.equals("ФИО")) {
                    System.out.print("Введите новое ФИО: ");
                    employee.setFio(stringInput());
                }
                if (employee_parameter.equals("Должность")) {
                    System.out.print("Введите новую должность: ");
                    employee.setPost(stringInput());
                }
                if (employee_parameter.equals("Номер телефона")) {
                    System.out.print("Введите новый номер телефона: ");
                    employee.setPhone(stringInput());
                }

                employeeService.updateEmployee(new EmployeeEntity(
                        employee.getEmpId(),
                        employee.getFio(),
                        employee.getPost(),
                        employee.getPhone()
                ));
                SystemPause();
                break;

            case 4:
                System.out.println("Обновление текущих договоров");
                System.out.println("Выберите договор для обновления");
                printContracts(contracts);
                System.out.println();
                System.out.print("Введите ID договора: ");
                int contract_ID = intInput();
                ContractEntity contract = new ContractEntity();
                for (ContractEntity value : contracts)
                    if (value.getContractId() == contract_ID)
                        contract = value;

                System.out.print("Введите параметр, который хотите обновить: ");
                String contract_parameter = stringInput();

                if (contract_parameter.equals("Клиент")) {
                    System.out.print("Выберите клиента для обновления");
                    printClients(clients);
                    System.out.print("Введите ID клиента: ");
                    int client_ID_search = intInput();
                    ClientsEntity contract_client = new ClientsEntity();
                    for (ClientsEntity value : clients)
                        if (value.getClientId() == client_ID_search)
                            contract_client = value;

                    contract.setClient(contract_client);
                }

                if (contract_parameter.equals("Работник")) {
                    System.out.println("Выберите работника для обновления");
                    printEmployees(employees);
                    System.out.print("Введите ID работника: ");
                    int employee_ID_search = intInput();
                    EmployeeEntity contract_employee = new EmployeeEntity();
                    for (EmployeeEntity value : employees)
                        if (value.getEmpId() == employee_ID_search)
                            contract_employee = value;
                    contract.setEmployee(contract_employee);
                }

                if (contract_parameter.equals("Объект недвижимости")) {
                    System.out.println("Выберите объект недвижимости для обновления");
                    printRealEstateObjects(realEstateObjects);
                    System.out.print("Введите ID объекта недвижимости: ");
                    int realEstateObject_ID_search = intInput();
                    RealEstateObjectEntity contract_realEstateObject = new RealEstateObjectEntity();
                    for (RealEstateObjectEntity value : realEstateObjects)
                        if (value.getObjId() == realEstateObject_ID_search)
                            contract_realEstateObject = value;
                    contract.setRealEstateObject(contract_realEstateObject);
                }

                if (contract_parameter.equals("Начало аренды")) {
                    System.out.print("Введите новую дату начала аренды (dd.MM.yyyy): ");
                    contract.setRentalStartDate(new SimpleDateFormat("dd.MM.yyyy").parse(stringInput()));
                }

                if (contract_parameter.equals("Конец аренды")) {
                    System.out.print("Введите новую дату завершения аренды (dd.MM.yyyy): ");
                    contract.setRentalEndDate(new SimpleDateFormat("dd.MM.yyyy").parse(stringInput()));
                }

                int rental_days_number =
                        Days.daysBetween(new LocalDate(contract.getRentalStartDate()), new LocalDate(contract.getRentalEndDate())).getDays();

                contract.setRentalDaysNumber(rental_days_number);

                int rental_cost = contract.getRealEstateObject().getLivingSpace() * contract.getRealEstateObject().getPricePerSquareMeter() / (365*5);

                if (rental_days_number < 15)
                    rental_cost *= 2.5;
                if (rental_days_number < 30)
                    rental_cost *= 2;
                if (rental_days_number < 90)
                    rental_cost *= 1.5;

                rental_cost *= rental_days_number;

                contract.setAmount(rental_cost);

                contractService.updateContract(new ContractEntity(
                        contract.getContractId(),
                        contract.getClient(),
                        contract.getEmployee(),
                        contract.getRealEstateObject(),
                        contract.getRentalStartDate(),
                        contract.getRentalEndDate(),
                        contract.getRentalDaysNumber(),
                        contract.getAmount()
                ));
                SystemPause();
                break;

            case 0:
                printMenu();
                break;

            default:
                System.out.println("Ошибка. Нужный пункт меню не найден.");
                break;

        }
    }

    public static void main(String[] args) throws ParseException {
        boolean isExit = false;
        while (!isExit) {
            isExit = printMenu();
        }
    }
}