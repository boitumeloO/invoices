package za.co.boitumelo.invoices.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {
	private static final long serialVersionUID = 2576630516563432964L;
	private long id; 
	private String client;
	private long vatRate;
	private Date invoiceDate;
	private List<LineItem> lineItems = new ArrayList<LineItem>(0);
	
	public Invoice() {
	}
	
	
	public Invoice(String client, long vatRate, Date invoiceDate, List<LineItem> lineItems) {
		super();
		this.client = client;
		this.vatRate = vatRate;
		this.invoiceDate = invoiceDate;
		this.lineItems = lineItems;
	}


	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_seq")
    @SequenceGenerator(name = "invoice_seq", sequenceName = "invoice_seq", allocationSize=1)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "client")
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	@Column(name = "vat_rate")
	public long getVatRate() {
		return vatRate;
	}
	public void setVatRate(long vatRate) {
		this.vatRate = vatRate;
	}
	@Column(name = "invoice_date")
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "invoice",cascade=CascadeType.ALL)
	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	@Transient
	private BigDecimal getTotal() {
		BigDecimal total = new BigDecimal(0);
		total.setScale(2);
		for(LineItem item:getLineItems()) {
			total.add(item.getLineItemTotal());
		}
		return total; 
	}
}
