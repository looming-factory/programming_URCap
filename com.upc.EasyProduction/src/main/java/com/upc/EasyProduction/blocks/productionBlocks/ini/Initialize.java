package com.upc.EasyProduction.blocks.productionBlocks.ini;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.BasicBlockData;

/**
 * This class represents the Initialize block.
 * @author Enric Lamarca Ferrés
 *
 */
public class Initialize extends Block{
	
	/**
	 * Informative JLabel of the parameters panel.
	 */
	protected JLabel infoLabel = new JLabel();
	
	/**
	 * Constructor.
	 */
	public Initialize() {
		
		panel.setLayout(new GridBagLayout());
		
	}
	
	@Override
	public BlockData getBlockData() {
		
		return new BasicBlockData(getClassName(), isSelected);
		
	}

}
