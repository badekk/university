package Zadania.Zjazd_7.Zadanie_07_02;

/**
 * @author Pawel Badysiak s21166
 */
public class AuctionFactory {

    public static Auction getAuction(AuctionType type) {
        switch (type) {
            case SIMPLE:
                return new SimpleAuction();
            case EXTENDED:
                return new ExtendedAuction();
            case REVERSED:
                return new ReversedAuction();
        }
        return null;
    }
}
