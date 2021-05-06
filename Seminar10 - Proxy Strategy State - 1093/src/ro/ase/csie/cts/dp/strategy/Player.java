package ro.ase.csie.cts.dp.strategy;

public class Player {
	
	String userName;
	int playTime;
	int experiencePoints;
	
	//lets say for holiday, (want to get all ur available time) will get extra points

	BonusStrategyInterface bonusCampaign = null;
	
	public void setBonusCampaign(BonusStrategyInterface bonusCampaign) {
		this.bonusCampaign = bonusCampaign;
	}
	
	public Player(String userName, int playTime, int experiencePoints) {
		super();
		this.userName = userName;
		this.playTime = playTime;
		this.experiencePoints = experiencePoints;
	}
	
//	public void getExperiencePoints(int pointsReceived) {
//		this.experiencePoints += pointsReceived; //later, delete this and grant double points, for a holiday
//		
//	}

	public void getExperiencePoints(int pointsReceived) {
		if(this.bonusCampaign != null) {
			this.bonusCampaign.getBonusPoints(pointsReceived, this); // also pass the ref to the player itself
		}
	}

	
	
	
}
