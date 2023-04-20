import MovieIcon from '@mui/icons-material/Movie';
import PlayCircleIcon from '@mui/icons-material/PlayCircle';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import ListItemText from '@mui/material/ListItemText';
import { useEffect, useState } from 'react';

import { getBoards } from 'api/BoardApi';
import texts from 'data/texts.json';
import Board from 'types/board';

export default function Home() {
    const [boards, setBoards] = useState<Board[]>([]);

    const fetchBoards = async () => {
        const boardsFetched = await getBoards();
        setBoards(boardsFetched);
    };

    useEffect(() => {
        fetchBoards();
    }, []);
    return (
        <>
            <List sx={{ maxWidth: 360, mx: 'auto' }}>
                {boards.map((board) => (
                    <ListItem
                        key={board.id}
                        secondaryAction={
                            <IconButton edge="end" aria-label={texts['button.play.ariaLabel']} href="#">
                                <PlayCircleIcon />
                            </IconButton>
                        }
                    >
                        <ListItemAvatar>
                            <Avatar>
                                <MovieIcon />
                            </Avatar>
                        </ListItemAvatar>
                        <ListItemText primary={board.name} />
                    </ListItem>
                ))}
            </List>
        </>
    );
}
