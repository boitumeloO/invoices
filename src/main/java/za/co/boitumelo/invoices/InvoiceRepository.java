package za.co.boitumelo.invoices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.boitumelo.invoices.entities.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

}
