import { Router, Request, Response } from 'express';

import { GAMES_BASE_ROUTE, API_VERSION } from 'constants/ApiConstants';

import GamesRouter from './GamesRouter';

const ApiRouter: Router = Router();

ApiRouter.get('/', (request: Request, response: Response) => {
    return response.json({ version: API_VERSION });
});

ApiRouter.use(GAMES_BASE_ROUTE, GamesRouter);

export default ApiRouter;
