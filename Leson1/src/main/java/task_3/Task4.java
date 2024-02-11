package task_3;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Task4 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*Użytkownik przykładowo wprowadza kolejno liczby 1, 2, 3, 0 wtedy zwrócona suma to 1 + 2 + 3 + 0 = 6.
        Z kolei dla liczb 1, 9, 2, -12 suma wyniesie 0.*/

        sum();

        /*Wypisz wartość średniej arytmetycznej pierwszych 10 liczb naturalnych.*/

        average();

        /*Twoim zadaniem jest złamać metodą brute-force słabe hasło składające się z 4 znaków będących literami
        alfabetu łacińskiego (litery zarówno małe jak i wielkie). Wygeneruj wszystkie możliwe kombinacje takiego
        hasła i wyświetl każdą z osobna.*/

        bruteForceAttack();

        /*Menu ma działać w oparciu o wybrany rodzaj pętli i ma wyświetlać userowi możliwe do wybrania wybory,
        dopóki nie wybierze opcji nr 4.*/

        displayInfo();

        /*Napisz program, który wczytuje od użytkownika liczbę oznaczającą, ile należy wylosować liczb z zakresu
        -100 do 100. Naspnie dokonuje obliczeń stosunku liczby wylosowanych liczb dodatnich (bez zera) do liczb
        ujemnych oraz wyświetla najmniejszą i największą znalezioną liczbę (użytkownik musi podać przynajmniej 2 liczby).
        Wynikiem działania programu ma być informacja na temat wszystkich trzech wartości. */

        checkRandomNumbers();
    }

    private static void checkRandomNumbers() {
        Random rand = new Random();
        int number = scanner.nextInt();
        while (number < 2) {
            System.out.println("Nieprawidłowa opcja. Podaj przynajmniej 2 liczby.");
            number = scanner.nextInt();
        }
        List<Integer> integers = IntStream.range(0, number)
                .mapToObj(i -> rand.nextInt(201) - 100)
                .sorted()
                .toList();
        long ratio = 0;
        try {
            ratio = integers.stream()
                    .filter(integer -> integer > 0)
                    .count() / integers.stream()
                    .filter(integer -> integer < 0)
                    .count();
        } catch (Exception e) {
            ratio = integers.size();
            System.out.println("Wszystkie liczby są dodatnie. Ich liczba: " + integers.size());
        }
        System.out.printf("%d, %d, %d ", ratio, integers.get(0), integers.get(integers.size() - 1));
    }

    private static void displayInfo() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1 - Wyświetl ilość kursantów");
            System.out.println("2 - Wyświetl nazwę firmy");
            System.out.println("3 - Wyświetl rok założenia firmy");
            System.out.println("4 - Wyjdz");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> System.out.println("Ilość kursantów: 70");
                case 2 -> System.out.println("Nazwa firmy:Devs-Mentoring.pl");
                case 3 -> System.out.println("Rok założenia firmy: 2021");
                case 4 -> {
                    System.out.println("Wyjdz");
                    System.exit(0);
                }
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

    private static void bruteForceAttack() {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String password = "";

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters.length; j++) {
                for (int k = 0; k < letters.length; k++) {
                    for (int l = 0; l < letters.length; l++) {
                        password = letters[i] + letters[j] + letters[k] + letters[l];
                        System.out.println(password);
                    }
                }
            }
        }
    }

    private static void average() {
        System.out.println(IntStream.rangeClosed(1, 10).sum() / 10);
    }

    private static void sum() {
        int sum = 0;
        System.out.println("Wpisz liczbę całkowitą (0, aby zakończyć): ");
        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            sum += number;
            System.out.println("Wpisz kolejną liczbę całkowitą (0, aby zakończyć): ");
        }
        System.out.println("Ostateczna suma wynosi: " + sum);
    }
}
