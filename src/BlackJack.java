import java.util.*;

public class BlackJack {
    public static void blackjack() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int bet = 0;
        int total = 0;
        int[] deck = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
        boolean gameOn = true;

        //actual game
        while (gameOn) {
            if (Starts.funds == 0){
                System.out.println("You are out of money. Sorry! Better luck next time!");
                gameOn = false;
                break;
            }
            boolean round = true;
            while (round) {
                System.out.println("Welcome! How much would you like to bet?");
                System.out.println("You currently have: $" + Starts.getFunds());
                bet = Integer.parseInt(sc.nextLine());
                if (bet > Starts.funds) {
                    System.out.println("You do not have enough money. Please choose another amount.");
                    bet = Integer.parseInt(sc.nextLine());
                }
                //player cards
                ArrayList<Integer> cards = new ArrayList<>();
                System.out.println("Here are your cards:");
                cards.add(deck[rand.nextInt(14)]);
                cards.add(deck[rand.nextInt(14)]);
                System.out.println(cards.get(0) + ", " + cards.get(1));
                //dealer cards
                ArrayList<Integer> dealerCards = new ArrayList<>();
                dealerCards.add(deck[rand.nextInt(14)]);
                dealerCards.add(deck[rand.nextInt(14)]);
                System.out.println("Dealers cards: " + dealerCards.get(0));
                if (dealerCards.get(0) + dealerCards.get(1) == 21) {
                    System.out.println("Dealer has: ");
                    System.out.println(dealerCards.get(0) + ", " + dealerCards.get(1));
                    System.out.println("Dealer has 21. Sorry, you lose!");
                    Starts.funds -= bet;
                    round = false;
                }
                boolean playerTurn = true;
                while (playerTurn) {
                    System.out.print("Your cards: ");
                    int playerTotal = 0;
                    for (Integer c : cards) {
                        System.out.print(c + " ");
                        playerTotal += c;
                        if (playerTotal > 21) {
                            System.out.println("\nSorry! You're over 21!");
                            playerTurn = false;
                            round = false;
                        }
                    }

                    System.out.println("What would you like to do?");
                    System.out.println("1. Hit");
                    System.out.println("2. Stand");
                    System.out.println("3. Double Down");
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            cards.add(deck[rand.nextInt(14)]);
                            break;
                        case 2:
                            playerTurn = false;
                            break;
                        case 3:
                            bet *= 2;
                            cards.add(deck[rand.nextInt(14)]);
                            playerTurn = false;
                            break;
                    }
                }
                System.out.println("Dealer Cards:");
                System.out.println(dealerCards.get(0) + ", " + dealerCards.get(1));

                total = dealerCards.get(0) + dealerCards.get(1);
                while (total < 17) {
                    total = 0;
                    dealerCards.add(deck[rand.nextInt(14)]);
                    for (Integer x : dealerCards) {
                        total += x;
                    }
                }

                System.out.println("Dealer has: ");
                for (int i = 0; i < dealerCards.size(); i++) {
                    System.out.print(dealerCards.get(i) + " ");
                }
                System.out.println();

                System.out.println("Dealer total is: " + total);
                System.out.println("You have: ");
                for (int i = 0; i < cards.size(); i++) {
                    System.out.println(cards.get(i));
                }
                System.out.println("Your total is: ");
                int playerTotal = 0;
                for (int i = 0; i < cards.size(); i++) {
                    playerTotal += cards.get(i);
                }
                System.out.println(playerTotal);
                if (playerTotal > 21) {
                    System.out.println("Sorry! You Lose!");
                    Starts.funds -= bet;
                    round = false;
                } else if (playerTotal > total) {
                    System.out.println("Congrats! You win!");
                    Starts.funds += bet;
                    round = false;
                } else if (playerTotal < total && total <= 21) {
                    System.out.println("Sorry! You Lose!");
                    Starts.funds -= bet;
                    round = false;
                }
            }
                System.out.println("Play again?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int play_again_choice = Integer.parseInt(sc.nextLine());
                switch(play_again_choice){
                    case 1:
                        break;
                    case 2:
                        System.out.println("Thanks for playing!");
                        gameOn = false;
                        break;
                }
            }
        }
    }