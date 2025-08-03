package pixelclient.event;

import java.lang.reflect.Method;

public class EventData{

	public final Object source;
	public final Method target;
	public final byte Priority;
	
	public EventData(Object source, Method target, byte priority) {
	this.source = source;
	this.target = target;
	this.Priority = priority;
	}
	
}
