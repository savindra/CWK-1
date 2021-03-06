import java.util.Date;


public interface InvoiceInterface {
	
	public int getInvoiceID();
	public void setInvoiceID(int invoiceID);
	public Date getInovoiceDate();
	public void setInovoiceDate(Date inovoiceDate);
	public Date getDueDate();
	public void setDueDate(Date dueDate);
	public double getTotal();
	public void setTotal(double total);
	public String getStatus();
	public void setStatus(String status);
	
	public int savetoDB(String clientID, String sampleID);
	public InvoiceInterface newInvoice();

}
