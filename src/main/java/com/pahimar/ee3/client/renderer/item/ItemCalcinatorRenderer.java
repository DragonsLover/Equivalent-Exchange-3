package com.pahimar.ee3.client.renderer.item;

import com.pahimar.ee3.client.model.ModelCalcinator;
import com.pahimar.ee3.lib.Textures;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Equivalent-Exchange-3
 * <p/>
 * ItemCalcinatorRenderer
 *
 * @author pahimar
 */
@SideOnly(Side.CLIENT)
public class ItemCalcinatorRenderer implements IItemRenderer
{
    private final ModelCalcinator modelCalcinator;

    public ItemCalcinatorRenderer()
    {
        modelCalcinator = new ModelCalcinator();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        switch (type)
        {
            case ENTITY:
            {
                renderCalcinator(-0.5F, 0.0F, 0.5F);
                return;
            }
            case EQUIPPED:
            {
                renderCalcinator(0.0F, 0.0F, 1.0F);
                return;
            }
            case EQUIPPED_FIRST_PERSON:
            {
                renderCalcinator(0.0F, 0.0F, 1.0F);
                return;
            }
            case INVENTORY:
            {
                renderCalcinator(0.0F, -0.1F, 1.0F);
                return;
            }
            default:
            {
            }
        }
    }

    private void renderCalcinator(float x, float y, float z)
    {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);

        // Scale, Translate, Rotate
        GL11.glScalef(1F, 1F, 1F);
        GL11.glTranslatef(x, y, z);
        GL11.glRotatef(-90F, 1F, 0, 0);

        // Bind texture
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.MODEL_CALCINATOR_IDLE);

        // Render
        modelCalcinator.renderPart("Calcinator");

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}
