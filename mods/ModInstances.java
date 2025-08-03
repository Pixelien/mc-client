package pixelclient.mods;

import pixelclient.gui.hud.HUDManager;
import pixelclient.gui.hud.IRenderer;
import pixelclient.mods.impl.ModArmorStatus;
import pixelclient.mods.impl.ModCPS;
import pixelclient.mods.impl.ModEsyaFizikleri;
import pixelclient.mods.impl.ModFPS;
import pixelclient.mods.impl.ModIksirStatus;
import pixelclient.mods.impl.ModKlavye;
import pixelclient.mods.impl.ModMiniPlayer;
import pixelclient.mods.impl.ModOklar;
import pixelclient.mods.impl.ModPing;
import pixelclient.mods.impl.ModXYZ;

public class ModInstances {
	
	private static ModFPS modFPS;
	private static ModPing modPing;
	private static ModArmorStatus modArmorStatus;
	private static ModIksirStatus modiksir;
	private static ModCPS modCPS;
	private static ModXYZ modXYZ;
	private static ModKlavye modKlavye;
	private static ModOklar modOklar;
	private static ModMiniPlayer modMiniPlayer;
	private static ModEsyaFizikleri modEsyaFizikleri;
	
	public static void register(HUDManager api) {
		
		modFPS = new ModFPS();
		api.register(modFPS);
		
		modPing = new ModPing();
	    api.register(modPing);
	    
		modArmorStatus = new ModArmorStatus();
	    api.register(modArmorStatus);
	    
		modiksir = new ModIksirStatus();
	    api.register(modiksir);
	    
		modCPS = new ModCPS();
	    api.register(modCPS);
	
		modXYZ = new ModXYZ();
	    api.register(modXYZ);
	    
	    modKlavye = new ModKlavye();
	    api.register(modKlavye);
	    
	    modOklar = new ModOklar();
	    api.register(modOklar);
	    
	    modMiniPlayer = new ModMiniPlayer();
	    api.register(modMiniPlayer);
	    
	    modEsyaFizikleri = new ModEsyaFizikleri();
	    api.register(modEsyaFizikleri);
	}

public static ModPing getModPing() {
	return modPing;
}
	
public static ModFPS getModFPS() {
	return modFPS;
}

public static ModArmorStatus getModArmorStatus() {
	return modArmorStatus;
}

public static ModIksirStatus getModiksir() {
	return modiksir;
}

public static ModCPS getModCPS() {
	return modCPS;
}

public static ModXYZ getModXYZ() {
	return modXYZ;
}

public static ModKlavye getModKlavye() {
	return modKlavye;
}
public static ModOklar getModOklar() {
	return modOklar;
}
public static ModMiniPlayer getModMiniPlayer() {
	return modMiniPlayer;
}
public static ModEsyaFizikleri getModEsyaFizikleri() {
	return modEsyaFizikleri;
}

}
