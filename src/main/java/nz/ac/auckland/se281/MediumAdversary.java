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
  public void updateOutcome(boolean playerEven) {

    // Update the win counters inside the top strategy
    if (playerEven) {
      topStrategy.incrementPlayerEvenCount();
    } else {
      topStrategy.incrementPlayerOddCount();
    }

    // increments the counter for number of rounds, and checks whether to switch strategies
    numRounds++;
    if (numRounds == 3) { // start using top strategy from the 4th game; i.e. after the 3rd
      super.strategy = topStrategy;
    }
  }
}
