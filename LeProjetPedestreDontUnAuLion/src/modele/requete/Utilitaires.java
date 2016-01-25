package modele.requete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utilitaires {

	/**
	 * Renvoie l'id max plus un d'une table
	 * @param conn
	 * @param table : !!! la première lettre doit être en majuscule !!!
	 * @return
	 * @throws SQLException
	 */
	public int getMaxIdPlusUn(Connection conn, String table) throws SQLException{
		int max = 0;
		
		PreparedStatement st = conn.prepareStatement("SELECT max(id) as maxid FROM id"+table);
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			max = rs.getInt("maxid") + 1;
		}
		
		return max;
	}
	
	/**
	 * transforme bool en int
	 * @param b
	 * @return
	 */
	public int getIntFromBoolean (boolean b){
		int r = 0;
		if(b) r = 1;
		return r;
	}
	
	/**
	 * transforme int en bool
	 * @param i
	 * @return
	 */
	public boolean getBooleanFromInt (int i){
		return (i==1);
	}
}
