package exams.Game;

import java.util.Scanner;

public class Game1 {
    int GameID;


    public void currencyConvertor(double amount, String currency){
        boolean valid_answer = false;
        while(!valid_answer){
        switch (currency) {
            case "USD":
                System.out.println("the value in " + currency + " is: " + amount / 3.7);
                valid_answer = true;
                break;
            case "JPY":
                System.out.println("the value in " + currency + " is: " + amount * 39.13);
                valid_answer = true;
                break;
            case "EUR":
                System.out.println("the value in " + currency + " is: " + amount / 4.17);
                valid_answer = true;
                break;
            case "GBP":
                System.out.println("the value in " + currency + " is: " + amount / 4.76);
                valid_answer = true;
                break;
            default:
                System.out.println("invalid currency was inserted in the system");
                Scanner sc5 = new Scanner(System.in);
                System.out.println("insert a currect currency: ");
                currency = sc5.nextLine();
                break;
            }
        }
    }

    public void upperFirst (String fullName){

        String[] names = fullName.split("\\s", 2);
        StringBuilder Acronym = new StringBuilder();
        for (String name: names){
            Acronym.append(Character.toUpperCase(name.charAt(0))).append(".");
        }
        System.out.println(Acronym.toString().substring(0, Acronym.length()-1)+" is the acronym.");

    }

    public void guessTheNumber(){
        int actual_number = (int) (Math.random()*10 + 1);
        Scanner sc1 = new Scanner(System.in);
        int fail_count = 0;
        int player_guess = 0;
        while (player_guess != actual_number){
            System.out.println("guess the number: ");

            player_guess = sc1.nextInt();
            if(player_guess == actual_number){
                System.out.println("nice! you got the number");
            }
            else
            {
                System.out.println("oops you got the wrong number!");
                fail_count++;
                        if(fail_count == 3){
                            System.out.println("you have failed for the last time! the answer was: "+ actual_number+"\n GAME OVER");
                            break;
                        }
            }
        }
    }
}
