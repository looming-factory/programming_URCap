package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import java.awt.Color;
import java.awt.GridBagConstraints;

/**
 * This class represents the WhileTrue block.
 * @author Enric Lamarca Ferrés
 *
 */
public class WhileTrue extends FlowInstructions {
	
	/**
	 * Constructor.
	 */
	public WhileTrue() {
				
		indentation = "    ";
		
		defaultCode = "\n"
				+ "  while (True):\n"
				+ "    $ 12 \"Programa de robot\"\n"
				+ "    $ 13 \"'Ver 3.0 rev 04/12/2020   4bases on stack 4bearing on stack &statistics'\"\n"
				+ "    # 'Ver 3.0 rev 04/12/2020   4bases on stack 4bearing on stack &statistics'\n"
				+ "    $ 14 \"'Programa de Pruebas'\"\n"
				+ "    # 'Programa de Pruebas'\n"
				+ "    $ 15 \"TimeWork: Iniciar\"\n"
				+ "    TimeWork_is_counting = True\n"
				+ "    $ 16 \"Time_to_Batch: Iniciar\"\n"
				+ "    Time_to_Batch_is_counting = True\n"
				+ "    $ 17 \"ExperimentTIME: Iniciar\"\n"
				+ "    ExperimentTIME_is_counting = True\n";
		
		name = "While(True)";
		
		this.setText(name);
		
		this.setBackground(new Color(0xaeaebf)); // ull!
		
		infoLabel.setText("<html>Main While True. It is necessary to disable Polyscope infinite<br/>loop for good indentation of the generated script.</html>");
		
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
		code = "\n"
				+ "  while (True):\n"
				+ "    $ 12 \"Programa de robot\"\n"
				+ "    $ 13 \"'Ver 3.0 rev 04/12/2020   4bases on stack 4bearing on stack &statistics'\"\n"
				+ "    # 'Ver 3.0 rev 04/12/2020   4bases on stack 4bearing on stack &statistics'\n"
				+ "    $ 14 \"'Programa de Pruebas'\"\n"
				+ "    # 'Programa de Pruebas'\n"
				+ "    $ 15 \"TimeWork: Iniciar\"\n"
				+ "    TimeWork_is_counting = True\n"
				+ "    $ 16 \"Time_to_Batch: Iniciar\"\n"
				+ "    Time_to_Batch_is_counting = True\n"
				+ "    $ 17 \"ExperimentTIME: Iniciar\"\n"
				+ "    ExperimentTIME_is_counting = True\n";
		
		return code;
	}
}
