package com.pahimar.ee3.client.gui.inventory;

import com.pahimar.ee3.inventory.ContainerAlchemicalChestSmall;
import com.pahimar.ee3.lib.Strings;
import com.pahimar.ee3.lib.Textures;
import com.pahimar.ee3.tileentity.TileAlchemicalChest;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

/**
 * Created by pahimar on 04/01/14.
 */
@SideOnly(Side.CLIENT)
public class GuiAlchemicalChestSmall extends GuiContainer
{
    private TileAlchemicalChest tileAlchemicalChest;

    public GuiAlchemicalChestSmall(InventoryPlayer inventoryPlayer, TileAlchemicalChest alchemicalChest)
    {
        super(new ContainerAlchemicalChestSmall(inventoryPlayer, alchemicalChest));
        tileAlchemicalChest = alchemicalChest;
        xSize = 230;
        ySize = 186;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        fontRenderer.drawString(tileAlchemicalChest.isInvNameLocalized() ? tileAlchemicalChest.getInvName() : StatCollector.translateToLocal(tileAlchemicalChest.getInvName()), 8, 6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal(Strings.CONTAINER_INVENTORY), 45, ySize - 89 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(Textures.GUI_ALCHEMICAL_STORAGE_SMALL);
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }
}
