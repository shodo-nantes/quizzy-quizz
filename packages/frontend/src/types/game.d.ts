import HypermediaLink from './hypermediaLink';

export default interface Game {
    id: string;
    name: string;
    question?: string;
    _links: Record<string, HypermediaLink>;
}
