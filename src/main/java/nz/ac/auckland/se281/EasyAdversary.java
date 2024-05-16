package nz.ac.auckland.se281;

public class EasyAdversary extends Adversary {

  /**
   * Constructs an EasyAdversary instance. All EasyAdversary instances only use the RandomStrategy
   * Strategy.
   */
  public EasyAdversary() {
    super(new RandomStrategy());
  }
}
