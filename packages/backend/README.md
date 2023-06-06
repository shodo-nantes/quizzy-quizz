# Quizzy quizz backend

Backend for quizzy quizz app

## Installation

See root [README](../../README.md#installation) for installation instructions

## Usage

### Development

See root [README](../../README.md#usage) for usage instructions

or

Run the following command:

```bash
npm run dev
```

## Configuration

You can configure the backend by creating a `.env` file in the root of the backend package.

### Environment variables

You have to define the following environment variables in the `.env` file:

| Name         | Description                                                                                                                            | Default value |
| ------------ | -------------------------------------------------------------------------------------------------------------------------------------- | ------------- |
| PORT         | Port to run the server on (optional)                                                                                                   | 3000          |
| DB_HOST      | Host of the database (used by docker-compose.yml)                                                                                      |               |
| DB_PORT      | Port of the database (used by docker-compose.yml)                                                                                      |               |
| DB_NAME      | Name of the database (used by docker-compose.yml)                                                                                      |               |
| DB_USER      | User of the database (used by docker-compose.yml)                                                                                      |               |
| DB_PASSWORD  | Password of the database (used by docker-compose.yml)                                                                                  |               |
| DATABASE_URL | URL of the database (used by prisma, [see documentation](https://www.prisma.io/docs/reference/database-reference/connection-urls#env)) |               |
