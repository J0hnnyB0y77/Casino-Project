import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Starts character = new Starts();
        boolean gameOn = true;
        boolean chooseChar = true;

        //choosing character
        System.out.println("Welcome to the Casino! What is your name?");
        String name = sc.nextLine();
        while (chooseChar) {
            System.out.println("What is your backstory?");
            System.out.println("1. Rich");
            System.out.println("2. Retiree");
            System.out.println("3. Rock Bottom");
            System.out.println("4. Custom");
            int choice = Integer.parseInt(sc.nextLine());
            int charChoice;
            switch (choice){
                case 1:
                    System.out.println("Rich: Whether you're an oil baron, a silicon valley geek, or you got a hold of your rich dad's credit card, you've got money, and a lot of it. \nBut be careful: big bets can lead to big losses, and you may not be rich for long. \nMoney: $1,000,000");
                    System.out.println("1. Choose character");
                    System.out.println("2. Go back");
                    charChoice = Integer.parseInt(sc.nextLine());
                    if (charChoice == 1){
                        character.Rich(name);
                        chooseChar = false;
                    }
                    break;
                case 2:
                    System.out.println("Retiree: You've had a successful and long career, and now its time to have some fun. You've built up a decent amount of money to have fun with, \nbut its not infinite. \nMoney: $100,000");
                    System.out.println("1. Choose character");
                    System.out.println("2. Go back");
                    charChoice = Integer.parseInt(sc.nextLine());
                    if (charChoice == 1){
                        character.Retiree(name);
                        chooseChar = false;
                    }
                    break;
                case 3:
                    System.out.println("Rock Bottom: You came to sin city with money in your pocket and a gleam in your eye, but through gambling, partying, or both, you're down to \nyour last Benjamin. Can you get back on your feet? Or will you be another victim of the casino? \nMoney: $100");
                    System.out.println("1. Choose character");
                    System.out.println("2. Go back");
                    charChoice = Integer.parseInt(sc.nextLine());
                    if (charChoice == 1){
                        character.RockBottom(name);
                        chooseChar = false;
                    }
                    break;
                case 4:
                    System.out.println("Custom: If you'd rather set your own story, you can set your own funds.");
                    System.out.println("1. Choose character");
                    System.out.println("2. Go back");
                    charChoice = Integer.parseInt(sc.nextLine());
                    if (charChoice == 1){
                        System.out.println("How much money do you want to start with?");
                        int money = Integer.parseInt(sc.nextLine());
                        if (money <= 0){
                            System.out.println("Invalid Amount, enter another!");
                            money = Integer.parseInt(sc.nextLine());
                        }
                        character.custom(name, money);
                        chooseChar = false;
                    }
                    break;
            }
        }

        //main program
        while (gameOn) {
            if (Starts.funds == 0){
                gameOn = false;
                break;
            }
            System.out.println("Name: " + Starts.getPlayerName() + "\tMoney: $" + Starts.getFunds());
            System.out.println("Welcome to the Casino! Please choose a game to play:");
            System.out.println("1. Roulette");
            System.out.println("2. BlackJack");
            System.out.println("3. Slots");
            System.out.println("4. Quit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Roulette roulette = new Roulette();
                    roulette.roulette();
                    break;
                case 2:
                    BlackJack bJ = new BlackJack();
                    bJ.blackjack();
                    break;
                case 3:
                    Slots slot = new Slots();
                    slot.slots();
                    break;
                case 4:
                    System.out.println("Thank you for playing! See you again soon!");
                    gameOn = false;
                    break;
            }
        }
    }
}