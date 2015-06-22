/**
 * Copyright (c) 22/06/15 Davide Cossu.
 * <p/>
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any
 * later version.
 * <p/>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, see <http://www.gnu.org/licenses>.
 */

package com.example.examplemod.blocks.te;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.ArrayList;

public class TestTE extends TileEntity{

    public ArrayList<String> visitors = new ArrayList<String>();

    @Override
    public void updateEntity(){
        super.updateEntity();
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        for(int i = 0; i < visitors.size(); i++){
            visitors.set(i, nbt.getString("Visitor" + i));
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        for(int i = 0; i < visitors.size(); i++){
            nbt.setString("Visitor" + i, visitors.get(i));
        }
    }

    public void processActivate(EntityPlayer player, World world){
        if(visitors.size() > 0){
            if(! visitors.get(visitors.size()).equals(player.getDisplayName())){ // Non vogliamo registrare 2 volte consecutive lo stesso giocatore
                visitors.add(player.getDisplayName());
            }
        }else{
            visitors.add(player.getDisplayName());
        }
        System.out.println(visitors);
        world.notifyBlockChange(xCoord, yCoord, zCoord, world.getBlock(xCoord, yCoord, zCoord));
    }

}