package nz.ac.auckland.se281;

public class MediumAdversary extends Adversary {

  Strategy strategy = new RandomStrategy();

  public MediumAdversary() {
    super();
  }

  @Override
  public int takeTurn() {
    return strategy.chooseFingers();
  }
}
