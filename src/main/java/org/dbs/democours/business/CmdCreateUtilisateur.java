package org.dbs.democours.business;

public class CmdCreateUtilisateur {
    private String lastName;
    private String firstName;

    public CmdCreateUtilisateur(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "CmdCreateUtilisateur{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    public boolean isValid() {
        boolean isOk;
        isOk = !((lastName == null) ||
                (lastName.isEmpty()) ||
                (firstName == null) ||
                (firstName.isEmpty()));

        return isOk;
    }
}

