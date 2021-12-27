package com.upc.EasyProduction.blocks.productionBlocks.getReadyToPut;

import com.upc.EasyProduction.panelManagement.Workflow;

/**
 * This class represents the DestackBearing block.
 * @author Enric Lamarca Ferrés
 *
 */
public class DestackBearing extends GetReadyToPut {	
	
	/**
	 * Constructor.
	 */
	public DestackBearing() {
		
		indentation = "      ";
		
		defaultCode = "\n"
				+ "      $ 40 \"BEARINGtime: Iniciar\"\n"
				+ "      BEARINGtime_is_counting = True\n"
				+ "      $ 41 \"MoverJ\"\n"
				+ "      $ 42 \"BEARINGready\" \"breakAfter\"\n"
				+ "      movej(get_inverse_kin(p[.298623961974, -.004480822059, .127082453796, 2.221537881908, -2.221289101494, .000338382310], qnear=[0.37087658047676086, -1.4807313124286097, -1.6561453978167933, -1.5754616896258753, 1.5705832242965698, 0.3707645833492279]), a=8.726646259971647, v=4.363323129985823)\n"
				+ "      # begin: URCap Program Node\n"
				+ "      #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "      #   Type: RG2\n"
				+ "      $ 43 \"RG2(40)\"\n"
				+ "      RG2(40,40,0.0,True,False,False)\n"
				+ "      # end: URCap Program Node\n"
				+ "      $ 44 \"'(((((((Destack BEARING))))))'\"\n"
				+ "      # '(((((((Destack BEARING))))))'\n"
				+ "      $ 45 \"Desapilar\"\n"
				+ "      if (interpolate_2 == 0.0):\n"
				+ "        $ 46 \"StartPos_1\" \"breakAfter\"\n"
				+ "        movel(p[.299961284094, -.003023643136, .087038648297, 2.221468076465, -2.221357463836, .000357837453], a=2.5, v=0.25)\n"
				+ "        global ur_start_point_45=get_forward_kin()\n"
				+ "      else:\n"
				+ "        movel(p[ur_start_point_45[0]+interpolate_2*-1.2164207743687688E-4, ur_start_point_45[1]+interpolate_2*-3.218337538111017E-4, ur_start_point_45[2]+interpolate_2*-0.9999999408131183, ur_start_point_45[3],ur_start_point_45[4],ur_start_point_45[5]], a=2.5, v=0.25)\n"
				+ "      end\n"
				+ "      thread ur_Thread_direction_45():\n"
				+ "        speedl([-1.2164207743687688E-6,-3.218337538111017E-6,-0.009999999408131182,0.0,0.0,0.0],2.5,100000.0)\n"
				+ "        ur_stacking_motion_running_45 = False\n"
				+ "      end\n"
				+ "      ur_thread_handler_45 = run ur_Thread_direction_45()\n"
				+ "      ur_stacking_motion_running_45 = True\n"
				+ "      while (ur_stacking_motion_running_45 == True):\n"
				+ "        if ((pose_dist(get_forward_kin(),ur_start_point_45)>0.051332977565098796)):\n"
				+ "          kill ur_thread_handler_45\n"
				+ "          ur_stacking_motion_running_45 = False\n"
				+ "          interpolate_2 = 0.0\n"
				+ "          stopl(2.5)\n"
				+ "        else:\n"
				+ "          if ( force () >= 20):\n"
				+ "            kill ur_thread_handler_45\n"
				+ "            ur_stacking_motion_running_45 = False\n"
				+ "            interpolate_2 = pose_dist(get_forward_kin(),ur_start_point_45) +0.014\n"
				+ "            stopl(1.2)\n"
				+ "            pose_2 = get_forward_kin()\n"
				+ "            $ 51 \"StackPos_Bearin\" \"breakAfter\"\n"
				+ "            movel(pose_2, a=2.5, v=0.25)\n"
				+ "            $ 52 \"RetrocesBearing\" \"breakAfter\"\n"
				+ "            movel(pose_trans(pose_2, pose_trans(pose_inv(p[.299984752629, -.003021484200, .087054949052, -2.221469171956, 2.221385192051, -.000420102607]),p[.299959936617, -.003013929312, .099996583094, 2.221416726466, -2.221332710455, .000238818527])), a=2.5, v=0.25)\n"
				+ "            # begin: URCap Program Node\n"
				+ "            #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "            #   Type: RG2\n"
				+ "            $ 53 \"RG2(60)\"\n"
				+ "            RG2(60,40,0.0,True,False,False)\n"
				+ "            # end: URCap Program Node\n"
				+ "            $ 54 \"GetBearingReady\" \"breakAfter\"\n"
				+ "            movel(pose_trans(pose_2, pose_trans(pose_inv(p[.299984752629, -.003021484200, .087054949052, -2.221469171956, 2.221385192051, -.000420102607]),p[.300025795311, -.002987830780, .075986793985, -2.221419779077, 2.221255986351, -.000444930108])), a=2.5, v=0.25)\n"
				+ "            # begin: URCap Program Node\n"
				+ "            #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "            #   Type: RG2\n"
				+ "            $ 55 \"RG2(47)\"\n"
				+ "            RG2(47,40,0.0,True,False,False)\n"
				+ "            # end: URCap Program Node\n"
				+ "            $ 56 \"Esperar: 0.5\"\n"
				+ "            sleep(0.5)\n"
				+ "            $ 57 \"ExitStackBearin\" \"breakAfter\"\n"
				+ "            movel(pose_trans(pose_2, pose_trans(pose_inv(p[.299984752629, -.003021484200, .087054949052, -2.221469171956, 2.221385192051, -.000420102607]),p[.299994499457, -.003028398327, .127794425207, 2.221507439481, -2.221369363430, .000403330862])), a=2.5, v=0.25)\n"
				+ "          end\n"
				+ "        end\n"
				+ "        sync()\n"
				+ "      end";
		
		name = "DestackBearing";
		
		this.setText(name);
		
	}
	
