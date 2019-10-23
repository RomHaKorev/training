interface RateProvider {
  Rate rateFor(Currency from, Currency to);
}

public RateProvider dummy() {
  return new RateProvider() {
    public Rate rateFor(final Currency from, final Currency to) {
      return null;
    }
  }
}


// --------------

assertEqual(newMoney(EUR, 10), newMoney(EUR, 10).changeTo(EUR, dummy()))
