package pixelclient.mods.impl;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import pixelclient.gui.hud.ScreenPosition;
import pixelclient.mods.ModDraggable;

public class ModMiniPlayer extends ModDraggable {

    public String modeCrouch = "up";
    public String modeAppear = "crouchSprint";
    public int stabilisation;
    public String visible;

    public ModMiniPlayer() {
    }

    @Override
    public int getWidth() {
        return 40;
    }

    @Override
    public int getHeight() {
        return 80;
    }

    @Override
    public void render(ScreenPosition pos) {
        if(isEnabled()) {
        if (modeCrouch == "none") {
            stabilisation = 0;
        }

        if (modeCrouch == "down") {
            stabilisation = 0;
        }

        if (modeCrouch == "up") {
            stabilisation = -2;
        }

        if (modeAppear == "always") {
            visible = "true";
        }

        if (modeAppear == "crouch") {
            if (mc.thePlayer.isSneaking()) {
                visible = "true";
            } else {
                visible = "true";
            }
        }

        if (modeAppear == "sprint") {
            if (mc.thePlayer.isSprinting()) {
                visible = "true";
            } else {
                visible = "true";
            }
        }

        if (modeAppear == "crouchSprint") {
            if (mc.thePlayer.isSprinting() || mc.thePlayer.isSneaking()) {
                visible = "true";
            } else {
                visible = "true";
            }
        }

        if(visible == "true") {
            if (!mc.thePlayer.isSneaking()) {
                GuiInventory.drawEntityOnScreen(pos.getAbsoluteX() + 20, (pos.getAbsoluteY() + 80), 30, -27f, 1.8f, Minecraft.getMinecraft().thePlayer);
            } else {
                GuiInventory.drawEntityOnScreen(pos.getAbsoluteX() + 20, (pos.getAbsoluteY() + 80) + stabilisation, 30, -27f, 1.8f, Minecraft.getMinecraft().thePlayer);
            }
        }
}

    }


}