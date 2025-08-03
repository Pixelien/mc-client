package pixelclient.cosmetics;

import net.minecraft.client.entity.AbstractClientPlayer;

public class CosmeticController {
	
	public static boolean shouldRenderTopHat(AbstractClientPlayer player) {
		return true;
	}
	
	public static float[] getTopHatColor(AbstractClientPlayer player) {
		return new float[] {1, 0, 1};
	}

	public static boolean shouldRenderWings(AbstractClientPlayer player) {
		return true;
	}
	
	public static float[] getWingsColor(AbstractClientPlayer player) {
		return new float[] {255, 255, 255};
	}
	
	public static boolean shouldRenderEyes(AbstractClientPlayer player) {
		return true;
	}

}
