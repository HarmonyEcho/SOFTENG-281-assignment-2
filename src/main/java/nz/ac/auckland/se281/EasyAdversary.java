package nz.ac.auckland.se281;

public class EasyAdversary extends Adversary {

  private Strategy strategy;

  public EasyAdversary() {
    super();
    this.strategy = new RandomStrategy();
  }

  @Override
  public int takeTurn() {
    return strategy.chooseFingers();
  }

  @Override
  public void updateOutcome(boolean adversaryWon) {}
}
