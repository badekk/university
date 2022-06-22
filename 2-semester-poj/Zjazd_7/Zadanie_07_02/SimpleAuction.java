package Zadania.Zjazd_7.Zadanie_07_02;

/**
 * @author Pawel Badysiak s21166
 */
public class SimpleAuction extends Auction {

    public SimpleAuction() {
        super(AuctionType.SIMPLE);
    }

    @Override
    public void subtractTrustPoints() {
        if (getBoughtBy() != null) {
            getBoughtBy().subtractTrustPoints(5);
        }
    }
}
