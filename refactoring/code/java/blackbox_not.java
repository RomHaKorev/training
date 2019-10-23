@Test
public void should_return_the_maximum_transaction() {
    Transaction t1 = transaction("client", "A", 300, LocalDateTime.of(2017, APRIL, 17, 8, 0, 0));
    Transaction t2 = transaction("client", "A", 600, LocalDateTime.of(2017, APRIL, 17, 8, 30, 0));
    stat.updateWith(t1);
    stat.updateWith(t2);
    assertEquals(Optional.of(maximum(600, LocalDateTime.of(2017, APRIL, 17, 8, 30, 0))), stat.maximum());
}
