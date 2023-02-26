import models.Contract;
import models.Patient;
import models.Doctor;
import models.PatientCard;
import services.ContractService;
import services.DoctorService;
import services.PatientCardService;
import services.PatientService;

import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class Main {
    public static DoctorService doctorService = new DoctorService();
    public static PatientService patientService = new PatientService();
    public static ContractService contractService = new ContractService();
    public static PatientCardService patientCardService = new PatientCardService();

    public static void SystemPause() {
        System.out.println();
        System.out.println("Нажмите для продолжения ...");
        new java.util.Scanner(System.in).nextLine();
    }

    public static void printPatientCards(List<PatientCard> patientCards) {
        System.out.println("Текущие карты пациентов");
        System.out.print(String.join("", Collections.nCopies(200, "-")));
        System.out.println();
        System.out.printf("%20s %30s %30s %30s %30s %30s %30s",
                "ID",
                "Номер карты",
                "Название процедуры",
                "Дата",
                "Цена",
                "Доктор",
                "Контракты");
        System.out.println();
        System.out.print(String.join("", Collections.nCopies(200, "-")));
        System.out.println();
        for (PatientCard patientCard : patientCards) {
            System.out.printf("%20s %30s %30s %30s %30s %30s %30s",
                    patientCard.getId(),
                    patientCard.getNumberCard(),
                    patientCard.getNameProc(),
                    patientCard.getCreateDate(),
                    patientCard.getPrice(),
                    patientCard.getDoctor(),
                    patientCard.getContract());
            System.out.println();
        }
    }

    public static void printPatients(List<Patient> patients) {
        System.out.println("Текущие пациенты");
        System.out.print(String.join("", Collections.nCopies(200, "-")));
        System.out.println();
        System.out.printf("%10s %40s %20s %20s",
                "ID",
                "ФИО",
                "Дата рождения",
                "Номер телефона");
        System.out.println();
        System.out.print(String.join("", Collections.nCopies(200, "-")));
        System.out.println();
        for (Patient patient : patients) {
            System.out.printf("%10s %40s %20s %20s",
                    patient.getId(),
                    patient.getName(),
                    patient.getBirthDate(),
                    patient.getPhoneNumber());
            System.out.println();
        }
    }

    public static void printDoctors(List<Doctor> doctors) {
        System.out.println("Текущие сотрудники");
        System.out.print(String.join("", Collections.nCopies(150, "-")));
        System.out.println();
        System.out.printf("%10s %20s %20s %20s %20s",
                "ID",
                "ФИО",
                "Должность",
                "Коэфицент",
                "Номер телефона");
        System.out.println();
        System.out.print(String.join("", Collections.nCopies(150, "-")));
        System.out.println();
        for (Doctor doctor : doctors) {
            System.out.printf("%10s %20s %20s %20s %20s",
                    doctor.getId(),
                    doctor.getName(),
                    doctor.getPost(),
                    doctor.getRatio(),
                    doctor.getPhoneNumber());
            System.out.println();
        }
    }

    public static void printContracts(List<Contract> contracts) {
        System.out.println("Текущие договоры");
        System.out.print(String.join("", Collections.nCopies(150, "-")));
        System.out.println();
        System.out.printf("%10s %30s %30s %15s %20s %20s",
                "ID",
                "Номер договора",
                "Дата",
                "Пациент",
                "Список процедур",
                "Конечная стоимость");
        System.out.println();
        System.out.print(String.join("", Collections.nCopies(150, "-")));
        System.out.println();
        for (Contract contract : contracts) {
            System.out.printf("%10s %30s %30s %15s %20s %20s",
                    contract.getId(),
                    contract.getNumberContract(),
                    contract.getCreateDate().toString().substring(0, 10),
                    contract.getPatient().getId(),
                    contract.getPatientCards(),
                    contract.getTotalCost());
            System.out.println();
        }
    }

    public static int intInput(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
    public static String stringInput(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static boolean menu() throws ParseException{
        System.out.println();
        System.out.println();
        System.out.println("Поликлиника");
        System.out.println();
        System.out.println("1) Просмотр таблицы");
        System.out.println("2) Добавить данные");
        System.out.println("3) Изменить данные:");
        System.out.println("4) Удалить данные:");
        System.out.println("0) Выйти");
        System.out.print("-> ");
        int num = intInput();
        switch (num){
            case (1):
                menuPrint();
                break;
            case (2):
                printInsertMenu();
                break;
            case (3):
                printUpdateMenu();
                break;
            case (4):
                printDeleteMenu();
                break;
            case (0):
                System.out.println("0) Выйти:");
                break;
            default:
                System.out.println("Такого варианта не существует. Повторите ввод");
                break;
        }
        if (num != 0){
            return false;
        }
        else
            return true;

    }
    public static void menuPrint() throws ParseException {
        System.out.println();
        System.out.println();
        System.out.println("Вывод таблицы");
        System.out.println();
        System.out.println("1) Просмотр таблицы пациента");
        System.out.println("2) Просмотр таблицы доктора");
        System.out.println("3) Просмотр таблицы карты пациента");
        System.out.println("4) Просмотр таблицы контракта");
        System.out.println("0) Выйти");
        System.out.println();
        System.out.print("-> ");
        int exit = intInput();
        switch (exit){
            case 1:
                List<Patient> patients = patientService.findAllPatients();
                System.out.println();
                printPatients(patients);
                SystemPause();
                break;

            case 2:
                List<Doctor> doctors = doctorService.findAllDoctors();
                System.out.println();
                printDoctors(doctors);
                SystemPause();
                break;

            case 3:
                List<PatientCard> patientCards = patientCardService.findAllPatientCards();
                System.out.println();
                printPatientCards(patientCards);
                SystemPause();
                break;

            case 4:
                List<Contract> contracts = contractService.findAllContracts();
                System.out.println();
                printContracts(contracts);
                SystemPause();
                break;

            case 0:
                menu();
                break;

            default:
                System.out.println("Такого варианта не существует. Повторите ввод");
                break;
        }

    }
    public static void printDeleteMenu() throws ParseException {
        System.out.println();
        System.out.println();
        System.out.println("Удалить данные из таблицы");
        System.out.println();
        System.out.println("1 - Карты пациента");
        System.out.println("2 - Пациенты");
        System.out.println("3 - Доктора");
        System.out.println("4 - Контракты");
        System.out.println("0 - Вернуться назад");
        System.out.println();
        System.out.print("-> ");
        int menuSelector = intInput();
        System.out.println();
        switch (menuSelector) {
            case 1:
                List<PatientCard> patientCards = patientCardService.findAllPatientCards();
                System.out.println("Удаление объекта недвижимости");
                System.out.println("Выберите объект недвижимости для удаления");
                printPatientCards(patientCards);
                System.out.println();
                System.out.print("Введите ID объекта недвижимости: ");
                int patientCard_ID = intInput();
                PatientCard patientCard = new PatientCard();
                for (PatientCard value : patientCards)
                    if (value.getId() == patientCard_ID)
                        patientCard = value;

                patientCardService.deletePatientCard(new PatientCard(
                        patientCard.getId(),
                        patientCard.getNumberCard(),
                        patientCard.getNameProc(),
                        patientCard.getCreateDate(),
                        patientCard.getPrice(),
                        patientCard.getDoctor(),
                        patientCard.getContract()
                ));
                SystemPause();
                break;

            case 2:
                List<Patient> patients = patientService.findAllPatients();
                System.out.println("Удаление пациента");
                System.out.println("Выберите пациента для удаления");
                printPatients(patients);
                System.out.println();
                System.out.print("Введите ID пациента: ");
                int patient_ID = intInput();
                Patient patient = new Patient();
                for (Patient value : patients)
                    if (value.getId() == patient_ID)
                        patient = value;

                patientService.deletePatient(new Patient(
                        patient.getId(),
                        patient.getName(),
                        patient.getPhoneNumber(),
                        patient.getBirthDate()
                ));
                SystemPause();
                break;

            case 3:
                List<Doctor> doctors = doctorService.findAllDoctors();
                System.out.println("Удаление доктора");
                System.out.println("Выберите доктора для удаления");
                printDoctors(doctors);
                System.out.println();
                System.out.print("Введите ID доктора: ");
                int doctor_ID = intInput();
                Doctor doctor = new Doctor();
                for (Doctor value : doctors)
                    if (value.getId() == doctor_ID)
                        doctor = value;

                doctorService.deleteDoctor(new Doctor(
                        doctor.getId(),
                        doctor.getName(),
                        doctor.getPost(),
                        doctor.getRatio(),
                        doctor.getPhoneNumber()
                ));
                SystemPause();
                break;

            case 4:
                List<Contract> contracts = contractService.findAllContracts();
                System.out.println();
                System.out.println();
                System.out.println("Удаление контракта");
                System.out.println("Выберите контракт для удаления");
                printContracts(contracts);
                System.out.println();
                System.out.print("Введите ID контракта: ");
                int contract_ID = intInput();
                Contract contract = new Contract();
                for (Contract value : contracts)
                    if (value.getId() == contract_ID)
                        contract = value;

                contractService.deleteContract(new Contract(
                        contract.getId(),
                        contract.getNumberContract(),
                        contract.getTotalCost(),
                        contract.getCreateDate(),
                        contract.getPatient(),
                        contract.getPatientCards()

                ));
                SystemPause();
                break;
            case 0:
                menu();
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
        System.out.println("1 - Карты пациентов");
        System.out.println("2 - Пациенты");
        System.out.println("3 - Доктора");
        System.out.println("4 - Контракты");
        System.out.println("0 - Вернуться назад");
        System.out.println();
        System.out.print("-> ");
        int menuSelector = intInput();
        System.out.println();
        switch (menuSelector) {
            case 1:
                List<Doctor> doctors = doctorService.findAllDoctors();
                List<Contract> contracts = contractService.findAllContracts();
                System.out.println("Добавление новой карты пациента");
                System.out.print("Введите номер карты: ");
                String numberCard = stringInput();
                System.out.print("Введите название процесса: ");
                String nameProc = stringInput();
                System.out.print("Введите дату: ");
                Date createDate = (Date) new SimpleDateFormat("dd.MM.yyyy").parse(stringInput());
                System.out.print("Введите цену: ");
                int price = intInput();
                System.out.println("Выберите доктора");
                printDoctors(doctors);
                System.out.print("Введите ID доктора: ");
                int doctor_id = intInput();
                Doctor cardDoctor = new Doctor();
                for (Doctor value : doctors)
                    if (value.getId() == doctor_id)
                        cardDoctor = value;
                System.out.println("Выберите доктора");
                printContracts(contracts);
                System.out.print("Введите ID доктора: ");
                int contract_id = intInput();
                Contract cardContract = new Contract();
                for (Contract value : contracts)
                    if (value.getId() == contract_id)
                        cardContract = value;
                PatientCard patientCard = new PatientCard(numberCard, nameProc, createDate, price, cardDoctor, cardContract);
                patientCardService.savePatientCard(patientCard);
                break;

            case 2:
                System.out.println("Добавление нового пациента");
                System.out.print("Введите ФИО: ");
                String name = stringInput();
                System.out.print("Введите номер телефона: ");
                String phoneNumber = stringInput();
                System.out.print("Введите дату: ");
                Date birthDate = (Date) new SimpleDateFormat("dd.MM.yyyy").parse(stringInput());
                Patient patient = new Patient(name, phoneNumber,birthDate);
                patientService.savePatient(patient);
                break;

            case 3:
                System.out.println("Добавление нового доктора");
                System.out.print("Введите ФИО: ");
                name = stringInput();
                System.out.print("Введите должность доктора: ");
                String post = stringInput();
                System.out.print("Введите должность доктора: ");
                int ratio = intInput();
                System.out.print("Введите номер телефона: ");
                phoneNumber = stringInput();
                Doctor doctor = new Doctor(name, post, ratio,phoneNumber);
                doctorService.saveDoctor(doctor);
                break;

            case 4:
                List<Patient> patients = patientService.findAllPatients();
                int totalCost = 0;
                List<PatientCard> patientCards = patientCardService.findAllPatientCards();
                System.out.println("Добавление нового Контракта");

                System.out.print("Введите номер контракта: ");
                String numberContract = stringInput();
                System.out.print("Введите дату: ");
                createDate = (Date) new SimpleDateFormat("dd.MM.yyyy").parse(stringInput());
                System.out.println("Выберите пациента");
                printPatients(patients);
                System.out.print("Введите ID клиента: ");
                int patient_id = intInput();
                Patient contract_patient = new Patient();
                for (Patient value : patients)
                    if (value.getId() == patient_id)
                        contract_patient = value;

                System.out.println("Выберите процедуры");
                printPatientCards(patientCards);
                List<PatientCard> patient_card = null;
                System.out.print("Введите ID процедур(0 - выход): ");
                int patientCard_ID=1;
                while (patientCard_ID!=0){
                    patientCard_ID = intInput();

                    for (PatientCard value : patientCards)
                        if (value.getId() == patientCard_ID){
                            patient_card.add(value);
                            totalCost+=value.getTotalPrice();
                        }
                }
                Contract contract = new Contract(
                        numberContract,
                        totalCost,
                        createDate,
                        contract_patient,
                        patient_card);
                contractService.saveContract(contract);
                break;
            case 0:
                menu();
                break;
            default:
                System.out.println("Ошибка. Нужный пункт меню не найден.");
                break;
        }
    }

    public static void printUpdateMenu() throws ParseException {
        List<PatientCard> patientCards = patientCardService.findAllPatientCards();
        List<Patient> patients = patientService.findAllPatients();
        List<Doctor> doctors = doctorService.findAllDoctors();
        List<Contract> contracts = contractService.findAllContracts();
        System.out.println();
        System.out.println();
        System.out.println("Обновление данных таблицы");
        System.out.println();
        System.out.println("1 - Карты пациента");
        System.out.println("2 - Пациенты");
        System.out.println("3 - Доктора");
        System.out.println("4 - Контракты");
        System.out.println("0 - Вернуться назад");
        System.out.println();
        System.out.print("-> ");
        int menuSelector = intInput();
        System.out.println();
        switch (menuSelector) {
            case 1:
                System.out.println("Обновление текущих карт пациентов");
                System.out.println("Выберите карты пациентов для обновления");
                printPatientCards(patientCards);
                System.out.println();
                System.out.print("Введите ID карты пациента: ");
                int patientCard_ID = intInput();
                PatientCard patientCard = new PatientCard();
                for (PatientCard value : patientCards)
                    if (value.getId() == patientCard_ID)
                        patientCard = value;

                System.out.print("Введите параметр, который хотите обновить: ");
                String patientCard_parameter = stringInput();
                if (patientCard_parameter.equals("Номер карты")) {
                    System.out.print("Введите новое наименование: ");
                    patientCard.setNumberCard(stringInput());
                }

                if (patientCard_parameter.equals("Процедура")) {
                    System.out.print("Введите новое наименование: ");
                    patientCard.setNameProc(stringInput());
                }

                if (patientCard_parameter.equals("Дата")) {
                    System.out.print("Введите новую дату (dd.MM.yyyy): ");
                    patientCard.setCreateDate((Date) new SimpleDateFormat("dd.MM.yyyy").parse(stringInput()));
                }

                if (patientCard_parameter.equals("Цена")) {
                    System.out.print("Введите новую цену: ");
                    patientCard.setPrice(intInput());
                }
                if (patientCard_parameter.equals("Доктор")) {
                    System.out.println("Выберите доктора для обновления");
                    printDoctors(doctors);
                    System.out.print("Введите ID работника: ");
                    int doctor_ID_search = intInput();
                    Doctor card_doctor = new Doctor();
                    for (Doctor value : doctors)
                        if (value.getId() == doctor_ID_search)
                            card_doctor = value;
                    patientCard.setDoctor(card_doctor);

                }
                if (patientCard_parameter.equals("Контракт")) {
                    System.out.println("Выберите контракт для обновления");
                    printContracts(contracts);
                    System.out.print("Введите ID работника: ");
                    int contract_ID_search = intInput();
                    Contract card_contract = new Contract();
                    for (Contract value : contracts)
                        if (value.getId() == contract_ID_search)
                            card_contract = value;
                    patientCard.setContract(card_contract);

                }

                patientCardService.updatePatientCard(new PatientCard(
                        patientCard.getId(),
                        patientCard.getNumberCard(),
                        patientCard.getNameProc(),
                        patientCard.getCreateDate(),
                        patientCard.getPrice(),
                        patientCard.getDoctor(),
                        patientCard.getContract()

                ));
                SystemPause();
                break;

            case 2:
                System.out.println("Обновление текущих пациентов");
                System.out.println("Выберите пациента для обновления");
                printPatients(patients);
                System.out.println();
                System.out.print("Введите ID пациента: ");
                int patient_ID = intInput();
                Patient patient = new Patient();
                for (Patient value : patients)
                    if (value.getId() == patient_ID)
                        patient = value;

                System.out.print("Введите параметр, который хотите обновить: ");
                String patient_parameter = stringInput();
                if (patient_parameter.equals("ФИО")) {
                    System.out.print("Введите новое ФИО: ");
                    patient.setName(stringInput());
                }
                if (patient_parameter.equals("Дата рождения")) {
                    System.out.print("Введите новую дату (dd.MM.yyyy): ");
                    patient.setBirthDate((Date) new SimpleDateFormat("dd.MM.yyyy").parse(stringInput()));
                }
                if (patient_parameter.equals("Номер телефона")) {
                    System.out.print("Введите новый номер телефона: ");
                    patient.setPhoneNumber(stringInput());
                }

                patientService.updatePatient(new Patient(
                        patient.getId(),
                        patient.getName(),
                        patient.getPhoneNumber(),
                        patient.getBirthDate()
                ));
                SystemPause();
                break;

            case 3:
                System.out.println("Обновление текущих докторов");
                System.out.println("Выберите доктора для обновления");
                printDoctors(doctors);
                System.out.println();
                System.out.print("Введите ID доктора: ");
                int doctor_ID = intInput();
                Doctor doctor = new Doctor();
                for (Doctor value : doctors)
                    if (value.getId() == doctor_ID)
                        doctor = value;

                System.out.print("Введите параметр, который хотите обновить: ");
                String doctor_parameter = stringInput();
                if (doctor_parameter.equals("ФИО")) {
                    System.out.print("Введите новое ФИО: ");
                    doctor.setName(stringInput());
                }
                if (doctor_parameter.equals("Должность")) {
                    System.out.print("Введите новую должность: ");
                    doctor.setPost(stringInput());
                }
                if (doctor_parameter.equals("Коэфицент")) {
                    System.out.print("Введите новый коэфицент: ");
                    doctor.setRatio(intInput());
                }
                if (doctor_parameter.equals("Номер телефона")) {
                    System.out.print("Введите новый номер телефона: ");
                    doctor.setPhoneNumber(stringInput());
                }

                doctorService.updateDoctor(new Doctor(
                        doctor.getId(),
                        doctor.getName(),
                        doctor.getPost(),
                        doctor.getRatio(),
                        doctor.getPhoneNumber()
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
                Contract contract = new Contract();
                for (Contract value : contracts)
                    if (value.getId() == contract_ID)
                        contract = value;

                System.out.print("Введите параметр, который хотите обновить: ");
                String contract_parameter = stringInput();

                if (contract_parameter.equals("Пациент")) {
                    System.out.print("Выберите пациента для обновления");
                    printPatients(patients);
                    System.out.print("Введите ID пациента: ");
                    int patient_ID_search = intInput();
                    Patient contract_patient = new Patient();
                    for (Patient value : patients)
                        if (value.getId() == patient_ID_search)
                            contract_patient = value;

                    contract.setPatient(contract_patient);
                }
                if (contract_parameter.equals("Номер")) {
                    System.out.print("Введите новый номер: ");
                    contract.setNumberContract(stringInput());
                }

                if (contract_parameter.equals("Дата")) {
                    System.out.print("Введите новую дату (dd.MM.yyyy): ");
                    contract.setCreateDate((Date) new SimpleDateFormat("dd.MM.yyyy").parse(stringInput()));
                }

                if (contract_parameter.equals("Процедуры")) {
                    int totalCost = 0;
                    System.out.println("Выберите процедуры");
                    printPatientCards(patientCards);
                    List<PatientCard> patient_card = null;
                    System.out.print("Введите ID процедур(0 - выход): ");
                    patientCard_ID = 1;
                    while (patientCard_ID != 0) {
                        patientCard_ID = intInput();
                        if (patientCard_ID != 0) {
                            for (PatientCard value : patientCards)
                                if (value.getId() == patientCard_ID) {
                                    patient_card.add(value);
                                    totalCost += value.getTotalPrice();
                                }

                        }
                    }
                }


                contractService.updateContract(new Contract(
                        contract.getId(),
                        contract.getNumberContract(),
                        contract.getTotalCost(),
                        contract.getCreateDate(),
                        contract.getPatient(),
                        contract.getPatientCards()
                ));
                SystemPause();
                break;

            case 0:
                menu();
                break;

            default:
                System.out.println("Ошибка. Нужный пункт меню не найден.");
                break;

        }
    }



    public static void main(String[] args) throws SQLException, ParseException {
        boolean exit = false;
        while (!exit){
            exit = menu();
        }




    }



}


