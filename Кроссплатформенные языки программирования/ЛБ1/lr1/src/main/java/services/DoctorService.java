package services;

import dao.DoctorDao;
import models.Doctor;

import java.util.List;


public class DoctorService {

    private DoctorDao doctorsDao = new DoctorDao();

    public DoctorService() {
    }

    public Doctor findDoctor(int id) {
        return doctorsDao.findById(id);
    }

    public void saveDoctor(Doctor doctor) {
        doctorsDao.save(doctor);
    }

    public void deleteDoctor(Doctor doctor) {
        doctorsDao.delete(doctor);
    }

    public void updateDoctor(Doctor doctor) {
        doctorsDao.update(doctor);
    }

    public List<Doctor> findAllDoctors() {
        return doctorsDao.findAll();
    }


}
