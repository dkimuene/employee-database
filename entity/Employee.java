package com.project.employeedatabase.entity;

import javax.persistence.*;

@Entity //Specific that the class is an entity(Represent a table in a relational database and
// each entity instance corresponds to a row in that table)
@Table(name = "employee") //Specific the primary tables
public class Employee {

    //define fields

    @Id // Specific the primary key of an entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Provides for the specification of
    // generation strategies for the values of primary keys. The primary key generation
    // strategy that the persistence provider must use to generate the annotated entity primary key.
    @Column(name = "id")// Specifies the mapped column for a persistent property or field.
    // If no Column annotation is specified, the default values apply.
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    // define the constructor(s)

    public Employee(){

    }

    public Employee(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // define toString
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
