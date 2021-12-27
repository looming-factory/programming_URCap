package com.upc.EasyProduction.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.BasicBlockData;
import com.upc.EasyProduction.blocks.dataBlocks.DefPutFuncsData;
import com.upc.EasyProduction.blocks.dataBlocks.GetReadyToPutData;
import com.upc.EasyProduction.blocks.dataBlocks.EmptyOperationData;
import com.upc.EasyProduction.blocks.dataBlocks.PopUpData;
import com.upc.EasyProduction.blocks.dataBlocks.SetAnalogOutputData;
import com.upc.EasyProduction.blocks.dataBlocks.SetDigitalOutputData;
import com.upc.EasyProduction.blocks.dataBlocks.SleepData;
import com.upc.EasyProduction.blocks.dataBlocks.ThreadData;

/**
 * This class builds BlockData instances from their JSons.
 * @author Enric Lamarca Ferrés
 *
 */
public class MyStringDeserialization {

	/**
	 * Deserialize JSon and builds the corresponding BlockData instance.
	 * @param data BlockData JSon string.
	 * @param type BlockData type.
	 * @return the corresponding BlockData instance built from data (JSon string).
	 */
	public BlockData deserializeBlockData(String data, String type) {
		
		if(type.contains("BasicBlockData")) {
			return getBasicBlockData(data);
		}
		else if(type.contains("DefPutFuncsData")) {
			return getDefPutFuncsData(data);
		}
		else if(type.contains("GetReadyToPutData")) {
			return getGetReadyToPutDataData(data);
		}
		else if(type.contains("OperationData")) {
			return getOperationData(data);
		}
		else if(type.contains("ThreadData")) {
			return getThreadData(data);
		}
		else if(type.contains("SleepData")) {
			return getSleepData(data);
		}
		else if(type.contains("PopUpData")) {
			return getPopUpData(data);
		}
		else if(type.contains("SetDigitalOutputData")) {
			return getSetDigitalOutputData(data);
		}
		else if(type.contains("SetAnalogOutputData")) {
			return getSetAnalogOutputData(data);
		}
		else {
			return null;
		}
	}
	
	/**
	 * Extracts of the JSon string the value of one attribute using a regular expression.
	 * @param attributeName name of the attribute that we want to know its value.
	 * @param data BlockData JSon string.
	 * @return the string representation of the attribute value.
	 */
	public String getVal(String attributeName, String data) {
		
		Pattern pattern = Pattern.compile("\"" + attributeName + "\":\"?([^,}{\"]*)");
		
		Matcher matcher = pattern.matcher(data);
		
		if (matcher.find()) {
			
			//System.out.println("DATA " + data);
			//System.out.println(attributeName + " " + matcher.group(1));
			
		    return matcher.group(1);
		    
		}
				
		return null;
	}
	
	/**
	 * Returns the BasicBlockData instance built from the JSon passed as parameter.
	 * @param data BasicBlockData JSon string.
	 * @return BasicBlockData instance.
	 */
	private BlockData getBasicBlockData(String data) {
		return new BasicBlockData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)));
	}
	
	/**
	 * Returns the DefPutFuncsData instance built from the JSon passed as parameter.
	 * @param data DefPutFuncsData JSon string.
	 * @return DefPutFuncsData instance.
	 */
	private BlockData getDefPutFuncsData(String data) {
		return new DefPutFuncsData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)), Double.parseDouble(getVal("velocity", data)),
				Double.parseDouble(getVal("acceleration", data)), Integer.parseInt(getVal("velocity_tag", data)), Integer.parseInt(getVal("acceleration_tag", data)));
	}
	
	/**
	 * Returns the GetReadyToPutData instance built from the JSon passed as parameter.
	 * @param data GetReadyToPutData JSon string.
	 * @return GetReadyToPutData instance.
	 */
	private BlockData getGetReadyToPutDataData(String data) {
		return new GetReadyToPutData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)), Double.parseDouble(getVal("velocity", data)),
				Double.parseDouble(getVal("acceleration", data)), Integer.parseInt(getVal("velocity_tag", data)), Integer.parseInt(getVal("acceleration_tag", data)));
	}
	
	/**
	 * Returns the EmptyOperationData instance built from the JSon passed as parameter.
	 * @param data EmptyOperationData JSon string.
	 * @return EmptyOperationData instance.
	 */
	private BlockData getOperationData(String data) {
		return new EmptyOperationData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)), getVal("indentation", data));
	}
	
	/**
	 * Returns the ThreadData instance built from the JSon passed as parameter.
	 * @param data ThreadData JSon string.
	 * @return ThreadData instance.
	 */
	private BlockData getThreadData(String data) {
		return new ThreadData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)), Boolean.parseBoolean(getVal("activateThread", data)));
	}
	
	/**
	 * Returns the SleepData instance built from the JSon passed as parameter.
	 * @param data SleepData JSon string.
	 * @return SleepData instance.
	 */
	private BlockData getSleepData(String data) {
		return new SleepData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)), getVal("indentation", data), Integer.parseInt(getVal("duration", data)));
	}
	
	/**
	 * Returns the PopUpData instance built from the JSon passed as parameter.
	 * @param data PopUpData JSon string.
	 * @return PopUpData instance.
	 */
	private BlockData getPopUpData(String data) {
		return new PopUpData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)),
				getVal("indentation", data), getVal("title", data), getVal("message", data), Boolean.parseBoolean(getVal("isMessage", data)),
				Boolean.parseBoolean(getVal("isWarning", data)), Boolean.parseBoolean(getVal("isError", data)),
				Boolean.parseBoolean(getVal("isBlocking", data)));
	}
	
	/**
	 * Returns the SetDigitalOutputData instance built from the JSon passed as parameter.
	 * @param data SetDigitalOutputData JSon string.
	 * @return SetDigitalOutputData instance.
	 */
	private BlockData getSetDigitalOutputData(String data) {
		return new SetDigitalOutputData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)), getVal("indentation", data), getVal("out", data), getVal("value", data));
	}
	
	/**
	 * Returns the SetAnalogOutputData instance built from the JSon passed as parameter.
	 * @param data SetAnalogOutputData JSon string.
	 * @return SetAnalogOutputData instance.
	 */
	private BlockData getSetAnalogOutputData(String data) {
		return new SetAnalogOutputData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)), getVal("indentation", data), getVal("out", data), getVal("value", data));
	}
}
