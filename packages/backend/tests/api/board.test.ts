import app from 'app';
import request from 'supertest';

import { BOARD_ROUTE } from 'constants/ApiConstants';
import questions from 'data/questions.json';

describe('Board', () => {
    it('when GET /board, should return an array of object with property "id" and "links"', async () => {
        const result = await request(app).get(BOARD_ROUTE).expect(200);
        expect(result.body).toEqual([
            {
                id: '1',
                links: [
                    { rel: 'self', method: 'GET', href: BOARD_ROUTE },
                    { rel: 'board', method: 'GET', href: `${BOARD_ROUTE}/1` }
                ]
            }
        ]);
    });

    it('when GET /board/:boardId, should return an object with property "id", "question" and "links"', async () => {
        const result = await request(app).get(`${BOARD_ROUTE}/1`).expect(200);
        expect(result.body).toEqual({
            id: '1',
            question: questions[0].question,
            links: [{ rel: 'self', method: 'GET', href: `${BOARD_ROUTE}/1` }]
        });
    });
});
