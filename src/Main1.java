import java.util.Random;
import java.util.Scanner;

public class Main1 {

    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println("Cześć!!!");
        corectNumber();

    }

    static int userNumbers(){
        System.out.println("Zgadnij liczbę");

        while(!scanner.hasNextInt()){
            scanner.next();
            System.out.println("To nie jest liczba");
        }
        int number = scanner.nextInt();
        //scanner.next();
        return number;
    }

    static int randomNumbers(){
        Random rand = new Random();
        int r = rand.nextInt(100) + 1;
        return r;
    }

    static void corectNumber(){
        int randNumber = randomNumbers();
        //System.out.println(randNumber);
        int count = 1;
        int userNumber = userNumbers();

        while (randNumber!=userNumber){
            if(userNumber>=1 && userNumber<=100) {
                if (userNumber > randNumber) {
                    System.out.println("Za dużo! Sprobuj raz jeszcze");
                    userNumber = userNumbers();
                } else if (userNumber < randNumber) {
                    System.out.println("Za mało!! Spróbuj raz jeszcze");
                    userNumber = userNumbers();
                }
            } else {
                System.out.println("Liczba musi zawirac sie w przedziale od 0 do 100");
                userNumber=userNumbers();
            }
            count ++;
        }

        System.out.println("Brawo ta liczba to "+ userNumber +  "odgadleś ja w " +count+" krokach");
    }
}
