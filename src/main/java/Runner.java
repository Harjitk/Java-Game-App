import db.DBConsole;
import db.DBGame;
import db.DBHelper;
import models.Console;
import models.Game;
import models.Genre;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Console console1 = new Console("Sony", "PS4", "Europe");
        DBHelper.saveOrUpdate(console1);

        Console console2 = new Console("Microsoft", "Xbox one", "North America");
        DBHelper.saveOrUpdate(console2);

        Console console3 = new Console("Nintendo", "Nintendo DS", "Asia");
        DBHelper.saveOrUpdate(console3);


        Game game1 = new Game("Space Invaders", Genre.ARCADE);
        DBHelper.saveOrUpdate(game1);
        Game game2 = new Game("Pokemon", Genre.RPG);
        DBHelper.saveOrUpdate(game2);
        Game game3 = new Game("Star Wars", Genre.FPS);
        DBHelper.saveOrUpdate(game3);

        DBHelper.delete(console1);
        List<Console> consoles = DBHelper.getAll(Console.class);
        List<Game> games = DBHelper.getAll(Game.class);

        Game findGame = DBHelper.find(Game.class, game1.getId());

        List<Console> getAvailableGames = DBGame.getAllAvailableGames(game1);

        List<Game> getAvailableConsoles = DBConsole.getAllAvailableConsoles(console1);

    }
}


