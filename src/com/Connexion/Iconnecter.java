package com.Connexion;

import java.util.List;

import com.Session.Admin;

public interface Iconnecter {

	 void saveAdmin(Admin student);

	 void updateAd(Admin student);

	 Admin getAdById(int id);

	 List<Admin> getAllAdmin();

	 void deleteAd(int id);
}