	@Override
	public String generateCode() {
		
		String conditionForce = "True";
		
		if (!Workflow.getInstance().getSim()) {
			conditionForce = "force() >= 20";
		}
		
		
		code = "\n"
				+ "      $ 40 \"BEARINGtime: Iniciar\"\n"
				+ "      BEARINGtime_is_counting = True\n"
				+ "      $ 41 \"MoverJ\"\n"
				+ "      $ 42 \"BEARINGready\" \"breakAfter\"\n"
				+ "      movej(get_inverse_kin(p[.298623961974, -.004480822059, .127082453796, 2.221537881908, -2.221289101494, .000338382310], qnear=[0.37087658047676086, -1.4807313124286097, -1.6561453978167933, -1.5754616896258753, 1.5705832242965698, 0.3707645833492279]), a=" + Double.toString(acceleration) + ", v=" + Double.toString(velocity) + ")\n"
				+ "      # begin: URCap Program Node\n"
				+ "      #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "      #   Type: RG2\n"
				+ "      $ 43 \"RG2(40)\"\n"
				+ "      " + Workflow.getInstance().getSimOrNot() + "RG2(40,40,0.0,True,False,False)\n"
				+ "      # end: URCap Program Node\n"
				+ "      $ 44 \"'(((((((Destack BEARING))))))'\"\n"
				+ "      # '(((((((Destack BEARING))))))'\n"
				+ "      $ 45 \"Desapilar\"\n"
				+ "      if (interpolate_2 == 0.0):\n"
				+ "        $ 46 \"StartPos_1\" \"breakAfter\"\n"
				+ "        movel(p[.299961284094, -.003023643136, .087038648297, 2.221468076465, -2.221357463836, .000357837453], a=2.5, v=0.25)\n"
				+ "        global ur_start_point_45=get_forward_kin()\n"
				+ "      else:\n"
				+ "        movel(p[ur_start_point_45[0]+interpolate_2*-1.2164207743687688E-4, ur_start_point_45[1]+interpolate_2*-3.218337538111017E-4, ur_start_point_45[2]+interpolate_2*-0.9999999408131183, ur_start_point_45[3],ur_start_point_45[4],ur_start_point_45[5]], a=2.5, v=0.25)\n"
				+ "      end\n"
				+ "      thread ur_Thread_direction_45():\n"
				+ "        speedl([-1.2164207743687688E-6,-3.218337538111017E-6,-0.009999999408131182,0.0,0.0,0.0],2.5,100000.0)\n"
				+ "        ur_stacking_motion_running_45 = False\n"
				+ "      end\n"
				+ "      ur_thread_handler_45 = run ur_Thread_direction_45()\n"
				+ "      ur_stacking_motion_running_45 = True\n"
				+ "      while (ur_stacking_motion_running_45 == True):\n"
				+ "        if ((pose_dist(get_forward_kin(),ur_start_point_45)>0.051332977565098796)):\n"
				+ "          kill ur_thread_handler_45\n"
				+ "          ur_stacking_motion_running_45 = False\n"
				+ "          interpolate_2 = 0.0\n"
				+ "          stopl(2.5)\n"
				+ "        else:\n"
				+ "          if (" + conditionForce + "):\n"
				+ "            kill ur_thread_handler_45\n"
				+ "            ur_stacking_motion_running_45 = False\n"
				+ "            interpolate_2 = pose_dist(get_forward_kin(),ur_start_point_45) +0.014\n"
				+ "            stopl(1.2)\n"
				+ "            pose_2 = get_forward_kin()\n"
				+ "            $ 51 \"StackPos_Bearin\" \"breakAfter\"\n"
				+ "            movel(pose_2, a=2.5, v=0.25)\n"
				+ "            $ 52 \"RetrocesBearing\" \"breakAfter\"\n"
				+ "            movel(pose_trans(pose_2, pose_trans(pose_inv(p[.299984752629, -.003021484200, .087054949052, -2.221469171956, 2.221385192051, -.000420102607]),p[.299959936617, -.003013929312, .099996583094, 2.221416726466, -2.221332710455, .000238818527])), a=2.5, v=0.25)\n"
				+ "            # begin: URCap Program Node\n"
				+ "            #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "            #   Type: RG2\n"
				+ "            $ 53 \"RG2(60)\"\n"
				+ "            " + Workflow.getInstance().getSimOrNot() + "RG2(60,40,0.0,True,False,False)\n"
				+ "            # end: URCap Program Node\n"
				+ "            $ 54 \"GetBearingReady\" \"breakAfter\"\n"
				+ "            movel(pose_trans(pose_2, pose_trans(pose_inv(p[.299984752629, -.003021484200, .087054949052, -2.221469171956, 2.221385192051, -.000420102607]),p[.300025795311, -.002987830780, .075986793985, -2.221419779077, 2.221255986351, -.000444930108])), a=2.5, v=0.25)\n"
				+ "            # begin: URCap Program Node\n"
				+ "            #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "            #   Type: RG2\n"
				+ "            $ 55 \"RG2(47)\"\n"
				+ "            " + Workflow.getInstance().getSimOrNot() + "RG2(47,40,0.0,True,False,False)\n"
				+ "            # end: URCap Program Node\n"
				+ "            $ 56 \"Esperar: 0.5\"\n"
				+ "            sleep(0.5)\n"
				+ "            $ 57 \"ExitStackBearin\" \"breakAfter\"\n"
				+ "            movel(pose_trans(pose_2, pose_trans(pose_inv(p[.299984752629, -.003021484200, .087054949052, -2.221469171956, 2.221385192051, -.000420102607]),p[.299994499457, -.003028398327, .127794425207, 2.221507439481, -2.221369363430, .000403330862])), a=2.5, v=0.25)\n"
				+ "          end\n"
				+ "        end\n"
				+ "        sync()\n"
				+ "      end";
		
		return code;
	}
}
