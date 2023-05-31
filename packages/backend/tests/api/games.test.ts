import app from 'app';
import request from 'supertest';

import { GAMES_ROUTE } from 'constants/ApiConstants';
import questions from 'data/questions.json';

describe('Games', () => {
    it('when GET /games, should return an array of object with property "id" and "links"', async () => {
        const result = await request(app).get(GAMES_ROUTE).expect(200);
        expect(result.body).toEqual([
            {
                id: '1',
                name: 'Game 1',
                _links: {
                    self: { method: 'GET', href: GAMES_ROUTE },
                    game: { method: 'GET', href: `${GAMES_ROUTE}/1` }
                }
            }
        ]);
    });

    it('when GET /games/:id, should return an object with property "id", "question" and "links"', async () => {
        const result = await request(app).get(`${GAMES_ROUTE}/1`).expect(200);
        expect(result.body).toEqual({
            id: '1',
            name: 'Game 1',
            question: questions[0].question,
            _links: {
                self: { method: 'GET', href: `${GAMES_ROUTE}/1` }
            }
        });
    });

    it('when GET /games/:id, should return 404 if id is not found', async () => {
        const result = await request(app).get(`${GAMES_ROUTE}/2`).expect(404);
        expect(result.body).toEqual({ message: 'Not found' });
    });

    it('when POST /games/:id/proposal, should return true if proposal is good', async () => {
        const result = await request(app)
            .post(`${GAMES_ROUTE}/1/proposal`)
            .send({ proposal: questions[0].answers[0] })
            .expect(200);
        expect(result.body).toEqual({ goodAnswer: true });
    });

    it('when POST /games/:id/proposal, should return false if proposal is not good', async () => {
        const result = await request(app)
            .post(`${GAMES_ROUTE}/1/proposal`)
            .send({ proposal: 'bad proposal' })
            .expect(200);
        expect(result.body).toEqual({ goodAnswer: false });
    });
});
