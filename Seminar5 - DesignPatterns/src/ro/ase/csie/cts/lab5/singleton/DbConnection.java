package ro.ase.csie.cts.lab5.singleton;

public class DbConnection {
	String socket;
	String schema;

	// version 1 - eager approach; dont want for anyone to ask for it,create when
	// its loaded
//	private static DbConnection dbConnection = new DbConnection();

	// version 2 - lazy approach; wait for everyone to ask for it
	private static DbConnection dbConnection = null;

	// static class constructor
	// class static initializer
	// uses the class lazy-loading approach - the class will be loaded only when we
	// need it
	static {
		// executed only once, when the class is loaded by the JVM
		System.out.println("Loading database connection string");

	}

	// constructor initializer
	{
		// executed before each constructor call
		System.out.println("Init connection string");
	}

	private DbConnection() {
		System.out.println("Creating a DB connection");

		// access a local settings file to get credentials and conn string

	}

	private DbConnection(String socket, String schema) {
		this.socket = socket;
		this.schema = schema;
	}

	// the method used to return the reference to the unique object
	// is using default/app settings values
	public static DbConnection getDbConnection() {
		if (DbConnection.dbConnection == null) {
			// you can get details from files, etc
			dbConnection = new DbConnection();
		}

		return DbConnection.dbConnection;
	}

	public static DbConnection getDbConnection(String socket, String schema) {
		if (DbConnection.dbConnection == null) {
			dbConnection = new DbConnection(socket, schema);
		}
		// optional - throw an error if they try to open a connection to a different db
		if(!socket.equals(dbConnection.socket) || 
				!schema.equals(dbConnection.schema)) {
			throw new UnsupportedOperationException("You already have an opened connection to a different DB");
		}
			
		return DbConnection.dbConnection;

	}

}
