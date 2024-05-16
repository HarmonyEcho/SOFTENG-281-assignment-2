package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AdversaryFactory {

  /**
   * Creates and returns an adversary of the appropriate Adversary subclass based on the given
   * difficulty.
   *
   * @param difficulty the difficulty of the game
   * @return adversary object corresponding to the given difficulty
   */
  public static Adversary makeAdversary(Difficulty difficulty) {

    // return an adversary of the subclass corresponding to the difficulty given
    switch (difficulty) {
      case EASY:
        return new EasyAdversary();
      case MEDIUM:
        return new MediumAdversary();
      case HARD:
        return new HardAdversary();
      default:
        return null;
    }
  }
}
