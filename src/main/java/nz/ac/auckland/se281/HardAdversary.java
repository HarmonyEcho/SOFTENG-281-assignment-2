package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class HardAdversary extends Adversary {

  private static final int CHANGE_STRATEGY_ROUND = 4;

  private TopStrategy topStrategy = new TopStrategy();
  private int numRounds;

  public HardAdversary() {
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
  public void updateOutcome(boolean playerEven, boolean playerWon) {

    // Update the win counters inside the top strategy
    if (playerEven) {
      topStrategy.incrementPlayerEvenCount();
    } else {
      topStrategy.incrementPlayerOddCount();
    }

    // increments the counter for number of rounds, and checks whether to switch strategies
    numRounds++;

    // start using top strategy from the 4th game; i.e. after the 3rd
    if (numRounds == CHANGE_STRATEGY_ROUND - 1) {
      super.strategy = topStrategy;
    } else if ((numRounds >= CHANGE_STRATEGY_ROUND)
        & playerWon) { // else if the adversary loses after the 4th round

      // swap strategies
      if (super.strategy.getClass() == topStrategy.getClass()) {
        super.strategy = new RandomStrategy();
      } else {
        super.strategy = topStrategy;
      }
    }
  }
}
