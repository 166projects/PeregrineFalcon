
package com.mphasis.flight.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.flight.bo.BookingBo;
import com.mphasis.flight.bo.FlightBo;
import com.mphasis.flight.bo.FuserBo;
import com.mphasis.flight.bo.PassengerBo;
import com.mphasis.flight.bo.RouteBo;
import com.mphasis.flight.bo.ScheduleBo;
import com.mphasis.flight.bo.TypeFlightBo;
import com.mphasis.flight.entities.Booking;
import com.mphasis.flight.entities.Flight;
import com.mphasis.flight.entities.Fuser;
import com.mphasis.flight.entities.Passenger;
import com.mphasis.flight.entities.Route;
import com.mphasis.flight.entities.Schedule;
import com.mphasis.flight.exceptions.BusinessException;

@RestController
@RequestMapping("/fuser")
public class FuserController {
       
       @Autowired
       FuserBo fuserBo;
       @Autowired
       BookingBo bookingBo;
       @Autowired
       FlightBo flightBo;
       @Autowired
       PassengerBo passengerBo;
       @Autowired
       RouteBo routeBo;
       @Autowired
       ScheduleBo scheduleBo;
       @Autowired
       TypeFlightBo typeFlightBo;
       
       //Fuser
       
       /*@RequestMapping(value="/fusers", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
       public Fuser login(@RequestBody Fuser fuser){
       
              Fuser fuser1 = fuserBo.login(fuser.getCid(), fuser.getCpass());
              if(fuser1!=null)
                     return fuser1;
              else
                     return null;
       }*/
       
       
       
       /*@SuppressWarnings("unchecked")
       @RequestMapping(value="/fusers", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
       public List<Fuser> getAll(){
              
              List<Fuser> fusers=fuserBo.getAllAdmins();
              return fusers;
       }*/
       
       @RequestMapping(value="/registeruser", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
       public void addUser(@RequestBody Fuser fuser) throws BusinessException{
              try {
                     fuserBo.register(fuser);
              }catch(BusinessException e) {
                     throw new BusinessException("Registration Failed");
              }
              
       }
       
       @RequestMapping(value="/updateuser", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
       public void updateUser(@RequestBody Fuser fuser){
              
                     fuserBo.updateAdmin(fuser);
              
       }
       
       @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
       public void deleteFuser(@PathVariable("id")String cid) throws BusinessException{
              try{
                     fuserBo.deleteAdmin(cid);
              }catch(BusinessException e) {
                     throw new BusinessException("User does not exist");
              }
       }
       
//       @RequestMapping(value="/fusers/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
//       public Fuser getFuserById(@PathVariable("id")String cid) throws BusinessException{
//       
//              return fuserBo.getById(cid);
//       }
       
       @RequestMapping(value="/fusers/{opass}/{npass}/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
       public void changeUserPassword(@PathVariable("opass")String opass, @PathVariable("npass")String npass, @PathVariable("id")String cid) throws BusinessException{
       
              fuserBo.changePassword(opass, npass, cid);
       }
       
       
       //Booking
       
       
       @RequestMapping(value="/addbooking", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
       public void addBooking(@RequestBody Booking booking) throws BusinessException{
              
              bookingBo.addBooking(booking);
              
       }
       
       @RequestMapping(value="/deletebooking", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
       public void deleteBooking(@RequestBody Booking booking) throws BusinessException{
              
                     bookingBo.deleteBooking(booking);             
       }
       
       
       @RequestMapping(value="/booking/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
       public Booking getBookingById(@PathVariable("id")int bid) throws BusinessException{
       
              return bookingBo.getById(bid);
       }
       
       
       //Flight
       
       @RequestMapping(value="/flights", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
       public List<Flight> getAll(){
              
              List<Flight> flights=flightBo.getAllFlights();
              return flights;
       }
       
       @RequestMapping(value="/flight/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
       public Flight getFlightById(@PathVariable("id")int fid) throws BusinessException{
       
              return flightBo.getById(fid);
       }
       
       //Schedule
       
       @RequestMapping(value="/schedules", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
       public List<Schedule> getAllSchedules(){
              
              List<Schedule> schedules=scheduleBo.getSchedules();
              return schedules;
       }
       
       @RequestMapping(value="/schedulebyid/{sid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    	public Schedule getScheduleById(@PathVariable("sid")int sid)
    	{
    		return scheduleBo.getScheduleById(sid);
    	}
       
       @RequestMapping(value="/schedulebydate/{date}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
     	public List<Schedule> getScheduleByDate(@PathVariable("date")String fdate)
     	{
       	 List<Schedule> schedules=scheduleBo.getScheduleByDate(fdate);
     		return schedules;
     	}
        
        @RequestMapping(value="/schedulebyatime/{atime}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
      	public List<Schedule> getScheduleByArrival(@PathVariable("atime")String atime)
      	{
        	 List<Schedule> schedules=scheduleBo.getScheduleByArrival(atime);
      		return schedules;
      	}
        
        @RequestMapping(value="/schedulebydtime/{dtime}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
       	public List<Schedule> getScheduleByDeparture(@PathVariable("dtime")String dtime)
       	{
         	 List<Schedule> schedules=scheduleBo.getScheduleByDeparture(dtime);
       		return schedules;
       	}
       
       
       //passenger
       @RequestMapping(value="/passenger/{name}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
       public List<Passenger> getPassengerByName(@PathVariable("name")String name) throws BusinessException{
       
              List<Passenger> passengers=passengerBo.getByName(name);
              return passengers;
       }
       
       @RequestMapping(value="/updatepassenger", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
       public void updatePassenger(@RequestBody Passenger passenger){
              passengerBo.updatePassenger(passenger);
       }
       
       @RequestMapping(value="/addpassenger", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
       public void addPassenger(@RequestBody Passenger passenger) throws BusinessException{
              
              passengerBo.addPassenger(passenger);
              
       }
       
       @RequestMapping(value="/cancelticket/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
       public void deletePassenger(@PathVariable("id")int pid) throws BusinessException{
              
                     passengerBo.deletePassenger(pid);       
       }
       
       //Route
       
       @RequestMapping(value="/getallroutes", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
       public List<Route> getAllRoutes(){
              
              List<Route> routes=routeBo.getRoutes();
              return routes;
       }
       
       @RequestMapping(value="/routebysource/{source}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    	public List<Route> getRouteBySourceUser(@PathVariable("source")String source) throws BusinessException
    	{
       	 List<Route> routes=routeBo.getBySource(source);
   		return routes;
      	 
    		
    	}
       @RequestMapping(value="/routebydestination/{destination}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
       public List<Route> getRouteByDestinationUser(@PathVariable("destinatiion")String destination) throws BusinessException{
       
              List<Route> routes=routeBo.getByDestination(destination);
              return routes;
       }
       
       
       //Type Flight
       
       @RequestMapping(value="//{source}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
       public List<Route> getRouteBySource(@PathVariable("source")String source) throws BusinessException{
       
              List<Route> routes=routeBo.getBySource(source);
              return routes;
       }
}

