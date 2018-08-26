insert into invoice(id,client,vat_rate, invoice_date) values (1,'client one',15,'2018-01-01');
insert into invoice(id,client,vat_rate, invoice_date) values (2,'client two',14,'2018-01-02');
insert into invoice(id,client,vat_rate, invoice_date) values (3,'client three',14,'2018-01-03');
insert into invoice(id,client,vat_rate, invoice_date) values (4,'resg four',14,'2018-01-04');
insert into invoice(id,client,vat_rate, invoice_date) values (5,'resg five',15,'2018-01-05');
insert into line_item(id,description,quantity, unit_price,invoice_id) values (1,'Kelloggs',15, 28, 1);
insert into line_item(id,description,quantity, unit_price,invoice_id) values (2,'oats',1, 48.323, 1);
insert into line_item(id,description,quantity, unit_price,invoice_id) values (3,'Kelloggs',5, 28, 2);
insert into line_item(id,description,quantity, unit_price,invoice_id) values (4,'oats',10, 48.323, 2);