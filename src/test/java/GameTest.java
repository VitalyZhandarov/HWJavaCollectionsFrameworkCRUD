import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void firstPlayerWin() {
        Player vitalik = new Player(001,"Виталик", 40);
        Player stas = new Player(002,"Стас", 65);
        Game game = new Game();

        game.register(vitalik);
        game.register(stas);
        int actual = game.round("Стас", "Виталик");
        int expected = 1;
    }

    @Test
    public void secondPlayerWin() {
        Player vitalik = new Player(001,"Виталик", 80);
        Player stas = new Player(002,"Стас", 65);
        Game game = new Game();

        game.register(vitalik);
        game.register(stas);
        int actual = game.round("Стас", "Виталик");
        int expected = 2;
    }

    @Test
    public void nobodyPlayerWin() {
        Player vitalik = new Player(001,"Виталик", 80);
        Player stas = new Player(002,"Стас", 80);
        Game game = new Game();

        game.register(vitalik);
        game.register(stas);
        int actual = game.round("Стас", "Виталик");
        int expected = 0;
    }

    @Test
    public void firstPlayerRegister() {
        Player vitalik = new Player(001,"Виталик", 80);
        Player stas = new Player(002,"Стас", 80);
        Game game = new Game();

        game.register(vitalik);
        game.register(stas);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Ира", "Стас"));

    }

    @Test
    public void secondPlayerRegister() {
        Player vitalik = new Player(001,"Виталик", 80);
        Player stas = new Player(002,"Стас", 80);
        Game game = new Game();

        game.register(vitalik);
        game.register(stas);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Виталик", "Дима"));

    }

    @Test
    public void nobodyPlayerRegister() {
        Player vitalik = new Player(001,"Виталик", 80);
        Player stas = new Player(002,"Стас", 80);
        Game game = new Game();

        game.register(vitalik);
        game.register(stas);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Игорь", "Дима"));

    }
}
