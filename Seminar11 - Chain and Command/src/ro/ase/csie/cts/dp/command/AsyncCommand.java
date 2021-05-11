package ro.ase.csie.cts.dp.command;

//concrete class
//wrapper class
public class AsyncCommand extends AsyncTask{

	String taskName;
	
	int priority; //maybe want to handle commands with higher priority
	
	//ref to the obj that will exec the task later
	GameModuleInterface module = null; //doesnt make any sense not to give it, so make a constructor
	
	
	
	public AsyncCommand(String taskName, GameModuleInterface module) { //need the reference that WE NEED, developers will forget
		super();
		this.taskName = taskName;
		this.module = module;
	}



	@Override
	public void asnycExecute() {
		this.module.doTask(taskName); //the fct itself that we execute
	}

}
