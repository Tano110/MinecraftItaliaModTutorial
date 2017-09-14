package com.example.examplemod.world.gen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.example.examplemod.ExampleMod;

import cpw.mods.fml.common.IWorldGenerator;

public class ExampleWorldGen implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
		
		switch(world.provider.dimensionId){
		case -1:
			generateInNether(world, random, chunkX*16, chunkZ*16);
			break;
		case 0:
			generateInOverworld(world, random, chunkX*16, chunkZ*16);
			break;
		case 1:
			generateInEnd(world, random, chunkX*16, chunkZ*16);
			break;
		}
		
	}
	
	private void generateInNether(World world, Random random, int x, int z) {
		for (int i = 0; i < 300; i++){// 300 = rarita'
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(256);
			int chunkZ = z + random.nextInt(16);
			// 10 = numero di blocchi per nodo
			(new WorldGenMinable(ExampleMod.testBlock, 10, Blocks.netherrack)).generate(world, random, chunkX, chunkY, chunkZ);
		}
	}

	private void generateInOverworld(World world, Random random, int x, int z) {
		// Genera il basicOre
		for (int i = 0; i < 25; i++){// 25 = rarita'
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(256);
			int chunkZ = z + random.nextInt(16);
			// 10 = numero di blocchi per nodo
			(new WorldGenMinable(ExampleMod.testBlock, 10)).generate(world, random, chunkX, chunkY, chunkZ);
		}
		// Genera il basicBlock
		for (int i = 0; i < 100; i++){// 100 = rarita'
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(256);
			int chunkZ = z + random.nextInt(16);
			// 50 = numero di blocchi per nodo
			(new WorldGenMinable(ExampleMod.testBlock, 50)).generate(world, random, chunkX, chunkY, chunkZ);
		}
	}

	private void generateInEnd(World world, Random random, int x, int z) {
		for (int i = 0; i < 300; i++){// 25 = rarita'
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(256);
			int chunkZ = z + random.nextInt(16);
			// 10 = numero di blocchi per nodo
			(new WorldGenMinable(ExampleMod.testBlock, 10, Blocks.end_stone)).generate(world, random, chunkX, chunkY, chunkZ);
		}
	}
	
}
