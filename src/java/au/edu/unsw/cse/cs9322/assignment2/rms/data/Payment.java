package au.edu.unsw.cse.cs9322.assignment2.rms.data;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Payment {

    private String id;
    private String card;
    private float amount;
    private Date paid_date;

    public Payment() {

    }

    public Payment(String id, float fee) {
        this.id = id;
        this.amount = fee;
        this.paid_date = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String rid) {
        id = rid;
    }

    public String getCardNumber() {
        return card;
    }

    public void setCardNumber(String card_num) {
        card = card_num;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float fee) {
        amount = fee;
    }

    public Date getPaidDate() {
        return paid_date;
    }

    public void setPaidDate(Date d) {
        paid_date = d;
    }

    public boolean isPaid() {
        return paid_date != null;
    }
}
