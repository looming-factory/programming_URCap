package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import java.awt.Color;
import java.awt.GridBagConstraints;

/**
 * This class represents the EndIfCAPSandProducts block.
 * @author Enric Lamarca Ferrés
 *
 */
public class EndIfCAPSandProducts extends FlowInstructions{
	
	/**
	 * Constructor.
	 */
	public EndIfCAPSandProducts() {
				
		indentation = "    ";
		
		defaultCode = "\n"
				+ "    end\n";
		
		name = "EndIf";
		
		this.setText(name);
		
		this.setBackground(new Color(0xb2c2b1));
		
		infoLabel.setText("End If of CAPs and Products placement.");
		
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
