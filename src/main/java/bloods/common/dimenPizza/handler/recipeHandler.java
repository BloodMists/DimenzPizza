package bloods.common.dimenPizza.handler;

import bloods.common.dimenPizza.Blooddp;
import bloods.common.dimenPizza.init.BDPItemsLoader;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class recipeHandler {
	
	public static void init(){
		
		initBloodRecipes();
		initAddOredict();
	}
	
	private static void initBloodRecipes()
	{	
		//Recipes
		//Shaped
		//tools
		GameRegistry.addRecipe(new ShapedOreRecipe (new ItemStack(BDPItemsLoader.tools,1,0), new Object[]
				{"   ","SWS","   ",'S', "stickWood",'W', "plankWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe (new ItemStack(BDPItemsLoader.tools,1,6), new Object[]
				{"   "," I ","   ",'I', "ingotIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe (new ItemStack(BDPItemsLoader.tools,1,2), new Object[]
				{" I ","IWI","SI ",'I', "ingotIron", 'W', "plankWood",'S',"stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe (new ItemStack(BDPItemsLoader.tools,1,3), new Object[]
				{"HSH","WIW","WWW",'W', "plankWood",'S',"stickWood",'H',"slabWood",'I',"ingotIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe (new ItemStack(BDPItemsLoader.tools,1,4), new Object[]
				{" H "," BI"," H ",'H',"slabWood",'B', Items.bowl, 'I', "ingotIron"}));
		
		//pizzas
		
		//other
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blooddp.fancyBoots, 1), new Object[]
				{"D D","D D","FNF",'D', "gemDiamond", 'F', Items.feather, 'N', Items.nether_star}));
		
		//Shapeless
		//tools
		GameRegistry.addShapelessRecipe(new ItemStack(BDPItemsLoader.tools,1,1), new Object[]
				{new ItemStack(BDPItemsLoader.tools,1,6), new ItemStack(Items.stick)});
		
		//pizzas
		GameRegistry.addShapelessRecipe(new ItemStack(BDPItemsLoader.pizzas,1,0), new Object[]
				{new ItemStack(BDPItemsLoader.stuffs,1,2), new ItemStack(BDPItemsLoader.tools,1,0)});
		
		//other
		//GameRegistry.addShapelessRecipe(new ItemStack(BDPItemsLoader.stuffs,#,#), new Object[]
		//		{new ItemStack(BDPItemsLoader.name,#,#), new ItemStack()});
		GameRegistry.addShapelessRecipe(new ItemStack(BDPItemsLoader.stuffs,3,13), new Object[]
				{new ItemStack(BDPItemsLoader.tools,1,5), new ItemStack(Items.wheat)});
		GameRegistry.addShapelessRecipe(new ItemStack(BDPItemsLoader.stuffs,2,11), new Object[]
				{new ItemStack(BDPItemsLoader.tools,1,1), new ItemStack(Blocks.brown_mushroom)});
		GameRegistry.addShapelessRecipe(new ItemStack(BDPItemsLoader.stuffs,2,11), new Object[]
				{new ItemStack(BDPItemsLoader.tools,1,1), new ItemStack(Blocks.red_mushroom)});
		GameRegistry.addShapelessRecipe(new ItemStack(BDPItemsLoader.stuffs,1,4), new Object[]
				{new ItemStack(BDPItemsLoader.tools,1,3), new ItemStack(Items.milk_bucket)});
		GameRegistry.addShapelessRecipe(new ItemStack(BDPItemsLoader.stuffs,1,6), new Object[]
				{new ItemStack(BDPItemsLoader.tools,1,1), new ItemStack(Items.beef)});
	}
	
	private static void initAddOredict()
	{
		
	}
}