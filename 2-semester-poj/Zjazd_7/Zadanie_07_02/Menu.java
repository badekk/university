package Zadania.Zjazd_7.Zadanie_07_02;

/**
 * @author Pawel Badysiak s21166
 */

public enum Menu {

    CREATE_AUCTION("Create new auction"),
    NEXT_ROUND("Go to next round"),
    SHOW_UNFINISHED("Show unfinished auctions"),
    SHOW_FINISHED("Show finished auctions"),
    FIND_BY_CREATOR("Find auctions created by user"),
    CHANGE_TRUSTPOINTS("Retract trust points from user"),
    CHANGE_USER("Change logged user"),
    EXIT("Exit");

    private final String name;

    Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
