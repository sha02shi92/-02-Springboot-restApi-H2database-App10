package in.ashokit.request;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class PassengerRequest {
	
	private String name;
	private String email;
	private long phno;
	private String from;
	private String to;
	private String jdate;
	private String trainNum;

}
