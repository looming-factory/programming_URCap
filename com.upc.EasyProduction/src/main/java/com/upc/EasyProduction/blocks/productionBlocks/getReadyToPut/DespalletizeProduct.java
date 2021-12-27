package com.upc.EasyProduction.blocks.productionBlocks.getReadyToPut;

import com.upc.EasyProduction.panelManagement.Workflow;

/**
 * This class represents the DespalletizeProduct block.
 * @author Enric Lamarca Ferrés
 *
 */
public class DespalletizeProduct extends GetReadyToPut{
	
	/**
	 * Constructor.
	 */
	public DespalletizeProduct() {
				
		indentation = "        ";
		
		defaultCode = "\n"
				+ "        $ 68 \"MoverJ\"\n"
				+ "        $ 69 \"Approach_2\" \"breakAfter\"\n"
				+ "        movej(get_inverse_kin(p[-.050273197644, -.341535366440, .102459786423, -.032924896149, 3.141372266899, -.000292544836], qnear=[-1.385470215474264, -1.690115753804342, -1.558995548878805, -1.463085953389303, 1.5708110332489014, 0.1643647700548172]), a=8.726646259971647, v=4.363323129985823)\n"
				+ "        # begin: URCap Program Node\n"
				+ "        #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "        #   Type: RG2\n"
				+ "        $ 70 \"RG2(90)\"\n"
				+ "        RG2(90,40,0.0,True,False,False)\n"
				+ "        # end: URCap Program Node\n"
				+ "        $ 71 \"'((((((Despalletize PRODUCT))))))'\"\n"
				+ "        # '((((((Despalletize PRODUCT))))))'\n"
				+ "        $ 72 \"Palé\"\n"
				+ "        cnt_5_x = cnt_5 % 2\n"
				+ "        cnt_5_y = floor(cnt_5 / 2)\n"
				+ "        pose_8 = interpolate_pose(interpolate_pose(p[-.110209633621, -.400798241069, .009725399388, .000262632384, 3.141493321512, -.000234405822], p[.004970221066, -.401270940244, .010001920963, .000344367912, 3.141488273201, -.000264838594], cnt_5_x/1), interpolate_pose(p[-.109906746146, -.295049659473, .010710437065, .000349421098, -3.141557552539, -.000330563446], p[.006849313810, -.295010200451, .009994673109, -.000113213599, 3.141585977963, -.000013454875],cnt_5_x/1), cnt_5_y/1)\n"
				+ "        if (cnt_5 >= 3):\n"
				+ "          cnt_5 = 0\n"
				+ "        else:\n"
				+ "          cnt_5 = cnt_5 + 1\n"
				+ "        end\n"
				+ "        $ 79 \"ApproachProduct\" \"noBreak\"\n"
				+ "        movel(pose_trans(pose_8, pose_trans(pose_inv(p[-.110222921483, -.400694473317, .016073121842, .000281289657, 3.141507524398, .000442570959]),p[-.110198978938, -.400712165434, .059970625820, .000150012859, 3.141507240541, .000351946364])), a=2.5, v=0.25)\n"
				+ "        $ 80 \"PatternPoint_4\" \"noBreak\"\n"
				+ "        movel(pose_8, a=2.5, v=0.25)\n"
				+ "        # begin: URCap Program Node\n"
				+ "        #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "        #   Type: RG2\n"
				+ "        $ 81 \"RG2(80)\" \"noBreak\"\n"
				+ "        RG2(80,40,0.25,True,False,False)\n"
				+ "        # end: URCap Program Node\n"
				+ "        $ 82 \"Esperar: 0.5\" \"noBreak\"\n"
				+ "        sleep(0.5)\n"
				+ "        $ 83 \"Exit_4\" \"noBreak\"\n"
				+ "        movel(pose_trans(pose_8, pose_trans(pose_inv(p[-.110222921483, -.400694473317, .016073121842, .000281289657, 3.141507524398, .000442570959]),p[-.110187854924, -.400679425425, .060006956619, .000206408095, 3.141448072859, .000559160477])), a=2.5, v=0.25)";
		
		name = "DespalletizeProduct";
		
		this.setText(name);
		
		
	}
	
