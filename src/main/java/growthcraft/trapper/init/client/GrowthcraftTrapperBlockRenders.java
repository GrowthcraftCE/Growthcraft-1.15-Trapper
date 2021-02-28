package growthcraft.trapper.init.client;

import growthcraft.trapper.init.GrowthcraftTrapperBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class GrowthcraftTrapperBlockRenders {

    private GrowthcraftTrapperBlockRenders() { /* Disable default public constructor */ }

    public static void setRenderLayers() {
        RenderTypeLookup.setRenderLayer(GrowthcraftTrapperBlocks.FISHTRAP_OAK.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GrowthcraftTrapperBlocks.FISHTRAP_ACACIA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GrowthcraftTrapperBlocks.FISHTRAP_DARKOAK.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GrowthcraftTrapperBlocks.FISHTRAP_SPRUCE.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GrowthcraftTrapperBlocks.FISHTRAP_JUNGLE.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GrowthcraftTrapperBlocks.FISHTRAP_BIRCH.get(), RenderType.getCutout());
    }

}
