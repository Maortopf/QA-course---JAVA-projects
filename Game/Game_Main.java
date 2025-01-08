package exams.Game;

import java.util.Scanner;

public class Game_Main {

    public static void main(String[] args) {
        Game1 instance_1 = new Game1();

        int Player_Choice;
        Scanner sc2 = new Scanner(System.in);
        boolean valid_choice = false;
        while(valid_choice == false){
            System.out.println("please choose your Game: \n - Game 1 \n - Game 2 \n - Game 3");
            Player_Choice= sc2.nextInt();
            if(Player_Choice == 1 || Player_Choice == 2 || Player_Choice == 3)
            {
                if(Player_Choice == 1){
                    Scanner sc3 = new Scanner(System.in);
                    Scanner sc4 = new Scanner(System.in);
                    System.out.println("insert a sum of money in shekels: ");
                    double amount = sc3.nextDouble();
                    System.out.println("now insert a currency from these options:\n - USD \n - JPY\n - EUR\n - GBP");
                    String currency = sc4.nextLine();
                    instance_1.currencyConvertor(amount,currency);
                    System.out.println("End credit:\n programmer: Maor topf \n Author: saed Jaber \n \n HOPE YOU ENJOIED THIS GAME");
                }////////////////////// //////////////// the first game - currency convertor
                else if(Player_Choice == 3){
                    instance_1.guessTheNumber();
                    System.out.println("End credit:\n programmer: Maor topf \n Author: saed Jaber \n \n HOPE YOU ENJOIED THIS GAME");
                } /////////// the third game - guess the number
                else
                {
                    System.out.println("Please insert you name: ");
                    Scanner sc1 = new Scanner(System.in);
                    String fullName = sc1.nextLine();
                    instance_1.upperFirst(fullName);
                    System.out.println("End credit:\n programmer: Maor topf \n Author: saed Jaber \n \n HOPE YOU ENJOIED THIS GAME");

                } /////////////////////////////////////////////////////// the second game - Acronym maker
                 valid_choice = true;
            }
            else
            {
                System.out.println("you inserted an Invalid number! try again");
            }
        }


    }
}
