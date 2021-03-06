
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;

public class DatabaseTable extends AbstractTableModel {

	final String DATABASE_URL = "jdbc:mysql://localhost:3306/ccc";
	final String dbuser = "root";
	final String dbpass = "";
	private Connection conn = null;
	private Statement statement = null;
	private ResultSet resultset;
	private ResultSetMetaData metaData;
	private int noOfRows;
	
	
	public DatabaseTable() throws SQLException
	{
		
		conn = DriverManager.getConnection(DATABASE_URL,dbuser,dbpass);
			
		statement = conn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.TYPE_SCROLL_SENSITIVE );
		
	}
	
	public Class getColumnClass( int columnIndex) throws IllegalStateException
	{
		return (getValueAt(0, columnIndex).getClass());
	}
	
	public String getColumnName( int cloumnIndex ) throws IllegalStateException
	{
		try
		{
			return metaData.getColumnName(cloumnIndex + 1 ); 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "";
	}
	
	
	public int getRowCount() 
	{
		return noOfRows;
	}

	public int getColumnCount() 
	{
		
		try
		{
			return metaData.getColumnCount();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}

	public Object getValueAt(int rowIndex, int columnIndex) 
	{
		try
		{
			resultset.absolute(rowIndex + 1);
			return resultset.getObject(columnIndex + 1 );
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return "";
	}
	
	public boolean isCellEditable(int row, int column) {
	    return (column == 1);
	  }
	
	public void allClients() {
		try
		{
			resultset = statement.executeQuery("SELECT * from customer");
		
			metaData = resultset.getMetaData();
		
			resultset.last();
			noOfRows = resultset.getRow();
		
			fireTableStructureChanged();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
