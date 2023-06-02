import express, { Express, Request, Response } from 'express';
import 'express-async-errors';

import { API_BASE_ROUTE } from 'constants/ApiConstants';
import { ExceptionsHandler } from 'middlewares/ExceptionsHandler';
import { UnknownRoutesHandler } from 'middlewares/RoutesHandler';
import ApiRouter from 'routes/ApiRouter';

const app: Express = express();

app.use(express.json());

app.get('/', (request: Request, response: Response) => {
    response.send();
});

app.use(API_BASE_ROUTE, ApiRouter);

app.all('*', UnknownRoutesHandler);

app.use(ExceptionsHandler);

export default app;
