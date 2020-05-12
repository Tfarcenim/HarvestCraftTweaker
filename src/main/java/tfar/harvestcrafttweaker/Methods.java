package tfar.harvestcrafttweaker;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
@ZenRegister
@ZenClass("mods.harvestcrafttweaker.HarvestCraftTweaker")
public class Methods {

	//note: these recipes will initially load when being accessed by these methods

	@ZenMethod
	public static void clearAllPressing(){
		ReflectionHacks.clearAllPressingRecipes();
	}

	@ZenMethod
	public static void addPressing(IIngredient input, IItemStack leftOutput, IItemStack rightOutput) {
		for (IItemStack inputStack : input.getItems())
		ReflectionHacks.makePressingRecipe(CraftTweakerMC.getItemStack(inputStack), CraftTweakerMC.getItemStack(leftOutput),
						CraftTweakerMC.getItemStack(rightOutput));
	}

	@ZenMethod
	public static void addPressing(IItemStack input, IItemStack leftOutput, IItemStack rightOutput) {
		ReflectionHacks.makePressingRecipe(CraftTweakerMC.getItemStack(input), CraftTweakerMC.getItemStack(leftOutput),
						CraftTweakerMC.getItemStack(rightOutput));
	}

	@ZenMethod
	public static void removePressingByInput(IItemStack input) {
		ReflectionHacks.removePressingRecipeByInput(CraftTweakerMC.getItemStack(input));
	}

	//note: these recipes will initially load when being accessed by these methods

	@ZenMethod
	public static void clearAllGrinding(){
		ReflectionHacks.clearAllGrindingRecipes();
	}

	@ZenMethod
	public static void addGrinding(IIngredient input, IItemStack leftOutput, IItemStack rightOutput) {
		for (IItemStack inputStack : input.getItems())
			ReflectionHacks.makeGrindingRecipe(CraftTweakerMC.getItemStack(inputStack), CraftTweakerMC.getItemStack(leftOutput),
							CraftTweakerMC.getItemStack(rightOutput));
	}

	@ZenMethod
	public static void addGrinding(IItemStack input, IItemStack leftOutput, IItemStack rightOutput) {
		ReflectionHacks.makeGrindingRecipe(CraftTweakerMC.getItemStack(input), CraftTweakerMC.getItemStack(leftOutput),
						CraftTweakerMC.getItemStack(rightOutput));
	}

	@ZenMethod
	public static void removeGrindingByInput(IItemStack input) {
		ReflectionHacks.removeGrindingRecipeByInput(CraftTweakerMC.getItemStack(input));
	}
}
