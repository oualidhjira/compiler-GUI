package application.struct;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Switch {
	
	String IpAddress;
	String SwitchType;
	
	HashMap<Integer ,HashMap<String,RessourcesConstraints>> constraint=new HashMap<Integer ,HashMap<String,RessourcesConstraints>>();
	public static int i=0;
	int h;
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
	
	public ArrayList<RessourcesConstraints> getRessourcesConstraints(HashMap<Integer ,HashMap<String,RessourcesConstraints>> constraint){	
		int j;
		ArrayList<RessourcesConstraints> rs = new ArrayList<RessourcesConstraints>();
		//System.out.println(constraint);
		for (i=0;i<constraint.size();i++){
			for (j=0;j<constraint.get(i).size();j++){
				//System.out.println(constraint.get(i).entrySet());
				//if we have performance constraints we should add condition on the type of the key
				//System.out.println(constraint.get(i).keySet());
				rs.add(constraint.get(i).get("application.struct.RessourcesConstraints"));

			}		
		}
		//System.out.println(rs);
	    return rs;
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
		//System.out.println(a.toString());
		a.put(Type, Constraints);
		//System.out.println(Constraints);
		//System.out.println(a);
		this.constraint.put(i,a);
		//System.out.println(i);
		i=i+1;
		//System.out.println(this.constraint.toString());
	}
	
	//RessourcesConstraints
}