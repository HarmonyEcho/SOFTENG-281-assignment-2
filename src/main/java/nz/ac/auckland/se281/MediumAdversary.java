package nz.ac.auckland.se281;

public class MediumAdversary extends Adversary {

  private Strategy strategy;
  private int playerWins;
  private int adversaryWins;

  public MediumAdversary() {
    super();
    this.strategy = new RandomStrategy();
    this.playerWins = 0;
    this.adversaryWins = 0;
  }

  @Override
  public int takeTurn() {
    return strategy.chooseFingers();
  }

  @Override
  public void updateOutcome(boolean adversaryWon) {
    if (adversaryWon) {
      adversaryWins++;
    } else {
      playerWins++;
    }
  }
}
