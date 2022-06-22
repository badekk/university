package Zadania.Zjazd_7.Zadanie_07_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Pawel Badysiak s21166
 */

public class UserList {

    public static List<User> userList = new ArrayList<>();

    static {
        String names[] = new String[]{"Steve", "Bronko", "Jesuz", "Robert", "Ulka"};
        String lastNames[] = new String[]{"Qqwe", "Zzxc", "Asdsd", "Kilof", "Steweard"};
        userList.add(new User("Pawel", "Badysiak", "p.badysiak", "pawel.badysiak@gmail.com", 99, 9999999));

        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            String n = names[r.nextInt(names.length - 1)];
            String l = lastNames[r.nextInt(lastNames.length - 1)];
            String login = String.format("%s.%s", n.substring(0, 1), l);
            String email = String.format("%s.%s@gmail.com", n, l);
            double funds = r.nextDouble() * 123456;
            userList.add(new User(n, l, login, email, r.nextInt(100), funds));
        }

        userList = userList.stream().distinct().collect(Collectors.toList());


    }
}
