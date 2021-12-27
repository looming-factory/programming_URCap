package com.upc.EasyProduction.blocks.productionBlocks.callFuncs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

/**
 * This class represents the CallPutBase block.
 * @author Enric Lamarca Ferrés
 *
 */
public class CallPutBase extends CallFuncs{
	
	/**
	 * Constructor.
	 */
	public CallPutBase() {
		
		indentation = "      ";
		
		defaultCode = "\n"
				+ "      $ 38 \"Invocar PUT_BASE_MATRIZ_ASSEMBLY\"\n"
				+ "      PUT_BASE_MATRIZ_ASSEMBLY()";
		
		name = "CallPutBase";
		
		this.setText(name);
		
		infoLabel.setText("Call of the function PutBase defined previously.");
		
		
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
