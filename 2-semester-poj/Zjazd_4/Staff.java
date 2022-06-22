/*
Summary: Exercise 20 UML CHART Staff Subclass extends Persons Class
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_4;

public class Staff extends Person {

    private String school;
    private double pay;

    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Staff[Person]{" +
                "name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", school='" + school + '\'' +
                ", pay=" + pay +
                '}';
    }
}
