package application.struct;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Switch {
	
	String IpAddress;
	String SwitchType;
	HashMap<Integer ,HashMap<String,RessourcesConstraints>> constraint=new HashMap<Integer ,HashMap<String,RessourcesConstraints>>();
	int i=0;
	public Switch() {
		super();
	}
	public Switch(String ipAddress, String switchType, HashMap<Integer ,HashMap<String,RessourcesConstraints>> constraint) {
		super();
		IpAddress = ipAddress;
		SwitchType = switchType;
		this.constraint = constraint;
	}
	public String getIpAddress() {
		return IpAddress;
	}
	public void setIpAddress(String ipAddress) {
		IpAddress = ipAddress;
	}
	public String getSwitchType() {
		return SwitchType;
	}
	public void setSwitchType(String switchType) {
		SwitchType = switchType;
	}
	public HashMap<Integer ,HashMap<String,RessourcesConstraints>> getConstraint() {
		return constraint;
	}
	public void setConstraint(HashMap<Integer ,HashMap<String,RessourcesConstraints>> constraint) {
		this.constraint = constraint;
	}
	@Override
	public String toString() {
		return "Switch [IpAddress=" + IpAddress + ", SwitchType=" + SwitchType + ", constraint=" + constraint + "]";
	}
	public void addConstraints(String Type,RessourcesConstraints Constraints){
		HashMap<String,RessourcesConstraints> a=new HashMap<String,RessourcesConstraints>();
		a.put(Type, Constraints);
		this.constraint.put(i,a);
		i=i+1;
	}
	
	//RessourcesConstraints
}