import CancelIcon from '@mui/icons-material/Cancel';
import CheckCircleIcon from '@mui/icons-material/CheckCircle';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Fade from '@mui/material/Fade';
import Paper from '@mui/material/Paper';
import Stack from '@mui/material/Stack';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableRow from '@mui/material/TableRow';
import TextField from '@mui/material/TextField';
import Typography from '@mui/material/Typography';
import { useCallback, useEffect, useState } from 'react';
import { useForm } from 'react-hook-form';
import { useParams } from 'react-router-dom';

import { getGame, postProposal } from 'api/GamesApi';
import texts from 'data/texts.json';
import Game from 'types/game';

interface Proposal {
    key: number;
    answer: string;
    isCorrect: boolean;
}

export default function GamePage() {
    const { id } = useParams();
    const { register, handleSubmit, reset } = useForm();
    const [game, setGame] = useState<Game>();
    const [proposals, setProposals] = useState<Proposal[]>([]);

    const fetchGame = useCallback(async () => {
        if (id !== undefined) {
            const gameFetched = await getGame(id);
            setGame(gameFetched);
        }
    }, [id]);

    useEffect(() => {
        fetchGame();
    }, [fetchGame]);

    async function onSubmit({ proposal }: { proposal: string }) {
        if (game) {
            const isCorrect = await postProposal(game.id, proposal);
            setProposals([{ key: Date.now(), answer: proposal, isCorrect }, ...proposals]);
            reset();
        }
    }

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
                    {proposals.length > 0 && (
                        <TableContainer component={Paper} sx={{ mt: 4 }}>
                            <Table aria-label="simple table">
                                <TableBody>
                                    {proposals.map(({ key, answer, isCorrect }, index) => (
                                        <Fade key={key} in={true} appear={true} timeout={700}>
                                            <TableRow sx={{ '&:last-child td, &:last-child th': { border: 0 } }}>
                                                <TableCell component="th" scope="row">
                                                    {answer}
                                                </TableCell>
                                                <TableCell>
                                                    {isCorrect ? (
                                                        <CheckCircleIcon color="success" />
                                                    ) : (
                                                        <CancelIcon color="error" />
                                                    )}
                                                </TableCell>
                                            </TableRow>
                                        </Fade>
                                    ))}
                                </TableBody>
                            </Table>
                        </TableContainer>
                    )}
                </Stack>
            )}
        </>
    );
}
