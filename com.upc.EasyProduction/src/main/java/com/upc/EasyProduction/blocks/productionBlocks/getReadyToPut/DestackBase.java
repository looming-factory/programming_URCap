package com.upc.EasyProduction.blocks.productionBlocks.getReadyToPut;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import com.upc.EasyProduction.panelManagement.Workflow;

/**
 * This class represents the DestackBase block.
 * @author Enric Lamarca Ferrés
 *
 */
public class DestackBase extends GetReadyToPut {
	
	/**
	 * Constructor.
	 */
	public DestackBase() {
				
		indentation = "      ";
		
		defaultCode = "\n"
				+ "      $ 23 \"BASEtime: Iniciar\"\n"
				+ "      BASEtime_is_counting = True\n"
				+ "      $ 24 \"'(((((((Destack BASE))))))'\"\n"
				+ "      # '(((((((Destack BASE))))))'\n"
				+ "      $ 25 \"Desapilar\"\n"
				+ "      if (interpolate_3 == 0.0):\n"
				+ "        $ 26 \"StartPos_Bases\" \"breakAfter\"\n"
				+ "        movel(p[.298624768117, -.112368891041, .093007213993, -2.221473960271, 2.221233530776, -.000322140067], a=2.5, v=0.25)\n"
				+ "        global ur_start_point_25=get_forward_kin()\n"
				+ "      else:\n"
				+ "        movel(p[ur_start_point_25[0]+interpolate_3*-0.009182871541590216, ur_start_point_25[1]+interpolate_3*1.4480909105633898E-4, ur_start_point_25[2]+interpolate_3*-0.9999578260609682, ur_start_point_25[3],ur_start_point_25[4],ur_start_point_25[5]], a=2.5, v=0.25)\n"
				+ "      end\n"
				+ "      thread ur_Thread_direction_25():\n"
				+ "        speedl([-9.182871541590215E-5,1.4480909105633898E-6,-0.009999578260609682,0.0,0.0,0.0],2.5,100000.0)\n"
				+ "        ur_stacking_motion_running_25 = False\n"
				+ "      end\n"
				+ "      ur_thread_handler_25 = run ur_Thread_direction_25()\n"
				+ "      ur_stacking_motion_running_25 = True\n"
				+ "      while (ur_stacking_motion_running_25 == True):\n"
				+ "        if ((pose_dist(get_forward_kin(),ur_start_point_25)>0.06) and (force()>30)):\n"
				+ "          kill ur_thread_handler_25\n"
				+ "          ur_stacking_motion_running_25 = False\n"
				+ "          interpolate_3 = 0.0\n"
				+ "          stopl(2.5)\n"
				+ "        else:\n"
				+ "          if (force() >= 20):\n"
				+ "            kill ur_thread_handler_25\n"
				+ "            ur_stacking_motion_running_25 = False\n"
				+ "            interpolate_3 = pose_dist(get_forward_kin(),ur_start_point_25) +0.015\n"
				+ "            stopl(0.5)\n"
				+ "            pose_1 = get_forward_kin()\n"
				+ "            $ 31 \"StackPos_Base\" \"breakAfter\"\n"
				+ "            movel(pose_1, a=2.5, v=0.25)\n"
				+ "            $ 32 \"Retroceso\" \"breakAfter\"\n"
				+ "            movel(pose_trans(pose_1, pose_trans(pose_inv(p[.298616370886, -.112392906623, .092972358085, -2.221423852054, 2.221343371111, -.000335514474]),p[.298573010704, -.112439319284, .110002843631, 2.221292614300, -2.221583920517, .000199925827])), a=2.5, v=0.25)\n"
				+ "            # begin: URCap Program Node\n"
				+ "            #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "            #   Type: RG2\n"
				+ "            $ 33 \"RG2(90)\"\n"
				+ "            RG2(90,40,0.0,True,False,False)\n"
				+ "            # end: URCap Program Node\n"
				+ "            $ 34 \"GetBaseReady\" \"breakAfter\"\n"
				+ "            movel(pose_trans(pose_1, pose_trans(pose_inv(p[.298616370886, -.112392906623, .092972358085, -2.221423852054, 2.221343371111, -.000335514474]),p[.298537000070, -.112435425956, .072997228836, 2.221168910712, -2.221487718883, -.000017648768])), a=2.5, v=0.25)\n"
				+ "            # begin: URCap Program Node\n"
				+ "            #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "            #   Type: RG2\n"
				+ "            $ 35 \"RG2(78)\"\n"
				+ "            RG2(78,40,0.0,True,False,False)\n"
				+ "            # end: URCap Program Node\n"
				+ "            $ 36 \"Esperar: 0.5\"\n"
				+ "            sleep(0.5)\n"
				+ "            $ 37 \"Exit_Bases\" \"breakAfter\"\n"
				+ "            movel(pose_trans(pose_1, pose_trans(pose_inv(p[.298616370886, -.112392906623, .092972358085, -2.221423852054, 2.221343371111, -.000335514474]),p[.298577789554, -.112373604398, .128177700744, 2.221160317439, -2.221480561123, -.000221512900])), a=2.5, v=0.25)\n"
				+ "          end\n"
				+ "        end\n"
				+ "        sync()\n"
				+ "      end";
		
		name = "DestackBase";
		
		
		// param panel
		
		this.panel.removeAll(); // no es pot ajustar velocitat ni acceleració...
		
		JLabel infoLabel = new JLabel();
		
		infoLabel.setText("<html>Destack Base, do not has an approximation point,<br/>because it has been already executed in GoToReadyWayPoint.</html>");
		
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridwidth = 3;
		c.gridheight = 3;
		
		c.gridx = 1;
		c.gridy = 1;
		
		panel.add(infoLabel, c);
		
		this.setText(name);
		
	}
	
