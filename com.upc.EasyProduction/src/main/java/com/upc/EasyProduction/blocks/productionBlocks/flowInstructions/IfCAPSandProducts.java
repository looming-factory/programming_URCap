package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import java.awt.Color;
import java.awt.GridBagConstraints;

/**
 * This class represents the IfCAPSandProducts block.
 * @author Enric Lamarca Ferrés
 *
 */
public class IfCAPSandProducts extends FlowInstructions{
	
	/**
	 * Constructor.
	 */
	public IfCAPSandProducts() {
				
		indentation = "      ";
		
		defaultCode = "\n"
				+ "    $ 59 \"If N_Bearings≥4\"\n"
				+ "    if (N_Bearings >= 4):";
		
		name = "If(Bearings>=4)";
		
		this.setText(name);
		
		this.setBackground(new Color(0xb2c2b1));
		
		infoLabel.setText("If of CAPs and Products placement.");
		
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
