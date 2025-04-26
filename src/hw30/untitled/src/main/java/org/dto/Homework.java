package org.dto;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "homework")
public class Homework {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String description;
        private LocalDate deadline;
        private int mark;
        @ManyToOne
        @JoinColumn(name = "student_id") // правильно вказуємо зв'язок
        private Student student;
}
