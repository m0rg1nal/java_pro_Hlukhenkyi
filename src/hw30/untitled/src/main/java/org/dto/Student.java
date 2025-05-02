package org.dto;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Homework> homeworks = new HashSet<>();

    public Student(String firstName, String lastName, String email, Set<Homework> homeworks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.homeworks = homeworks;
    }

    public Student(){

    }

    public void addHomework(final Homework homework) {
        homeworks.add(homework);
    }

    public void removeHomework(final Homework homework) {
        homeworks.remove(homework);
    }
}