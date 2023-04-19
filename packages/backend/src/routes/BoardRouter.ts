import path from 'path';

import { Router, Request, Response } from 'express';

import { BOARD_ROUTE } from 'constants/ApiConstants';

const BoardRouter: Router = Router();

const DEFAULT_BOARD_ID = '1';

BoardRouter.get('/', (request: Request, response: Response) => {
    // FIXME: Board ID is not really important for now
    return response.json({ id: DEFAULT_BOARD_ID });
});

BoardRouter.get('/:boardId', (request, response) => {
    return response.json({
        id: request.params.boardId,
        links: [{ rel: 'self', method: 'GET', href: path.join(BOARD_ROUTE, request.params.boardId) }]
    });
});

export default BoardRouter;
