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

package com.example.examplemod.blocks;

import com.example.examplemod.blocks.te.TestTE;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TestTEBlock extends Block implements ITileEntityProvider{

    public TestTEBlock(Material material){
        super(material);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
        if(!world.isRemote){ // Solo da un lato, solo serverSide
            TestTE t = (TestTE) world.getTileEntity(x, y, z);
            t.processActivate(player, world);
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta){
        return new TestTE();
    }
}