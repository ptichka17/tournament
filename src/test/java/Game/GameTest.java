package Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    public void testWhenFirstPlayerIsStronger() {
        Game game = new Game();
        Player nastya = new Player(1,"Настя",80);
        Player sasha = new Player(2,"Саша",40);

        game.register(nastya);
        game.register(sasha);
        int actual = game.round("Настя", "Саша");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerIsStronger() {
        Game game = new Game();
        Player nastya = new Player(1,"Настя",80);
        Player sasha = new Player(2,"Саша",100);

        game.register(nastya);
        game.register(sasha);
        int actual = game.round("Настя", "Саша");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenBothPlayersAreEqual() {
        Game game = new Game();
        Player nastya = new Player(1,"Настя",100);
        Player sasha = new Player(2,"Саша",100);

        game.register(nastya);
        game.register(sasha);
        int actual = game.round("Настя", "Саша");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenBothPlayersNotRegistered() {
        Game game = new Game();
        Player nastya = new Player(1,"Настя",100);
        Player sasha = new Player(2,"Саша",100);

        game.register(nastya);
        game.register(sasha);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Дима", "Лиза")
        );
    }

    @Test
    public void testWhenPlayerNotRegistered() {
        Game game = new Game();
        Player nastya = new Player(1,"Настя",100);
        Player sasha = new Player(2,"Саша",100);

        game.register(nastya);
        game.register(sasha);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Саша", "Лиза")
        );
    }
}