import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import TextField from '@mui/material/TextField';
import Typography from '@mui/material/Typography';
import { useCallback, useEffect, useState } from 'react';
import { SubmitHandler, useForm } from 'react-hook-form';
import { useParams } from 'react-router-dom';

import { getGame } from 'api/GamesApi';
import texts from 'data/texts.json';
import Game from 'types/game';

function onSubmit(data: SubmitHandler<{ proposal: string }>) {
    console.info('submit', data);
}

export default function GamePage() {
    const { id } = useParams();
    const { register, handleSubmit } = useForm();
    const [game, setGame] = useState<Game>();

    const fetchGame = useCallback(async () => {
        if (id !== undefined) {
            const gameFetched = await getGame(id);
            setGame(gameFetched);
        }
    }, [id]);

    useEffect(() => {
        fetchGame();
    }, [fetchGame]);

    return (
        <>
            {game && (
                <Stack alignItems="center">
                    <Typography variant="h2">{game.name}</Typography>
                    <Typography variant="body1">{game.question}</Typography>
                    <Box
                        component="form"
                        onSubmit={handleSubmit(onSubmit)}
                        sx={{ mt: 2, display: 'flex', flexDirection: 'column', gap: '10px' }}
                    >
                        <TextField label={texts['input.proposal.label']} variant="outlined" {...register('proposal')} />
                        <Button variant="contained" type="submit">
                            {texts['button.proposal.submit']}
                        </Button>
                    </Box>
                </Stack>
            )}
        </>
    );
}
