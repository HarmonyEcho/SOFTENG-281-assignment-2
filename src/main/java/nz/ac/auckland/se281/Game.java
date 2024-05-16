package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  // maximum allowed input fingers. note: the message in MessageCli is hardcoded
  public static final int MAX_FINGERS = 5;

  // name of the ai opponent
  public static final String ADVERSARY_NAME = "HAL-9000";

  private int roundNumber; // the round of the game
  private String playerName; // player's name
  private Adversary adversary;
  private Choice oddEvenChoice;
  private int playerWins;
  private int adversaryWins;

  /**
   * Starts a new game, initialising values needed for a new game.
   *
   * @param difficulty the difficulty setting of the game
   * @param choice whether the player needs even or odd totals to win
   * @param options other options; currently options[0] is the player's name
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    // the first element of options[0]; is the name of the player
    playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    roundNumber = 0;
    playerWins = 0;
    adversaryWins = 0;

    // create a new adversary of the chosen difficulty
    adversary = AdversaryFactory.makeAdversary(difficulty);
    oddEvenChoice = choice;
    adversary.updateChoice(oddEvenChoice);
  }

  /**
   * Starts a new round in a game, taking player inputs, displaying the outcome of the round, and
   * giving any information necessary for the adversary ai.
   */
  public void play() {
    roundNumber += 1;
    MessageCli.START_ROUND.printMessage(Integer.toString(roundNumber));

    // repeat asking the player for input until valid input is recieved
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

    // display the player's hand
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, Integer.toString(playerFingers));

    int adversaryFingers = adversary.takeTurn();
    MessageCli.PRINT_INFO_HAND.printMessage(ADVERSARY_NAME, Integer.toString(adversaryFingers));

    // Check whether the total is even or odd
    int totalFingers = playerFingers + adversaryFingers;
    Choice totalChoice;
    if (Utils.isEven(totalFingers)) {
      totalChoice = Choice.EVEN;
    } else {
      totalChoice = Choice.ODD;
    }

    // print the outcome of the round
    boolean playerWon = (totalChoice == oddEvenChoice);
    if (playerWon) { // player wins
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          Integer.toString(totalFingers), totalChoice.name(), playerName);
      playerWins++;
    } else { // adversary wins
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          Integer.toString(totalFingers), totalChoice.name(), ADVERSARY_NAME);
      adversaryWins++;
    }

    // update the data for the adversary strategies
    adversary.updateOutcome(Utils.isEven(playerFingers), playerWon);
  }

  public void endGame() {}

  /** Prints the name and number of times won for the player and adversary. */
  public void showStats() {
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, Integer.toString(playerWins), Integer.toString(adversaryWins));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        ADVERSARY_NAME, Integer.toString(adversaryWins), Integer.toString(playerWins));
  }
}
