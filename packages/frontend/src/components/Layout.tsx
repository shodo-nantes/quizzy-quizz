import Container from '@mui/material/Container';
import { Outlet } from 'react-router-dom';

export default function Layout() {
    return (
        <>
            <Container maxWidth="md" component="main">
                <Outlet />
            </Container>
        </>
    );
}
