package task_2;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(5);
        integers.add(10);
        integers.add(15);
        integers.add(4);

        System.out.println(sum(integers));
        String text = "java";
        System.out.println(addLetters(text));

        System.out.println(splitNumber(integers));
        System.out.println(revers(text));

    }

    boolean checkNumber(int a) {
        return a % 2 != 0;
    }

    static int sum(List<Integer> integers) {
        int number = 0;
        for (int i = 0; i <= integers.size() - 1; i++) {
            if (i % 2 == 0) {
                number += integers.get(i);
            }
        }
        return number;
    }

    static String addLetters(String text) {
        char[] chars = text.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= chars.length - 1; i++) {
            if (i % 2 == 0) {
                stringBuilder.append(chars[i]);
            }
        }
        return stringBuilder.toString();
    }

    static List<List<Integer>> splitNumber(List<Integer> integers) {
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        integers.stream().filter(integer -> integer % 2 == 0)
                .forEach(evenNumbers::add);

        integers.stream().filter(integer -> integer % 2 != 0)
                .forEach(oddNumbers::add);
        return List.of(oddNumbers, evenNumbers);
//        integers.forEach(i -> {
//            if (integers.get(i) % 2 == 0) {
//                evenNumbers.add(integers.get(i));
//            } else {
//                oddNumbers.add(integers.get(i));
//            }
//        });
//        return List.of(oddNumbers, evenNumbers);
    }

    static String revers(String text) {
      /*  char[] chars = text.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();*/
        return new StringBuilder(text).reverse().toString();
    }
}
