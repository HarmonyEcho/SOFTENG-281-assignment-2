package nz.ac.auckland.se281;

public class MediumAdversary extends Adversary {

  Strategy strategy;
  int playerWins;
  int adversaryWins;

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
