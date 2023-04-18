import dotenv from 'dotenv';
import express, { Express, Request, Response } from 'express';

import { API_BASE_ROUTE } from 'constants/ApiConstants';
import ApiRouter from 'routes/ApiRouter';

dotenv.config();

const app: Express = express();
const PORT = process.env.PORT || 3000;

app.get('/', (request: Request, result: Response) => {
    result.send();
});

app.use(API_BASE_ROUTE, ApiRouter);

app.listen(PORT, () => {
    console.info(`Listening at http://localhost:${PORT}`);
});
