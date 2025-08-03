package pixelclient;

import net.minecraft.client.Minecraft;
import pixelclient.event.EventManager;
import pixelclient.event.EventTarget;
import pixelclient.event.impl.ClientTickEvent;
import pixelclient.gui.SplashProgress;
import pixelclient.gui.ModAyarları.GuiModSettingsMain;
import pixelclient.gui.hud.HUDManager;
import pixelclient.mods.ModInstances;

public class Client {
	public static boolean KozmetikHareketliPelerin = CosmeticToggle.loadEnabledFromFile("KozmetikHareketliPelerin");
	private static final Client INSTANCE = new Client();
	public static final Client getInstance() { 
		return INSTANCE;	 
	}
	
	private DiscordRP discordRP = new DiscordRP();
	
	private HUDManager hudManager;
	
	public void init() {
		FileManager.init();
		SplashProgress.setProgress(1, "Client - Discord RP y�kleniyor!");
		discordRP.start();
		EventManager.register(this);
	}
	
	public void start() {
	hudManager = HUDManager.getInstance();
	ModInstances.register(hudManager);
	}
	
	public void shutdown() {
		discordRP.shutdown();
	}
	
	public DiscordRP getDiscordRP() {
		return discordRP;
	}

	@EventTarget
	public void onTick(ClientTickEvent e) {
		if(Minecraft.getMinecraft().gameSettings.PIXELCLIENT_GUI_MOD_AYAR.isPressed()) {
            Minecraft.getMinecraft().displayGuiScreen(new GuiModSettingsMain());
        }
	}
	
}
