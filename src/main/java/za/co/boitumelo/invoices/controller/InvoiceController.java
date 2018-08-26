package za.co.boitumelo.invoices.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import za.co.boitumelo.invoices.InvoiceRepository;
import za.co.boitumelo.invoices.entities.Invoice;

@RestController
public class InvoiceController {

	@Autowired
	InvoiceRepository repository;

	
	private Logger log = LogManager.getLogger(this.getClass());

	
	public InvoiceController() {
		// TODO Auto-generated constructor stub
	}
	@PostMapping("/invoices")
	public Invoice addInvoice(@RequestBody Invoice invoice) {
		return save(invoice);
	}
	
	@GetMapping("/invoices/{invoiceId}")
	public Invoice viewInvoice(@PathVariable long invoiceId){
		return getInvoiceById(invoiceId);
	}
	@GetMapping("/invoices")
	public List<Invoice> viewAllInvoices(){
		return getAllInvoices();
	}
	
	

	private Invoice save(Invoice invoice) {
		try {
			log.info("Saving invoice");
			repository.save(invoice);
			log.info("saved invoice");
			return  invoice;
		}catch(Exception e) {
			log.error("*******************************Could not save invoice ********************************");
			e.printStackTrace();
		}
		return null;
	}
	
	private List<Invoice> getAllInvoices(){
		try {
			log.info("getting all invoices");
			return (List<Invoice>)repository.findAll();
		}catch(Exception e ) {
			log.error("*******************************Could not get all invoices ********************************");
			e.printStackTrace();
		}
		return null;
	}
	
	private Invoice getInvoiceById(long id) {
		try {
			log.info("geting invoice with id " + id);
			Invoice invoice = repository.findOne(id);
			return invoice;
		}catch(Exception e) {
			log.error("*******************************Could not get invoice ********************************");
			e.printStackTrace();
		}
		return null;
	}
}
