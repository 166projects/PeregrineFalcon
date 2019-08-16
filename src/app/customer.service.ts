import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Fuser } from './fuser';
import { Observable, of, BehaviorSubject } from '../../node_modules/rxjs';
import { catchError, tap, map } from 'rxjs/operators';
import { Passenger } from './passenger';
import { Booking } from './booking';
import { Flight } from './flight';
import { Schedule } from './schedule';
import { Route } from './route';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};



@Injectable({
  providedIn: 'root'
})
export class CustomerService {
 private currentFuser:BehaviorSubject<Fuser>;
 public currentfuser:Observable<Fuser>;

  private http: HttpClient;
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private _http:HttpClient) {
  this.currentFuser=new BehaviorSubject<Fuser>(JSON.parse(localStorage.getItem('currentfuser')));
  
  this.currentfuser=this.currentFuser.asObservable();

   }
  

   public get currentFuserValue():Fuser{
     return this.currentFuser.value;
   }
   
   logout(){
    localStorage.removeItem('currentUser');
    this.currentFuser.next(null);
  }
  

  registerUser(fuser: Fuser): Observable<Fuser>{
    const apiUrl='http://localhost:8089/PerigrineFlight/fuser/registeruser';
    const url = `${apiUrl}`;
    console.log('service called '+ fuser)
    return this._http.post<Fuser>(url,fuser,httpOptions).pipe(
      tap(_ => console.log(`user registered`)),
      catchError(this.handleError<Fuser>(`registerUser`))
    );
  }
  
  updateUser(fuser: Fuser): Observable<Fuser>{
    const apiUrl='http://localhost:8089/PerigrineFlight/fuser/updateuser';
    const url = `${apiUrl}`;
    return this._http.put<Fuser>(url,fuser,httpOptions).pipe(
      tap(_ => console.log(`user updated`)),
      catchError(this.handleError<Fuser>(`updateUser`))
    );
  }

  deleteUser(id: String): Observable<any>{
    const apiUrl='http://localhost:8089/PerigrineFlight/fuser/delete/{id}';
    const url = `${apiUrl}`;
  return this._http.delete(url).pipe(
     tap(_ => console.log(`user deleted`)),
     catchError(this.handleError<Fuser>(` deleteUser`))
  );
  }

  changePassword(opass: String,npass: String,id: String): Observable<Fuser>{
    const apiUrl='http://localhost:8089/PerigrineFlight/fuser/changepassword/{opass}/{npass}/{id}';
    const url = `${apiUrl}`;
    return this._http.put<Fuser>(url,httpOptions).pipe(
      tap(_ => console.log(`password changed`)),
      catchError(this.handleError<Fuser>(`changePassword`))
    );
  }

  addBooking(booking: Booking): Observable<Booking>{
    const apiUrl='http://localhost:8089/PerigrineFlight/fuser/addbooking';
    const url = `${apiUrl}`;
    return this._http.post<Booking>(url,booking,httpOptions).pipe(
      tap(_ => console.log(`booking added`)),
      catchError(this.handleError<Booking>(`addBooking`))
    );
  }

  
  login(cid: string, cpass: string):Observable<Fuser>{
    console.log('service called');  
    const url1= 'http://localhost:8089/PerigrineFlight/admin/login';
   // const lurl = `http://localhost:8089/OnlineClinic/LoginSignup/login/priya@gmail.com/1234`;
    const lurl=`${url1}/${cid}/${cpass}`;
    return this._http.get<Fuser>(lurl)
    .pipe(tap(fuser =>{localStorage.setItem('currentfuser',JSON.stringify(fuser));
  this.currentFuser.next(fuser);
    return fuser;}),
    catchError(this.handleError<Fuser>(`getProduct id=${cid}`))
  );
  }
 
  // login(email: string, password: string):Observable<User>{
  //   console.log('service called');  
  //   const url1= 'http://localhost:8089/StormReaper/user/userlogin';
  
  // const lurl=`${url1}/${email}/${password}`;
  //   return this._http.get<User>(lurl)
  //   .pipe(tap(user => {
  //     localStorage.setItem('currentPassenger',JSON.stringify(user));
  //     this.currentUserSubject.next(user);
  //   return user;}),
  //   catchError(this.handleError<User>(`getProduct id=${email}`))
  // );
  
  // } 
  
  // logout(){
  //   localStorage.removeItem('currentUser');
  //   this.currentUserSubject.next(null);
  // }
  









  deleteBooking(id:String):Observable<any>{
    const apiUrl=`http://localhost:8089/Perigrineflight/fuser/deleteBooking/${id}`;
    const url = `${apiUrl}/${id}`;
    return this._http.delete(url).pipe(
      tap(_=> console.log('booking deleted')),
      catchError(this.handleError<Booking>(` deleteBooking`))
    );
  }
  
  getBookingbyId(id:String):Observable<Booking>{
    const apiUrl=`http://localhost:8089/Perigrineflight/fuser/getBookingbyid/${id}`
    const url = `${apiUrl}/${id}`;
    return this._http.get<Booking>(url).pipe(
      tap(_ => console.log('getBookingbyId')),
      catchError(this.handleError<Booking>('getBookingbyId'))
    );
  }

  getFlights(flight: Flight):Observable<Flight>{
      const apiUrl=`http://localhost:8089/PerigrineFlight/fuser/getFlights`;
      const url = `${apiUrl}`;
      return this._http.get<Flight>(url).pipe(
        tap(_ => console.log(`getFlights`)),
        catchError(this.handleError<Flight>(`getFlights`))
      );

  }

  getFlightById(id:String):Observable<Flight>{
    const apiUrl=`http://localhost:8089/PerigrineFlight/fuser/flightbyid/${id}`
    const url = `${apiUrl}`;
    return this._http.get<Flight>(url).pipe(
     tap(_ => console.log(`getFlightbyId`)),
      catchError(this.handleError<Flight>(`getFlightbyId`))
    );
  }

  getSchedules():Observable<Schedule>{
    const apiUrl=`http://localhost:8089/PerigrineFlight/fuser/getallschedules`;
    const url = `${apiUrl}`;
    return this._http.get<Schedule>(url).pipe(
      tap(_ => console.log('recevied all Schedules')),
      catchError(this.handleError<Schedule>('getSchedules'))
    );
  }



  updatePassenger(passenger: Passenger): Observable<Passenger>{
    const apiUrl='http://localhost:8089/PerigrineFlight/fuser/updatepassenger';
    const url = `${apiUrl}`;
    return this._http.put<Passenger>(url,passenger,httpOptions).pipe(
      tap(_ => console.log(`passenger updated`)),
      catchError(this.handleError<Passenger>(`updatePassenger`))
    );
  }

  
  getPassengerByName( name: String): Observable<Passenger> {
    const apiUrl='http://localhost:8089/PerigrineFlight/fuser/passengerbyname/{name}';
   const url = `${apiUrl}`;
   return this._http.get<Passenger>(url).pipe(
     tap(_ => console.log(`fetched name=${name}`)),
     catchError(this.handleError<Passenger>(`getPassengerByname`))
   );
}

