package services;

import dao.PatientDao;
import models.Contract;
import models.Patient;

import java.util.List;

public class PatientService {

    private static PatientDao patientsDao = new PatientDao();

    public PatientService() {
    }

    public Patient findPatient(int id) {
        return patientsDao.findById(id);
    }

    public void savePatient(Patient patient) {
        patientsDao.save(patient);
    }

    public void deletePatient(Patient patient) {
        patientsDao.delete(patient);
    }

    public void updatePatient(Patient patient) {
        patientsDao.update(patient);
    }

    public List<Patient> findAllPatients() {
        return patientsDao.findAll();
    }

//    public Contract findPatientById(int id) {
//        return patientsDao.findContractById(id);
//    }


}

