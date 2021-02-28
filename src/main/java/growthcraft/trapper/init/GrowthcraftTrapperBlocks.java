package growthcraft.trapper.init;

import growthcraft.trapper.common.block.*;
import growthcraft.trapper.shared.Reference;
import growthcraft.trapper.shared.UnlocalizedName;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class GrowthcraftTrapperBlocks {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Reference.MODID);

    public static final RegistryObject<BlockOakFishtrap> FISHTRAP_OAK = BLOCKS.register(
            UnlocalizedName.FISHTRAP_OAK,
            BlockOakFishtrap::new
    );
    public static final RegistryObject<BlockAcaciaFishtrap> FISHTRAP_ACACIA = BLOCKS.register(
            UnlocalizedName.FISHTRAP_ACACIA,
            BlockAcaciaFishtrap::new
    );
    public static final RegistryObject<BlockDarkOakFishtrap> FISHTRAP_DARKOAK = BLOCKS.register(
            UnlocalizedName.FISHTRAP_DARK_OAK,
            BlockDarkOakFishtrap::new
    );
    public static final RegistryObject<BlockBirchFishtrap> FISHTRAP_BIRCH = BLOCKS.register(
            UnlocalizedName.FISHTRAP_BIRCH,
            BlockBirchFishtrap::new
    );
    public static final RegistryObject<BlockJungleFishtrap> FISHTRAP_JUNGLE = BLOCKS.register(
            UnlocalizedName.FISHTRAP_JUNGLE,
            BlockJungleFishtrap::new
    );
    public static final RegistryObject<BlockSpruceFishtrap> FISHTRAP_SPRUCE = BLOCKS.register(
            UnlocalizedName.FISHTRAP_SPRUCE,
            BlockSpruceFishtrap::new
    );

    private GrowthcraftTrapperBlocks() { /* Prevent default public constructor */ }

    public static void registerBlockItems(IForgeRegistry<Item> itemRegistry, Item.Properties properties) {
        BLOCKS.getEntries().stream()
                .map(RegistryObject::get).forEach(block -> {
            final BlockItem blockItem = new BlockItem(block, properties);
            if (block.getRegistryName() != null) {
                blockItem.setRegistryName(block.getRegistryName());
                itemRegistry.register(blockItem);
            }
        });
    }

}
