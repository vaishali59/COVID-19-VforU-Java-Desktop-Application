package vForU;

import application.HomeUI;
import application.Mediator;
import application.MediatorInterface;
import application.UI;

public class VforU {
	public void runApplication() {

		MediatorInterface m = new Mediator();
		UI page = new HomeUI(m);
		page.display();
		
	}
}
