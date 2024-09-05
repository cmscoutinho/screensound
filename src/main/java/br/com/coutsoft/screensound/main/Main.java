package br.com.coutsoft.screensound.main;

import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);

    public void showMenu() {

        int option;

        do {

            System.out.println("""
                Welcome to Screensound!
                Choose an option:
                                
                1-Register artist
                2-Register song
                3-List songs
                4-Search song by artist
                5-Look for info about artist
                9-Exit""");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    registerArtist();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 9:
                    break;
            }
        } while (option != 9);

    }

    private void registerArtist() {
        System.out.print("Artist's name:");
        var name = scanner.nextLine();

        System.out.print("Artist type (solo, duo, band):");
        var type = scanner.nextLine();

        System.out.print("Register another artist? (Y/N): ");
        var registerNew = scanner.nextLine();

    }
}
