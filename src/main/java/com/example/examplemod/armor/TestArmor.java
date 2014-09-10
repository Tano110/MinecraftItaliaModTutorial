package com.example.examplemod.armor;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.utilities.References;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class TestArmor extends ItemArmor{

	public TestArmor(ArmorMaterial material, int id, int placement){
		super(material, id, placement);
		
		/*
		 * 3=Elmo
		 * 2=Corazza
		 * 1=Gambali
		 * 0=Stivali
		 */
		
		switch(placement){
		case 0:
			this.setTextureName(References.MODID + ":testHelmet");
		case 1:
			this.setTextureName(References.MODID + ":testChestplate");
		case 2:
			this.setTextureName(References.MODID + ":testLeggins");
		case 3:
			this.setTextureName(References.MODID + ":testBoots");
		}
		
	}

	@Override
	public String getArmorTexture(ItemStack  stack, Entity entity, int slot, String type){
		if(stack.getItem() == ExampleMod.testHelmet || stack.getItem() == ExampleMod.testChestplate || 
				stack.getItem() == ExampleMod.testBoots){
			return References.MODID+":textures/models/armor/testArmor_1.png";
		}else if(stack.getItem() == ExampleMod.testLeggins){
			return References.MODID+":textures/models/armor/testArmor_2.png";
		}else{
			return null;
		}
	}
	
}