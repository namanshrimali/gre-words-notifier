package words;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Words {
  private final Map< String, String> words = new HashMap<>();
  private final SystemTray tray;
  TrayIcon trayIcon;

  public Words() throws AWTException, IOException {
    tray = SystemTray.getSystemTray();
    Imagpackage words;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Words {
  private final Map< String, String> words = new HashMap<>();
  private final SystemTray tray;
  TrayIcon trayIcon;

  public Words() throws AWTException, IOException {
    tray = SystemTray.getSystemTray();
    Image image = Toolkit.getDefaultToolkit().createImage("");
    trayIcon = new TrayIcon(image, "GRE Word Meanings");
    trayIcon.setImageAutoSize(true);
    tray.add(trayIcon);

    populateWordMeaningsSet();

  }

  private void populateWordMeaningsSet() throws IOException {
    String filePath = "resources/words.txt";
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

  public void displayMeaningsOnPopup() {
    while(!words.isEmpty()) {
      System.out.println("======= Words Service Started =======");
      try {
        for (Map.Entry<String, String> wordAndMeaning : words.entrySet()) {
          popupMachine(wordAndMeaning);
          Thread.sleep(10000);
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
