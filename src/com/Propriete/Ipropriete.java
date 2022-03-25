package com.Propriete;

import java.util.List;

import com.Session.Proprietes;

public interface Ipropriete {

	 void savePropriete(Proprietes student);

	 void updateP(Proprietes student);

	 Proprietes getPById(int id);

	 List<Proprietes> getP();

	 void deleteP(int id);
}
