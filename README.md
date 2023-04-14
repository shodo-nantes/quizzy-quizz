# quizzy-quizz

Quizz app done in typescript

## Requirements

Use the package manager [npm](https://www.npmjs.com/) to install dependencies.

If you need to install node and npm, you can use [nvm](https://github.com/nvm-sh/nvm#installing-and-updating)

-   Node.js >= 18.14
-   Npm >= 9.5

## Installation

Run the following command directly from root folder to install dependencies:

```bash
npm ci
```

_Note: you don't have to install dependencies for each package, the root package.json will install all dependencies for you_

## Usage

### Development

To start the frontend in development mode, run the following command:

```bash
npm run dev -w frontend
```

## Tools

### Linting

Eslint is used to lint the code. To run the linter, run the following command:

```bash
npm run lint
```

You can install the eslint extension for your IDE to see linting errors in your code.

### Formatting

Prettier is used to format the code. You can install the prettier extension for your IDE to format the code on save.

## Frontend

See [frontend](packages/frontend/README.md) for more information.

## Backend

See [backend](packages/backend/README.md) for more information.
