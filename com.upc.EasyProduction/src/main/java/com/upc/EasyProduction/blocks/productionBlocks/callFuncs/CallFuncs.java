package com.upc.EasyProduction.blocks.productionBlocks.callFuncs;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import com.upc.EasyProduction.blocks.Block;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.BasicBlockData;

/**
 * This class represents the CallFuncs block.
 * @author Enric Lamarca Ferrés
 *
 */
public class CallFuncs extends Block{
	
	/**
	 * Information JLabel of parameters panel.
	 */
	protected JLabel infoLabel = new JLabel();
	
	/**
	 * Constructor.
	 */
	public CallFuncs() {
		
		panel.setLayout(new GridBagLayout());
	}
	
	@Override
	public BlockData getBlockData() {
		return new BasicBlockData(getClassName(), isSelected);
	}
	
}
