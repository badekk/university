/*  Summary: Main class - to operate them all classes :)
    Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_3;

public class main {
    public static void main(String[] args) {
        System.out.println("Class Employee");
        Employee myData = new Employee(1, "Pawel", "Badysiak", 15000);
        System.out.println(myData.getAnnualSalary());// return 180000
        System.out.println(myData.raiseSalary(50));//returns 22500
        System.out.println(myData.toString());

        System.out.println("Class InvoiceItem");
        InvoiceItem product = new InvoiceItem("1", "vitamin C", 5, 4.00);
        System.out.println(product.getTotal()); // should return 20.0
        System.out.println(product.toString());

        System.out.println("Class Account");
        Account bank = new Account("1", "Badysiak", 3000);
        Account bank_2 = new Account("2", "Wiercipieta", 50000);
        System.out.println(bank.credit(10000));// return 13000
        System.out.println(bank.debit(1000));// return 12000
        System.out.println(bank.debit(15000));// return prnt Exceed / 12000
        System.out.println(bank.transferTo(bank_2, 5000));//return 7000
        System.out.println(bank_2.getBalance());// return 55000
        System.out.println(bank.toString());
        System.out.println(bank_2.toString());

        System.out.println("Class Date");
        Date myDate = new Date(19, 04, 1992);
        System.out.println(myDate.toString());//returns 19 / 04 / 1992

        System.out.println("Class Time");
        Time myTime = new Time(23, 59, 59);
        System.out.println(myTime.toString());//returns 23:59:59
        System.out.println(myTime.nextSecond());//returns 00:00:00
        System.out.println(myTime.previousSecond().previousSecond().previousSecond());//returns 23:59:57

        System.out.println("Class Company");
        Company.listOfEmployees();

        System.out.println("Class Palindrom");
        Palindrom code = new Palindrom();
        System.out.println(code.isPalindrom("Atak kata"));//returns true
        System.out.println(code.isPalindrom("ALA"));//returns true
        System.out.println(code.isPalindrom("Muzo, raz daj jad za rozum"));//returns true
        System.out.println(code.isPalindrom("Wódy żal dla żydów"));//returns true
        System.out.println(code.isPalindrom("Ptaki latają kluczem"));//returns false
    }
}
