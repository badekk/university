package Zadania.Zjazd_7.Zadanie_07_02;

/**
 * @author Pawel Badysiak s21166
 */
public abstract class Auction {

    private String name;
    private String description;
    private AuctionType type;
    private double startingPrice;
    private int durationInRounds;
    private int minTrustPoints;
    private int startingRound;
    private AuctionStatus status;
    private User createdBy;
    private User boughtBy;


    public Auction(AuctionType type) {
        this.type = type;
        this.status = AuctionStatus.START;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AuctionType getType() {
        return type;
    }

    public void setType(AuctionType type) {
        this.type = type;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public int getDurationInRounds() {
        return durationInRounds;
    }

    public void setDurationInRounds(int durationInRounds) {
        this.durationInRounds = durationInRounds;
    }

    public int getMinTrustPoints() {
        return minTrustPoints;
    }

    public void setMinTrustPoints(int minTrustPoints) {
        this.minTrustPoints = minTrustPoints;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public int getStartingRound() {
        return startingRound;
    }

    public void setStartingRound(int startingRound) {
        this.startingRound = startingRound;
    }

    public AuctionStatus getStatus() {
        return status;
    }

    public void setStatus(AuctionStatus status) {
        this.status = status;
    }

    public User getBoughtBy() {
        return boughtBy;
    }

    public void setBoughtBy(User boughtBy) {
        this.boughtBy = boughtBy;
    }


    @Override
    public String toString() {
        return "Auction{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", startingPrice=" + startingPrice +
                ", durationInRounds=" + durationInRounds +
                ", minTrustPoints=" + minTrustPoints +
                ", startingRound=" + startingRound +
                ", status=" + status +
                ", createdBy=" + createdBy +
                ", boughtBy=" + boughtBy +
                '}';
    }

    public abstract void subtractTrustPoints();
}
