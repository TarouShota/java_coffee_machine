package machine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int disposables ;
    private int money;
    static Map<Integer,String> map = new HashMap<>();

    static {
        map.put(0,"water");
        map.put(1,"milk");
        map.put(2,"beans");
        map.put(3,"money");
        map.put(4,"disposables");
    }
    static int [] ingredients = new int[5];
    public CoffeeMachine(int water, int milk, int beans, int disposables, int money)
    {
        this.water = water;
        this.milk=milk;
        this.beans=beans;
        this.disposables=disposables;
        this.money =money;
    }


    public void init()
    {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Write action (buy, fill, take, exit, remaining): ");
            String action = scanner.nextLine();


            switch (action){
                case "buy":{
                    this.buy();
                    break;
                }
                case "fill":{
                    fill();
                    break;
                }
                case "take":{
                    take();
                    break;
                }
                case "remaining":{
                    printState();
                    break;
                }
                case "exit":{
                    return;
                }
            }
        }



    }

    private void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " ml of water");
        System.out.println(this.milk + " ml of milk");
        System.out.println(this.beans+ " g of coffee beans");
        System.out.println(this.disposables+" disposable cups");
        System.out.println("$"+this.money+" of money");
    }

    public void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Scanner scanner = new Scanner(System.in);
        String coffeeType = scanner.nextLine();

        switch (coffeeType){
            case "1":{
                buyACup(250,0,16,4);
                break;
            }
            case "2":{
                buyACup(350,75,20,7);
                break;
            }
            case "3":{
                buyACup(200,100,12,6);
                break;
            }
            default:
                break;
        }
    }

    private void buyACup(int waterToUse,int milkToUse,int beansToUse,int moneyToAdd) {



        if (this.water < waterToUse) {
            System.out.println("Sorry, not enough water!");
            return;
        }

        if (this.milk < milkToUse) {
            System.out.println("Sorry, not enough milk!");
            return;
        }

        if (this.beans < beansToUse) {
            System.out.println("Sorry, not enough coffee bean!");
            return;
        }

        if (this.disposables<1){
            System.out.println("Sorry, not enough disposable cups!");
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");
        this.water=this.water-waterToUse;
        this.milk=this.milk-milkToUse;
        this.beans=this.beans-beansToUse;
        this.money=this.money+moneyToAdd;
        this.disposables=this.disposables-1;


    }

    void fill(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water you want to add:");
        this.water= this.water+ scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        this.milk =this.milk+ scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        this.beans = this.beans+ scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        this.disposables = this.disposables+ scanner.nextInt();

    }
    void take(){
        System.out.println("I gave you $"+this.money);
        this.money=0;
    }

}

