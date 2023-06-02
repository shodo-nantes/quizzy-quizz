import prisma from 'db/prisma';

import { User, UserWithoutId } from 'types/user';

export async function getUsers(): Promise<User[]> {
    return prisma.user.findMany();
}

export async function getUserById(id: number): Promise<User | null> {
    return prisma.user.findUnique({ where: { id } });
}

export async function createUser(user: UserWithoutId): Promise<User> {
    return prisma.user.create({ data: user });
}
