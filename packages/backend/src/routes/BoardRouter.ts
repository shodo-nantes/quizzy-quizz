import path from 'path';

import { Router, Request, Response } from 'express';

import { BOARD_ROUTE } from 'constants/ApiConstants';
import questions from 'data/questions.json';

const BoardRouter: Router = Router();

// Note: This is a temporary solution
const DEFAULT_BOARD_ID = '1';
const DEFAULT_QUESTION = questions[0];

BoardRouter.get('/', (request: Request, response: Response) => {
    // FIXME: Board ID is not really important for now
    return response.json({ id: DEFAULT_BOARD_ID });
});

BoardRouter.get('/:boardId', (request, response) => {
    return response.json({
        id: request.params.boardId,
        question: DEFAULT_QUESTION.question,
        links: [{ rel: 'self', method: 'GET', href: path.join(BOARD_ROUTE, request.params.boardId) }]
    });
});

export default BoardRouter;
