import java.util.Date;
public interface SampleInterface {
	
	public String getSampleID();
	public void setSampleID(String sampleID);
	public Date getStorageDate();
	public void setStorageDate(Date storageDate);
	public Date getEndDate();
	public void setEndDate(Date endDate);
	public String getStatus();
	public void setStatus(String status);
	public String getCertifiedBy();
	public void setCertifiedBy(String certifiedBy);
	
	public SampleInterface newSample();
	
	public int updateSampleID(String sampleIDOld);

}
