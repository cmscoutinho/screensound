package br.com.coutsoft.screensound.main;

import java.util.Scanner;

public class Main {

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Welcome to Screensound!
                Choose an option:
                                
                1-Register artist
                2-Register song
                3-List songs
                4-Search song by artist
                5-Look for info about artist
                9-Exit""");

        var option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
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
    }
}
