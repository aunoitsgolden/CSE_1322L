import java.util.*;

class Pokemon {

  private int level;
  private double baseCatchRate;

  public Pokemon(int level, double baseCatchRate) {
    this.level = level;
    this.baseCatchRate = baseCatchRate;
  }

  public int getLevel() {
    return level;
  }

  public double getBaseCatchRate() {
    return baseCatchRate;
  }

  @Override
  public String toString() {
    return "A level " + level + " " + this.getClass().getSimpleName();
  }

}

class Bulbasaur extends Pokemon {

  public Bulbasaur(int level) {
    super(level, 0.2);
  }

}

class Caterpie extends Pokemon {
  
  public Caterpie(int level) {
    super(level, 0.5);
  }

}

class Charmander extends Pokemon {

  public Charmander(int level) {
    super(level, 0.2);
  }

}

class Pokedex {

  private List<Pokemon> myPokedex = new ArrayList<>();

  public void addToDex(Pokemon pokemon) {
    myPokedex.add(pokemon);
  }

  @Override
  public String toString() {  
    String result = "";
    for (Pokemon pokemon : myPokedex) {
        result += pokemon.toString() + "\n";
    }
    return result;
  }

}

public class Assignment3 {
 
  private static final Random random = new Random();
  private static final Scanner scanner = new Scanner(System.in);

  public static Pokemon spawn() {
    int level = random.nextInt(21);
    int pokemonType = random.nextInt(4);

    Pokemon encountered;
    if (pokemonType == 1) {
      encountered = new Bulbasaur(level);
    } else if (pokemonType == 2) {
      encountered = new Charmander(level);
    } else {
      encountered = new Caterpie(level);
    }

    System.out.println("You encounter " + encountered.toString());
    return encountered;
}

  public static float throwBall() {
    System.out.println("What type of ball do you wish to use? (Poke, Great, Ultra)");
    String ballType = scanner.nextLine();
    float ballMultiplier = switch (ballType.toLowerCase()) {
      case "great" -> 1.5f;
      case "ultra" -> 2.0f;
      default -> 1.0f;
    };

    System.out.println("What berry do you wish to use? (None, Razz, SilverPinap, GoldenRazz)");
    String berry = scanner.nextLine();
    float berryMultiplier = switch (berry.toLowerCase()) {
      case "razz" -> 1.5f;
      case "silverpinap" -> 1.8f;
      case "goldenrazz" -> 2.5f;
      default -> 1.0f;
    };

    System.out.println("Is this a curveball? (Yes or No)");
    String curveball = scanner.nextLine();
    float curveMultiplier = curveball.equalsIgnoreCase("Yes") ? 1.7f : 1.0f;

    return ballMultiplier * berryMultiplier * curveMultiplier;
  }

  public static void main(String[] args) {
    Pokedex myDex = new Pokedex();
    boolean continueCatching = true;

    while (continueCatching) {
      Pokemon encountered = spawn();
      boolean caught = false;
      while (!caught) {
        float multipliers = throwBall();
        double cpm = 0.49985844;
        double probability = 1 - Math.pow(1 - (encountered.getBaseCatchRate() / 2 * cpm), multipliers);
        if (random.nextDouble() < probability) {
          System.out.println(encountered.toString() + " Caught!");
          myDex.addToDex(encountered);
          caught = true;
        } else {
          System.out.println("Oops, " + encountered.toString() + " jumped out, try again!");
        }
      }

      System.out.println("Continue Catching Pokemon? (Y or N)");
      String answer = scanner.nextLine();
      continueCatching = answer.equalsIgnoreCase("Y");
    }
    System.out.println("You have the following pokemon:");
    System.out.println(myDex.toString());
  }

}
