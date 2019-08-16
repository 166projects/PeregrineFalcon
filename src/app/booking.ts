import { Fuser } from './fuser';
import { Passenger } from './passenger';
import { Route } from './route';
import { Schedule } from './schedule';
import { TypeFlight } from './type-flight';

export class Booking {
    bid: String;
    totalfare: number;
    fuser: Fuser;
    route: Route;
    schedule: Schedule;
    passenger: Passenger;
    typeFlight: TypeFlight;
}
