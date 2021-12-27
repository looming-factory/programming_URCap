package com.upc.EasyProduction.blocks.productionBlocks.defFuncs;

import com.upc.EasyProduction.panelManagement.Workflow;

/**
 * This class represents the DefPutBase block.
 * @author Enric Lamarca Ferrés
 *
 */
public class DefPutBase extends DefPutFuncs {
	
	/**
	 * Constructor.
	 */
	public DefPutBase() {
		
		indentation = "  ";
		
		defaultCode = "\n"
				+ "  def PUT_BASE_MATRIZ_ASSEMBLY():\n"
				+ "    $ 154 \"PUT_BASE_MATRIZ_ASSEMBLY\" \"noBreak\"\n"
				+ "    $ 155 \"MoverJ\"\n"
				+ "    $ 156 \"Approach_1\" \"breakAfter\"\n"
				+ "    movej(get_inverse_kin(p[-.050273197644, -.341535366440, .102459786423, -.032924896149, 3.141372266899, -.000292544836], qnear=[-1.385470215474264, -1.690115753804342, -1.558995548878805, -1.463085953389303, 1.5708110332489014, 0.1643647700548172]), a=8.726646259971647, v=4.363323129985823)\n"
				+ "    $ 157 \"Ajustar\"\n"
				+ "    $ 158 \"Palé\"\n"
				+ "    cnt_1_x = cnt_1 % 2\n"
				+ "    cnt_1_y = floor(cnt_1 / 2)\n"
				+ "    pose_3 = interpolate_pose(interpolate_pose(p[-.110673632447, -.402743662388, .015996416449, .032706351896, -3.141351771470, .000351403696], p[.008396106862, -.402130170560, .016227729830, .032640341384, -3.141418719233, .000092901147], cnt_1_x/1), interpolate_pose(p[-.112260996332, -.293407017066, .015939005158, .032910336852, -3.141302870591, .000038647066], p[.008382824449, -.293496273771, .016018525418, .032591397905, -3.141409227119, .000362020996],cnt_1_x/1), cnt_1_y/1)\n"
				+ "    if (cnt_1 >= 3):\n"
				+ "      cnt_1 = 0\n"
				+ "    else:\n"
				+ "      cnt_1 = cnt_1 + 1\n"
				+ "    end\n"
				+ "    $ 165 \"Approach_1\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_3, pose_trans(pose_inv(p[-.110651833329, -.402569437652, .023124877487, -.032782560488, 3.141404308257, .000637195456]),p[-.050273197644, -.341535366440, .102459786423, -.032924896149, 3.141372266899, -.000292544836])), a=2.5, v=0.25)\n"
				+ "    $ 166 \"Waypoint_1\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_3, pose_trans(pose_inv(p[-.110651833329, -.402569437652, .023124877487, -.032782560488, 3.141404308257, .000637195456]),p[-.110672112561, -.402715575685, .058260378378, .032725340444, -3.141376210088, .000183865050])), a=2.5, v=0.25)\n"
				+ "    $ 167 \"PatternPoint_1\" \"noBreak\"\n"
				+ "    movel(pose_3, a=2.5, v=0.25)\n"
				+ "    # begin: URCap Program Node\n"
				+ "    #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "    #   Type: RG2\n"
				+ "    $ 168 \"RG2(90)\" \"noBreak\"\n"
				+ "    RG2(90,40,0.0,True,False,False)\n"
				+ "    # end: URCap Program Node\n"
				+ "    $ 169 \"Esperar: 0.5\" \"noBreak\"\n"
				+ "    sleep(0.5)\n"
				+ "    $ 170 \"Waypoint_1\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_3, pose_trans(pose_inv(p[-.110651833329, -.402569437652, .023124877487, -.032782560488, 3.141404308257, .000637195456]),p[-.110672112561, -.402715575685, .058260378378, .032725340444, -3.141376210088, .000183865050])), a=2.5, v=0.25)\n"
				+ "    $ 171 \"N_Bases≔N_Bases+1\" \"noBreak\"\n"
				+ "    global N_Bases=N_Bases+1\n"
				+ "    $ 172 \"BASEs≔BASEs+1\" \"noBreak\"\n"
				+ "    global BASEs=BASEs+1\n"
				+ "    $ 173 \"Exit_1\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_3, pose_trans(pose_inv(p[-.110651833329, -.402569437652, .023124877487, -.032782560488, 3.141404308257, .000637195456]),p[-.050258128201, -.341513912103, .102443674357, -.033037479367, 3.141376028057, -.000141032752])), a=2.5, v=0.25)\n"
				+ "    if (cnt_1 == 0):\n"
				+ "      $ 174 \"TrasFin\" \"noBreak\"\n"
				+ "      $ 175 \"BASEtime: Detener\" \"noBreak\"\n"
				+ "      BASEtime_is_counting = False\n"
				+ "      $ 176 \"CycleTimeBASE≔BASEtime\" \"noBreak\"\n"
				+ "      global CycleTimeBASE=BASEtime\n"
				+ "      $ 177 \"BASEtime: Restablecer\" \"noBreak\"\n"
				+ "      BASEtime = 0\n"
				+ "    end\n"
				+ "  end";
		
		name = "DefPutBase";
		
		this.setText(name);
	}
	