	@Override
	public String generateCode() {
		
		String conditionForce = "True";
		
		if (!Workflow.getInstance().getSim()) {
			conditionForce = "force() >= 20";
		}
		
		code = "\n"
				+ "      $ 23 \"BASEtime: Iniciar\"\n"
				+ "      BASEtime_is_counting = True\n"
				+ "      $ 24 \"'(((((((Destack BASE))))))'\"\n"
				+ "      # '(((((((Destack BASE))))))'\n"
				+ "      $ 25 \"Desapilar\"\n"
				+ "      if (interpolate_3 == 0.0):\n"
				+ "        $ 26 \"StartPos_Bases\" \"breakAfter\"\n"
				+ "        movel(p[.298624768117, -.112368891041, .093007213993, -2.221473960271, 2.221233530776, -.000322140067], a=2.5, v=0.25)\n"
				+ "        global ur_start_point_25=get_forward_kin()\n"
				+ "      else:\n"
				+ "        movel(p[ur_start_point_25[0]+interpolate_3*-0.009182871541590216, ur_start_point_25[1]+interpolate_3*1.4480909105633898E-4, ur_start_point_25[2]+interpolate_3*-0.9999578260609682, ur_start_point_25[3],ur_start_point_25[4],ur_start_point_25[5]], a=2.5, v=0.25)\n"
				+ "      end\n"
				+ "      thread ur_Thread_direction_25():\n"
				+ "        speedl([-9.182871541590215E-5,1.4480909105633898E-6,-0.009999578260609682,0.0,0.0,0.0],2.5,100000.0)\n"
				+ "        ur_stacking_motion_running_25 = False\n"
				+ "      end\n"
				+ "      ur_thread_handler_25 = run ur_Thread_direction_25()\n"
				+ "      ur_stacking_motion_running_25 = True\n"
				+ "      while (ur_stacking_motion_running_25 == True):\n"
				+ "        if ((pose_dist(get_forward_kin(),ur_start_point_25)>0.06) and (force()>30)):\n"
				+ "          kill ur_thread_handler_25\n"
				+ "          ur_stacking_motion_running_25 = False\n"
				+ "          interpolate_3 = 0.0\n"
				+ "          stopl(2.5)\n"
				+ "        else:\n"
				+ "          if (" + conditionForce + "):\n"
				+ "            kill ur_thread_handler_25\n"
				+ "            ur_stacking_motion_running_25 = False\n"
				+ "            interpolate_3 = pose_dist(get_forward_kin(),ur_start_point_25) +0.015\n"
				+ "            stopl(0.5)\n"
				+ "            pose_1 = get_forward_kin()\n"
				+ "            $ 31 \"StackPos_Base\" \"breakAfter\"\n"
				+ "            movel(pose_1, a=2.5, v=0.25)\n"
				+ "            $ 32 \"Retroceso\" \"breakAfter\"\n"
				+ "            movel(pose_trans(pose_1, pose_trans(pose_inv(p[.298616370886, -.112392906623, .092972358085, -2.221423852054, 2.221343371111, -.000335514474]),p[.298573010704, -.112439319284, .110002843631, 2.221292614300, -2.221583920517, .000199925827])), a=2.5, v=0.25)\n"
				+ "            # begin: URCap Program Node\n"
				+ "            #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "            #   Type: RG2\n"
				+ "            $ 33 \"RG2(90)\"\n"
				+ "            " + Workflow.getInstance().getSimOrNot() + "RG2(90,40,0.0,True,False,False)\n"
				+ "            # end: URCap Program Node\n"
				+ "            $ 34 \"GetBaseReady\" \"breakAfter\"\n"
				+ "            movel(pose_trans(pose_1, pose_trans(pose_inv(p[.298616370886, -.112392906623, .092972358085, -2.221423852054, 2.221343371111, -.000335514474]),p[.298537000070, -.112435425956, .072997228836, 2.221168910712, -2.221487718883, -.000017648768])), a=2.5, v=0.25)\n"
				+ "            # begin: URCap Program Node\n"
				+ "            #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "            #   Type: RG2\n"
				+ "            $ 35 \"RG2(78)\"\n"
				+ "            " + Workflow.getInstance().getSimOrNot() + "RG2(78,40,0.0,True,False,False)\n"
				+ "            # end: URCap Program Node\n"
				+ "            $ 36 \"Esperar: 0.5\"\n"
				+ "            sleep(0.5)\n"
				+ "            $ 37 \"Exit_Bases\" \"breakAfter\"\n"
				+ "            movel(pose_trans(pose_1, pose_trans(pose_inv(p[.298616370886, -.112392906623, .092972358085, -2.221423852054, 2.221343371111, -.000335514474]),p[.298577789554, -.112373604398, .128177700744, 2.221160317439, -2.221480561123, -.000221512900])), a=2.5, v=0.25)\n"
				+ "          end\n"
				+ "        end\n"
				+ "        sync()\n"
				+ "      end";
		
		return code;
	}
}
