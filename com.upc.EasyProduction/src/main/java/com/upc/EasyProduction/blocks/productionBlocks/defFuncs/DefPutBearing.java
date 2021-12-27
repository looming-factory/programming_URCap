package com.upc.EasyProduction.blocks.productionBlocks.defFuncs;

import com.upc.EasyProduction.panelManagement.Workflow;

/**
 * This class represents the DefPutBearing block.
 * @author Enric Lamarca Ferrés
 *
 */
public class DefPutBearing extends DefPutFuncs {
	
	/**
	 * Constructor.
	 */
	public DefPutBearing() {
		
		indentation = "  ";
		
		defaultCode = "\n"
				+ "  def PUT_BEARING_MATRIZ_ASSEMBLY():\n"
				+ "    $ 128 \"PUT_BEARING_MATRIZ_ASSEMBLY\" \"noBreak\"\n"
				+ "    $ 129 \"'Ver 1.0 rev 05/10/2020 Bases in matrix 4*4'\"\n"
				+ "    # 'Ver 1.0 rev 05/10/2020 Bases in matrix 4*4'\n"
				+ "    $ 130 \"MoverJ\"\n"
				+ "    $ 131 \"Approach_2\" \"breakAfter\"\n"
				+ "    movej(get_inverse_kin(p[-.050273197644, -.341535366440, .102459786423, -.032924896149, 3.141372266899, -.000292544836], qnear=[-1.385470215474264, -1.690115753804342, -1.558995548878805, -1.463085953389303, 1.5708110332489014, 0.1643647700548172]), a=8.726646259971647, v=4.363323129985823)\n"
				+ "    $ 132 \"Ajustar\"\n"
				+ "    $ 133 \"Palé\"\n"
				+ "    cnt_3_x = cnt_3 % 2\n"
				+ "    cnt_3_y = floor(cnt_3 / 2)\n"
				+ "    pose_5 = interpolate_pose(interpolate_pose(p[-.110698014011, -.404256215370, .037039855074, -.032651951944, 3.141303350114, -.024820428486], p[.008365619902, -.401875405937, .037033485025, .032546504275, -3.141349295395, -.004489768950], cnt_3_x/1), interpolate_pose(p[-.111984878209, -.294051331752, .035907576276, .032792806628, -3.141285338428, -.003236093701], p[.008342654262, -.293291574903, .037005687781, .032781646304, -3.141194481082, -.003042610230],cnt_3_x/1), cnt_3_y/1)\n"
				+ "    if (cnt_3 >= 3):\n"
				+ "      cnt_3 = 0\n"
				+ "    else:\n"
				+ "      cnt_3 = cnt_3 + 1\n"
				+ "    end\n"
				+ "    $ 140 \"Approach_3\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_5, pose_trans(pose_inv(p[-.110694380911, -.403562251454, .036970609834, .032592691804, -3.141316894964, .012342883790]),p[-.050273197644, -.341535366440, .102459786423, -.032924896149, 3.141372266899, -.000292544836])), a=2.5, v=0.25)\n"
				+ "    $ 141 \"Waypoint_2\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_5, pose_trans(pose_inv(p[-.110694380911, -.403562251454, .036970609834, .032592691804, -3.141316894964, .012342883790]),p[-.110702578703, -.402720127022, .054984750320, .032876732918, -3.141314066424, .000327064816])), a=2.5, v=0.25)\n"
				+ "    $ 142 \"PatternPoint_2\" \"noBreak\"\n"
				+ "    movel(pose_5, a=2.5, v=0.25)\n"
				+ "    $ 143 \"Ajustar\" \"noBreak\"\n"
				+ "    # begin: URCap Program Node\n"
				+ "    #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "    #   Type: RG2\n"
				+ "    $ 144 \"RG2(90)\" \"noBreak\"\n"
				+ "    RG2(90,40,0.0,True,False,False)\n"
				+ "    # end: URCap Program Node\n"
				+ "    $ 145 \"Esperar: 0.5\" \"noBreak\"\n"
				+ "    sleep(0.5)\n"
				+ "    $ 146 \"Waypoint_3\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_5, pose_trans(pose_inv(p[-.110694380911, -.403562251454, .036970609834, .032592691804, -3.141316894964, .012342883790]),p[-.110702578703, -.402720127022, .054984750320, .032876732918, -3.141314066424, .000327064816])), a=2.5, v=0.25)\n"
				+ "    $ 147 \"N_Bearings≔N_Bearings+1\" \"noBreak\"\n"
				+ "    global N_Bearings=N_Bearings+1\n"
				+ "    $ 148 \"BEARINGs≔BEARINGs+1\" \"noBreak\"\n"
				+ "    global BEARINGs=BEARINGs+1\n"
				+ "    $ 149 \"Exit_3\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_5, pose_trans(pose_inv(p[-.110694380911, -.403562251454, .036970609834, .032592691804, -3.141316894964, .012342883790]),p[-.050258128201, -.341513912103, .102443674357, -.033037479367, 3.141376028057, -.000141032752])), a=2.5, v=0.25)\n"
				+ "    if (cnt_3 == 0):\n"
				+ "      $ 150 \"TrasFin\" \"noBreak\"\n"
				+ "      $ 151 \"BEARINGtime: Detener\" \"noBreak\"\n"
				+ "      BEARINGtime_is_counting = False\n"
				+ "      $ 152 \"CycleTimeBEARIN≔BEARINGtime\" \"noBreak\"\n"
				+ "      global CycleTimeBEARIN=BEARINGtime\n"
				+ "      $ 153 \"BEARINGtime: Restablecer\" \"noBreak\"\n"
				+ "      BEARINGtime = 0\n"
				+ "    end\n"
				+ "  end";
		
		name = "DefPutBearing";
		
		this.setText(name);
		
	}
	
