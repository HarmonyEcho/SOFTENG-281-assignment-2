package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public abstract class Adversary {

  protected Strategy strategy;

  /**
   * Constructs an adversary instance.
   *
   * @param strategy strategy to use when playing
   */
  public Adversary(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Updates whether the player needs odd or even totals to win. Child classes that use strategies
   * that need this information will override this method.
   *
   * @param choice whether the player needs odd or even totals to win
   */
  public void updateChoice(Choice choice) {}

  /**
   * Returns the number of fingers that the adversary should put up when playing a round.
   *
   * @return number of fingers to put up
   */
  public abstract int takeTurn();

  /**
   * Updates information that various child classes need for strategies that they use. Information
   * that changes between rounds should be updated using this method.
   *
   * @param playerEven whether the player put up an even number of fingers
   * @param playerWon whether the player won
   */
  public abstract void updateOutcome(boolean playerEven, boolean playerWon);
}