	@Override
	public String generateCode() {	
		code = "\n"
				+ "  def PUT_BASE_MATRIZ_ASSEMBLY():\n"
				+ "    $ 154 \"PUT_BASE_MATRIZ_ASSEMBLY\" \"noBreak\"\n"
				+ "    $ 155 \"MoverJ\"\n"
				+ "    $ 156 \"Approach_1\" \"breakAfter\"\n"
				+ "    movej(get_inverse_kin(p[-.050273197644, -.341535366440, .102459786423, -.032924896149, 3.141372266899, -.000292544836], qnear=[-1.385470215474264, -1.690115753804342, -1.558995548878805, -1.463085953389303, 1.5708110332489014, 0.1643647700548172]), a=" + Double.toString(acceleration) + ", v=" + Double.toString(velocity) + ")\n"
				+ "    $ 157 \"Ajustar\"\n"
				+ "    $ 158 \"Palé\"\n"
				+ "    cnt_1_x = cnt_1 % 2\n"
				+ "    cnt_1_y = floor(cnt_1 / 2)\n"
				+ "    pose_3 = interpolate_pose(interpolate_pose(p[-.110673632447, -.402743662388, .015996416449, .032706351896, -3.141351771470, .000351403696], p[.008396106862, -.402130170560, .016227729830, .032640341384, -3.141418719233, .000092901147], cnt_1_x/1), interpolate_pose(p[-.112260996332, -.293407017066, .015939005158, .032910336852, -3.141302870591, .000038647066], p[.008382824449, -.293496273771, .016018525418, .032591397905, -3.141409227119, .000362020996],cnt_1_x/1), cnt_1_y/1)\n"
				+ "    if (cnt_1 >= 3):\n"
				+ "      cnt_1 = 0\n"
				+ "    else:\n"
				+ "      cnt_1 = cnt_1 + 1\n"
				+ "    end\n"
				+ "    $ 165 \"Approach_1\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_3, pose_trans(pose_inv(p[-.110651833329, -.402569437652, .023124877487, -.032782560488, 3.141404308257, .000637195456]),p[-.050273197644, -.341535366440, .102459786423, -.032924896149, 3.141372266899, -.000292544836])), a=2.5, v=0.25)\n"
				+ "    $ 166 \"Waypoint_1\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_3, pose_trans(pose_inv(p[-.110651833329, -.402569437652, .023124877487, -.032782560488, 3.141404308257, .000637195456]),p[-.110672112561, -.402715575685, .058260378378, .032725340444, -3.141376210088, .000183865050])), a=2.5, v=0.25)\n"
				+ "    $ 167 \"PatternPoint_1\" \"noBreak\"\n"
				+ "    movel(pose_3, a=2.5, v=0.25)\n"
				+ "    # begin: URCap Program Node\n"
				+ "    #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "    #   Type: RG2\n"
				+ "    $ 168 \"RG2(90)\" \"noBreak\"\n"
				+ "    " + Workflow.getInstance().getSimOrNot() + "RG2(90,40,0.0,True,False,False)\n"
				+ "    # end: URCap Program Node\n"
				+ "    $ 169 \"Esperar: 0.5\" \"noBreak\"\n"
				+ "    sleep(0.5)\n"
				+ "    $ 170 \"Waypoint_1\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_3, pose_trans(pose_inv(p[-.110651833329, -.402569437652, .023124877487, -.032782560488, 3.141404308257, .000637195456]),p[-.110672112561, -.402715575685, .058260378378, .032725340444, -3.141376210088, .000183865050])), a=2.5, v=0.25)\n"
				+ "    $ 171 \"N_Bases≔N_Bases+1\" \"noBreak\"\n"
				+ "    global N_Bases=N_Bases+1\n"
				+ "    $ 172 \"BASEs≔BASEs+1\" \"noBreak\"\n"
				+ "    global BASEs=BASEs+1\n"
				+ "    $ 173 \"Exit_1\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_3, pose_trans(pose_inv(p[-.110651833329, -.402569437652, .023124877487, -.032782560488, 3.141404308257, .000637195456]),p[-.050258128201, -.341513912103, .102443674357, -.033037479367, 3.141376028057, -.000141032752])), a=2.5, v=0.25)\n"
				+ "    if (cnt_1 == 0):\n"
				+ "      $ 174 \"TrasFin\" \"noBreak\"\n"
				+ "      $ 175 \"BASEtime: Detener\" \"noBreak\"\n"
				+ "      BASEtime_is_counting = False\n"
				+ "      $ 176 \"CycleTimeBASE≔BASEtime\" \"noBreak\"\n"
				+ "      global CycleTimeBASE=BASEtime\n"
				+ "      $ 177 \"BASEtime: Restablecer\" \"noBreak\"\n"
				+ "      BASEtime = 0\n"
				+ "    end\n"
				+ "  end";
		
		return code;
	}
}
