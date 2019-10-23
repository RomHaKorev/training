@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringConfiguration.class })
public class FizzbuzzTest {

  @Inject
  Fizzbuzz sut;

  @Test
  public void should_return_fizz_when_multiple_of_3() {
       assertThat(sut.fizzbuzz(3)).isEqualTo("Fizz");
  }
}
