import { Routes, Route } from 'react-router-dom';

import Layout from 'components/Layout';
import Game from 'pages/GamePage';
import Home from 'pages/Home';
import NotFound from 'pages/NotFound';

function App() {
    return (
        <Routes>
            <Route element={<Layout />}>
                <Route path="/" element={<Home />} />
                <Route path="/games/:id" element={<Game />} />

                {/* Using path="*"" means "match anything", so this route
                acts like a catch-all for URLs that we don't have explicit
                routes for. */}
                <Route path="*" element={<NotFound />} />
            </Route>
        </Routes>
    );
}

export default App;
