package com.qpa.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;
    
    @Column(unique = true, nullable = false)
    private String emailId;
    
    @Column(unique = true)
    private String contactNumber;

    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    private String userName;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    public UserInfo() {}

    public UserInfo(String firstName, String lastName, String emailId, String contactNumber, UserType userType, String address, Status status, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.contactNumber = contactNumber;
        this.userType = userType;
        this.address = address;
        this.status = status;
        this.userName = userName;
        this.password = password;
    }

    // Getters and Setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName(){ return lastName;}
    public void setLastName(String lastName){ this.lastName = lastName; }

    public UserType getUserType(){ return userType; }
    public void setUserType(UserType userType){ this.userType = userType; }

    public String getEmailId() { return emailId; }
    public void setEmailId(String emailId) { this.emailId = emailId; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; } // Removed encoding from setter

}
