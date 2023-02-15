import model.Student;
import model.Group;
import service.GroupService;
import service.StudentService;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws SQLException, ParseException {
        StudentService userService = new StudentService();
        GroupService groupService = new GroupService();

        Group group = new Group();
        group.setName("ИУК4-52Б");
        groupService.saveGroup(group);


        Student student = new Student();
        student.setName("Nikita Keyone");
        student.setGroup(group);
        DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
        java.util.Date utilDate = df.parse(new String("08/02/2002"));
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        student.setBirthDate(sqlDate);
        student.setPhoneNumber("+79106055606");
        userService.saveStudent(student);
    }
}