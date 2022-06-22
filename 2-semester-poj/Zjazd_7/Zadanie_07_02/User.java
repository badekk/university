package Zadania.Zjazd_7.Zadanie_07_02;

import java.util.Objects;

/**
 * @author Pawel Badysiak s21166
 */
public class User {

    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private int trustPoints;
    private double funds;

    public User(String firstName, String lastName, String login, String email, int trustPoints, double funds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.email = email;
        this.trustPoints = trustPoints;
        this.funds = funds;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public int getTrustPoints() {
        return trustPoints;
    }

    public void addTrustPoints(int amount) {
        this.trustPoints += amount;
    }

    public void subtractTrustPoints(int amount) {
        this.trustPoints -= amount;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", trustPoints=" + trustPoints +
                String.format(", funds=%02f",funds) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
