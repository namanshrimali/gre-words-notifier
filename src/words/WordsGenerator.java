package words;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordsGenerator {
  private final Map< String, String> words = new HashMap<>();
  TrayIcon trayIcon;

  public WordsGenerator(short section, short level) throws AWTException, IOException {
    SystemTray tray = SystemTray.getSystemTray();
    Image image = Toolkit.getDefaultToolkit().createImage("");
    trayIcon = new TrayIcon(image, "GRE Word Meanings");
    trayIcon.setImageAutoSize(true);
    tray.add(trayIcon);
    populateWordMeaningsSet(section, level);

  }

  private void populateWordMeaningsSet(short section, short level) throws IOException {
    String filePath = String.format("resources/%s%s.txt", section, level);
    String line;
    BufferedReader reader = new BufferedReader(new FileReader(filePath));
    while ((line = reader.readLine()) != null)
    {
      String[] parts = line.split(":", 2);
      if (parts.length >= 2)
      {
        String key = parts[0];
        String value = parts[1];
        words.put(key, value);
      } else {
        System.out.println("ignoring line: " + line);
      }
    }

    reader.close();
  }

  public void displayMeaningsOnPopup(short frequency) {
    while(!words.isEmpty()) {
      System.out.println("======= Words Service Started =======");
      try {
        for (Map.Entry<String, String> wordAndMeaning : words.entrySet()) {
          popupMachine(wordAndMeaning);
          Thread.sleep(frequency*60*1000);
        }
      } catch (InterruptedException | AWTException e) {
        e.printStackTrace();
      }
    }
  }
  private void popupMachine(Map.Entry<String, String> wordAndMeaning) throws AWTException {
    System.out.println(String.format("Generating popup %s ---- %s", wordAndMeaning.getKey(), wordAndMeaning.getValue()));
    trayIcon.displayMessage(wordAndMeaning.getKey(), wordAndMeaning.getValue(), TrayIcon.MessageType.INFO);
  }
}
