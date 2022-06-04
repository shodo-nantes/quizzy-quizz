package io.shodo.quizzyquizz.domain;

import java.util.Optional;
import java.util.UUID;

public interface AllGames {
    Game save(Game game);

    Optional<Game> findBy(UUID uuid);
}
