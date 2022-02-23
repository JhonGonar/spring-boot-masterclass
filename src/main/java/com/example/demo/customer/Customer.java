package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Customer{
    @Id
    private  Long id;
    @NotBlank(message = "name must be not empty")
    private  String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "password must be not empty")
    private  String password;
    @NotBlank(message = "email must be not empty")
    @Email(regexp = ".+@.+\\..+")//base Annotation doesn't chek final dot ".", before co , com, org, etc...
    private  String email;

/*    Customer(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Customer() {

    }*/

    @JsonProperty("customerId")
    public Long getId() {
        return id;
    }

    //Using JAKSON Library this si display as customerId, skipping the get and set prefix
    /*public Long getCustomerId(){
        return id;
    }*/

    public String getName() {
        return name;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

/*    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }*/
}
