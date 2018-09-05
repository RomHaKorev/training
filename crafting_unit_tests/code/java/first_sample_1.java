@Test
public void should_return_2018_template() {
   if (LocalDateTime.now().getYear() == 2018){
       assertThat(getVersion()).isEqualTo("2018.1.7");
   }
   else{
       assertThat(getVersion()).isEqualTo("1.7");
   }
}

// .....................................

public String getVersion() {
   if (LocalDateTime.now().getYear() >= 2018){
       return LocalDateTime.now().getYear() + ".1.7";
   }
   else{
       return "1.7";
   }
}
