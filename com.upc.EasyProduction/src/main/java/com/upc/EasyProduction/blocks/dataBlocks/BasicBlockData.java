package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.BlockData;

/**
 * This class represents the basic data of a block.
 * 
 * @author Enric Lamarca Ferrés
 *
 */
public class BasicBlockData extends BlockData{
	
	/**
	 * Constructor.
	 * @param className class name of the corresponding block.
	 * @param isSelected boolean that indicates if the corresponding block is selected.
	 */
	public BasicBlockData(String className, Boolean isSelected) {
		
		this.className = className;
		this.isSelected = isSelected;
	}

}
