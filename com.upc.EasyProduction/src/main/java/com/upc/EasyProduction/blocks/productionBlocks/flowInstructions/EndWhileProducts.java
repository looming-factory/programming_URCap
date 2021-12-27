package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import java.awt.Color;
import java.awt.GridBagConstraints;

/**
 * This class represents the EndWhileProducts block.
 * @author Enric Lamarca Ferrés
 *
 */
public class EndWhileProducts extends FlowInstructions{
	
	/**
	 * Constructor.
	 */
	public EndWhileProducts() {
				
		indentation = "      ";
		
		defaultCode = "\n"
				+ "        Loop_1 = Loop_1 + 1\n"
				+ "      end";
		
		name = "EndWhile";
		
		this.setText(name);
		
		this.setBackground(new Color(0xb2c2b1));
		
		infoLabel.setText("End While of products placement.");
		
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
