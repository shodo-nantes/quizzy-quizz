import app from 'app';
import request from 'supertest';

import { SIGNUP_ROUTE } from 'constants/ApiConstants';

describe('Auth', () => {
    describe(`when POST ${SIGNUP_ROUTE}`, () => {
        it('should return 400 if name is not provided', async () => {
            const result = await request(app).post(SIGNUP_ROUTE).send({ password: 'password' }).expect(400);
            expect(result.body).toEqual({ message: 'Fields name and password are required', status: 400 });
        });

        it('should return 400 if password is not provided', async () => {
            const result = await request(app).post(SIGNUP_ROUTE).send({ name: 'name' }).expect(400);
            expect(result.body).toEqual({ message: 'Fields name and password are required', status: 400 });
        });

        it('should return an object with property "token"', async () => {
            const result = await request(app)
                .post(SIGNUP_ROUTE)
                .send({ name: 'name', password: 'password' })
                .expect(200);

            expect(result.body).toEqual({
                token: expect.any(String)
            });
        });
    });
});
