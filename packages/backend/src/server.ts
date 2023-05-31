import { PORT } from 'config/environment';

import app from './app';

app.listen(PORT, () => {
    console.info(`Listening at http://localhost:${PORT}`);
});
