package tfar.harvestcrafttweaker;

import com.pam.harvestcraft.item.GrinderRecipes;
import com.pam.harvestcraft.item.PresserRecipes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

public class ReflectionHacks {

	//PresserRecipes
	public static final Method registerPressingRecipe;
	public static final Field pressingList;

	//GrinderRecipes
	public static final Method registerGrindingRecipe;
	public static final Field grindingList;

	static {
		try {
			registerPressingRecipe = PresserRecipes.class.getDeclaredMethod("makeItemStackRecipe", ItemStack.class, ItemStack.class, ItemStack.class);
			registerPressingRecipe.setAccessible(true);

			pressingList = PresserRecipes.class.getDeclaredField("pressingList");
			pressingList.setAccessible(true);

			registerGrindingRecipe = GrinderRecipes.class.getDeclaredMethod("makeItemStackRecipe", ItemStack.class, ItemStack.class, ItemStack.class);
			registerGrindingRecipe.setAccessible(true);

			grindingList = GrinderRecipes.class.getDeclaredField("grindingList");
			grindingList.setAccessible(true);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void makePressingRecipe(ItemStack input, ItemStack leftOutput,ItemStack rightOutput) {
		try {
			registerPressingRecipe.invoke(null,input,leftOutput,rightOutput);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}


	public static void removePressingRecipeByInput(ItemStack input) {
		try {
			Map<ItemStack,ItemStack[]> map = (Map<ItemStack, ItemStack[]>) pressingList.get(null);
			for (Iterator<Map.Entry<ItemStack, ItemStack[]>> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
				Map.Entry<ItemStack, ItemStack[]> entry = iterator.next();
				ItemStack stack = entry.getKey();
				if (ItemStack.areItemsEqual(input, stack))
					iterator.remove();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void clearAllPressingRecipes() {
		try {
			Map<ItemStack,ItemStack[]> map = (Map<ItemStack, ItemStack[]>) pressingList.get(null);
			map.clear();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//====================================================================================================

	public static void makeGrindingRecipe(ItemStack input, ItemStack leftOutput, ItemStack rightOutput) {
		try {
			registerGrindingRecipe.invoke(null,input,leftOutput,rightOutput);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	public static void removeGrindingRecipeByInput(ItemStack input) {
		try {
			Map<ItemStack,ItemStack[]> map = (Map<ItemStack, ItemStack[]>) grindingList.get(null);
			for (Iterator<Map.Entry<ItemStack, ItemStack[]>> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
				Map.Entry<ItemStack, ItemStack[]> entry = iterator.next();
				ItemStack stack = entry.getKey();
				if (ItemStack.areItemsEqual(input, stack))
					iterator.remove();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void clearAllGrindingRecipes() {
		try {
			Map<ItemStack,ItemStack[]> map = (Map<ItemStack, ItemStack[]>) grindingList.get(null);
			map.clear();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
