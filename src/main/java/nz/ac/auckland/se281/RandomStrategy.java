package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  /**
   * Returns a random number of fingers between 0 and the maximum fimgers (inclusive)
   *
   * @return number of fingers to put up
   */
  @Override
  public int chooseFingers() {
    return Utils.getRandomNumberRange(0, Game.MAX_FINGERS);
  }
}
