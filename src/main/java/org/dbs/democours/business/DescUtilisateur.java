package org.dbs.democours.business;

public class DescUtilisateur {
    private String fistName;
    private String lastName;
    private int memberInFamilly;
    private int orderInFamilly;

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMemberInFamilly() {
        return memberInFamilly;
    }

    public void setMemberInFamilly(int memberInFamilly) {
        this.memberInFamilly = memberInFamilly;
    }

    public int getOrderInFamilly() {
        return orderInFamilly;
    }

    public void setOrderInFamilly(int orderInFamilly) {
        this.orderInFamilly = orderInFamilly;
    }

    @Override
    public String toString() {
        return "DescUtilisateur{" +
                "fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", memberInFamilly=" + memberInFamilly +
                ", orderInFamilly=" + orderInFamilly +
                '}';
    }
}
