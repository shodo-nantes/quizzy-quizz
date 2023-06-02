import { User, UserWithoutId } from 'types/user';

describe('UserRepository', () => {
    const prismaMock = {
        user: {
            findMany: jest.fn(),
            findUnique: jest.fn(),
            create: jest.fn()
        }
    };
    let UserRepository: typeof import('../UserRepository');

    beforeAll(async () => {
        jest.mock('db/prisma', () => prismaMock);
        UserRepository = await import('../UserRepository');
    });

    afterEach(() => {
        jest.resetAllMocks();
    });

    describe('getUsers', () => {
        it('should call prisma.user.findMany', async () => {
            await UserRepository.getUsers();

            expect(prismaMock.user.findMany).toHaveBeenCalled();
        });
    });

    describe('getUserById', () => {
        it('should call prisma.user.findUnique', async () => {
            await UserRepository.getUserById(1);

            expect(prismaMock.user.findUnique).toHaveBeenCalledWith({ where: { id: 1 } });
        });
    });

    describe('createUser', () => {
        const user: UserWithoutId = { name: 'John Doe', password: 'password' };
        const createdUser: User = { id: 1, ...user };

        beforeEach(() => {
            prismaMock.user.create.mockResolvedValue(createdUser);
        });

        it('should return the created user', async () => {
            expect(await UserRepository.createUser(user)).toEqual(createdUser);
        });

        it('should call prisma.user.create', async () => {
            await UserRepository.createUser(user);

            expect(prismaMock.user.create).toHaveBeenCalledWith({
                data: user
            });
        });
    });
});
