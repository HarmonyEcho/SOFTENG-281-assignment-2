package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  // maximum allowed input fingers. note: the message in MessageCli is hardcoded
  public static final int MAX_FINGERS = 5;

  private int roundNumber; // the round of the game
  private String playerName; // player's name

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    // the first element of options[0]; is the name of the player
    playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    roundNumber = 0;
  }

  public void play() {
    roundNumber += 1;
    MessageCli.START_ROUND.printMessage(Integer.toString(roundNumber));
    int playerFingers;
    while (true) {
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();

      // Check whether the player's input is valid
      if (Utils.isInteger(input)) { // check whether the input is an integer

        // check whether the input is a valid integer
        playerFingers = Integer.parseInt(input);
        if ((playerFingers < 0) | (playerFingers > MAX_FINGERS)) {
          MessageCli.INVALID_INPUT.printMessage();
          continue;
        } else {
          break; // the input is valid; exit the loop
        }
      } else {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }
    }
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, Integer.toString(playerFingers));
  }

  public void endGame() {}

  public void showStats() {}
}
