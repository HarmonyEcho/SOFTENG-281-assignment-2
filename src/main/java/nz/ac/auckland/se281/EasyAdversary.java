package nz.ac.auckland.se281;

public class EasyAdversary extends Adversary {

  /**
   * Constructs an EasyAdversary instance. All EasyAdversary instances only use the RandomStrategy
   * Strategy.
   */
  public EasyAdversary() {
    super(new RandomStrategy());
  }

  /**
   * Returns the number of fingers that the adversary should put up when playing a round.
   *
   * @return number of fingers to put up
   */
  @Override
  public int takeTurn() {
    return super.strategy.chooseFingers();
  }

  /**
   * Updates information that various child classes need for strategies that they use. EasyAdversary
   * does not use this method.
   *
   * @param playerEven whether the player put up an even number of fingers; unused for this subclass
   * @param playerWon whether the player won; unused for this subclass
   */
  @Override
  public void updateOutcome(boolean adversaryWon, boolean playerWon) {}
}
