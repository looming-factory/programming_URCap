package com.upc.EasyProduction.blocks.productionBlocks.callFuncs;

import java.awt.GridBagConstraints;

/**
 * This class represents the CallPutBearing block.
 * @author Enric Lamarca Ferrés
 *
 */
public class CallPutBearing extends CallFuncs{
		
	/**
	 * Constructor.
	 */
	public CallPutBearing() {
		
		indentation = "      ";
		
		defaultCode = "\n"
				+ "      $ 58 \"Invocar PUT_BEARING_MATRIZ_ASSEMBLY\"\n"
				+ "      PUT_BEARING_MATRIZ_ASSEMBLY()";
		
		name = "CallPutBearing";
		
		this.setText(name);
		
		infoLabel.setText("Call of the function PutBearing defined previously.");
		
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
