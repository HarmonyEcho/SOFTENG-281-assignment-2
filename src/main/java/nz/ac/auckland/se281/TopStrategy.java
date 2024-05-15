package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {

  private Choice oddEvenChoice;
  private int playerWins = 0;
  private int adversaryWins = 0;

  @Override
  public int chooseFingers() {
    return Utils.getRandomNumberRange(0, Game.MAX_FINGERS);
  }

  public void updateChoice(Choice choice) {
    this.oddEvenChoice = choice;
  }

  public void incrementPlayerWins() {
    playerWins++;
  }

  public void incrementAdversaryWins() {
    adversaryWins++;
  }
}
