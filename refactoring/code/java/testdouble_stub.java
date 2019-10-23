interface RateProvider {
  Rate rateFor(Currency from, Currency to);
}

public RateProvider stub(final Rate rate) {
  return new RateProvider() {
    public Rate rateFor(final Currency from, final Currency to) {
      return rate;
    }
  }
}


// --------------

assertEqual(newMoney(USD, 15), newMoney(EUR, 10).changeTo(USD, stub(rate(1.5))))
