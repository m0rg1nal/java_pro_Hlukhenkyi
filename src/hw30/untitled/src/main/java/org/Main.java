package org;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.dao.HomeworkDaoImpl;
import org.dao.StudentDaoImpl;
import org.dto.Homework;
import org.dto.Student;

import java.time.LocalDate;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hillel-persistence-unit");
        EntityManager manager = factory.createEntityManager();

        StudentDaoImpl studentDao = new StudentDaoImpl(manager);
        HomeworkDaoImpl homeworkDao = new HomeworkDaoImpl(manager);

        Student student = new Student("John", "Smith", "dfgdfg", new HashSet<>());

        studentDao.save(student);
        System.out.println("Student saved: " + student);

        Homework homework = new Homework();
        homework.setDescription("Learn Hibernate");
        homework.setDeadline(LocalDate.now().plusDays(7));
        homework.setMark(0);
        homework.setStudent(student);

        homeworkDao.save(homework);
        System.out.println("Homework saved: " + homework);

        Student foundStudent = studentDao.findById(student.getId());
        System.out.println("Student found by ID: " + foundStudent);

        System.out.println("All homework:");
        for (Homework h : homeworkDao.findAll()) {
            System.out.println(h);
        }

        homework.setMark(100);
        homeworkDao.update(homework);
        System.out.println("Homework updated: " + homeworkDao.findById(homework.getId()));

        homeworkDao.deleteById(homework.getId());
        System.out.println("Homework deleted");

        manager.close();
        factory.close();
    }
}