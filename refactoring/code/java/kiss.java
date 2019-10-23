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
   deck_is_composed_by()
           .card("Martin Isabelle").card("Martin Kevin").card("Martin Kevina")
           .card("García Maria").card("García Pablo").card("García Lisa")
           .card("Murphy Abbie").card("Murphy Brandon").card("Murphy Brenda")
           .card("Miller Alexandra").card("Miller Claud").card("Miller Anna")
           .card("Smith Adam").card("Smith Ava").card("Smith Donald").card("Smith Michell").card("Smith Steven").card("Smith Scarlett")
           .card("Rossi Antonio").card("Rossi Alessandra").card("Rossi Luigi").card("Rossi Isabella").card("Rossi Mario").card("Rossi Maria")
           .card("Silva Manuel").card("Silva Louisa").card("Silva Joao").card("Silva Andreia").card("Silva Luis").card("Silva Lucia");

   when_player_1_ask_for("Rossi Antonio");

   then_he_should_be_invited_to_pick_a_card_in_deck()
}
