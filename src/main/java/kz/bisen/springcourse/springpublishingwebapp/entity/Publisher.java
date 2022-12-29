package kz.bisen.springcourse.springpublishingwebapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotEmpty(message = "First name must not be empty")
    @Size(max = 30, message = "First name length must not be greater than 30 characters")
    private String firstName;

    @Column
    @NotEmpty(message = "First name must not be empty")
    @Size(max = 30, message = "Last name length must not be greater than 30 characters")
    private String lastName;

    public Publisher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Publisher() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
