package com.experiment04;
import com.experiment04.entity.Student;
import com.experiment04.resource.DatabaseUtils;
import com.experiment04.service.impl.StudentServiceImpl;

import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        List<Student> students = null;
        StudentServiceImpl studentService = new StudentServiceImpl();
        for (Student s : DatabaseUtils.getStudents()) {
            students = studentService.addStudent(s);
        }
        System.out.println("All Students:");
        students.forEach(Test::printStudentInfo);

        System.out.println("\nlistStudentsByYear (2010):");
        students = studentService.listStudentsByYear(2010);
        students.forEach(Test::printStudentInfo);

        System.out.println("\nlistStudentsNames (2010,Male):");
        List<String> sl = studentService.listStudentsNames(2010, Student.Sex.MALE);
        sl.forEach(s -> System.out.println(s));

        System.out.println("\nmapStudentsBySex:");
        Map<Student.Sex, List<Student>> mp = studentService.mapStudentsBySex();
        for(Student.Sex sex :mp.keySet()) {
            System.out.println("--  Sex : "+(sex==Student.Sex.MALE?"Male --":"Female --"));
            mp.get(sex).forEach(Test::printStudentInfo);
        }

        System.out.println("\nremoveStudent (201000):");
        System.out.println(studentService.removeStudent(201000));
        System.out.println("removeStudent (201002):");
        System.out.println(studentService.removeStudent(201002));
    }

    public static void printStudentInfo(Student student) {
        System.out.println("Id="+student.getId()
                +" Sex="+(student.getSex()==Student.Sex.MALE?"Male":"Female")
                +" Name="+student.getName()
                +" Year="+student.getYear());
    }
}
