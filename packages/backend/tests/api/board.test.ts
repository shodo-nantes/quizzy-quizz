import path from 'path';

import app from 'app';
import request from 'supertest';

import { API_BASE_ROUTE, BOARD_BASE_ROUTE } from 'constants/ApiConstants';

const BOARD_ROUTE = path.join(API_BASE_ROUTE, BOARD_BASE_ROUTE);

describe('Board', () => {
    it('when GET /board, should return an object with property "id"', async () => {
        const result = await request(app).get(BOARD_ROUTE).expect(200);
        expect(result.body).toHaveProperty('id');
        expect(typeof result.body.id).toBe('string');
    });

    it('when GET /board/:id, should return an object with property "id" and "links"', async () => {
        const result = await request(app).get(`${BOARD_ROUTE}/1`).expect(200);
        expect(result.body).toEqual({
            id: '1',
            links: [{ rel: 'self', href: `${BOARD_ROUTE}/1` }]
        });
    });
});
