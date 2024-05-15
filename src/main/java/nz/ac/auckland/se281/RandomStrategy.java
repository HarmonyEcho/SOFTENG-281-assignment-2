package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {
  @Override
  public int chooseFingers() {
    return Utils.getRandomNumberRange(0, Game.MAX_FINGERS);
  }
}
