package com.upc.EasyProduction.blocks.productionBlocks.defFuncs;

import com.upc.EasyProduction.panelManagement.Workflow;

/**
 * This class represents the DefPutProduct block.
 * @author Enric Lamarca Ferrés
 *
 */
public class DefPutProduct extends DefPutFuncs {
	
	/**
	 * Constructor.
	 */
	public DefPutProduct() {
		
		indentation = "  ";
		
		defaultCode = "\n"
				+ "  def PUT_PRODUCT_TO_PALLET():\n"
				+ "    $ 103 \"PUT_PRODUCT_TO_PALLET\" \"noBreak\"\n"
				+ "    $ 104 \"MoverJ\"\n"
				+ "    $ 105 \"AproxProdut\" \"breakAfter\"\n"
				+ "    movej(get_inverse_kin(p[-.112319819676, -.298642046942, .128043700236, .000316560833, 3.141470148193, -.000196272256], qnear=[-1.5708053747742925, -1.5708444754221969, -1.5661852995509884, -1.5752342383014133, 1.5709187984447324, 1.9249662173020146E-4]), a=8.726646259971647, v=4.363323129985823)\n"
				+ "    $ 106 \"Palé\"\n"
				+ "    pose_7 = interpolate_pose(p[-.344302522499, -.265870673009, .012499702318, .000272131390, 3.141440178317, -.000220580670],p[-.345343046095, .000923620663, .012453451980, .000201380349, 3.141277962958, -.000094445183], cont_1/3.0)\n"
				+ "    if (cont_1 >= 3):\n"
				+ "      cont_1 = 0\n"
				+ "    else:\n"
				+ "      cont_1 = cont_1 + 1\n"
				+ "    end\n"
				+ "    $ 111 \"AproxProduct\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_7, pose_trans(pose_inv(p[-.344606234484, -.264884060606, .013430585805, .000252666497, 3.141428422176, -.000103433619]),p[-.345428558078, -.262392353348, .128077304526, .000517058093, 3.141447748678, -.000051278243])), a=2.5, v=0.3)\n"
				+ "    $ 112 \"PuntoDePatrón_1\" \"noBreak\"\n"
				+ "    movel(pose_7, a=2.5, v=0.3)\n"
				+ "    $ 113 \"Esperar: 0.5\" \"noBreak\"\n"
				+ "    sleep(0.5)\n"
				+ "    # begin: URCap Program Node\n"
				+ "    #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "    #   Type: RG2\n"
				+ "    $ 114 \"RG2(90)\" \"noBreak\"\n"
				+ "    RG2(90,40,0.0,True,False,False)\n"
				+ "    # end: URCap Program Node\n"
				+ "    $ 115 \"PRODUCTs≔PRODUCTs+1\" \"noBreak\"\n"
				+ "    global PRODUCTs=PRODUCTs+1\n"
				+ "    $ 116 \"SalirStorage\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_7, pose_trans(pose_inv(p[-.344606234484, -.264884060606, .013430585805, .000252666497, 3.141428422176, -.000103433619]),p[-.344641798183, -.264869614725, .093030276347, .000478851211, 3.141475407486, -.000230857726])), a=2.5, v=0.3)\n"
				+ "    if (cont_1 == 0):\n"
				+ "      $ 117 \"TrasFin\" \"noBreak\"\n"
				+ "      $ 118 \"interpolate_2≔0\" \"noBreak\"\n"
				+ "      global interpolate_2=0\n"
				+ "      $ 119 \"interpolate_3≔0\" \"noBreak\"\n"
				+ "      global interpolate_3=0\n"
				+ "      $ 120 \"N_Bases≔0\" \"noBreak\"\n"
				+ "      global N_Bases=0\n"
				+ "      $ 121 \"N_Bearings≔0\" \"noBreak\"\n"
				+ "      global N_Bearings=0\n"
				+ "      $ 122 \"Time_to_Batch: Detener\" \"noBreak\"\n"
				+ "      Time_to_Batch_is_counting = False\n"
				+ "      $ 123 \"PRODUCtime≔Time_to_Batch\" \"noBreak\"\n"
				+ "      global PRODUCtime=Time_to_Batch\n"
				+ "      $ 124 \"Time_to_Batch: Restablecer\" \"noBreak\"\n"
				+ "      Time_to_Batch = 0\n"
				+ "      $ 125 \"CAP_time: Restablecer\" \"noBreak\"\n"
				+ "      CAP_time = 0\n"
				+ "      $ 126 \"Ajustar L_Verde=Apagar\" \"noBreak\"\n"
				+ "      set_standard_digital_out(2, False)\n"
				+ "      $ 127 \"CyclesCompleted≔CyclesCompleted+1\" \"noBreak\"\n"
				+ "      global CyclesCompleted=CyclesCompleted+1\n"
				+ "    end\n"
				+ "  end";
		
		name = "DefPutProduct";
		
		this.setText(name);
		
	}
	
