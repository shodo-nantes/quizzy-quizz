package io.shodo.quizzyquizz.infra;

import io.shodo.quizzyquizz.domain.AllGames;
import io.shodo.quizzyquizz.domain.Game;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public final class InMemoryAllGames implements AllGames {

    private final Map<UUID, Game> createdGames = new HashMap<>();

    public InMemoryAllGames() {
    }

    @Override
    public Game save(Game game) {
        this.createdGames.put(game.getId(), game);
        return game;
    }

    @Override
    public Optional<Game> findBy(UUID uuid) {
        return Optional.ofNullable(createdGames.get(uuid));
    }
}
