CREATE TRIGGER promo AFTER insert ON commande for each row
DECLARE
id Integer;
montant float;
BEGIN
	IF NEW.prixTotal >= 100 THEN
		select max(idPromo) into id from promo;
		id = id + 1;
		montant = NEW.prixTotal * 0,05;
		insert into promo values (id, NEW.mailClient, montant);
	END IF;
END