public class Starts {
    //these are all the different starts that the player can have
    static String playerName;
    static int funds;
    public void Rich(String name){
        playerName = name;
        funds = 1000000;
    }

    public void Retiree(String name){
        playerName = name;
        funds = 100000;
    }

    public void RockBottom(String name){
        playerName = name;
        funds = 100;
    }

    public void custom(String name, int f){
        playerName = name;
        funds = f;
    }

    //getters and setters

    public static String getPlayerName() {
        return playerName;
    }

    public static int getFunds() {
        return funds;
    }
}
