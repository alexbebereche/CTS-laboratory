package ro.ase.csie.cts.dp.strategy;

public class TestStrategy {

	public static void main(String[] args) {
		
		Player player = new Player("John", 10, 100);
		
		player.setBonusCampaign(new NoCampaign());
		player.getExperiencePoints(150); 
		
		System.out.println("points: " + player.experiencePoints); // 100 + 150 = 250
		
		player.setBonusCampaign(new EasterCampaign());
		player.getExperiencePoints(150); 
		
		System.out.println("points: " + player.experiencePoints); // 250 + 150 * 2

		
		player.setBonusCampaign(new SummerCampaign());
		player.getExperiencePoints(150);
		
		System.out.println("points: " + player.experiencePoints);

		//set is mandatory!
	}

}
