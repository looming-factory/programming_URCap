package com.upc.EasyProduction.blocks.productionBlocks.getReadyToPut;

import com.upc.EasyProduction.panelManagement.Workflow;

/**
 * This class represents the GoToReadyWayPoint block.
 * @author Enric Lamarca Ferrés
 *
 */
public class GoToReadyWayPoint extends GetReadyToPut{
	/**
	 * Constructor.
	 */
	public GoToReadyWayPoint() {
					
		indentation = "    ";
		
		defaultCode = "\n"
				+ "    $ 18 \"MoverJ\"\n"
				+ "    $ 19 \"P_Ready\" \"breakAfter\"\n"
				+ "    movej(get_inverse_kin(p[.298616357137, -.112388877195, .127097072908, -2.221424005928, 2.221422962714, -.000273677751], qnear=[-3.5587941304981996E-5, -1.5707243124591272, -1.5707510153399866, -1.5707724730121058, 1.5706911087036133, -3.606477846318512E-5]), a=8.726646259971647, v=4.363323129985823)\n"
				+ "    # begin: URCap Program Node\n"
				+ "    #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "    #   Type: RG2\n"
				+ "    $ 20 \"RG2(50)\"\n"
				+ "    RG2(50,40,0.0,True,False,False)\n"
				+ "    # end: URCap Program Node\n"
				+ "    $ 21 \"'StartPos_Bases= Punto de contacto con el stack=StackPos_Base'\"\n"
				+ "    # 'StartPos_Bases= Punto de contacto con el stack=StackPos_Base'";
		
		name = "GoToReadyWayPoint";
		
		this.setText(name);
		
	}
		
	@Override
	public String generateCode() {
		
		code = "\n"
				+ "    $ 18 \"MoverJ\"\n"
				+ "    $ 19 \"P_Ready\" \"breakAfter\"\n"
				+ "    movej(get_inverse_kin(p[.298616357137, -.112388877195, .127097072908, -2.221424005928, 2.221422962714, -.000273677751], qnear=[-3.5587941304981996E-5, -1.5707243124591272, -1.5707510153399866, -1.5707724730121058, 1.5706911087036133, -3.606477846318512E-5]), a=" + Double.toString(acceleration) + ", v=" + Double.toString(velocity) + ")\n"
				+ "    # begin: URCap Program Node\n"
				+ "    #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "    #   Type: RG2\n"
				+ "    $ 20 \"RG2(50)\"\n"
				+ "    " + Workflow.getInstance().getSimOrNot() + "RG2(50,40,0.0,True,False,False)\n"
				+ "    # end: URCap Program Node\n"
				+ "    $ 21 \"'StartPos_Bases= Punto de contacto con el stack=StackPos_Base'\"\n"
				+ "    # 'StartPos_Bases= Punto de contacto con el stack=StackPos_Base'";
		
		return code;
	}
}
