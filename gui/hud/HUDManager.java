package pixelclient.gui.hud;

import java.util.Collection;
import java.util.Set;

import com.google.common.collect.Sets;

import pixelclient.event.Event;
import pixelclient.event.EventManager;
import pixelclient.event.EventTarget;
import pixelclient.event.impl.RenderEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiContainer;

public class HUDManager {
	
	private HUDManager() {}
	
	private static HUDManager instance = null;
	
	public static HUDManager getInstance() {
		if(instance != null) {
			return instance;
		}
		
		instance = new HUDManager();
		EventManager.register(instance);
		
		return instance;
	}
	
	private Set<IRenderer> registeredRenders = Sets.newHashSet();
	private Minecraft mc = Minecraft.getMinecraft();
	
	public void register(IRenderer... renderers) {
		for(IRenderer render : renderers) {
			this.registeredRenders.add(render);
		}
	}
	
	public void unRegister(IRenderer... renderers) {
		for(IRenderer render : renderers) {
			this.registeredRenders.add(render);
		}
	}
	
	public Collection<IRenderer> getRegisteredRenderers() {
		return Sets.newHashSet(registeredRenders);
	}
	
	@EventTarget
	public void onRender(RenderEvent e) {
		if(mc.currentScreen == null || mc.currentScreen instanceof GuiContainer || mc.currentScreen instanceof GuiChat) {
			for(IRenderer renderer: registeredRenders) {
				callRenderer(renderer);
			}
		}
	}

	private void callRenderer(IRenderer renderer) {
		if(!renderer.isEnabled()) {
			return;
		}
		
		ScreenPosition pos = renderer.load();
		
		if(pos == null) {
			pos = ScreenPosition.fromRelativePosition(0.5, 0.5);
		}
		
		renderer.render(pos);
	}

	public void openConfigScreen() {
		mc.displayGuiScreen(new HUDConfigScreen(this));
	}
	
	

}
