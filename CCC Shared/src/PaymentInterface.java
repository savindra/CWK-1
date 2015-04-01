import java.util.Date;


public interface PaymentInterface {
	
	public String getCardType();
	public void setCardType(String cardType);
	public String getCardNo();
	public void setCardNo(String cardNo);
	public Date getExpDate();
	public void setExpDate(Date expDate);
	public String getPaymentPlan();
	public void setPaymentPlan(String paymentPlan);
	
	public PaymentInterface newPayment();
	
	public int savetoDB(String clientID);

}
