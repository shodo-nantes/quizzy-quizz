import MenuIcon from '@mui/icons-material/Menu';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import Menu from '@mui/material/Menu';
import MenuItem from '@mui/material/MenuItem';
import Toolbar from '@mui/material/Toolbar';
import { useState } from 'react';

import texts from 'data/texts.json';

import NavBarBrand from './NavBarBrand';

interface NavBarProps {
    pages: { title: string; href: string }[];
}

export default function NavBar({ pages }: NavBarProps) {
    const [anchorElementNav, setAnchorElementNav] = useState<null | HTMLElement>(null);

    const handleOpenNavMenu = (event: React.MouseEvent<HTMLElement>) => {
        setAnchorElementNav(event.currentTarget);
    };

    const handleCloseNavMenu = () => {
        setAnchorElementNav(null);
    };

    return (
        <AppBar position="static" component="header" role="banner">
            <Toolbar>
                <NavBarBrand isCentered={false} isDisplayedOnMobile={false} />
                <Box
                    component="nav"
                    role="navigation"
                    sx={{ ml: 5, display: { xs: 'none', md: 'flex' }, gap: '0 0.5rem' }}
                >
                    <List sx={{ display: 'flex', flexDirection: 'row' }} disablePadding>
                        {pages.map((page) => (
                            <ListItem key={page.title}>
                                <Button href={page.href} onClick={handleCloseNavMenu} sx={{ color: 'inherit' }}>
                                    {page.title}
                                </Button>
                            </ListItem>
                        ))}
                    </List>
                </Box>

                <Box sx={{ display: { xs: 'flex', md: 'none' } }}>
                    <IconButton
                        size="large"
                        aria-label={texts['navbar.menuButton.ariaLabel']}
                        aria-controls="menu-navbar"
                        aria-haspopup="true"
                        onClick={handleOpenNavMenu}
                        color="inherit"
                    >
                        <MenuIcon />
                    </IconButton>
                    <Menu
                        id="menu-navbar"
                        anchorEl={anchorElementNav}
                        anchorOrigin={{
                            vertical: 'bottom',
                            horizontal: 'left'
                        }}
                        keepMounted
                        transformOrigin={{
                            vertical: 'top',
                            horizontal: 'left'
                        }}
                        open={Boolean(anchorElementNav)}
                        onClose={handleCloseNavMenu}
                        sx={{
                            display: { xs: 'block', md: 'none' }
                        }}
                    >
                        {pages.map((page) => (
                            <MenuItem key={page.title} onClick={handleCloseNavMenu}>
                                <Button href={page.href}>{page.title}</Button>
                            </MenuItem>
                        ))}
                    </Menu>
                </Box>
                <NavBarBrand isCentered={true} isDisplayedOnMobile={true} />
            </Toolbar>
        </AppBar>
    );
}
