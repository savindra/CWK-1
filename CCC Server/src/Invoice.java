import java.util.Date;

import de.root1.simon.annotation.SimonRemote;

@SimonRemote(value = {InvoiceInterface.class})
public class Invoice implements InvoiceInterface {
	
	private int invoiceID;
	private Date inovoiceDate;
	private Date dueDate;
	private double total;
	private String status;
	
	public int getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}
	public Date getInovoiceDate() {
		return inovoiceDate;
	}
	public void setInovoiceDate(Date inovoiceDate) {
		this.inovoiceDate = inovoiceDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public InvoiceInterface newInvoice(){
		return new Invoice();
	}
	
	public int savetoDB(String clientID, String sampleID){
		Database d = new Database();
		return d.insertInvoice(clientID, this, sampleID);
		
	}

}
