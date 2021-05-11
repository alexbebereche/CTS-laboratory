package ro.ase.csie.cts.dp.command;

import java.util.ArrayList;

public class TaskManager {

	// easiest to handle the commands is arraylist here
	ArrayList<AsyncTask> tasks = new ArrayList<AsyncTask>();

	public void addAsyncTask(AsyncTask task) {
		tasks.add(task);
	}

	// round robin
	// should execute on a different thread
	public void execute() {
		if (tasks.size() > 0) {
			// there would be multi threading usually...
			AsyncTask taskToExecute = tasks.get(0); // at least 1 task to not return null
			if (taskToExecute != null) {
				tasks.remove(0);
				taskToExecute.asnycExecute();
			}
		}

	}
}
