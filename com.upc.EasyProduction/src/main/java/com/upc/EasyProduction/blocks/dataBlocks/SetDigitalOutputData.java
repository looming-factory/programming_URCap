package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.operationBlocks.SetDigitalOutput;

/**
 * This class represents the data of the SetDigitalOutput block.
 * @author Enric Lamarca Ferrés
 *
 */
public class SetDigitalOutputData extends BlockData{
	
	/**
	 * Indentation of the SetDigitalOutput block.
	 */
	private String indentation;
	
	/**
	 * Digital output selected of the SetDigitalOutput block.
	 */
	private String out;
	/**
	 * Value of the selected output of the SetDigitalOutput block.
	 */
	private String value;
	
	/**
	 * Constructor.
	 * @param className className class name of the SetDigitalOutput block.
	 * @param isSelected boolean that indicates if the SetDigitalOutput block is selected.
	 * @param indentation indentation of the SetDigitalOutput block.
	 * @param out digital output selected of the SetDigitalOutput block.
	 * @param value value of the selected output of the SetDigitalOutput block.
	 */
	public SetDigitalOutputData(String className, Boolean isSelected, String indentation, String out, String value) {
		
		this.className = className;
		this.isSelected = isSelected;
		
		this.indentation = indentation;
		
		this.out = out;
		this.value = value;
	}
	
	@Override
	public Block getBlockInstance() {
				
		SetDigitalOutput b = (SetDigitalOutput) super.getBlockInstance();
		
		b.setIndentation(indentation);
		
		b.setOut(out);
		b.setValue(value);
		
		b.setPanel();
				
		return (Block) b;
	}
	
}
