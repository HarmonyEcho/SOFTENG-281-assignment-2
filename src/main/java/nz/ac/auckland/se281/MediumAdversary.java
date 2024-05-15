package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumAdversary extends Adversary {

  private TopStrategy topStrategy = new TopStrategy();
  private int playerWins;
  private int adversaryWins;

  public MediumAdversary() {
    super(new RandomStrategy());
    this.playerWins = 0;
    this.adversaryWins = 0;
  }

  @Override
  public void updateChoice(Choice choice) {
    topStrategy.updateChoice(choice);
  }

  @Override
  public int takeTurn() {
    return super.strategy.chooseFingers();
  }

  @Override
  public void updateOutcome(boolean adversaryWon) {
    if (adversaryWon) {
      topStrategy.incrementAdversaryWins();
    } else {
      topStrategy.incrementPlayerWins();
    }
    if (adversaryWins + playerWins == 4) {
      super.strategy = topStrategy;
    }
  }
}
