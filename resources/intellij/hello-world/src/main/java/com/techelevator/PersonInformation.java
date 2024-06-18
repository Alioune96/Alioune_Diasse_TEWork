package com.techelevator;

public class PersonInformation {

    private int personId;
    private String firstName;
    private String lastName;
    private String userHandle;
    private int ageOfPerson;
    private String address;

    public PersonInformation() {
    }

    public PersonInformation(int personId, String firstName, String lastName, String userHandle, int ageOfPerson, String address) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userHandle = userHandle;
        this.ageOfPerson = ageOfPerson;
        this.address = address;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
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

    public String getUserHandle() {
        return userHandle;
    }

    public void setUserHandle(String userHandle) {
        this.userHandle = userHandle;
    }

    public int getAgeOfPerson() {
        return ageOfPerson;
    }

    public void setAgeOfPerson(int ageOfPerson) {
        this.ageOfPerson = ageOfPerson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
