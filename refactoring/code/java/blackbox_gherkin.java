@Test
   public void should_return_the_maximum_transaction() {
      given().a_transaction().of(300).at("08:00:00");
      and().a_transaction().of(600).at("08:30:00");

      when_maximum_is_computed();

      then().a_transaction().of(600).at("08:30:00").should_be_returned()
   }
