package Client;

import java.util.*;

public class Main {
	public static void main(String[] args){
	TimerTask tt = new TimerSchedulePeriod();
	Timer timer = new Timer();
	timer.schedule(tt, 0, 10000);
	}
}