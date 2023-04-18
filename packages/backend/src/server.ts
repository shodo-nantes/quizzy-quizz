import dotenv from 'dotenv';
import express, { Express, Request, Response } from 'express';

dotenv.config();

const app: Express = express();
const PORT = process.env.PORT || 3000;

app.get('/', (request: Request, result: Response) => {
    result.send('Hello world!');
});

app.listen(PORT, () => {
    console.info(`Listening at http://localhost:${PORT}`);
});
