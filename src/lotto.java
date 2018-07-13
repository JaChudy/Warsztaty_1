import java.util.*;

public class lotto {

    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        //tabOfUserNumbers();
        //randomTab();
        lottoWin();
        scanner.close();

    }

    static int[] tabOfUserNumbers (){
        int[] listOfUserNumbers = new int[6];
        int count = 1;

        System.out.println("Podaj liczbę numer " +count+":");
        while(!scanner.hasNextInt())
        {
            scanner.next();
            System.out.println("to nie jest liczba");
        }
        int liczba1 = scanner.nextInt();

        while (liczba1<1 || liczba1>49){
            System.out.println("Liczba przekracza zakres podaj liczbe z przedzilu od 1 do 49");
            while(!scanner.hasNextInt())
            {
                scanner.next();
                System.out.println("to nie jest liczba");
            }
            liczba1 = scanner.nextInt();
        }

        listOfUserNumbers[0]=liczba1;

        for(int i=1; i<6; i++){

                System.out.println("Podaj liczbę numer " +(i+1)+":");
                while(!scanner.hasNextInt())
                {
                    scanner.next();
                    System.out.println("to nie jest liczba");
                }
                int liczba = scanner.nextInt();

                while (liczba<1 || liczba>49){
                    System.out.println("Liczba przekracza zakres podaj liczbe z przedzilu od 1 do 49");
                    while(!scanner.hasNextInt())
                    {
                        scanner.next();
                        System.out.println("to nie jest liczba");
                    }
                    liczba = scanner.nextInt();
                }
            for(int j=0; j<i; j++) {
                while (liczba == listOfUserNumbers[j]) {
                    System.out.println("ta liczba juz jest w tablicy");
                    while (!scanner.hasNextInt()) {
                        scanner.next();
                        System.out.println("to nie jest liczba");
                    }
                    liczba = scanner.nextInt();
                }

                listOfUserNumbers[i] = liczba;
            }

        }
        Arrays.sort(listOfUserNumbers);
        //System.out.println(Arrays.toString(listOfUserNumbers));
        return listOfUserNumbers;
    }

    static Integer[] randomTab(){
        Integer[] arr = new Integer[49];
        for (int i=0 ; i<arr.length; i++){
            arr[i] = i+1;
        }
        //System.out.println(Arrays.toString(arr));
        Collections.shuffle(Arrays.asList(arr));

        Integer[] winTab = new Integer[6];
        for(int k=0; k<6; k++){
            winTab[k] = arr[k];
        }

        //System.out.println("Liczby wylowane przez maszyne to " + Arrays.toString(winTab));

        return winTab;
    }

    static void lottoWin(){
        Integer[] randT = randomTab();
        int[] user = tabOfUserNumbers();
        int counter =0;

        for(int i=0; i<user.length; i++){
            for(int k=0; k<randT.length; k++){
                if(user[i]==randT[k]){
                    counter++;
                }
            }
        }
        System.out.println("Liczby ktore wybrałeś to:" + Arrays.toString(user));
        Arrays.sort(randT);
        System.out.println("Liczby wybrane przez maszyne to:" + Arrays.toString(randT));
        if(counter<=2){
            System.out.println("Trafileś "+counter+"\n Nic nie wygraleś: Po co wydałeś kasę??");
        } else if (counter == 3){
            System.out.println("Trafiles poprawnie 3 liczby kupon sie zwróbił");
        } else if (counter == 4){
            System.out.println("Trafileś poprawnie 4 liczby możesz iść na piwo z kolegami");
        } else if (counter == 5){
            System.out.println("Trafileś poprawnie 5 liczb brawo ty");
        } else {
            System.out.println("BRAWO WYGRAŁEŚ TRAFIŁEŚ 6");
        }
    }
}
