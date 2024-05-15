package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  // maximum allowed input fingers. note: the message in MessageCli is hardcoded
  private static final int MAX_FINGERS = 5;

  private int roundNumber; // the round of the game

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    roundNumber = 0;
  }

  public void play() {
    roundNumber += 1;
    MessageCli.START_ROUND.printMessage(Integer.toString(roundNumber));
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();

    // Check whether the player's input is valid
    int playerFingers;
    if (Utils.isInteger(input)) {
      playerFingers = Integer.parseInt(input);
      if ((playerFingers < 0) | (playerFingers > MAX_FINGERS)) {
        MessageCli.INVALID_INPUT.printMessage();
        return;
      }
    } else {
      MessageCli.INVALID_INPUT.printMessage();
      return;
    }
  }

  public void endGame() {}

  public void showStats() {}
}
