package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.repository.IrctcDao;
import in.ashokit.request.PassengerRequest;
import in.ashokit.response.TicketResponse;

@Service
public class IrctcService {
	
	@Autowired
	private IrctcDao dao;
	
	public String bookTicket(PassengerRequest request) {
		
		// logic where the book a ticket
		
		TicketResponse response = new TicketResponse();
		response.setTicketId(123);
		response.setName(request.getName());
		response.setStatus("CONFIRMED");
		response.setCost(555.50);
		response.setFrom(request.getFrom());
		response.setTo(request.getTo());
		response.setJdate(request.getJdate());
		response.setPnr("PNR55786066");
		dao.saveTicket (response);
		return "PNR55786066";
		}
	
	public TicketResponse getTicketByPnr(String pnr) {
		return dao.getTicketByPnr(pnr);
	}
	
	public String updateTicket(TicketResponse ticket) {
		return dao.updateTicket(ticket);
	}
	
	public String deleteTicket(String pnr) {
		return dao.deleteTicket(pnr);
	}
	

}
