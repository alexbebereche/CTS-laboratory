package ro.ase.csie.cts.lab5.singleton.registry;

import java.util.HashMap;

public class DbConnection {
	String socket;
	String schema;

	private static HashMap<String, DbConnection> connections = new HashMap<String, DbConnection>();

	private DbConnection(String socket, String schema) {
		this.socket = socket;
		this.schema = schema;
	}

	public static DbConnection getConnection(String socket, String schema) {
		//we use the socket as the key
		DbConnection connection = connections.get(socket);
		
		if(connection == null) {
			connection = new DbConnection(socket, schema);
			connections.put(socket, connection); // daca nu exista, il pun in hashmap
		}
		
		return connection;
	}
}
