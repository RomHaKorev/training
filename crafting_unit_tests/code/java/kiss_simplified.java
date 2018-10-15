@Test
public void a_player_invite_the_opponent_to_pick_a_card_when_he_does_not_have_the_asked_card(){
   given_a_seven_famillies_game()
           .with_familly("Martin").withGrandfather("Robert").andGrandmother("Andrée").withFather("Didier").withMother("Isabelle").withSon("Kevin").withDaughter("Kevina")
           .with_familly("García").withGrandfather("Juan").andGrandmother("Lucia").withFather("Pedro").withMother("Maria").withSon("Pablo").withDaughter("Lisa")
           .with_familly("Murphy").withGrandfather("Eddie").andGrandmother("Elizabeth").withFather("John").withMother("Abbie").withSon("Brandon").withDaughter("Brenda")
           .with_familly("Miller").withGrandfather("Thomas").andGrandmother("Eva").withFather("Andrea").withMother("Alexandra").withSon("Claus").withDaughter("Anna")
           .with_familly("Smith").withGrandfather("Adam").andGrandmother("Ava").withFather("Donald").withMother("Michell").withSon("Steven").withDaughter("Scarlett")
           .with_familly("Rossi").withGrandfather("Antonio").andGrandmother("Alessandra").withFather("Luigi").withMother("Isabella").withSon("Mario").withDaughter("Maria")
           .with_familly("Silva").withGrandfather("Manuel").andGrandmother("Louisa").withFather("Joao").withMother("Andreia").withSon("Luis").withDaughter("Lucia");

   given_player_1_has().card("Martin Robert").card("Martin Andrée").card("Martin Didier").card("Garcia Juan").card("Garcia Lucia").card("Garcia Pedro");
   given_player_2_has().card("Murphy Eddie").card("Murphy Elizabeth").card("Murphy John").card("Miller Thomas").card("Miller Eva").card("Miller Andrea");

   when_player_1_ask_for("Rossi Antonio");

   then_he_should_be_invited_to_pick_a_card_in_deck()
}