	@Override
	public String generateCode() {		
		code = "\n"
				+ "  def PUT_BEARING_MATRIZ_ASSEMBLY():\n"
				+ "    $ 128 \"PUT_BEARING_MATRIZ_ASSEMBLY\" \"noBreak\"\n"
				+ "    $ 129 \"'Ver 1.0 rev 05/10/2020 Bases in matrix 4*4'\"\n"
				+ "    # 'Ver 1.0 rev 05/10/2020 Bases in matrix 4*4'\n"
				+ "    $ 130 \"MoverJ\"\n"
				+ "    $ 131 \"Approach_2\" \"breakAfter\"\n"
				+ "    movej(get_inverse_kin(p[-.050273197644, -.341535366440, .102459786423, -.032924896149, 3.141372266899, -.000292544836], qnear=[-1.385470215474264, -1.690115753804342, -1.558995548878805, -1.463085953389303, 1.5708110332489014, 0.1643647700548172]), a=" + Double.toString(acceleration) + ", v=" + Double.toString(velocity) + ")\n"
				+ "    $ 132 \"Ajustar\"\n"
				+ "    $ 133 \"Palé\"\n"
				+ "    cnt_3_x = cnt_3 % 2\n"
				+ "    cnt_3_y = floor(cnt_3 / 2)\n"
				+ "    pose_5 = interpolate_pose(interpolate_pose(p[-.110698014011, -.404256215370, .037039855074, -.032651951944, 3.141303350114, -.024820428486], p[.008365619902, -.401875405937, .037033485025, .032546504275, -3.141349295395, -.004489768950], cnt_3_x/1), interpolate_pose(p[-.111984878209, -.294051331752, .035907576276, .032792806628, -3.141285338428, -.003236093701], p[.008342654262, -.293291574903, .037005687781, .032781646304, -3.141194481082, -.003042610230],cnt_3_x/1), cnt_3_y/1)\n"
				+ "    if (cnt_3 >= 3):\n"
				+ "      cnt_3 = 0\n"
				+ "    else:\n"
				+ "      cnt_3 = cnt_3 + 1\n"
				+ "    end\n"
				+ "    $ 140 \"Approach_3\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_5, pose_trans(pose_inv(p[-.110694380911, -.403562251454, .036970609834, .032592691804, -3.141316894964, .012342883790]),p[-.050273197644, -.341535366440, .102459786423, -.032924896149, 3.141372266899, -.000292544836])), a=2.5, v=0.25)\n"
				+ "    $ 141 \"Waypoint_2\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_5, pose_trans(pose_inv(p[-.110694380911, -.403562251454, .036970609834, .032592691804, -3.141316894964, .012342883790]),p[-.110702578703, -.402720127022, .054984750320, .032876732918, -3.141314066424, .000327064816])), a=2.5, v=0.25)\n"
				+ "    $ 142 \"PatternPoint_2\" \"noBreak\"\n"
				+ "    movel(pose_5, a=2.5, v=0.25)\n"
				+ "    $ 143 \"Ajustar\" \"noBreak\"\n"
				+ "    # begin: URCap Program Node\n"
				+ "    #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "    #   Type: RG2\n"
				+ "    $ 144 \"RG2(90)\" \"noBreak\"\n"
				+ "    " + Workflow.getInstance().getSimOrNot() + "RG2(90,40,0.0,True,False,False)\n"
				+ "    # end: URCap Program Node\n"
				+ "    $ 145 \"Esperar: 0.5\" \"noBreak\"\n"
				+ "    sleep(0.5)\n"
				+ "    $ 146 \"Waypoint_3\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_5, pose_trans(pose_inv(p[-.110694380911, -.403562251454, .036970609834, .032592691804, -3.141316894964, .012342883790]),p[-.110702578703, -.402720127022, .054984750320, .032876732918, -3.141314066424, .000327064816])), a=2.5, v=0.25)\n"
				+ "    $ 147 \"N_Bearings≔N_Bearings+1\" \"noBreak\"\n"
				+ "    global N_Bearings=N_Bearings+1\n"
				+ "    $ 148 \"BEARINGs≔BEARINGs+1\" \"noBreak\"\n"
				+ "    global BEARINGs=BEARINGs+1\n"
				+ "    $ 149 \"Exit_3\" \"noBreak\"\n"
				+ "    movel(pose_trans(pose_5, pose_trans(pose_inv(p[-.110694380911, -.403562251454, .036970609834, .032592691804, -3.141316894964, .012342883790]),p[-.050258128201, -.341513912103, .102443674357, -.033037479367, 3.141376028057, -.000141032752])), a=2.5, v=0.25)\n"
				+ "    if (cnt_3 == 0):\n"
				+ "      $ 150 \"TrasFin\" \"noBreak\"\n"
				+ "      $ 151 \"BEARINGtime: Detener\" \"noBreak\"\n"
				+ "      BEARINGtime_is_counting = False\n"
				+ "      $ 152 \"CycleTimeBEARIN≔BEARINGtime\" \"noBreak\"\n"
				+ "      global CycleTimeBEARIN=BEARINGtime\n"
				+ "      $ 153 \"BEARINGtime: Restablecer\" \"noBreak\"\n"
				+ "      BEARINGtime = 0\n"
				+ "    end\n"
				+ "  end";
		
		return code;
	}
}
