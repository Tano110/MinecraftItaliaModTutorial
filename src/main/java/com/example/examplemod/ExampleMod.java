package com.example.examplemod;

import com.example.examplemod.blocks.TestBlock;
import com.example.examplemod.items.TestItem;
import com.example.examplemod.proxy.CommonProxy;
import com.example.examplemod.utilities.References;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
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
    
	@Instance
	public ExampleMod instance;
	
	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static Block testBlock = new TestBlock(Material.clay).setBlockName("testBlock").setCreativeTab(CreativeTabs.tabBlock).setLightLevel(1.0F);
	public static Item testItem = new TestItem().setUnlocalizedName("testItem").setCreativeTab(CreativeTabs.tabMisc);
	
    @EventHandler
    public void preinit(FMLPreInitializationEvent event){
    	
    	GameRegistry.registerBlock(testBlock, "testBlock");
    	
    	GameRegistry.registerItem(testItem, "testItem");
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event){
    	
    }
}