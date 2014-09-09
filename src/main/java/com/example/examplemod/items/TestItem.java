package com.example.examplemod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class TestItem extends Item{

	public TestItem(){
		
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
        
		player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 600, 1));
		
		return stack;
    }
	
}