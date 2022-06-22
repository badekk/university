package Zadania.Zjazd_7.Zadanie_07_02;

/**
 * @author Pawel Badysiak s21166
 */

public class ReversedAuction extends Auction {

    public ReversedAuction() {
        super(AuctionType.REVERSED);
    }

    @Override
    public void subtractTrustPoints() {
        if (getBoughtBy() != null) {
            getBoughtBy().subtractTrustPoints(2);
        }
    }
}
