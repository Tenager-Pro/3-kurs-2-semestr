package service;

import dao.StudentDao;
import model.Student;

import java.util.List;

public class StudentService {

    private StudentDao studentsDao = new StudentDao();

    public StudentService() {
    }

    public Student findStudent(int id) {
        return studentsDao.findById(id);
    }

    public void saveStudent(Student student) {
        studentsDao.save(student);
    }

    public void deleteUser(Student student) {
        studentsDao.delete(student);
    }

    public void updateStudent(Student student) {
        studentsDao.update(student);
    }

    public List<Student> findAllStudents() {
        return studentsDao.findAll();
    }
}
