import { Router, Request, Response } from 'express';

import { AUTH_BASE_ROUTE, GAMES_BASE_ROUTE, API_VERSION } from 'constants/ApiConstants';

import AuthRouter from './AuthRouter';
import GamesRouter from './GamesRouter';

const ApiRouter: Router = Router();

ApiRouter.get('/', (request: Request, response: Response) => {
    return response.json({ version: API_VERSION });
});

ApiRouter.use(AUTH_BASE_ROUTE, AuthRouter);
ApiRouter.use(GAMES_BASE_ROUTE, GamesRouter);

export default ApiRouter;
