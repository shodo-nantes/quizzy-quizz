import { Router } from 'express';

import { BOARD_BASE_ROUTE, API_VERSION } from 'constants/ApiConstants';

import BoardRouter from './BoardRouter';

const ApiRouter: Router = Router();

ApiRouter.get('/', (request, result) => {
    return result.json({ version: API_VERSION });
});

ApiRouter.use(BOARD_BASE_ROUTE, BoardRouter);

export default ApiRouter;
