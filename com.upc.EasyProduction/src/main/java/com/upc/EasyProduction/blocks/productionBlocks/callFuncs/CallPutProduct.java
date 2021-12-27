package com.upc.EasyProduction.blocks.productionBlocks.callFuncs;

import java.awt.GridBagConstraints;

/**
 * This class represents the CallPutProduct block.
 * @author Enric Lamarca Ferrés
 *
 */
public class CallPutProduct extends CallFuncs{		
		
	/**
	 * Constructor.
	 */
	public CallPutProduct() {
		
		indentation = "        ";
		
		defaultCode = "\n"
				+ "        $ 84 \"Invocar PUT_PRODUCT_TO_PALLET\"\n"
				+ "        PUT_PRODUCT_TO_PALLET()";
		
		name = "CallPutProduct";
		
		this.setText(name);
		
		infoLabel.setText("Call of the function PutProduct defined previously.");
		
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
