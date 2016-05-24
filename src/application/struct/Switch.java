package application.struct;

import java.util.HashMap;

public class Switch {
	
	String IpAddress;
	String SwitchType;
	HashMap<String,RessourcesConstraints> constraint=new HashMap<String,RessourcesConstraints>();
	public Switch(String ipAddress, String switchType, HashMap<String, RessourcesConstraints> constraint) {
		super();
		IpAddress = ipAddress;
		SwitchType = switchType;
		this.constraint = constraint;
	}
	
	
}