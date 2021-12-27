package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import java.awt.Color;
import java.awt.GridBagConstraints;

/**
 * This class represents the IfBearings block.
 * @author Enric Lamarca Ferrés
 *
 */
public class IfBearings extends FlowInstructions{
	
	/**
	 * Constructor.
	 */
	public IfBearings() {
		
		indentation = "      ";
		
		defaultCode = "\n"
				+ "    $ 39 \"If N_Bases≥4\"\n"
				+ "    if (N_Bases >= 4):";
		
		name = "If(Bases>=4)";
		
		this.setText(name);
		
		this.setBackground(new Color(0xb2c2b1));
		
		infoLabel.setText("If of bearings placement.");
		
		// param panel
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridwidth = 3;
		c.gridheight = 3;
		
		c.gridx = 1;
		c.gridy = 1;
		
		panel.add(infoLabel, c);
	}
	

	@Override
	public String generateCode() {
		code = defaultCode;
		
		return code;
	}

}
