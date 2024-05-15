package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumAdversary extends Adversary {

  private TopStrategy topStrategy = new TopStrategy();
  private int numRounds;

  public MediumAdversary() {
    super(new RandomStrategy());
    this.numRounds = 0;
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

    // Update the win counters inside the top strategy
    if (adversaryWon) {
      topStrategy.incrementAdversaryWins();
    } else {
      topStrategy.incrementPlayerWins();
    }

    // increments the counter for number of rounds, and checks whether to switch strategies
    numRounds++;
    if (numRounds == 4) {
      super.strategy = topStrategy;
    }
  }
}
