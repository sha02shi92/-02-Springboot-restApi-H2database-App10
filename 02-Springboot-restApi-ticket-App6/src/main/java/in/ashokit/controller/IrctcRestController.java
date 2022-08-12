package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.request.PassengerRequest;
import in.ashokit.response.TicketResponse;
import in.ashokit.service.IrctcService;

@RestController
public class IrctcRestController {
	
	@Autowired
	private  IrctcService service;

	@PostMapping ( value="/bookTicket",
			    consumes= {"application/xml", "application/json"}
			)
	public ResponseEntity<String> bookTicket(@RequestBody PassengerRequest request){ 
		
		String pnr=service.bookTicket(request);
		String msg="Ticket booking Completed ::" + pnr;
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping (value="/ticket/{pnr}",
			produces= {"application/xml", "application/json"}
	)
	public ResponseEntity<TicketResponse> getTicket(@PathVariable String pnr){
		TicketResponse ticket= service.getTicketByPnr(pnr);
		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/ticket/{pnr}")
	public ResponseEntity<String> deleteTicket(@PathVariable String pnr){
		String msg=service.deleteTicket(pnr);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@PutMapping(value="/ticket/update",
			consumes= {"application/xml" , "application/json"}
			)
	public ResponseEntity<String> updateTicket(@RequestBody TicketResponse ticket){
		String msg=service.updateTicket(ticket);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
}
