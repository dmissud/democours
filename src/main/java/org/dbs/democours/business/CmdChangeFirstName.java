package org.dbs.democours.business;

public class CmdChangeFirstName {
    private String lastName;
    private String oldFirstName;
    private String newFirstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOldFirstName() {
        return oldFirstName;
    }

    public void setOldFirstName(String oldFirstName) {
        this.oldFirstName = oldFirstName;
    }

    public String getNewFirstName() {
        return newFirstName;
    }

    public void setNewFirstName(String newFirstName) {
        this.newFirstName = newFirstName;
    }

    @Override
    public String toString() {
        return "CmdChangeFirstName{" +
                "lastName='" + lastName + '\'' +
                ", oldFirstName='" + oldFirstName + '\'' +
                ", newFirstName='" + newFirstName + '\'' +
                '}';
    }
    public boolean isValid() {
        boolean isOk;
        isOk = !((lastName == null) ||
                (lastName.isEmpty()) ||
                (oldFirstName == null) ||
                (oldFirstName.isEmpty()) ||
                (newFirstName == null) ||
                (newFirstName.isEmpty()) ||
                newFirstName.equals(oldFirstName));

        return isOk;
    }

}
