package kz.bisen.springcourse.springpublishingwebapp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PublisherDto {

    @NotEmpty(message = "First name must not be empty")
    @Size(max = 30, message = "First name length must not be greater than 30 characters")
    private String firstName;

    @NotEmpty(message = "First name must not be empty")
    @Size(max = 30, message = "Last name length must not be greater than 30 characters")
    private String lastName;

    public PublisherDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PublisherDto() {
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
