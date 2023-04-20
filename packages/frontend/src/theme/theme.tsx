import { LinkProps } from '@mui/material/Link';
import { createTheme } from '@mui/material/styles';
import * as React from 'react';
import { Link as RouterLink, LinkProps as RouterLinkProps } from 'react-router-dom';

const LinkBehavior = React.forwardRef<HTMLAnchorElement, Omit<RouterLinkProps, 'to'> & { href: RouterLinkProps['to'] }>(
    (props, reference) => {
        const { href, ...other } = props;
        // Map href (MUI) -> to (react-router)
        return <RouterLink ref={reference} to={href} {...other} />;
    }
);

const theme = createTheme({
    palette: {
        mode: 'dark'
    },
    components: {
        MuiLink: {
            defaultProps: {
                component: LinkBehavior
            } as LinkProps
        },
        MuiButtonBase: {
            defaultProps: {
                LinkComponent: LinkBehavior
            }
        }
    }
});

export default theme;
