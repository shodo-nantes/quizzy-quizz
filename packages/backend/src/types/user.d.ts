export interface User {
    id: number;
    name: string;
    password: string;
}

export interface UserWithoutId extends Omit<User, 'id'> {}
