@Test
public void a_player_invite_the_opponent_to_pick_a_card_when_he_does_not_have_the_asked_card(){
   given_a_standard_seven_famillies_game();
   given_nobody_has().card("Murphy Eddie");
   when_player_1_ask_for("Murphy Eddie");
   then_he_should_be_invited_to_pick_a_card_in_deck()
}

@Test
public void a_player_should_give_his_opponent_a_card_when_this_card_is_asked(){
   given_a_standard_seven_famillies_game();
   given_player_2_has().card("Murphy Eddie");
   when_player_1_ask_for("Murphy Eddie");
   then_he_should_received("Murphy Eddie")
}
