import java.util.Date;

import de.root1.simon.annotation.SimonRemote;

@SimonRemote(value = {SampleInterface.class})
public class Sample implements SampleInterface {
	
	private String sampleID;
	private Date storageDate;
	private Date endDate;
	private String status;
	private String certifiedBy;
	
	public String getSampleID() {
		return sampleID;
	}
	public void setSampleID(String sampleID) {
		this.sampleID = sampleID;
	}
	public Date getStorageDate() {
		return storageDate;
	}
	public void setStorageDate(Date storageDate) {
		this.storageDate = storageDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCertifiedBy() {
		return certifiedBy;
	}
	public void setCertifiedBy(String certifiedBy) {
		this.certifiedBy = certifiedBy;
	}
	
	public SampleInterface newSample(){
		return new Sample();
	}
	
	public int updateSampleID(String sampleIDOld){
		Database d = new Database();
		return d.updateSampleID(this, sampleIDOld);
	}
	

}
