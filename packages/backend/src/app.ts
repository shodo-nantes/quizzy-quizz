import express, { Express, Request, Response } from 'express';

import { API_BASE_ROUTE } from 'constants/ApiConstants';
import ApiRouter from 'routes/ApiRouter';

const app: Express = express();

app.get('/', (request: Request, result: Response) => {
    result.send();
});

app.use(API_BASE_ROUTE, ApiRouter);

export default app;
