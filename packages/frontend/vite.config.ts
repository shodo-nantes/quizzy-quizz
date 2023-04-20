import react from '@vitejs/plugin-react-swc';
import { defineConfig, loadEnv } from 'vite';
import tsconfigPaths from 'vite-tsconfig-paths';

export default defineConfig(({ mode }) => {
    let { API_URL } = loadEnv(mode, process.cwd(), '');

    if (!API_URL) {
        API_URL = 'http://localhost:3000';
        console.info('API_URL is not defined in .env file. Using default value.');
    }

    return {
        plugins: [react(), tsconfigPaths()],
        server: {
            proxy: {
                '/api': {
                    target: API_URL,
                    changeOrigin: true
                }
            }
        }
    };
});
