package words;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws AWTException, IOException {
        if(SystemTray.isSupported()) {
            System.out.println("======= GRE WORDS NOTIFIER =======");
            WordsGenerator words = new WordsGenerator();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the desired frequency (words/minute) in which you want to see the notifications : ");
            words.displayMeaningsOnPopup(scanner.nextInt());
        } else {
            System.out.println("Pop up notification is not supported by your system");
        }
    }
}
