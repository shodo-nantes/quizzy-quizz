import { NextFunction, Request, Response } from 'express';

import Error from 'types/error';

export function ExceptionsHandler(error: Error, request: Request, response: Response, next: NextFunction) {
    if (response.headersSent) {
        return next(error);
    }

    if (error.status && error.message) {
        return response.status(error.status).json({ message: error.message, status: error.status });
    }

    return response.status(500).json({ message: 'Internal error', status: 500 });
}
