package com.upc.EasyProduction.blocks.productionBlocks.ini;

import java.awt.GridBagConstraints;

/**
 * This class represents the InitializeVars block.
 * @author Enric Lamarca Ferrés
 *
 */
public class InitializeVars extends Initialize {
	
	/**
	 * Constructor.
	 */
	public InitializeVars() { // maybe it should be singleton
		
		indentation = "  ";
		
		defaultCode = "\n"
				+ "  global cnt_1=0\n"
				+ "  global cnt_3=0\n"
				+ "  global cnt_5=0\n"
				+ "  global cont_1=0\n"
				+ "  global interpolate_2=0.0\n"
				+ "  global interpolate_3=0.0\n"
				+ "  global BASEtime=0\n"
				+ "  global BEARINGtime=0\n"
				+ "  global CAP_time=0\n"
				+ "  global ExperimentTIME=0\n"
				+ "  global TimeWork=0\n"
				+ "  global Time_to_Batch=0\n"
				+ "  global CAP_time_is_counting=False\n"
				+ "  global ExperimentTIME_is_counting=False\n"
				+ "  global TimeWork_is_counting=False\n"
				+ "  global BASEtime_is_counting=False\n"
				+ "  global Time_to_Batch_is_counting=False\n"
				+ "  global BEARINGtime_is_counting=False"
				
				+ "\n"
				+ "  # $ 2 \"BeforeStart\"\n"
				+ "  # $ 3 \"N_Bases≔0\"\n"
				+ "  global N_Bases=0\n"
				+ "  # $ 4 \"N_Bearings≔0\"\n"
				+ "  global N_Bearings=0\n"
				+ "  # $ 5 \"BASEs≔0\"\n"
				+ "  global BASEs=0\n"
				+ "  # $ 6 \"BEARINGs≔0\"\n"
				+ "  global BEARINGs=0\n"
				+ "  # $ 7 \"CAPs≔0\"\n"
				+ "  global CAPs=0\n"
				+ "  # $ 8 \"PRODUCTs≔0\"\n"
				+ "  global PRODUCTs=0\n"
				+ "  # $ 9 \"CyclesCompleted≔0\"\n"
				+ "  global CyclesCompleted=0\n"
				+ "  # $ 10 \"Set DO[0]=Off\"\n"
				+ "  set_standard_digital_out(0, False)\n"
				+ "  # $ 11 \"Set DO[2]=Off\"\n"
				+ "  set_standard_digital_out(2, False)";
		
		name = "InitilizeVars";
		
		this.setText(name);
		
		infoLabel.setText("Initialization of some relevant variables.");
		
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
