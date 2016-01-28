CREATE TRIGGER promo BEFORE update ON client for each row
DECLARE
BEGIN
	IF NEW.desactivate == 1 THEN
		update FichierImage set partage = 0 where client = OLD.mail;
	END IF;
END ;
/