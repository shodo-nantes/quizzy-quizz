import path from 'path';

import { Router, Request, Response } from 'express';

import { API_BASE_ROUTE, BOARD_BASE_ROUTE } from 'constants/ApiConstants';

const BoardRouter: Router = Router();

const BOARD_ROUTE = path.join(API_BASE_ROUTE, BOARD_BASE_ROUTE);
const DEFAULT_BOARD_ID = '1';

BoardRouter.get('/', (request: Request, response: Response) => {
    // FIXME: Board ID is not really important for now
    return response.json({ id: DEFAULT_BOARD_ID });
});

BoardRouter.get('/:id', (request, response) => {
    return response.json({
        id: request.params.id,
        links: [{ rel: 'self', href: `${BOARD_ROUTE}/${request.params.id}` }]
    });
});

export default BoardRouter;
