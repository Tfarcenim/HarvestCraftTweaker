package tfar.harvestcrafttweaker.mixin;

import com.pam.harvestcraft.tileentities.TileEntityGroundTrap;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import tfar.harvestcrafttweaker.GroundTrapRecipes;

@Mixin(TileEntityGroundTrap.class)
public class TileEntityGroundTrapMixin {

	@Shadow @Final private ItemStackHandler itemstackhandler;

	/**
	 * @author Tfar
	 * @reason bad code, redirected to use a recipe system instead of hardcoded switch statements
	 */
	@Overwrite
	public ItemStack getComb(){
		return GroundTrapRecipes.getResult(itemstackhandler.getStackInSlot(18));
	}
}
