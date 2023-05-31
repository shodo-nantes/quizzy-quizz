import dotenv from 'dotenv';

dotenv.config();

export const PORT = process.env.PORT || 3000;

if (!process.env.JWT_SECRET) {
    throw new Error(
        'JWT_SECRET is not defined, you have to define it in your .env file or in your environment variables'
    );
}
export const JWT_SECRET: string = process.env.JWT_SECRET as string;
