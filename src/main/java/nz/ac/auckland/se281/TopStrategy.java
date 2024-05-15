package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {

  private Choice oddEvenChoice;
  private int playerEvenCount = 0;
  private int playerOddCount = 0;

  @Override
  public int chooseFingers() {
    System.out.println("TOP COMMENT GOES HERE AAAAAA");
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

  public void updateChoice(Choice choice) {
    this.oddEvenChoice = choice;
  }

  public void incrementPlayerEvenCount() {
    this.playerEvenCount++;
  }

  public void incrementPlayerOddCount() {
    this.playerOddCount++;
  }
}
