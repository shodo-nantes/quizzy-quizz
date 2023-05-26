import Button from '@mui/material/Button';
import FormControl from '@mui/material/FormControl';
import Stack from '@mui/material/Stack';
import TextField from '@mui/material/TextField';
import Typography from '@mui/material/Typography';
import { useCallback, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';

import { getGame } from 'api/GamesApi';
import Game from 'types/game';

function handleSubmit(event: React.FormEvent<HTMLFormElement>) {
    event.preventDefault();
    console.info('submit', event);
    // const { name, value } = event.target;
    // console.info('submit', name, value);
}

interface FormState {
    proposal: string;
}

const initialFormState: FormState = {
    proposal: ''
};

export default function GamePage() {
    const { id } = useParams();
    const [game, setGame] = useState<Game>();
    const [formState, setFormState] = useState<FormState>(initialFormState);

    const fetchGame = useCallback(async () => {
        if (id !== undefined) {
            const gameFetched = await getGame(id);
            setGame(gameFetched);
        }
    }, [id]);

    useEffect(() => {
        fetchGame();
    }, [fetchGame]);

    const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = event.target;
        console.info('change', name, value);
        setFormState((previousState) => ({ ...previousState, [name]: value }));
    };

    return (
        <>
            {game && (
                <Stack alignItems="center">
                    <Typography variant="h2">{game.name}</Typography>
                    <Typography variant="body1">{game.question}</Typography>
                    <FormControl component="form" onSubmit={handleSubmit}>
                        <TextField
                            id="proposal"
                            name="proposal"
                            label="Proposition"
                            value={formState.proposal}
                            onChange={handleInputChange}
                            variant="outlined"
                        />
                        <Button variant="contained" type="submit">
                            Valider
                        </Button>
                    </FormControl>
                </Stack>
            )}
        </>
    );
}
