package pixelclient.event.impl;

import pixelclient.event.Event;
import net.minecraft.world.World;	

public class WorldUnloadEvent extends Event {
	
	private final World world;
	
	public WorldUnloadEvent(World world) {
		this.world = world;
	}
	
	public World getworld() {
		return world;	
	}
	
}
