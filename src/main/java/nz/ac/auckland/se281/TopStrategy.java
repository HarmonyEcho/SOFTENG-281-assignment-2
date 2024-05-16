package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {

  private Choice oddEvenChoice; // whether the player needs even or odd to win
  private int playerEvenCount = 0; // number of times the player hand has been even
  private int playerOddCount = 0; // number of times the player hand has been odd

  /**
   * Returns a random odd or even number of fingers to put up in order for the adversary (not
   * player) to win, under the assumption that the player will continue using their most frequently
   * chosen type of number (odd or even). If the player has played odd and even hands an equal
   * number of times, will return a random number from 0 to the maximum fingers (inclusive).
   *
   * @return number of fingers to put up
   */
  @Override
  public int chooseFingers() {
    if (playerEvenCount == playerOddCount) { // if player has no preference, return random number
      return Utils.getRandomNumberRange(0, Game.MAX_FINGERS);
    } else if (playerEvenCount > playerOddCount) { // if the player prefers to make even hands

      // if the player needs even totals to win, make an odd hand, otherwise make an even hand
      if (oddEvenChoice == Choice.EVEN) {
        return Utils.getRandomOddNumber();
      } else {
        return Utils.getRandomEvenNumber();
      }
    } else { // else the player prefers to make odd hands

      // if the player needs even totals to win, make an even hand, otherwise make an odd hand
      if (oddEvenChoice == Choice.EVEN) {
        return Utils.getRandomEvenNumber();
      } else {
        return Utils.getRandomOddNumber();
      }
    }
  }

  /**
   * Updates whether the player needs odd or even totals to win.
   *
   * @param choice whether the player needs odd or even totals to win
   */
  public void updateChoice(Choice choice) {
    this.oddEvenChoice = choice;
  }

  /** Increments the counter of how many times the player has played an even hand. */
  public void incrementPlayerEvenCount() {
    this.playerEvenCount++;
  }

  /** Increments the counter of how many times the player has played an odd hand. */
  public void incrementPlayerOddCount() {
    this.playerOddCount++;
  }
}
