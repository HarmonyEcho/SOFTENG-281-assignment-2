package nz.ac.auckland.se281;

public abstract class Adversary {

  public abstract int takeTurn();

  public abstract void updateOutcome(boolean adversaryWon);
}
