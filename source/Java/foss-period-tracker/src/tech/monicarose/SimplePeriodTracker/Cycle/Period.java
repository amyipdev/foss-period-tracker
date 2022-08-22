package tech.monicarose.SimplePeriodTracker.Cycle;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import tech.monicarose.SimplePeriodTracker.Cycle.*;
import tech.monicarose.SimplePeriodTracker.SexualActivity.*;

public class Period extends GregorianCalendar {
	private Date _start;
	private Calendar _current = Calendar.getInstance();
	private Period _next;
	private int _offset;
	private int _length;
	private int _range;
	private boolean _regular = true;
	
	public Period() {
		_start = null;
		_next = null;
		_length = 0;
		_offset = 0;
		_range = 0;
		_regular = true;
		_current = Calendar.getInstance();
		_current.setLenient(true);
	}
	
	// Sets the number of days in between cycles
	public void setOffset(int diff) {
		_offset = diff;
	}
	
	// Starts the current cycle now
	public void startNow() {
		_start = _current.getTime(); 
	}
	
	// Sets the date of the next cycle
	// Requires an integer in days
	// TODO: Throw an error if _offset is an illogical time (<= 0)
	public void setPeriod(Date day) {
		_start = day;
	}
	
	public void setPeriod() {
		_current.add(DATE, _offset);
		_start = _current.getTime();
	}
	
	public void setNextPeriod(Date nextDay) {
		_next.setPeriod(nextDay);
	}
	
	// Sets if a cycle is regular or not.
	// Requires a boolean
	public void setRegularity(boolean regularity) {
		_regular = regularity;
	}
	
	// Sets the length of a cycle
	// Requires an integer
	// TODO: Add a check for an unrealistic time (<= 0)
	public void setLength(int len) {
		_length = len;
	}
	
	// Reminder for the user for when a cycle is supposed to start
	// Requires an integer for number of days
	// TODO: Add a check for an unrealistic time (<= 0)
	public void setAlarmRange(int days) {
		if (days < 0) {
			throw new IndexOutOfBoundsException("The number that you entered is "
					+ "not permitted. Please input a number greater than or equal "
					+ "to 0");
		}
		_range = days;
	}
	
	// Returns the Date of the next cycle
	public String cycleStart() {
		return _start.toString();
	}
	
	// Returns the boolean representation of if the cycle is regular.
	public boolean isRegular() {
		return _regular;
	}
	
	// Returns a boolean representation of if a cycle has started
	public boolean hasStarted() {
		return _current.equals(_start) || _current.after(_start);
	}
}
