package io.shodo.quizzyquizz.domain;

import java.util.HashMap;
import java.util.UUID;

public final class Games {
    private static Games instance;
    HashMap<UUID, Game> createdGames;
    //TODO ça pourrait être une interface car la hashmap est déjà une implémentation

    private Games() {
        this.createdGames = new HashMap<>();
    }

    public static Games getInstance() {
        if (instance == null) {
            instance = new Games();
        }
        return instance;
    }

    void save(Game game) {
        this.createdGames.put(game.getId(), game);
    }

    public Game getGame(UUID uuid) {
        return createdGames.get(uuid);
    }
}
