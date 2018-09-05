public class Fizzbuzz {
  public String compute(long input) {
    if (input % (3 * 5) == 0) {
      return "FizzBuzz";
    }
    if (input % 3 == 0) {
      return "Fizz";
    }
    if (input % 5 == 0) {
      return "Fizz";
    }
    return String.valueOf(input)
  }
}
