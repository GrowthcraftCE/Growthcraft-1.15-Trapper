package growthcraft.trapper.init;

import growthcraft.trapper.lib.common.tileentity.TileEntityFishtrap;
import growthcraft.trapper.shared.Reference;
import growthcraft.trapper.shared.UnlocalizedName;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GrowthcraftTrapperTileEntities {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Reference.MODID);

    public static RegistryObject<TileEntityType<TileEntityFishtrap>> oakFishtrapTileEntity = null;
    public static RegistryObject<TileEntityType<TileEntityFishtrap>> acaciaFishtrapTileEntity = null;
    public static RegistryObject<TileEntityType<TileEntityFishtrap>> jungleFishtrapTileEntity = null;
    public static RegistryObject<TileEntityType<TileEntityFishtrap>> spruceFishtrapTileEntity = null;
    public static RegistryObject<TileEntityType<TileEntityFishtrap>> darkOakFishtrapTileEntity = null;
    public static RegistryObject<TileEntityType<TileEntityFishtrap>> birchFishtrapTileEntity = null;

    static {
        oakFishtrapTileEntity = TILE_ENTITIES.register(
                UnlocalizedName.FISHTRAP_OAK,
                () -> TileEntityType.Builder.create(
                        () -> new TileEntityFishtrap(oakFishtrapTileEntity.get()), GrowthcraftTrapperBlocks.FISHTRAP_OAK.get()
                ).build(null)
        );
        acaciaFishtrapTileEntity = TILE_ENTITIES.register(
                UnlocalizedName.FISHTRAP_ACACIA,
                () -> TileEntityType.Builder.create(
                        () -> new TileEntityFishtrap(acaciaFishtrapTileEntity.get()), GrowthcraftTrapperBlocks.FISHTRAP_ACACIA.get()
                ).build(null)
        );
        jungleFishtrapTileEntity = TILE_ENTITIES.register(
                UnlocalizedName.FISHTRAP_JUNGLE,
                () -> TileEntityType.Builder.create(
                        () -> new TileEntityFishtrap(jungleFishtrapTileEntity.get()), GrowthcraftTrapperBlocks.FISHTRAP_JUNGLE.get()
                ).build(null)
        );
        spruceFishtrapTileEntity = TILE_ENTITIES.register(
                UnlocalizedName.FISHTRAP_SPRUCE,
                () -> TileEntityType.Builder.create(
                        () -> new TileEntityFishtrap(spruceFishtrapTileEntity.get()), GrowthcraftTrapperBlocks.FISHTRAP_SPRUCE.get()
                ).build(null)
        );
        darkOakFishtrapTileEntity = TILE_ENTITIES.register(
                UnlocalizedName.FISHTRAP_DARK_OAK,
                () -> TileEntityType.Builder.create(
                        () -> new TileEntityFishtrap(darkOakFishtrapTileEntity.get()), GrowthcraftTrapperBlocks.FISHTRAP_DARKOAK.get()
                ).build(null)
        );
        birchFishtrapTileEntity = TILE_ENTITIES.register(
                UnlocalizedName.FISHTRAP_BIRCH,
                () -> TileEntityType.Builder.create(
                        () -> new TileEntityFishtrap(birchFishtrapTileEntity.get()), GrowthcraftTrapperBlocks.FISHTRAP_BIRCH.get()
                ).build(null)
        );
    }

    private GrowthcraftTrapperTileEntities() { /* Disable Default Public Constructor */ }

}
