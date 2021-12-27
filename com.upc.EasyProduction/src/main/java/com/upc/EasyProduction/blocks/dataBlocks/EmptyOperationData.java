package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.operationBlocks.Operation;

/**
 * This class represents the data of an empty Operation block, which means an operation block that has no parameters.
 * 
 * @author Enric Lamarca Ferrés
 *
 */
public class EmptyOperationData extends BlockData{
	
	/**
	 * Indentation of the empty Operation block.
	 */
	private String indentation;
	
	/**
	 * Constructor.
	 * @param className class name of the empty Operation block.
	 * @param isSelected boolean that indicates if the empty Operation block is selected.
	 * @param indentation indentation of the empty Operation block.
	 */
	public EmptyOperationData(String className, Boolean isSelected, String indentation) {
		
		this.className = className;
		this.isSelected = isSelected;
		
		this.indentation = indentation;
	}
	
	@Override
	public Block getBlockInstance() {
				
		Operation b = (Operation) super.getBlockInstance();
		
		b.setIndentation(indentation);
		
		b.setPanel();
				
		return (Block) b;
	}
}
