package task_3.space;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static SpaceX spaceX = new SpaceX();


    public static void main(String[] args) {

        getFuelLevel(spaceX);
        getAstronaut(spaceX);
        countAllDistance();

        System.out.println(spaceX.getDistance() >= 2000 ? "Statek kosmiczny dotarł do orbity" : "Statek kosmiczny nie dotarł do orbity");
    }


    private static void countAllDistance() {
        while (checkFuelConsumption()) {
            spaceX.setDistance(spaceX.getDistance() + 100);
            System.out.println("Aktualnie przebyty dystans przez statek kosmiczny: " + spaceX.getDistance());
            fuelConsumption(spaceX);
        }
    }

    private static boolean checkFuelConsumption() {
        return spaceX.getFuel() - (300 + 100 * spaceX.getAstronaut()) > 0;
    }

    private static void fuelConsumption(SpaceX spaceX) {
        for (int i = 0; i < 3; i++) {
            if (checkFuelConsumption()) {
                spaceX.setFuel(spaceX.getFuel() - (300 + 100 * spaceX.getAstronaut()));
            } else {
                i = 3;
                System.out.println("skończyło się paliwo");
            }
        }
    }

    private static int getAstronaut(SpaceX spaceX) {
        System.out.println("Podaj ilośc astronautòw (max-7): ");
        while (true) {
            spaceX.setAstronaut(scanner.nextInt());
            if (spaceX.getAstronaut() <= 7 && spaceX.getAstronaut() > 0) {
                return spaceX.getAstronaut();
            }
            System.out.println("Nieprawidłowa ilośc astronautòw. Podaj wartość z przedziału 1-7.");
        }
    }

    private static int getFuelLevel(SpaceX spaceX) {
        System.out.println("Podaj poziom paliwa (5000-30000): ");
        while (true) {
            spaceX.setFuel(scanner.nextInt());
            if (spaceX.getFuel() >= 5000 && spaceX.getFuel() <= 30000) {
                return spaceX.getFuel();
            }
            System.out.println("Nieprawidłowa wartość paliwa. Podaj wartość z przedziału 5000-30000.");
        }
    }
}

