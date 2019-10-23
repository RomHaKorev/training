@RunWith(MockitoJUnitRunner.class)
public class FizzbuzzTest {

  @InjectMocks
  public FizzbuzzService sut;

  @Mock
  public Database database;

  @Mock
  public FizzbuzzConverter converter;

  @Test
  public void should_return_fizz_when_multiple_of_3() {
    Mockito.when(database.findwords()).thenReturns(newHashMaps(3, "Fizz"));
    Mockito.when(converter.convert(anyInt(), anyMaps()))
      .thenCallRealMethod();

    assertThat(sut.fizzbuzz(3)).isEqualTo("Fizz");

    Mockito.verify(database, atLeastOnce()).convert(anyInt(), anyMaps());
    Mockito.verify(database, atLeastOnce()).findwords();
    Mockito.verify(database, noMoreInteractions()).findwords();
  }
}
