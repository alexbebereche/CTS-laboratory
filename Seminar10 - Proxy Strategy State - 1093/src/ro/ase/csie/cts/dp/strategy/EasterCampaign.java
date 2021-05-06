package ro.ase.csie.cts.dp.strategy;

public class EasterCampaign implements BonusStrategyInterface{

	@Override
	public void getBonusPoints(int points, Player player) {
		if(player.playTime > 5) {
			player.experiencePoints += (2 * points);
		}
	}

	//if played more than x hours, double the points
}
