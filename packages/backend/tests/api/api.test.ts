import app from 'app';
import request from 'supertest';

import { API_VERSION, API_BASE_ROUTE } from 'constants/ApiConstants';

describe('API', () => {
    it('should return the API version', async () => {
        const result = await request(app).get(API_BASE_ROUTE).expect(200);
        expect(result.body).toEqual({ version: API_VERSION });
    });
});
