package com.upc.EasyProduction.blocks.operationBlocks;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.EmptyOperationData;

/**
 * This class represents the Operation block which is a block that
 * initially it is not in the workflow but it can be added (or removed) by the user.
 * @author Enric Lamarca Ferrés
 *
 */
public class Operation extends Block{
	/**
	 * Constructor.
	 */
	public Operation() {
		
		this.setBackground(new Color(0xeae7e7));
	}
	
	
	@Override
	public String getDefaultCode() {
		return "\n" + indentation + defaultCode; //ULL!!!! (funciona només si és una línia de codi)
	}
	
	@Override
	public String generateCode() {
		code = defaultCode;
		
		return "\n" + indentation + code;
	}
	
	@Override
	public BlockData getBlockData() {
		return new EmptyOperationData(getClassName(), isSelected, indentation);
	}
}
