import { Schedule } from './schedule';
import { Route } from './route';
import { TypeFlight } from './type-flight';

export class Flight {
    fid: string;
    name: string;
    distance: number;
    typeofflight: string;
    flight: Flight[];
    typeFlight: TypeFlight[];
    schedule: Schedule[];
    route: Route;
}
