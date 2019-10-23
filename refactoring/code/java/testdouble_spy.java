interface RateProvider {
  Rate rateFor(Currency from, Currency to);
}

class SpyRateProvider implements RateProvider {
  public List<String> events = newArrayList();

  public Rate rateFor(final Currency from, final Currency to) {
    events.add(from + " -> " + to);
    return rate(1);
  }

  String events() {
    return Joiner.on(", ").join(events);
  }
}

// --------------

RateProvider spy = new SpyRateProvider();
RateProvider provider = composite(spy, spy);
provider.rateFor(EUR, USD);
assertEqual("EUR -> USD, EUR -> USD", spy.events());
