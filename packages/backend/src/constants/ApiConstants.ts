import path from 'path';

export const API_VERSION = 1;
export const API_BASE_ROUTE = `/api/v${API_VERSION}`;

export const BOARD_BASE_ROUTE = `/board`;
export const BOARD_ROUTE = path.join(API_BASE_ROUTE, BOARD_BASE_ROUTE);
