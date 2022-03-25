package com.Menu;

import java.awt.Menu;
import java.util.List;


public interface Imenu {

	 void saveMenu(Menu student);

	 void updateMe(Menu student);

	Menu getAdByMe(int id);

	 List<Menu> getAllMenu();

	 void deleteAd(int id);
}
