package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.operationBlocks.Sleep;

/**
 * This class represents the data of the Sleep block.
 * @author Enric Lamarca Ferrés
 *
 */
public class SleepData extends BlockData{
	/**
	 * Indentation of the Sleep block.
	 */
	private String indentation;
	/**
	 * Duration of the Sleep block.
	 */
	private int duration;
	
	/**
	 * Constructor.
	 * @param className class name of the Sleep block.
	 * @param isSelected boolean that indicates if the Sleep block is selected.
	 * @param indentation indentation of the Sleep block.
	 * @param duration duration of the Sleep block.
	 */
	public SleepData(String className, Boolean isSelected, String indentation, int duration) {
		
		this.className = className;
		this.isSelected = isSelected;
		
		this.indentation = indentation;
		
		this.duration = duration;
	}
	
	@Override
	public Block getBlockInstance() {
				
		Sleep b = (Sleep) super.getBlockInstance();
		
		b.setIndentation(indentation);
		
		b.setDuration(duration);
		
		b.setPanel();
				
		return (Block) b;
	}
}
