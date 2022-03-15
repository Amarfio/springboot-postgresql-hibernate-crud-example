package net.javaguides.springboot.model;

//this is a simple jpa entity
import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    //employee details
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    //default constructor
    public Employee(){
        super();
    }

    //value specifying constructor
    public Employee(String firstName, String lastName, String email){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //get employee's id number
    public long getId() {
        return id;
    }

    //set employee's id number
    public void setId(long id) {
        this.id = id;
    }

    //get employee's first name
    public String getFirstName() {
        return firstName;
    }

    //set employee's first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //get employee's last name
    public String getLastName() {
        return lastName;
    }

    //set employee's last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //get employee's email address
    public String getEmail() {
        return email;
    }

    //set employee's email address
    public void setEmail(String email) {
        this.email = email;
    }
}
