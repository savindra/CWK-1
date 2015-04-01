public interface DatabaseTableInterface {
	
	public Class getColumnClass( int columnIndex) throws IllegalStateException;
	
	public String getColumnName( int cloumnIndex ) throws IllegalStateException;
	
	public int getRowCount();

	public int getColumnCount();

	public Object getValueAt(int rowIndex, int columnIndex) ;
	public void allClients();
	

}
