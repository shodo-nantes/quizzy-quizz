import bcrypt from 'bcrypt';
import { Router, Request, Response } from 'express';
import jwt from 'jsonwebtoken';

import { JWT_SECRET, SALT_ROUNDS } from 'config/environment';
import { SIGNUP_BASE_ROUTE } from 'constants/ApiConstants';
import { createUser, getUserByName } from 'repositories/UserRepository';
import { UserWithoutId } from 'types/user';
import { BadRequestException, ConflictException } from 'utils/exceptions';

const AuthRouter: Router = Router();

const TOKEN_EXPIRATION = '1h';

AuthRouter.post(SIGNUP_BASE_ROUTE, async (request: Request, response: Response) => {
    const { name, password }: UserWithoutId = request.body;

    if (!name || !password) {
        throw new BadRequestException('Fields name and password are required');
    }

    const user = await getUserByName(name);
    if (user !== null) {
        throw new ConflictException('An user with this name already exists');
    }

    const hashedPassword = await bcrypt.hash(password, SALT_ROUNDS);
    const userCreated = await createUser({ name, password: hashedPassword });
    if (userCreated == null) {
        throw new BadRequestException('Error when creating user');
    }

    const token = jwt.sign({ id: userCreated.id, name: userCreated.name }, JWT_SECRET, { expiresIn: TOKEN_EXPIRATION });
    return response.json({ token });
});

export default AuthRouter;
