@Test
public void when_I_create_a_game_there_are_mines_on_grid() {
   given_a_minesweeper()
    .withNbMines(10);
   when_I_start_the_game();
   then_mines_number_should_be(10);
}

@Test
public void when_I_ask_for_adjacent_position_of_top_left_corner_it_returns_only_right_down_positions(){
   given_a_board()
   when_I_ask_for_adjacent_position_of(position(0, 0));
   then_adjacent_position_should_be(
                           position(0, 1),
           position(1, 0), position(1, 1));
}
