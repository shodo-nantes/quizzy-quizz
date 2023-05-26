import path from 'path';

import { Router, Request, Response } from 'express';

import { GAMES_ROUTE } from 'constants/ApiConstants';
import questions from 'data/questions.json';

const GamesRouter: Router = Router();

// Note: This is a temporary solution
const DEFAULT_GAMES_ID = '1';
const DEFAULT_GAMES_NAME = `Game ${DEFAULT_GAMES_ID}`;
const DEFAULT_QUESTION = questions[0];

GamesRouter.get('/', (request: Request, response: Response) => {
    return response.json([
        {
            id: DEFAULT_GAMES_ID,
            name: DEFAULT_GAMES_NAME,
            _links: {
                self: { method: 'GET', href: GAMES_ROUTE },
                game: { method: 'GET', href: path.join(GAMES_ROUTE, DEFAULT_GAMES_ID) }
            }
        }
    ]);
});

GamesRouter.get('/:id', (request, response) => {
    return request.params.id === DEFAULT_GAMES_ID
        ? response.json({
              id: request.params.id,
              name: DEFAULT_GAMES_NAME,
              question: DEFAULT_QUESTION.question,
              _links: {
                  self: { method: 'GET', href: path.join(GAMES_ROUTE, request.params.id) }
              }
          })
        : response.status(404).json({ message: 'Not found' });
});

export default GamesRouter;
