import HypermediaLink from './hypermediaLink';

export default interface Board {
    id: string;
    name: string;
    _links: Record<string, HypermediaLink>;
}
