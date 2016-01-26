package modele.requete;

import java.sql.Connection;

public class Requete {

	public Connection conn;
	public Utilitaires util;
	
	public Requete (Connection connection){
		this.conn = connection;
		this.util = new Utilitaires();
	}
}
