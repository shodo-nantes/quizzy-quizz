import HypermediaLink from './hypermediaLink';

export default interface Game {
    id: string;
    name: string;
    _links: Record<string, HypermediaLink>;
}
