import axios from 'axios';

import Game from 'types/game';

const GAMES_API_URL = '/api/v1/games';

export async function getGames(): Promise<Game[]> {
    const { data } = await axios.get(GAMES_API_URL);
    return data;
}

export async function getGame(id: string): Promise<Game> {
    const { data } = await axios.get(`${GAMES_API_URL}/${id}`);
    return data;
}
