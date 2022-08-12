package in.ashokit.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import in.ashokit.response.TicketResponse;

@Repository
public class IrctcDao {
	
	private Map<String, TicketResponse> ticketsMap =new HashMap<>();
	
	public String saveTicket(TicketResponse response) {
		//logic will be there to store ticket in db table
		
			ticketsMap.put(response.getPnr(), response);
			return response.getPnr();
	}
	   public String updateTicket(TicketResponse response) {
		   String pnr=response.getPnr();
		   ticketsMap.put(pnr,response);
		   return "Ticket Updated";
	   }
	   
	   public String deleteTicket(String pnr) {
		   ticketsMap.remove(pnr);
		   return "Ticket deleted";
	   }
	
	
	
	public TicketResponse getTicketByPnr(String pnr) {
		// logic will be there to get ticket from db table
		
			if(ticketsMap.containsKey(pnr)) {
				return ticketsMap.get(pnr);
			}else {
				return null;
			}
	}
	
	

}
