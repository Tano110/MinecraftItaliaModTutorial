package com.example.examplemod;

import com.example.examplemod.armor.TestArmor;
import com.example.examplemod.blocks.TestBlock;
import com.example.examplemod.combat.TestAxe;
import com.example.examplemod.combat.TestHoe;
import com.example.examplemod.combat.TestPick;
import com.example.examplemod.combat.TestShovel;
import com.example.examplemod.combat.TestSword;
import com.example.examplemod.items.TestItem;
import com.example.examplemod.proxy.CommonProxy;
import com.example.examplemod.utilities.References;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = References.MODID, version = References.VERSION)
public class ExampleMod{
	
	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Instance
	public ExampleMod instance;
	
	// ID unici per l'armatura
	public static int helmetID;
	public static int chestplateID;
	public static int legginsID;
	public static int bootsID;
	
	// Inizializziamo il materiale per Armatura
	public static ArmorMaterial testArmorMaterial = new EnumHelper().addArmorMaterial("testArmorMaterial", 66, new int[]{6, 16, 12, 6}, 10);

	//Inizializziamo il materiale per gli utensili
	public static ToolMaterial testMaterial = new EnumHelper().addToolMaterial("testMaterial", 3, 1024, 10.0f, 8.0f, 10);
	
	// Iniziallizziamo un blocco
	public static Block testBlock = new TestBlock(Material.clay).setBlockName("testBlock").setCreativeTab(CreativeTabs.tabBlock).setLightLevel(1.0F).setBlockTextureName(References.MODID + ":testBlock");
	// Iniziallizziamo un ogetto
	public static Item testItem = new TestItem().setUnlocalizedName("testItem").setCreativeTab(CreativeTabs.tabMisc).setTextureName(References.MODID + ":testItem");
	
	// Armatura
	public static Item testHelmet = new TestArmor(testArmorMaterial, helmetID, 0).setUnlocalizedName("testHelmet").setCreativeTab(CreativeTabs.tabCombat);
	public static Item testChestplate = new TestArmor(testArmorMaterial, chestplateID, 1).setUnlocalizedName("testChestplate").setCreativeTab(CreativeTabs.tabCombat);
	public static Item testLeggins = new TestArmor(testArmorMaterial, legginsID, 2).setUnlocalizedName("testLeggins").setCreativeTab(CreativeTabs.tabCombat);
	public static Item testBoots = new TestArmor(testArmorMaterial, bootsID, 3).setUnlocalizedName("testBoots").setCreativeTab(CreativeTabs.tabCombat);
	
	//Utensili
	public static Item testAxe = new TestAxe(testMaterial).setUnlocalizedName("testAxe").setCreativeTab(CreativeTabs.tabTools).setTextureName(References.MODID+":testAxe");
	public static Item testHoe = new TestHoe(testMaterial).setUnlocalizedName("testHoe").setCreativeTab(CreativeTabs.tabTools).setTextureName(References.MODID+":testHoe");
	public static Item testPickaxe = new TestPick(testMaterial).setUnlocalizedName("testPickaxe").setCreativeTab(CreativeTabs.tabTools).setTextureName(References.MODID+":testPickaxe");
	public static Item testShovel = new TestShovel(testMaterial).setUnlocalizedName("testShovel").setCreativeTab(CreativeTabs.tabTools).setTextureName(References.MODID+":testShovel");
	public static Item testSword = new TestSword(testMaterial).setUnlocalizedName("testSword").setCreativeTab(CreativeTabs.tabCombat).setTextureName(References.MODID+":testSword");


	
    @EventHandler
    public void preinit(FMLPreInitializationEvent event){
    	
    	// Registriamo sia il blocco che l'oggetto
    	GameRegistry.registerBlock(testBlock, "testBlock");
    	GameRegistry.registerItem(testItem, "testItem");
    	
    	// Registriamo l'armatura
    	GameRegistry.registerItem(testHelmet, "testHelmet");
    	GameRegistry.registerItem(testChestplate, "testChestplate");
    	GameRegistry.registerItem(testLeggins, "testLeggins");
    	GameRegistry.registerItem(testBoots, "testBoots");
    	
    	// Registriamo gli utensili
    	GameRegistry.registerItem(testAxe, "testAxe");
		GameRegistry.registerItem(testHoe, "testHoe");
		GameRegistry.registerItem(testPickaxe, "testPickaxe");
		GameRegistry.registerItem(testShovel, "testShovel");
		GameRegistry.registerItem(testSword, "testSword");

    	// Ricette!!!
		GameRegistry.addRecipe(new ItemStack(testItem), "x x", " x ", "x x", 'x', Blocks.anvil);
		GameRegistry.addShapelessRecipe(new ItemStack(testItem), "x", "x", 'x', Blocks.cactus);
		GameRegistry.addRecipe(new ItemStack(testItem), "x", "x", "x",'x', Blocks.cactus);
		GameRegistry.addRecipe(new ItemStack(testItem, 5), "x", "x", "x",'x', Blocks.end_stone);
		GameRegistry.addRecipe(new ItemStack(testItem, 15), "x", "x", "x",'x', new ItemStack(Blocks.wool, 1, 4));
		GameRegistry.addSmelting(Blocks.bookshelf, new ItemStack(testBlock), 0.5F);

    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event){
    	
    }
}