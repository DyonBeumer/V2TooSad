package Client.DAO;

import java.util.TimerTask;

public class TimerSchedulePeriod extends TimerTask{

	@Override
	public void run() {
		DAOController d = new DAOController();
		d.run();
		
	}

}
