import { NotFoundException } from 'utils/exceptions';

export function UnknownRoutesHandler() {
    throw new NotFoundException();
}
