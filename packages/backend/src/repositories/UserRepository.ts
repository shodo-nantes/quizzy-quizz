import prisma from 'db/prisma';
import { User, UserWithoutId } from 'types/user';

export async function getUsers(): Promise<User[]> {
    return prisma.user.findMany();
}

export async function getUserByName(name: string): Promise<User | null> {
    return prisma.user.findUnique({ where: { name } });
}

export async function createUser(user: UserWithoutId): Promise<User> {
    return prisma.user.create({ data: user });
}
