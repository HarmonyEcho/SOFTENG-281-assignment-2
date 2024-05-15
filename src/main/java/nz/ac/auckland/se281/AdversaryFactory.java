package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AdversaryFactory {
  public static Adversary MakeAdversary(Difficulty difficulty) {
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
