package com.h2testing.H2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Table(name = "Task")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "dueDate")
    private Date dueDate;

    @Column(name = "CreatedOn")
    private Date createdOn;

    @PrePersist
    protected void onCreate() {
        createdOn = new Date();
    }

}
