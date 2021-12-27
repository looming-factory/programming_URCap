package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.operationBlocks.SetAnalogOutput;
/**
 * This class represents the data of the SetAnalogOutput block.
 * @author Enric Lamarca Ferrés
 *
 */
public class SetAnalogOutputData extends BlockData {
	
	/**
	 * Indentation of the SetAnalogOutput block.
	 */
	private String indentation;
	
	/**
	 * Analog output selected of the SetAnalogOutput block.
	 */
	private String out;
	/**
	 * Value of the selected output of the SetAnalogOutput block.
	 */
	private String value;
	
	/**
	 * Constructor.
	 * @param className className class name of the SetAnalogOutput block.
	 * @param isSelected boolean that indicates if the SetAnalogOutput block is selected.
	 * @param indentation indentation of the SetAnalogOutput block.
	 * @param out analog output selected of the SetAnalogOutput block.
	 * @param value value of the selected output of the SetAnalogOutput block.
	 */
	public SetAnalogOutputData(String className, Boolean isSelected, String indentation, String out, String value) {
		
		this.className = className;
		this.isSelected = isSelected;
		
		this.indentation = indentation;
		
		this.out = out;
		this.value = value;
	}
	
	@Override
	public Block getBlockInstance() {
				
		SetAnalogOutput b = (SetAnalogOutput) super.getBlockInstance();
		
		b.setIndentation(indentation);
		
		b.setOut(out);
		b.setValue(value);
		
		b.setPanel();
				
		return (Block) b;
	}
	
}
