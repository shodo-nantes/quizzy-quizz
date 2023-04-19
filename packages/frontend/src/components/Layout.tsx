import Container from '@mui/material/Container';
import { Outlet } from 'react-router-dom';

import NavBar from 'components/navbar/NavBar';
import texts from 'data/texts.json';

export default function Layout() {
    return (
        <>
            <NavBar pages={[{ title: texts['navbar.page.home'], href: '/' }]} />

            <Container maxWidth="md" component="main">
                <Outlet />
            </Container>
        </>
    );
}
