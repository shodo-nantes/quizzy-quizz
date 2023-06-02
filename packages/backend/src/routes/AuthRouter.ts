import { Router, Request, Response } from 'express';
import jwt from 'jsonwebtoken';

import { JWT_SECRET } from 'config/environment';
import { SIGNUP_BASE_ROUTE } from 'constants/ApiConstants';
import { UserWithoutId } from 'types/user';
import { BadRequestException } from 'utils/exceptions';

const AuthRouter: Router = Router();

const TOKEN_EXPIRATION = '1h';

AuthRouter.post(SIGNUP_BASE_ROUTE, (request: Request, response: Response) => {
    const { name, password }: UserWithoutId = request.body;

    if (!name || !password) {
        throw new BadRequestException('Fields name and password are required');
    }

    const token = jwt.sign({ name }, JWT_SECRET, { expiresIn: TOKEN_EXPIRATION });
    return response.json({ token });
});

export default AuthRouter;
