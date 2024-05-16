package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumAdversary extends Adversary {

  private static final int CHANGE_STRATEGY_ROUND = 4;

  private TopStrategy topStrategy = new TopStrategy();
  private int numRounds;

  public MediumAdversary() {
    super(new RandomStrategy());
    this.numRounds = 0;
  }

  /**
   * Updates whether the player needs odd or even totals to win.
   *
   * @param choice whether the player needs odd or even totals to win
   */
  @Override
  public void updateChoice(Choice choice) {
    topStrategy.updateChoice(choice);
  }

  /**
   * Returns the number of fingers that the adversary should put up when playing a round
   *
   * @return number of fingers to put up
   */
  @Override
  public int takeTurn() {
    return super.strategy.chooseFingers();
  }

  /**
   * Updates information that MediumAdversary needs for strategies are used. Information that
   * changes between rounds should be updated using this method. Will switch strategies to the top
   * strategy after a certain number of rounds.
   *
   * @param playerEven whether the player put up an even number of fingers
   * @param playerWon whether the player won; unused for this subclass
   */
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

    // start using top strategy from the 4th round; i.e. after the 3rd
    if (numRounds == CHANGE_STRATEGY_ROUND - 1) {
      super.strategy = topStrategy;
    }
  }
}
