
import java.util.Date;

import de.root1.simon.annotation.SimonRemote;
@SimonRemote(value = {PaymentInterface.class})
public class Payment implements PaymentInterface {
	
	private String cardType;
	private String cardNo;
	private Date expDate;
	private String paymentPlan;
	
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public String getPaymentPlan() {
		return paymentPlan;
	}
	public void setPaymentPlan(String paymentPlan) {
		this.paymentPlan = paymentPlan;
	}
	
	public PaymentInterface newPayment(){
		return new Payment();
	}
	
	public int savetoDB(String clientID){
		Database d = new Database();
		return d.insertPayment(clientID, this);
	}

}