import { Router } from 'express';

import { API_BASE_ROUTE, BOARD_BASE_ROUTE } from 'constants/ApiConstants';

const BoardRouter: Router = Router();

const DEFAULT_BOARD_ID = 1;

BoardRouter.get('/', (request, result) => {
    // FIXME: Board ID is not really important for now
    return result.json({ id: DEFAULT_BOARD_ID });
});

BoardRouter.get('/:id', (request, result) => {
    return result.json({
        id: request.params.id,
        links: [{ rel: 'self', href: `${API_BASE_ROUTE}${BOARD_BASE_ROUTE}/${request.params.id}` }]
    });
});

export default BoardRouter;
