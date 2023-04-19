import { Router, Request, Response } from 'express';

import { BOARD_BASE_ROUTE, API_VERSION } from 'constants/ApiConstants';

import BoardRouter from './BoardRouter';

const ApiRouter: Router = Router();

ApiRouter.get('/', (request: Request, response: Response) => {
    return response.json({ version: API_VERSION });
});

ApiRouter.use(BOARD_BASE_ROUTE, BoardRouter);

export default ApiRouter;
