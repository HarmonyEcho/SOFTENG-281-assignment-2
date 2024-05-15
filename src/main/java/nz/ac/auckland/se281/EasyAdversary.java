package nz.ac.auckland.se281;

public class EasyAdversary extends Adversary {

  public EasyAdversary() {
    super(new RandomStrategy());
  }

  @Override
  public int takeTurn() {
    return super.strategy.chooseFingers();
  }

  @Override
  public void updateOutcome(boolean adversaryWon) {}
}
