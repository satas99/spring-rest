package com.example.restdemo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
//specifies that the class is an entity and is mapped to a database table.
@Data
//a convenient shortcut annotation that bundles the features of @ToString , @EqualsAndHashCode , @Getter / @Setter and @RequiredArgsConstructor together.
@Table(name = "users")
//allows you to specify the details of the table that will be used to persist the entity in the database.
public class User {

    @Id
    @Column(name = "user_id") // used for Adding the column the name in the table of a particular database.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //indicates that the persistence provider must assign primary keys for the entity using a database identity column.
    private int id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "age")
    private int age;
}
