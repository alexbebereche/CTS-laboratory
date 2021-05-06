package ro.ase.csie.cts.dp.strategy;

public class NoCampaign implements BonusStrategyInterface{

	@Override
	public void getBonusPoints(int points, Player player) {
		player.experiencePoints += points;
	}

}
