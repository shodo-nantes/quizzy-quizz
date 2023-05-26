import MovieIcon from '@mui/icons-material/Movie';
import PlayCircleIcon from '@mui/icons-material/PlayCircle';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import ListItemText from '@mui/material/ListItemText';
import { useEffect, useState } from 'react';

import { getGames } from 'api/GamesApi';
import texts from 'data/texts.json';
import Game from 'types/game';

const GAME_PATH = '/games';

export default function Home() {
    const [games, setGames] = useState<Game[]>([]);

    const fetchGames = async () => {
        const gamesFetched = await getGames();
        setGames(gamesFetched);
    };

    useEffect(() => {
        fetchGames();
    }, []);
    return (
        <>
            <List sx={{ maxWidth: 360, mx: 'auto' }}>
                {games.map((game) => (
                    <ListItem
                        key={game.id}
                        secondaryAction={
                            <IconButton
                                edge="end"
                                aria-label={texts['button.play.ariaLabel']}
                                href={`${GAME_PATH}/${game.id}`}
                            >
                                <PlayCircleIcon />
                            </IconButton>
                        }
                    >
                        <ListItemAvatar>
                            <Avatar>
                                <MovieIcon />
                            </Avatar>
                        </ListItemAvatar>
                        <ListItemText primary={game.name} />
                    </ListItem>
                ))}
            </List>
        </>
    );
}
