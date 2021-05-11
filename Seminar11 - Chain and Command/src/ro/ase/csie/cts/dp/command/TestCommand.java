package ro.ase.csie.cts.dp.command;

public class TestCommand {

	public static void main(String[] args) {
		
		TaskManager manager = new TaskManager();
		manager.addAsyncTask(new AsyncCommand("Autosave", new BackupModule())); //here, can combine with factory, singleton...(optional)
		manager.addAsyncTask(new AsyncCommand("Update 3d models", new UpdateModule()));
		
		System.out.println("Game is running");
		
		manager.execute(); //exec on a single thread while the game is running
		manager.execute(); //exec on a single thread while the game is running
		manager.execute(); //exec on a single thread while the game is running - no third asyncTask
		
		System.out.println("Game is running");
	}

}
