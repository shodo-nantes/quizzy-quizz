import app from 'app';
import request from 'supertest';

describe('API', () => {
    it('should return the API version', async () => {
        const result = await request(app).get('/api/v1').expect(200);
        expect(result.body).toEqual({ version: 1 });
    });
});
