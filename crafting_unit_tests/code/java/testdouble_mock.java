interface RateProvider {
  Rate rateFor(Currency from, Currency to);
}

// --------------

RateProvider provider = Mockito.mock(RateProvider.class);
when(provider.rateFor(EUR, USD)).thenReturn(rate(1.5));
assertEqual(newMoney(USD, 15), newMoney(EUR, 10).changeTo(USD, provider));
