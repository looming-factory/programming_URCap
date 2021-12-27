package com.upc.EasyProduction.blocks.productionBlocks.humanWork;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.BasicBlockData;

/**
 * This class represents the HumanWork block.
 * @author Enric Lamarca Ferrés
 *
 */
public class HumanWork extends Block{
	
	/**
	 * Informative JLabel of the parameters panel.
	 */
	protected JLabel infoLabel = new JLabel();
	
	/**
	 * Constructor.
	 */
	public HumanWork() {
		panel.setLayout(new GridBagLayout());
	}
	
	@Override
	public BlockData getBlockData() {
		return new BasicBlockData(getClassName(), isSelected);
	}

}