getallRoutes():Observable<Route>{
  const apiUrl=`http://localhost:8089/PerigrineFlight/fuser/getallroutes`;
  const url = `${apiUrl}`;
  return this._http.get<Route>(url).pipe(
    tap(_ => console.log(`all routes`)),
    catchError(this.handleError<Route>(`getRoutes`))
  );

}

getnoofseats(typeofseat: String, fid: String): Observable<number> {
  console.log('getnoofseats service called');
  const apiUrl= 'http://localhost:8089/PerigrineFlight/fuser/getnoofseats';
  const url= `${apiUrl}/${typeofseat}/${fid}`;
  return this._http.get<number>(url)
  .pipe(tap(_ => console.log(`${typeofseat}`)),
  catchError(this.handleError<number>(`Error`))
);
}
addPassenger(passenger: Passenger): Observable<Passenger>{
  const apiUrl='http://localhost:8089/PerigrineFlight/fuser/addpassenger';
  const url = `${apiUrl}`;
  console.log('service called');
  return this._http.post<Passenger>(url,passenger,httpOptions).pipe(
    tap(_ => console.log(`passenger added`)),
    catchError(this.handleError<Passenger>(`addPassenger failed`))
  );
}

getflightdetails(source:String, destination:String): Observable<Schedule[]> {
  const apiUrl='http://localhost:8089/PerigrineFlight/fuser/getflightdetails';
  const url= `${apiUrl}/${source}/${destination}`;
  return this._http.get<Schedule[]>(url)
  .pipe(tap(_ => console.log(`schedule details fetched`)),
  catchError(this.handleError<Schedule[]>(`Error`))
);
}



  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }




  }
