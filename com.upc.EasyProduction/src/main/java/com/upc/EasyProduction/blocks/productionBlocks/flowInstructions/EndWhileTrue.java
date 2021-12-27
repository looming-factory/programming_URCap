package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import java.awt.Color;
import java.awt.GridBagConstraints;

/**
 * This class represents the EndWhileTrue block.
 * @author Enric Lamarca Ferrés
 *
 */
public class EndWhileTrue extends FlowInstructions {
	
	/**
	 * Constructor.
	 */
	public EndWhileTrue() {
				
		indentation = "  ";
		
		defaultCode = "\n"
				+ "  end\n";
		
		name = "EndWhile";
		
		this.setText(name);
		
		this.setBackground(new Color(0xaeaebf));
		
		infoLabel.setText("End While True.");
		
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
