package Client;

import java.util.TimerTask;

import DAO.DAOController;

public class TimerSchedulePeriod extends TimerTask{

	@Override
	public void run() {
		DAOController d = new DAOController();
		d.run();
		
	}

}
