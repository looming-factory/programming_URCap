package com.upc.EasyProduction.blocks.productionBlocks.humanWork;

import java.awt.Color;
import java.awt.GridBagConstraints;

/**
 * This class represents the GetCAPs block.
 * @author Enric Lamarca Ferrés
 *
 */
public class GetCAPs extends HumanWork {
	
	/**
	 * Constructor.
	 */
	public GetCAPs() {
				
		indentation = "      ";
		
		defaultCode = "\n"
				+ "      $ 60 \"'(((( GET CAPs )))))'\"\n"
				+ "      # '(((( GET CAPs )))))'\n"
				+ "      $ 61 \"Ajustar L_Verde=Encender\"\n"
				+ "      set_standard_digital_out(2, True)\n"
				+ "      $ 62 \"CAP_time: Iniciar\"\n"
				+ "      CAP_time_is_counting = True\n"
				+ "      $ 63 \"Aviso: OPERATOR:  *** Place CAP on ASSEMBLY ***\"\n"
				+ "      popup(\"OPERATOR:  *** Place CAP on ASSEMBLY ***\", \"Mensaje\", False, False, blocking=True)\n"
				+ "      $ 64 \"CAPs≔CAPs+4\"\n"
				+ "      global CAPs=CAPs+4\n"
				+ "      $ 65 \"CAP_time: Detener\"\n"
				+ "      CAP_time_is_counting = False\n"
				+ "      $ 66 \"Ajustar L_Verde=Apagar\"\n"
				+ "      set_standard_digital_out(2, False)";
		
		name = "GetCaps";
		
		this.setText(name);
		this.setBackground(new Color(0xe1e0bd));
		
		infoLabel.setText("Operator must place CAPs to finalize products and continue.");
		
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
