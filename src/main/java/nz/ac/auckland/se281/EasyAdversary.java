package nz.ac.auckland.se281;

public class EasyAdversary extends Adversary {

  Strategy strategy = new RandomStrategy();

  public EasyAdversary() {
    super();
  }

  @Override
  public int takeTurn() {
    return strategy.chooseFingers();
  }
}
