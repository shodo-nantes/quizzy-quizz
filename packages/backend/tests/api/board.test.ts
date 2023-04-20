import app from 'app';
import request from 'supertest';

import { BOARD_ROUTE } from 'constants/ApiConstants';
import questions from 'data/questions.json';

describe('Board', () => {
    it('when GET /board, should return an array of object with property "id" that is a string', async () => {
        const { body } = await request(app).get(BOARD_ROUTE).expect(200);
        expect(Array.isArray(body)).toBe(true);
        expect(body[0]).toHaveProperty('id');
        expect(typeof body[0].id).toBe('string');
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
