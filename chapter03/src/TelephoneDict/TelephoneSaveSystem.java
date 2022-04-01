package TelephoneDict;

import TelephoneDict.Service.Service;
import TelephoneDict.Service.ServiceTest;
import TelephoneDict.controller.Controller;
import TelephoneDict.controller.ControllerTest;

public class TelephoneSaveSystem {
	
	public static void main(String[] args) {

		Service service = new ServiceTest();
		Controller pro = new ControllerTest(service);
		pro.runUser();

		}
	}
	


