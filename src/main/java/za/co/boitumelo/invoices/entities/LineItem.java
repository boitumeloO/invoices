package za.co.boitumelo.invoices.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "lineItem")
public class LineItem implements Serializable{
	
	private static final long serialVersionUID = -6363361855163717931L;
	private long id; 
	private String description;
	private long quantity;
	private BigDecimal unitPrice;
	private Invoice invoice;
	
	public LineItem() {
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LineItem_seq")
    @SequenceGenerator(name = "LineItem_seq", sequenceName = "LineItem_seq",allocationSize=1)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "quantity")
	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	@Column(name = "unitPrice")
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	@Transient
	public BigDecimal getLineItemTotal() {
		BigDecimal total = new BigDecimal(0.0);
		try {
		total = getUnitPrice().multiply(new BigDecimal(getQuantity()));
		}catch(Exception e){
			e.printStackTrace();
		}
		return total;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "invoice_id")
	public Invoice getInvoice() {
		return invoice;
	}

	public LineItem(String description, long quantity, BigDecimal unitPrice) {
		super();
		this.description = description;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}
