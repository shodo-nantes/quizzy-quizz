class Exception {
    constructor(readonly message: string, readonly status: number) {}
}

export class NotFoundException extends Exception {
    constructor(message = 'Not Found') {
        super(message, 404);
    }
}

export class BadRequestException extends Exception {
    constructor(message = 'Bad Request') {
        super(message, 400);
    }
}
