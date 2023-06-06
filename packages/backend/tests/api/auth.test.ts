import supertest from 'supertest';

import { SIGNUP_ROUTE } from 'constants/ApiConstants';
import { User } from 'types/user';

describe('Auth', () => {
    const user: User = { id: 1, name: 'name', password: 'password' };
    const UserRepositoryMock = {
        getUserByName: jest.fn(),
        createUser: jest.fn()
    };
    let request: supertest.SuperTest<supertest.Test>;

    beforeAll(async () => {
        jest.mock('repositories/UserRepository', () => UserRepositoryMock);
        const { default: app } = await import('app');
        request = supertest(app);
    });

    beforeEach(() => {
        UserRepositoryMock.getUserByName.mockResolvedValue(null);
        UserRepositoryMock.createUser.mockResolvedValue(user);
    });

    afterEach(() => {
        jest.resetAllMocks();
    });

    afterAll(() => {
        jest.restoreAllMocks();
    });

    describe(`WHEN POST ${SIGNUP_ROUTE}`, () => {
        describe('AND name and password are not provided', () => {
            beforeEach(() => {
                UserRepositoryMock.getUserByName.mockRejectedValue(new Error('getUserByName should not be called'));
                UserRepositoryMock.createUser.mockRejectedValue(new Error('createUser should not be called'));
            });

            it('should return 400 if name is not provided', async () => {
                const result = await request.post(SIGNUP_ROUTE).send({ password: 'password' }).expect(400);
                expect(result.body).toEqual({ message: 'Fields name and password are required', status: 400 });
            });

            it('should return 400 if password is not provided', async () => {
                const result = await request.post(SIGNUP_ROUTE).send({ name: 'name' }).expect(400);
                expect(result.body).toEqual({ message: 'Fields name and password are required', status: 400 });
            });
        });

        it('should return an object with property "token"', async () => {
            const result = await request.post(SIGNUP_ROUTE).send({ name: 'name', password: 'password' }).expect(200);

            expect(result.body).toEqual({
                token: expect.any(String)
            });
        });

        it('should return 409 if user already exists', async () => {
            UserRepositoryMock.getUserByName.mockResolvedValue(user);

            const result = await request.post(SIGNUP_ROUTE).send({ name: 'name', password: 'password' }).expect(409);

            expect(result.body).toEqual({ message: 'An user with this name already exists', status: 409 });
        });

        it('should return 400 if user could not be created', async () => {
            UserRepositoryMock.createUser.mockResolvedValue(null);

            const result = await request.post(SIGNUP_ROUTE).send({ name: 'name', password: 'password' }).expect(400);

            expect(result.body).toEqual({ message: 'Error when creating user', status: 400 });
        });
    });
});
