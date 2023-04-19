import Link from '@mui/material/Link';
import Stack from '@mui/material/Stack';
import Typography from '@mui/material/Typography';

export default function NotFound() {
    return (
        <Stack direction="column" alignItems="center" spacing={1}>
            <Typography variant="h2">404</Typography>
            <Typography variant="body1">La page que vous recherchez n'existe pas.</Typography>
            <Link href="/">Retour à l'accueil</Link>
        </Stack>
    );
}
