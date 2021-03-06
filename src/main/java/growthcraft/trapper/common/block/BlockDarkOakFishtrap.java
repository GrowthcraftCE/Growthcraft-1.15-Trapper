package growthcraft.trapper.common.block;

import growthcraft.trapper.init.GrowthcraftTrapperTileEntities;
import growthcraft.trapper.lib.common.block.FishtrapBlock;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

/**
 * e
 * Customized Fishtrap Block - Inherit everything except createTileEntity.
 */
public class BlockDarkOakFishtrap extends FishtrapBlock {

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return GrowthcraftTrapperTileEntities.darkOakFishtrapTileEntity.get().create();
    }

}
