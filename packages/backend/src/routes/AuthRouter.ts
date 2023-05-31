import { Router, Request, Response } from 'express';
import jwt from 'jsonwebtoken';

import { JWT_SECRET } from 'config/environement';
import { SIGNUP_BASE_ROUTE } from 'constants/ApiConstants';

const AuthRouter: Router = Router();

const TOKEN_EXPIRATION = '1h';

AuthRouter.post(SIGNUP_BASE_ROUTE, (request: Request, response: Response) => {
    const { username, password } = request.body;

    if (!username || !password) {
        return response.status(400).json({ message: 'Bad request' });
    }

    const token = jwt.sign({ username }, JWT_SECRET, { expiresIn: TOKEN_EXPIRATION });
    return response.json({ token });
});

export default AuthRouter;
