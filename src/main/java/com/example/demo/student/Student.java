package com.example.demo.student;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@RequiredArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Getter
    private Long id;

    @NonNull
    private String Name;

    @NonNull
    private Integer age;

    @NonNull
    private String email;

    @NonNull
    private LocalDate dob;



}
