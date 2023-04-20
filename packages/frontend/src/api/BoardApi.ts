import axios from 'axios';

import Board from 'types/board';

const BOARDS_API_URL = '/api/v1/boards';

export async function getBoards(): Promise<Board[]> {
    const { data } = await axios.get(BOARDS_API_URL);
    return data;
}
