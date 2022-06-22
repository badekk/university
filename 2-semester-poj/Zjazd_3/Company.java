/*  Summary: Exercise 16  Print Name/Salary and date of joining 8 employees
    Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_3;

import org.w3c.dom.ls.LSOutput;

import javax.xml.crypto.Data;
import java.util.*;

public class Company {
    //    Employee employee1 = new Employee(1, "Wojtek", "Wojtyla", 2500);
    private String firstName;
    private String lastName;
    private int salary;
    private Date joinDate;

    public Company(String firstName, String lastName, int salary, Date joinDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.joinDate = joinDate;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public static void listOfEmployees() {
        ArrayList<Company> employees = new ArrayList<Company>();
        Company person1 = new Company("Pawel", "Badyl", 5000, new Date(19, 4, 1992));
        Company person2 = new Company("Piotr", "Tempo", 15000, new Date(18, 3, 1995));
        Company person3 = new Company("Agata", "Wsbo", 2000, new Date(6, 11, 1994));
        Company person4 = new Company("Konrad", "Ten", 6500, new Date(30, 1, 1999));
        Company person5 = new Company("Zofia", "Krzyż", 20000, new Date(16, 10, 1990));
        Company person6 = new Company("Pamela", "Ander", 3300, new Date(26, 6, 1988));
        Company person7 = new Company("Adrei", "Tusk", 4000, new Date(8, 5, 1989));
        Company person8 = new Company("Tadzio", "Lepper", 80000, new Date(12, 2, 1947));

        employees.add(person1);
        employees.add(person2);
        employees.add(person3);
        employees.add(person4);
        employees.add(person5);
        employees.add(person6);
        employees.add(person7);
        employees.add(person8);

        for (Company obj : employees) {
            System.out.println(obj);
        }
    }

    @Override
    public String toString() {
        return "Company{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", joinDate=" + joinDate +
                '}';
    }
}
