interface RateProvider {
  Rate rateFor(Currency from, Currency to);
}

class FakeRateProvider implements RateProvider {
  private final Map<String, Double> rates;

  FakeRateProvider rate(Currency from, Currency to, double rate) {
    rates.put(from + " -> " + to, rate);
    return this;
  }

  public Rate rateFor(final Currency from, final Currency to) {
    return rates.get(from + " -> " + to);
  }
}

// --------------

assertEqual(newMoney(USD, 15), newMoney(EUR, 10).changeTo(USD, new FakeRateProvider().rate(EUR, USD, 1.5)))
