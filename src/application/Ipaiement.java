package application;

import java.util.List;

import com.Session.Facture;

public interface Ipaiement {
	
	 void saveFacture(Facture student);

	 void updateFacture(Facture student);

	 Facture getFactureById(int id);

	 List<Facture> getAllFacture();

	 void deleteFacture(int id);
}
