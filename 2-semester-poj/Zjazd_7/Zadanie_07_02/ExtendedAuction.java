package Zadania.Zjazd_7.Zadanie_07_02;

/**
 * @author Pawel Badysiak s21166
 */
public class ExtendedAuction extends Auction {

    public ExtendedAuction() {
        super(AuctionType.EXTENDED);
    }

    @Override
    public void subtractTrustPoints() {
        if (getBoughtBy() != null) {
            getBoughtBy().subtractTrustPoints(4);
        }
    }
}
