import express, { Express, Request, Response } from 'express';

const app: Express = express();
const port = 3000;

app.get('/', (request: Request, result: Response) => {
    result.send('Hello world!');
});

app.listen(port, () => {
    console.info(`Listening at http://localhost:${port}`);
});