	@Override
	public String generateCode() {		
		code = "\n"
				+ "  def PUT_PRODUCT_TO_PALLET():\n"
				+ "    $ 103 \"PUT_PRODUCT_TO_PALLET\" \"noBreak\"\n"
				+ "    $ 104 \"MoverJ\"\n"
				+ "    $ 105 \"AproxProdut\" \"breakAfter\"\n"
				+ "    movej(get_inverse_kin(p[-.112319819676, -.298642046942, .128043700236, .000316560833, 3.141470148193, -.000196272256], qnear=[-1.5708053747742925, -1.5708444754221969, -1.5661852995509884, -1.5752342383014133, 1.5709187984447324, 1.9249662173020146E-4]), a=" + Double.toString(acceleration) + ", v=" + Double.toString(velocity) + ")\n"
				+ "    $ 106 \"Palé\"\n"
				+ "    pose_7 = interpolate_pose(p[-.344302522499, -.265870673009, .012499702318, .000272131390, 3.141440178317, -.000220580670],p[-.345343046095, .000923620663, .012453451980, .000201380349, 3.141277962958, -.000094445183], cont_1/3.0)\n"
				+ "    if (cont_1 >= 3):\n"
				+ "      cont_1 = 0\n"
				+ "    else:\n"
				+ "      cont_1 = cont_1 + 1\n"
				+ "    end\n"
				+ "    $ 111 \"AproxProduct\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_7, pose_trans(pose_inv(p[-.344606234484, -.264884060606, .013430585805, .000252666497, 3.141428422176, -.000103433619]),p[-.345428558078, -.262392353348, .128077304526, .000517058093, 3.141447748678, -.000051278243])), a=2.5, v=0.3)\n"
				+ "    $ 112 \"PuntoDePatrón_1\" \"noBreak\"\n"
				+ "    movel(pose_7, a=2.5, v=0.3)\n"
				+ "    $ 113 \"Esperar: 0.5\" \"noBreak\"\n"
				+ "    sleep(0.5)\n"
				+ "    # begin: URCap Program Node\n"
				+ "    #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "    #   Type: RG2\n"
				+ "    $ 114 \"RG2(90)\" \"noBreak\"\n"
				+ "    " + Workflow.getInstance().getSimOrNot() + "RG2(90,40,0.0,True,False,False)\n"
				+ "    # end: URCap Program Node\n"
				+ "    $ 115 \"PRODUCTs≔PRODUCTs+1\" \"noBreak\"\n"
				+ "    global PRODUCTs=PRODUCTs+1\n"
				+ "    $ 116 \"SalirStorage\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_7, pose_trans(pose_inv(p[-.344606234484, -.264884060606, .013430585805, .000252666497, 3.141428422176, -.000103433619]),p[-.344641798183, -.264869614725, .093030276347, .000478851211, 3.141475407486, -.000230857726])), a=2.5, v=0.3)\n"
				+ "    if (cont_1 == 0):\n"
				+ "      $ 117 \"TrasFin\" \"noBreak\"\n"
				+ "      $ 118 \"interpolate_2≔0\" \"noBreak\"\n"
				+ "      global interpolate_2=0\n"
				+ "      $ 119 \"interpolate_3≔0\" \"noBreak\"\n"
				+ "      global interpolate_3=0\n"
				+ "      $ 120 \"N_Bases≔0\" \"noBreak\"\n"
				+ "      global N_Bases=0\n"
				+ "      $ 121 \"N_Bearings≔0\" \"noBreak\"\n"
				+ "      global N_Bearings=0\n"
				+ "      $ 122 \"Time_to_Batch: Detener\" \"noBreak\"\n"
				+ "      Time_to_Batch_is_counting = False\n"
				+ "      $ 123 \"PRODUCtime≔Time_to_Batch\" \"noBreak\"\n"
				+ "      global PRODUCtime=Time_to_Batch\n"
				+ "      $ 124 \"Time_to_Batch: Restablecer\" \"noBreak\"\n"
				+ "      Time_to_Batch = 0\n"
				+ "      $ 125 \"CAP_time: Restablecer\" \"noBreak\"\n"
				+ "      CAP_time = 0\n"
				+ "      $ 126 \"Ajustar L_Verde=Apagar\" \"noBreak\"\n"
				+ "      set_standard_digital_out(2, False)\n"
				+ "      $ 127 \"CyclesCompleted≔CyclesCompleted+1\" \"noBreak\"\n"
				+ "      global CyclesCompleted=CyclesCompleted+1\n"
				+ "    end\n"
				+ "  end";
		
		return code;
	}
}
