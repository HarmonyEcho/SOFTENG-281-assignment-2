package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public abstract class Adversary {

  protected Strategy strategy;

  public Adversary(Strategy strategy) {
    this.strategy = strategy;
  }

  public void updateChoice(Choice choice) {}

  public abstract int takeTurn();

  public abstract void updateOutcome(boolean playerEven, boolean playerWon);
}
