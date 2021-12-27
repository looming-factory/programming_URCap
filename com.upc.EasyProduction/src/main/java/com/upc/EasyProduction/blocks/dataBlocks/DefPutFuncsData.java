package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.productionBlocks.defFuncs.DefPutFuncs;

/**
 * This class represents the data of the DefPutFuncs block.
 * 
 * @author Enric Lamarca Ferrés
 *
 */
public class DefPutFuncsData extends BlockData{
	
	/**
	 * Velocity of the robot movement to the approximation point of the DefPutFuncs block.
	 */
	private double velocity;
	/**
	 * Acceleration of the robot movement to the approximation point of the DefPutFuncs block.
	 */
	private double acceleration;
	
	/**
	 * Velocity tag of the DefPutFuncs block.
	 */
	private int velocity_tag;
	/**
	 * Acceleration tag of the DefPutFuncs block.
	 */
	private int acceleration_tag;
	
	/**
	 * Constructor.
	 * @param className class name of the DefPutFuncs block.
	 * @param isSelected boolean that indicates if the DefPutFuncs block is selected.
	 * @param velocity velocity of the robot movement to the approximation point of the DefPutFuncs block.
	 * @param acceleration acceleration of the robot movement to the approximation point of the DefPutFuncs block.
	 * @param velocity_tag velocity tag of the DefPutFuncs block.
	 * @param acceleration_tag acceleration tag of the DefPutFuncs block.
	 */
	public DefPutFuncsData(String className, Boolean isSelected, double velocity, double acceleration, int velocity_tag, int acceleration_tag){
		
		this.className = className;
		this.isSelected = isSelected;
		
		this.velocity = velocity;
		this.acceleration = acceleration;
		
		this.velocity_tag = velocity_tag;
		this.acceleration_tag = acceleration_tag;
		
	}
	
	@Override
	public Block getBlockInstance() {
				
		DefPutFuncs b = (DefPutFuncs) super.getBlockInstance();
		
		b.setVelocity(velocity, velocity_tag);
		b.setAcceleration(acceleration, acceleration_tag);
		
		b.setPanel();
				
		return (Block) b;
	}
	
}