	@Override
	public String generateCode() {
		code = "\n"
				+ "        $ 68 \"MoverJ\"\n"
				+ "        $ 69 \"Approach_2\" \"breakAfter\"\n"
				+ "        movej(get_inverse_kin(p[-.050273197644, -.341535366440, .102459786423, -.032924896149, 3.141372266899, -.000292544836], qnear=[-1.385470215474264, -1.690115753804342, -1.558995548878805, -1.463085953389303, 1.5708110332489014, 0.1643647700548172]), a=" + Double.toString(acceleration) + ", v=" + Double.toString(velocity) + ")\n"
				+ "        # begin: URCap Program Node\n"
				+ "        #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "        #   Type: RG2\n"
				+ "        $ 70 \"RG2(90)\"\n"
				+ "        " + Workflow.getInstance().getSimOrNot() + "RG2(90,40,0.0,True,False,False)\n"
				+ "        # end: URCap Program Node\n"
				+ "        $ 71 \"'((((((Despalletize PRODUCT))))))'\"\n"
				+ "        # '((((((Despalletize PRODUCT))))))'\n"
				+ "        $ 72 \"Palé\"\n"
				+ "        cnt_5_x = cnt_5 % 2\n"
				+ "        cnt_5_y = floor(cnt_5 / 2)\n"
				+ "        pose_8 = interpolate_pose(interpolate_pose(p[-.110209633621, -.400798241069, .009725399388, .000262632384, 3.141493321512, -.000234405822], p[.004970221066, -.401270940244, .010001920963, .000344367912, 3.141488273201, -.000264838594], cnt_5_x/1), interpolate_pose(p[-.109906746146, -.295049659473, .010710437065, .000349421098, -3.141557552539, -.000330563446], p[.006849313810, -.295010200451, .009994673109, -.000113213599, 3.141585977963, -.000013454875],cnt_5_x/1), cnt_5_y/1)\n"
				+ "        if (cnt_5 >= 3):\n"
				+ "          cnt_5 = 0\n"
				+ "        else:\n"
				+ "          cnt_5 = cnt_5 + 1\n"
				+ "        end\n"
				+ "        $ 79 \"ApproachProduct\" \"noBreak\"\n"
				+ "        movel(pose_trans(pose_8, pose_trans(pose_inv(p[-.110222921483, -.400694473317, .016073121842, .000281289657, 3.141507524398, .000442570959]),p[-.110198978938, -.400712165434, .059970625820, .000150012859, 3.141507240541, .000351946364])), a=2.5, v=0.25)\n"
				+ "        $ 80 \"PatternPoint_4\" \"noBreak\"\n"
				+ "        movel(pose_8, a=2.5, v=0.25)\n"
				+ "        # begin: URCap Program Node\n"
				+ "        #   Source: RG - On Robot, 1.9.0, OnRobot A/S\n"
				+ "        #   Type: RG2\n"
				+ "        $ 81 \"RG2(80)\" \"noBreak\"\n"
				+ "        " + Workflow.getInstance().getSimOrNot() + "RG2(80,40,0.25,True,False,False)\n"
				+ "        # end: URCap Program Node\n"
				+ "        $ 82 \"Esperar: 0.5\" \"noBreak\"\n"
				+ "        sleep(0.5)\n"
				+ "        $ 83 \"Exit_4\" \"noBreak\"\n"
				+ "        movel(pose_trans(pose_8, pose_trans(pose_inv(p[-.110222921483, -.400694473317, .016073121842, .000281289657, 3.141507524398, .000442570959]),p[-.110187854924, -.400679425425, .060006956619, .000206408095, 3.141448072859, .000559160477])), a=2.5, v=0.25)";
		
		return code;
	}
}
