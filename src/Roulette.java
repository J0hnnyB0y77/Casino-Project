import java.util.Scanner;
import java.util.Random;

public class Roulette {
    public static void roulette() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int[][] roulette_number = new int[3][12];
        int bet;
        boolean win = true;
        boolean gameOn = true;

        int[][] Roullette = new int[3][12];

        //filling the table
        for (int i = 0; i < 3; i++) {
            int num = i + 1;
            for (int j = 0; j < 12; j++) {
                Roullette[i][j] = num;
                num += 3;
            }
        }
        while (gameOn) {
            if (Starts.funds == 0){
                System.out.println("You are out of money. Sorry! Better luck next time!");
                gameOn = false;
                break;
            }
            System.out.println("Welcome to Roulette! How much would you like to bet?");
            System.out.println("You currently have: $" + Starts.getFunds());
            bet = sc.nextInt();
            while (bet > Starts.getFunds()) {
                System.out.println("You do not have enough money. Choose another amount:");
                bet = sc.nextInt();
            }

            //printing table
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 12; j++) {
                    System.out.print(Roullette[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("What would you like to choose?");
            System.out.println("1. Choose a number");
            System.out.println("2. Choose odd or even");
            System.out.println("3. Choose a third");
            System.out.println("4. Choose a half");
            int choice = Integer.parseInt(sc.nextLine());
            int row = rand.nextInt(3);
            int column = rand.nextInt(12);

            switch (choice) {
                case 1:
                    System.out.println("Please choose a number.");
                    int num_choice = Integer.parseInt(sc.nextLine());
                    if (num_choice > 36 || num_choice < 1) {
                        System.out.println("Number out of bounds, please try again.");
                        num_choice = sc.nextInt();
                    }
                    if (num_choice == roulette_number[row][column]) {
                        win = true;
                        bet *= 35;
                    } else {
                        win = false;
                    }
                    break;
                case 2:
                    System.out.println("Please choose:");
                    System.out.println("1. Odd");
                    System.out.println("2. Even");
                    int oddeven = Integer.parseInt(sc.nextLine());
                    if (oddeven == 1) {
                        if (roulette_number[row][column] % 2 != 0) {
                            win = false;
                        } else {
                            win = true;
                        }
                    } else if (oddeven == 2) {
                        if (roulette_number[row][column] % 2 == 0) {
                            win = true;
                        } else {
                            win = false;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Please choose:");
                    System.out.println("1. 1 - 12");
                    System.out.println("2. 13- 24");
                    System.out.println("3. 25 - 36");
                    int third_choice = Integer.parseInt(sc.nextLine());
                    switch (third_choice) {
                        case 1:
                            if (roulette_number[row][column] < 13) {
                                win = true;
                            } else {
                                win = false;
                            }
                            break;
                        case 2:
                            if (roulette_number[row][column] > 12 && roulette_number[row][column] < 25) {
                                win = true;
                            } else {
                                win = false;
                            }
                            break;
                        case 3:
                            if (roulette_number[row][column] > 24) {
                                win = true;
                            } else {
                                win = false;
                            }
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Please choose a half:");
                    System.out.println("1. 1 - 18");
                    System.out.println("2. 19 - 36");
                    int half_choice = Integer.parseInt(sc.nextLine());
                    switch (half_choice) {
                        case 1:
                            if (roulette_number[row][column] < 19) {
                                win = true;
                            } else {
                                win = false;
                            }
                            break;
                        case 2:
                            if (roulette_number[row][column] > 18) {
                                win = true;
                            } else {
                                win = false;
                            }
                            break;
                    }
                    break;
            }
            if (win) {
                System.out.println("You win! Congrats!");
                Starts.funds += bet;
            } else {
                System.out.println("Sorry! You lose!");
                Starts.funds -= bet;
            }
            System.out.println("Keep playing?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int keepPlaying = Integer.parseInt(sc.nextLine());
            switch (keepPlaying) {
                case 1:
                    gameOn = true;
                    break;
                case 2:
                    gameOn = false;
                    break;
            }
        }
    }
}