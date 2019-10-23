@Test
public void should_return_Fizz_when_multiple_of_3() {
  assertEqual("Fizz", fizzbuzz(3));
  assertEqual("Fizz", fizzbuzz(33));
}

@Test
public void should_return_Buzz_when_multiple_of_5() {
  assertEqual("Buzz", fizzbuzz(5));
  assertEqual("Buzz", fizzbuzz(50));
}

@Test
public void should_return_FizzBuzz_when_multiple_of_3_and_5() {
  assertEqual("FizzBuzz", fizzbuzz(0));
  assertEqual("FizzBuzz", fizzbuzz(15));
}

@Test
public void should_return_the_input_otherwise() {
  assertEqual("1", fizzbuzz(1));
  assertEqual("17", fizzbuzz(17));
}
