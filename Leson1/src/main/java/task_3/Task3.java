package task_3;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Task3 {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        /*Napisz program, który odczyta od użytkownika takie dane jak:
        Imię Nazwisko Wiek Wzrost
        A nastiness na podstawie pobranych informacji wyświetli komunikat:
        “Hello <Twoje imię i nazwisko>! Thank you for joining us.
        You are <Twój wiek> years old and your height is <Twój wzrost>”.*/

        printDate();

        /*Napisz program, który pobierze od użytkownika dowolną liczbę całkowitą.
        Następnie na podstawie danych wejściowych, wyświetlaj komunikat “liczba parzysta” lub “nieparzysta”.*/

        checkNumberForEvenness();

        /* Napisz program “FizzBuzz”, który będzie pobierał od użytkownika dowolną liczbę całkowitą i będzie wyświetlał komunikat:
        “Fizz”, gdy liczba ta jest podzielna przez 3
        “Buzz”, gdy liczba ta jest podzielna przez 4
        “FizzBuzz”, gdy liczba ta jest podzielna przez 3 i 4 równocześnie
        “N/A”, gdy liczba ta nie jest podzielna ani przez 3, ani przez 4 */

        checkNumberForDivision();

        chooseZodiacSign();

        /*Napisz program wyświetlający liczby całkowite z przedziału <0; y>,
        gdzie y podaje użytkownik. Wykonaj to na pętli for i while.*/

         printNumberFromLimit();

        /*Napisz program wyświetlający liczby całkowite z przedziału <100; 50> w porządku malejącym.
         Wykonaj to na pętli for i while.*/

        printNumberInDescendingOrder(100,50);

        /*Napisz program wyświetlający liczby z przedziału <0, 5, 10, 15, …, 100>*/

        printNumberInRange();

        /*Napisz program, wyświetlający n kolejnych potęg liczby 2. Wartość n podaje użytkownik.*/

        exponentiation();

        /*Napisz program, który wyświetli liczby z przedziału <50; 100>
        podzielne przez całkowitą liczbę k, którą podaje użytkownik.
        Przekształć program tak, aby przedział podawał również użytkownik. */

        printNumbersFromEnteredLimit(3);

    }

    private static void printNumbersFromEnteredLimit(int k) {
        System.out.println("Podaj początkowy przedział <min; max>: ");
        int min = scanner.nextInt();
        int max  = scanner.nextInt();
        IntStream.range(min, max).filter(i -> i % k == 0).forEach(System.out::println);
    }

    private static void exponentiation() {
        System.out.print("Podaj wartość n: ");
        for (int i = 0; i < scanner.nextInt(); i++) {
            System.out.println(Math.pow(2, i));
        }
    }

    private static void printNumberInRange() {
        for (int i = 0; i <= 100; i += 5) {
            System.out.println(i);
        }
    }

    private static void printNumberInDescendingOrder(int a, int b) {
        if (a > b) {
            while (a >= b) {
                System.out.println(a);
                a--;
            }
        } else if (b > a) {
            for (int i = b; i >= a; i--) {
                System.out.println(i);
            }
        } else {
            System.out.println("numbers are equals");
        }
    }

    private static void printNumberFromLimit() {
        System.out.println("Podaj liczbę całkowitą: ");
        int y = scanner.nextInt();
        if (y > 0) {
            IntStream.range(0, y).forEach(System.out::println);
//            int i = 0;
//            while (i <= y) {
//                System.out.println(i);
//                i++;
        }
    }

    private static void chooseZodiacSign() {
        System.out.println("Choose your Zodiac sign: Aquarius, Pisces, Aries, Taurus, " +
                "Gemini, Cancer, Leo, Virgo, Libra, Scorpio, Sagittarius, Capricorn");
        String s = scanner.next();

        switch (s) {
            case "Aquarius" -> System.out.println("You're born between " + "20 Jan and 18 Feb");
            case "Pisces" -> System.out.println("You're born between " + "19 Feb and 19 Mar");
            case "Aries" -> System.out.println("You're born between " + "21 Mar and 19 Apr");
            case "Taurus" -> System.out.println("You're born between " + "20 Apr and 22 May");
            case "Gemini" -> System.out.println("You're born between " + "22 May and 21 Jun");
            case "Cancer" -> System.out.println("You're born between " + "22 Jun and 22 Jul");
            case "Leo" -> System.out.println("You're born between " + "23 Jul and 22 Aug");
            case "Virgo" -> System.out.println("You're born between " + "24 Aug and 22 Sep");
            case "Libra" -> System.out.println("You're born between " + "23 Sep and 22 May");
            case "Scorpio" -> System.out.println("You're born between " + "23 Oct and 21 Nov");
            case "Sagittarius" -> System.out.println("You're born between " + "22 Nov and 21 Dec");
            case "Capricorn" -> System.out.println("You're born between " + "22 Dec and 19 Jan");
        }
    }

    private static void checkNumberForDivision() {
        System.out.println("Podaj liczbę całkowitą: ");
        while (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            if (value % 3 == 0 && value % 4 == 0) {
                System.out.println("FizzBuzz");
            } else if (value % 3 == 0) {
                System.out.println("Fizz");
            } else if (value % 4 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println("N/A");
            }
        }
    }

    private static void checkNumberForEvenness() {
        while (scanner.hasNextInt()) {
            System.out.println(scanner.nextInt() % 2 == 0 ? "liczba parzysta" : "liczba nieparzysta");
        }
    }

    private static void printDate() {
        System.out.print("Podaj swoje imię: ");
        String firstName = scanner.nextLine();

        System.out.print("Podaj swoje nazwisko: ");
        String lastName = scanner.nextLine();

        System.out.print("Podaj swój wiek: ");
        int age = scanner.nextInt();

        System.out.print("Podaj swój wzrost: ");
        double height = scanner.nextDouble();

        System.out.printf("Hello %s %s! Thank you for joining us.\n" +
                "You are %d years old and your height is %2f" , firstName, lastName, age, height);
    }

}
