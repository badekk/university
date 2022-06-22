package Zadania.Zjazd_7.Zadanie_07_02;

/**
 * @author Pawel Badysiak s21166
 */

public enum AuctionType {

    SIMPLE,
    EXTENDED,
    REVERSED;

    @Override
    public String toString() {
        return this.name();
    }
}
