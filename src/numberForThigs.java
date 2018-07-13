import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class numberForThigs {

    static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        //System.out.println(randomNumber());
        //tabForTo(20,30);
        question();
        scanner.close();
    }

    static Integer[] tabForTo(int min, int max){
        int k = max-min;
        Integer[] tabelForTo = new Integer[(max-min) +1];

        for(int i =0; i<tabelForTo.length; i++){
            tabelForTo[i] = k;
            k++;
        }
        System.out.println(Arrays.toString(tabelForTo));
        return tabelForTo;

    }

    static void question(){
        System.out.println("Pomyśl liczbę od 0 - 1000");
        int min = 0;
        int max = 1000;


        //Integer[] tablica = tabForTo(min, max);

        int guess = ((max-min)/2)+min;
        int count =1;
        System.out.println("Zagduje" + guess + "?");

        System.out.println("Czy zgadlem? \n Jeśli tak naciśnij T \n Jeśli moja liczba jest za duża" +
                "naciśnij  D \n Jeśli moja liczba jest za mała naciśnij  L");
        String answerd = scanner.nextLine();

        while(true){
            if(answerd.equalsIgnoreCase("T") ||
                    answerd.equalsIgnoreCase("L") ||
                    answerd.equalsIgnoreCase("D")  ){
                System.out.println("Tak by to szlafił");
                break;
            } else {
                System.out.println("Niepoprawna wartosc: Czy zgadlem? \n Jeśli tak naciśnij T \n Jeśli moja liczba jest za duża" +
                        "naciśnij  D \n Jeśli moja liczba jest za mała naciśnij  L");
                answerd = scanner.nextLine();
            }
        }

        while (!answerd.equalsIgnoreCase("t")) {

            if (answerd.equalsIgnoreCase("L")) {
                min = guess;
            } else if (answerd.equalsIgnoreCase("d")) {
                max = guess;
            }
            guess = (max - min) / 2 + min;

            System.out.println("czy jest to" + guess + "?\n" +
                    "Czy zgadlem? \n Jeśli tak naciśnij T \n Jeśli moja liczba jest za duża" +
                    "naciśnij  D \n Jeśli moja liczba jest za mała naciśnij  L");
            answerd = scanner.nextLine();

            count++;
        }

        System.out.println("Pomyslana przez ciebie lcizba to " + guess + " odgadlem ja w " +count+ " krokach");

    }


}
