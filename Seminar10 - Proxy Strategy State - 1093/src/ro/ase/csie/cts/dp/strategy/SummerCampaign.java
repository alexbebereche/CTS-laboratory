package ro.ase.csie.cts.dp.strategy;

public class SummerCampaign implements BonusStrategyInterface{

	@Override
	public void getBonusPoints(int points, Player player) {
		//during the summer, all the players get all the time xp *1.5
		player.experiencePoints += 1.5* points;
	}

	
}
