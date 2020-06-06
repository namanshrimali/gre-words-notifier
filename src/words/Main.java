package words;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws AWTException, IOException {
        System.out.println("======= GRE WORDS NOTIFIER =======");
        Scanner scanner = new Scanner(System.in);
        System.out.print("======= Sections =======\n3. Advanced Words\nSelect section : ");
        short section = scanner.nextShort();
        System.out.print("======= Levels =======\n4. Level 4\n5. Level 5\nSelect level : ");
        short level = scanner.nextShort();
        System.out.print("Enter the desired frequency (words/minute) in which you want to see the notifications : ");
        WordsGenerator words = new WordsGenerator(section, level);
        words.displayMeaningsOnPopup(scanner.nextShort());
    }
}
