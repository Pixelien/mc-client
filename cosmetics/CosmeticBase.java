package pixelclient.cosmetics;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;

public abstract class CosmeticBase implements LayerRenderer<AbstractClientPlayer> {
	
	protected final RenderPlayer playerRenderer;
	
	public CosmeticBase(RenderPlayer playerRenderer) {
		this.playerRenderer = playerRenderer;
	}

	@Override
	public void doRenderLayer(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		
		if(player.hasPlayerInfo() && !player.isInvisible()) {
			render(player, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
		}
	}
	
	public abstract void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale);

	@Override
	public boolean shouldCombineTextures() {
		// TODO Auto-generated method stub
		return false;
	}

	private static float Sigmoid(double value) {
        return 1.0F / (1.0F + (float) Math.exp(-value));
    }


 protected float getWingAngle(boolean isFlying, float maxAngle, int totalTime, int flyingTime, int offset) {
        float angle = 0.0F;
        int flapTime = totalTime;

        if (isFlying) {
            flapTime = flyingTime;
        }

        float deltaTime = this.getAnimationTime(flapTime, offset);

        if (deltaTime <= 0.5F) {
            angle = Sigmoid((double) (-4.0F + deltaTime * 2.0F * 8.0F));
        } else {
            angle = 1.0F - Sigmoid((double) (-4.0F + (deltaTime * 2.0F - 1.0F) * 8.0F));
        }

        angle *= maxAngle;
        return angle;
    }

 protected void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

 private float getAnimationTime(int totalTime, int offset) {
        float time = (float) ((System.currentTimeMillis() + (long) offset) % (long) totalTime);

        return time / (float) totalTime;
    }
}
