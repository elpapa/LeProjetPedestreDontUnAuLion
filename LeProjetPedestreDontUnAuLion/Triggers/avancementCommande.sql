CREATE TRIGGER promo AFTER update ON commande for each row
DECLARE
BEGIN
	IF NEW.paye ==1 THEN
		update commande set statutCommande = "envoye" where refCommande = OLD.refCommande;
	END IF;
END ;
/