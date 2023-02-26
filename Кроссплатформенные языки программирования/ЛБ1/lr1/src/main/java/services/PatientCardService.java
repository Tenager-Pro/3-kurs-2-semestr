package services;

import dao.PatientCardDao;
import models.PatientCard;

import java.util.List;


public class PatientCardService {

    private PatientCardDao patientCardsDao = new PatientCardDao();

    public PatientCardService() {
    }

    public PatientCard findPatientCard(int id) {
        return patientCardsDao.findById(id);
    }

    public void savePatientCard(PatientCard patientCard) {
        patientCardsDao.save(patientCard);
    }

    public void deletePatientCard(PatientCard patientCard) {
        patientCardsDao.delete(patientCard);
    }

    public void updatePatientCard(PatientCard patientCard) {
        patientCardsDao.update(patientCard);
    }

    public List<PatientCard> findAllPatientCards() {
        return patientCardsDao.findAll();
    }


}
