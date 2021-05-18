package ro.ase.csie.cts.dp.memento;

import java.util.Date;

public class HeroRestorePoint {

	//liskov, define fr going level after level - go with the abstract definition
	
	String name;
	int lifePoints;
	private String magic;
	
	//may contain additional data
	private Date timestamp;
	
	public HeroRestorePoint(String name, int lifePoints, String magic) {
		super();
		this.name = name;
		this.lifePoints = lifePoints;
		this.magic = magic;
		this.timestamp = new Date(); //crt date
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMagic() {
		return magic;
	}
	
	
	//DONT PROVIDE THE METHODS
	
	
	
	
}
