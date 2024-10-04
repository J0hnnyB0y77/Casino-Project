import java.util.*;

public class Slots {
    public static void slots(){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        boolean slotGame = true;
        char[][] slotMachine = new char[3][6];
        for (int i = 0; i < 3; i++){
            slotMachine[i][0] = '\u2660';
            slotMachine[i][1] = '\u2663';
            slotMachine[i][2] = '\u2665';
            slotMachine[i][3] = '\u2666';
            slotMachine[i][4] = '\u266B';
            slotMachine[i][5] = '\u263A';
        }



        //actual game
        while(slotGame){
            if (Starts.funds == 0){
                System.out.println("You are out of money. Sorry! Better luck next time!");
                slotGame = false;
                break;
            }
            System.out.println("Welcome to slots! What would you like to do?");
            System.out.println("1. Play slots");
            System.out.println("2. Show the combinations");
            System.out.println("3. Quit");
            int choice = Integer.parseInt(sc.nextLine());
            //switch statement
            switch (choice){
                case 1:
                    boolean round = true;
                    while(round) {
                        System.out.println("What would you like to bet?");
                        int bet = Integer.parseInt(sc.nextLine());
                        if (bet > Starts.funds){
                            System.out.println("You do not have enough money. Please choose another value.");
                            bet = Integer.parseInt(sc.nextLine());
                        }
                        Starts.funds -= bet;
                        char[] slots = new char[3];
                        for (int x = 0; x < 3; x++) {
                            slots[x] = slotMachine[rand.nextInt(3)][rand.nextInt(6)];
                        }
                        for (char s : slots) {
                            System.out.print(s + " ");
                        }
                        System.out.println();
                        if (slots[0] == '\u2660' && slots[1] == '\u2660' && slots[2] == '\u2660') {
                            System.out.println("Congrats! You just hit the Jackpot!");
                            bet *= 3;
                            Starts.funds += bet;
                        } else if (slots[0] == '\u2663' && slots[1] == '\u2663' && slots[2] == '\u2663') {
                            System.out.println("Congrats! You got three clubs!");
                            bet *= 1.5;
                            Starts.funds += bet;
                        } else if (slots[0] == '\u2665' && slots[1] == '\u2665' && slots[2] == '\u2665') {
                            System.out.println("Congrats! You got three Hearts!");
                            bet *= 2;
                            Starts.funds += bet;
                        } else if (slots[0] == '\u2666' && slots[1] == '\u2666' && slots[2] == '\u2666') {
                            System.out.println("Congrats! You got three Diamonds!");
                            bet *= 2.5;
                            Starts.funds += bet;
                        } else if (slots[0] == '\u266B' && slots[1] == '\u266B' && slots[2] == '\u266B') {
                            System.out.println("Congrats! You got three Notes!");
                            bet *= 1.1;
                            Starts.funds += bet;
                        } else if (slots[0] == '\u263A' && slots[1] == '\u263A' && slots[2] == '\u263A') {
                            System.out.println("Congrats! You got three Smileys!");
                            bet += 1.5;
                            Starts.funds += bet;
                        } else {
                            System.out.println("Sorry! You lose!");
                        }
                        System.out.println("Play again?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        int playAgain = Integer.parseInt(sc.nextLine());
                        if (playAgain == 2){
                            round = false;
                        }
                    }
                    break;
                case 2:
                    System.out.println("\u266B \u266B \u266B: \t 1.1X");
                    System.out.println("\u263A \u263A \u263A: \t 1.5X");
                    System.out.println("\u2665 \u2665 \u2665: \t 2X");
                    System.out.println("\u2666 \u2666 \u2666: \t 2.5X");
                    System.out.println("\u2660 \u2660 \u2660: \t 3X");
                    System.out.println("Type '1' to go back");
                    int goBack = Integer.parseInt(sc.nextLine());
                    if (goBack == 1){
                        break;
                    }
                case 3:
                    System.out.println("Thanks for playing! See you later!");
                    slotGame = false;
                    break;
            }
        }
    }
}
