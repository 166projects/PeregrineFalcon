package com.mphasis.flight.controllers;

import java.sql.Time;
import java.time.Instant;
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

import com.mphasis.flight.exceptions.*;
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
import com.mphasis.flight.entities.TypeFlight;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	FuserBo fuserBo;
	@Autowired
	ScheduleBo scheduleBo;
	@Autowired
	RouteBo routeBo;
	@Autowired
	TypeFlightBo typeFlightBo;
	@Autowired
	FlightBo flightBo;
	@Autowired
	PassengerBo passengerBo;
	@Autowired
	BookingBo bookingBo;
	
	@RequestMapping(value="/login",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public void loginAdmin(@RequestBody String cid,@RequestBody String password)
	{
		fuserBo.login(cid, password);
    }
	
	@RequestMapping(value="/changepassword/{oldpass}/{newpass}/{cid}",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void changeAdminPassword(@PathVariable("oldpass")String oldpass,@PathVariable("newpass")String newpass,@PathVariable("cid")String cid)
	{
		fuserBo.changePassword(oldpass, newpass, cid);
	}



		
	@RequestMapping(value="/addadmin",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addAdmin(@RequestBody Fuser fuser)
	{
			fuserBo.addAdmin(fuser);
	}
	
	@RequestMapping(value="/deleteadmin/{cid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteAdmin(@PathVariable("cid") String cid)
	{
		try {
			fuserBo.deleteAdmin(cid);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/updateadmin",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateAdmin(@RequestBody Fuser fuser)
	{
		fuserBo.updateAdmin(fuser);
	}
	
	@RequestMapping(value="/getalladmin",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Fuser> getAllAdmins()
	{
		List<Fuser> fusers=fuserBo.getAllAdmins();
		return fusers;
	}
	
	@RequestMapping(value="/addpassenger",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addPassenger(@RequestBody Passenger passenger)
	{
		passengerBo.addPassenger(passenger);
	}
	
	@RequestMapping(value="/getallpassenger",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Passenger> getAllPassengers()
	{
		List<Passenger> passengers=passengerBo.getPassengers();
		return passengers;
	}
	
	@RequestMapping(value="/getallbookings",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Booking> getAllBookings()
	{
		List<Booking> bookings=bookingBo.getAll();
		return bookings;
	}
	
	@RequestMapping(value="/booking/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Booking getBookingById(@PathVariable("id")int bid)
	{
		return bookingBo.getById(bid);
	}
	

     @RequestMapping(value="/addschedule",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
     public void addSchedule(@RequestBody Schedule schedule)
     {
	    scheduleBo.addSchedule(schedule);
     }
     
     @RequestMapping(value="/updateschedule",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
 	public void updateSchedule(@RequestBody Schedule schedule)
 	{
 		scheduleBo.updateSchedule(schedule);
 	}
     
     @RequestMapping(value="/deleteschedule/{sid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
 	public void deleteSchedule(@PathVariable("sid")int sid)
 	{
 		scheduleBo.deleteSchedule(sid);
 	}
 	
     @RequestMapping(value="/getallschedules",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
 	public List<Schedule> getAllSchedules()
 	{
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
     
     @RequestMapping(value="/getallroutes",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
 	public List<Route> getAllRoutes()
 	{
   	 List<Route> routes=routeBo.getRoutes();
   	 return routes;
 	}
     
     @RequestMapping(value="/addroute",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
  	public void addRoute(@RequestBody Route route)
  	{
    	 routeBo.insertRoute(route);
    	
  	}
     
     @RequestMapping(value="/deleteroute/{rid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
   	public void deleteRoute(@PathVariable int rid)
   	{
     	 routeBo.removeRoute(rid);
     	
   	}
     
     @RequestMapping(value="/updateroute",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
    	public void updateRoute(@RequestBody Route route)
    	{
      	 routeBo.editRoute(route);
      	
    	}
     
     @RequestMapping(value="/routebysource/{source}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
 	public List<Route> getRouteBySource(@PathVariable("source")String source) throws BusinessException
 	{
    	 List<Route> routes=routeBo.getBySource(source);
		return routes;
   	 
 		
 	}
     
     @RequestMapping(value="/routebydestination/{destination}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
  	public List<Route> getRouteByDestination(@PathVariable("destination")String destination) throws BusinessException
  	{
     	 List<Route> routes=routeBo.getByDestination(destination);
 		return routes;
    	 
  		
  	}
     @RequestMapping(value="/addflight",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
   	public void addFlight(@RequestBody Flight flight)
   	{
    	 System.out.println("flight values"+flight.getDistance());
     	 flightBo.addFlight(flight);
     	
   	}
     @RequestMapping(value="/updateflight",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
 	public void updateFlight(@RequestBody Flight flight)
 	{
   	 flightBo.updateFlight(flight);
   	
 	}
     @RequestMapping(value="/deleteflight/{fid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
    	public void deleteFlight(@PathVariable("fid") int fid)
    	{
      	 flightBo.deleteFlight(fid);
      	
    	} 
     @RequestMapping(value="/getallflights",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
  	public List<Flight> getAllFlights()
  	{
    	 List<Flight> flights=flightBo.getAllFlights();
    	 return flights;
  	}
     
     @RequestMapping(value="/getflight/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
 	public Flight getFlightById(@PathVariable("id")int id) throws BusinessException
 	{
    	 Flight flights=flightBo.getById(id);
		return flights;
 	}
     
     @RequestMapping(value="/addtypeflight",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
     public void addTypeFlight(@RequestBody TypeFlight typeflight)
     {
    	 typeFlightBo.addTypeFlight(typeflight);
     }
     
     @RequestMapping(value="/getnoofseats/{typeofseat}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
     public int getNoOfSeats(@PathVariable("typeofseat")String typeofseat)
     {
    	 
    	 int s=typeFlightBo.getNoofSeats(typeofseat);
    	 return s;
    	 
    	 
     }
     
     
     
}

