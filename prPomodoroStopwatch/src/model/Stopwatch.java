package model;

import java.time.LocalDateTime;

import javax.swing.JTextField;

public class Stopwatch {

	private byte[] timePassed;
	private long startTime;
	
	public Stopwatch() {
		timePassed = new byte[3];
		startTime = LocalDateTime.now().toEpochSecond(null);
	}
	
	private void updateValues() {
		
	}
	
	public void updateField(JTextField tf) {
		updateValues();
		tf.setText(getHours()+":"+getMinutes()+":"+getSeconds());
	}
}
