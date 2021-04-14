package com.experiment04.service.impl;

import com.experiment04.entity.Student;
import com.experiment04.service.StudentService;

import java.util.*;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    List<Student> students = new ArrayList<>();
    @Override
    public List<Student> addStudent(Student student) {
        students.add(student);
        return students;
    }

    @Override
    public List<Student> listStudentsByYear(int year) {
        return students.stream().filter((s)->s.getYear()==year).collect(Collectors.toList());
    }

    @Override
    public List<String> listStudentsNames(int year, Student.Sex sex) {
        List<Student>ss =  students.stream().filter(s->s.getYear()==year&&s.getSex()==sex).collect(Collectors.toList());
        List<String>snames = new ArrayList<>();
        for(Student s:ss) {
            snames.add(s.getName());
        }
        return snames;
    }

    @Override
    public Map<Student.Sex, List<Student>> mapStudentsBySex() {
        Map<Student.Sex, List<Student>> ms = new HashMap<>();
        for (Student s:students) {
            if(ms.get(s.getSex())==null)ms.put(s.getSex(),new ArrayList<>());
            List<Student> studentList = ms.get(s.getSex());
            studentList.add(s);
        }
        return  ms;
    }

    @Override
    public boolean removeStudent(int id) {
        Iterator<Student> it = students.iterator();
        while(it.hasNext()) {
            Student s =it.next();
            if(s.getId()==id) {
                it.remove();
                return true;
            }
        }
        return false;
    }
}
