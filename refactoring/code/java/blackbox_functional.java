@Test
public void should_return_the_maximum_transaction() {
    assertEquals("600 at 08:30:00",
            maximum(transaction(300, "08:00:00"), transaction(600, "08:30:00")));
}
