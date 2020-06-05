Lallu:Jallupackage words;

import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws AWTException, IOException {
        if(SystemTray.isSupported()) {
            Words words = new Words();
            words.displayMeaningsOnPopup();
        } else {
            System.out.println("Pop up notification is not supported by your system");
        }
    }
}
