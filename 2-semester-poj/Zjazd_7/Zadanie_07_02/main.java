package Zadania.Zjazd_7.Zadanie_07_02;

/**
 * @author Pawel Badysiak s21166
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class main {

    static List<Auction> auctionList = new ArrayList<>();
    static User loggedUser;
    static int currentRound = 1;

    public static void main(String[] args) {
        if (loggedUser == null)
            login();

        showMenu();

    }

    private static void login() {
        int idx = chooseUser();
        loggedUser = UserList.userList.get(--idx);
    }

    private static void showMenu() {
        Scanner sc = new Scanner(System.in);
        Menu[] menuArray = Menu.values();
        int option;
        while (true) {
            System.out.println("Current round: " + currentRound);
            System.out.printf("Auction Menu (logged as %s): \n", loggedUser.getLogin());
            for (int i = 0; i < menuArray.length; i++) {
                System.out.printf("%d. %s\n", i + 1, menuArray[i].getName());
            }
            option = sc.nextInt();
            clearBuffer(sc);
            if (option > menuArray.length || option < 1) {
                System.out.println("Wrong option");
                continue;
            }
            Menu chosenMenu = menuArray[option - 1];
            switch (chosenMenu) {

                case CREATE_AUCTION:
                    createAuction();
                    break;
                case NEXT_ROUND:
                    goToNextRound();
                    break;
                case SHOW_UNFINISHED:
                    showAuctionsByStatus(AuctionStatus.START);
                    break;
                case SHOW_FINISHED:
                    showAuctionsByStatus(AuctionStatus.END);
                    break;
                case FIND_BY_CREATOR:
                    findAuctionsByCreator();
                    break;
                case CHANGE_TRUSTPOINTS:
                    retractBuyerTrustPoints();
                    break;
                case CHANGE_USER:
                    login();
                    break;
                case EXIT:
                    return;
            }
        }
    }

    private static void createAuction() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Auction type: ");

        AuctionType[] auctionTypes = AuctionType.values();
        int type;
        while (true) {
            for (int i = 0; i < auctionTypes.length; i++) {
                System.out.printf("%d - %s\n", i + 1, auctionTypes[i]);
            }
            type = sc.nextInt();
            clearBuffer(sc);
            if (type > auctionTypes.length || type < 1) {
                System.out.println("Wrong number");
            } else {
                break;
            }
        }

        Auction auction = AuctionFactory.getAuction(auctionTypes[type - 1]);

        System.out.println("Auction name: ");
        auction.setName(sc.nextLine());
        System.out.println("Auction description: ");
        auction.setDescription(sc.nextLine());
        while (true) {
            System.out.println("Starting price: ");
            try {
                auction.setStartingPrice(sc.nextDouble());
                break;
            } catch (Exception e) {
                System.out.println("Wrong format, example. 11,3");
                clearBuffer(sc);
            }
        }
        clearBuffer(sc);
        System.out.println("Duration in rounds: ");
        auction.setDurationInRounds(sc.nextInt());
        clearBuffer(sc);
        while (true) {
            System.out.println("Mininum trust points: (max 100)");
            try {
                auction.setMinTrustPoints(sc.nextInt());
                if (auction.getMinTrustPoints() > 100 || auction.getMinTrustPoints() < 0)
                    throw new Exception();
                break;
            } catch (Exception e) {
                System.out.println("Wrong number, max. 100");
                clearBuffer(sc);
            }
        }
        clearBuffer(sc);
        auction.setCreatedBy(loggedUser);
        auction.setStartingRound(currentRound);

        auctionList.add(auction);

        System.out.println("Auction created!");
        System.out.println(auction);

    }

    private static void goToNextRound() {
        currentRound++;
        for (Auction auction : auctionList) {
            int start = auction.getStartingRound();
            int duration = auction.getDurationInRounds();
            if (currentRound - start > duration)
                auction.setStatus(AuctionStatus.END);
        }
    }

    private static void showAuctionsByStatus(AuctionStatus status) {
        List<Auction> auctions = auctionList.stream()
                .filter(auction -> auction.getStatus().equals(status))
                .collect(Collectors.toList());
        System.out.printf("\n%s auction list\n", status.equals(AuctionStatus.START) ? "Unfinished" : "Finished");
        printAuctionList(auctions);
    }

    private static void findAuctionsByCreator() {
        int idx = chooseUser() - 1;
        User user = UserList.userList.get(idx);
        List<Auction> auctions = auctionList.stream()
                .filter(auction -> auction.getCreatedBy().equals(user))
                .collect(Collectors.toList());
        printAuctionList(auctions);

    }

    private static void retractBuyerTrustPoints() {
        Scanner sc = new Scanner(System.in);
        System.out.println("From which auction you wish to retract buyer trust points: ");
        List<Auction> auctions = auctionList.stream()
                .filter(auction -> auction.getCreatedBy().equals(loggedUser)
                        && auction.getBoughtBy() != null)
                .collect(Collectors.toList());
        int idx;
        while (true) {
            idx = 1;
            printAuctionList(auctions);
            idx = sc.nextInt();
            clearBuffer(sc);
            if (idx > auctions.size() || idx < 1) {
                System.out.println("Wrong number");
            } else {
                break;
            }
        }
        Auction auction = auctions.get(--idx);
        auction.subtractTrustPoints();
        System.out.println("Points have been substracted from the buyer.");
    }

    private static int chooseUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select login: ");
        int idx;
        while (true) {
            idx = 1;
            for (User user : UserList.userList) {
                System.out.printf("%d - %s\n", idx++, user.getLogin());
            }
            idx = sc.nextInt();
            clearBuffer(sc);
            if (idx > UserList.userList.size() || idx < 1) {
                System.out.println("Wrong number");
            } else {
                break;
            }
        }
        return idx;
    }

    private static void clearBuffer(Scanner sc) {
        sc.nextLine();
    }

    private static void printAuctionList(List<Auction> auctions) {
        if (auctions.isEmpty()) {
            System.out.println("NO AUCTIONS FOUND");
        } else {
            int idx = 1;
            for (Auction auction : auctions) {
                System.out.printf("%d. %s\n", idx++, auction);
            }
        }
    }


}
