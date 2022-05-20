package io.shodo.quizzyquizz.domain;

import java.util.HashMap;
import java.util.UUID;

public final class Games {
    private static Games instance;
    HashMap<UUID, Game> createdGames; //TODO mettre l'id en key de la hashmap c'est une bonne idée ou pas ?

    private Games() {
        this.createdGames = new HashMap<>();
    }

    public static Games getInstance() {
        if (instance == null) {
            instance = new Games();
        }
        return instance;
    }

    void addNewGame(Game game) {
        this.createdGames.put(game.getId(), game);
    }

    public Game getGame(UUID uuid) {
        return createdGames.get(uuid);
    }
}
