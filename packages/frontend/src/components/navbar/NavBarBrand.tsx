import QuizIcon from '@mui/icons-material/Quiz';
import Link from '@mui/material/Link';
import Typography from '@mui/material/Typography';

import texts from 'data/texts.json';

interface NavBarBrandProps {
    isCentered: boolean;
    isDisplayedOnMobile: boolean;
}

export default function NavBarBrand({ isCentered, isDisplayedOnMobile }: NavBarBrandProps) {
    return (
        <Link
            href="/"
            sx={{
                mx: isCentered ? 'auto' : 0,
                display: isDisplayedOnMobile ? { xs: 'flex', md: 'none' } : { xs: 'none', md: 'flex' },
                alignItems: 'center',
                gap: '0 0.5rem',
                color: 'inherit',
                textDecoration: 'none'
            }}
        >
            <QuizIcon />
            <Typography
                variant="h5"
                component="span"
                noWrap
                sx={{
                    fontWeight: 700,
                    letterSpacing: '.25rem'
                }}
            >
                {texts['navbar.title']}
            </Typography>
        </Link>
    );
}
