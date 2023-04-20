// eslint-disable-next-line import/no-commonjs, @typescript-eslint/no-var-requires, unicorn/prefer-module
require('esbuild').build({
    entryPoints: ['./src/server.ts'],
    bundle: true,
    platform: 'node',
    minify: true,
    outfile: './dist/server.js'
});
