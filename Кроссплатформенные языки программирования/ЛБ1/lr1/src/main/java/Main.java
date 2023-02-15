import models.Contract;
import models.Patient;
import services.ContractService;
import services.PatientService;
import services.ServiceService;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws SQLException, ParseException {

        PatientService patientService = new PatientService();
        ContractService contractService = new ContractService();
        ServiceService serviceService = new ServiceService();

        Patient patient = new Patient();
        patient.setFirstName("Artem");
        DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
        java.util.Date utilDate = df.parse(new String("08/02/2002"));
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        patient.setBirthDate(sqlDate);
        patient.setPhoneNumber("+79106055606");
        patientService.savePatient(patient);

        

        Contract contract = new Contract();
        contract.setNumberContract("2324Б");
        contract.setPatient(patient);
        contractService.saveContract(contract);



    }

    public void printMenu(){
        System.out.println("Меню:");
        System.out.println("Меню:");
        System.out.println("Меню:");
        System.out.println("Меню:");
    }
}