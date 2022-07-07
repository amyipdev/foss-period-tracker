package tech.monicarose.foss_period_tracker.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CurrentPeriod extends GregorianCalendar {
	private Date _start;
	private int _offset;
	private Calendar _current = Calendar.getInstance();
	private Calendar _next = _current;
	
	public CurrentPeriod() {
		_start = null;
		_offset = 0;
		_current = Calendar.getInstance();
		_next = _current;
		
		_current.setLenient(true);
		_next.setLenient(true);
		
		_next.add(Calendar.DAY_OF_MONTH, _offset);
	}
	
	public void SetOffset(int diff) {
		_offset = diff;
	}
	
	public void StartNow() {
		_start = _current.getTime(); 
	}
	
	public void SetNext() {
		SetNext(_offset);
	}
	
	public void SetNext(int offset) {
		_next.set(Calendar.DAY_OF_MONTH, offset);
	}
	
	public Date NextCycle() {
		return _start;
	}
}
