package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.operationBlocks.PopUp;

/**
 * This class represents the data of the PopUp block.
 * 
 * @author Enric Lamarca Ferrés
 *
 */
public class PopUpData extends BlockData{
	
	/**
	 * Indentation of the PopUP block.
	 */
	private String indentation;
	
	/**
	 * Title of the PopUp block.
	 */
	private String title;
	/**
	 * Message of the PopUp block.
	 */
	private String message;
	
	/**
	 * boolean that indicates if the PopUp block is a message.
	 */
	private boolean isMessage;
	/**
	 * boolean that indicates if the PopUp block is a warning.
	 */
	private boolean isWarning;
	/**
	 * boolean that indicates if the PopUp block is an error.
	 */
	private boolean isError;
	/**
	 * boolean that indicates if the PopUp block is blocking.
	 */
	private boolean isBlocking;
	
	/**
	 * Constructor.
	 * @param className class name of the PopUp block.
	 * @param isSelected boolean that indicates if the PopUp block is selected.
	 * @param indentation indentation of the PopUp block.
	 * @param title title of the PopUp block.
	 * @param message message of the PopUp block.
	 * @param isMessage boolean that indicates if the PopUp block is a message.
	 * @param isWarning boolean that indicates if the PopUp block is a warning.
	 * @param isError boolean that indicates if the PopUp block is an error.
	 * @param isBlocking boolean that indicates if the PopUp block is blocking.
	 */
	public PopUpData(String className, Boolean isSelected, String indentation, String title, String message, boolean isMessage, boolean isWarning, boolean isError, boolean isBlocking) {
		
		this.className = className;
		this.isSelected = isSelected;
		
		this.indentation = indentation;
		
		this.title = title;
		this.message = message;
		this.isMessage = isMessage;
		this.isWarning = isWarning;
		this.isError = isError;
		this.isBlocking = isBlocking;
	}
	
	@Override
	public Block getBlockInstance() {
				
		PopUp b = (PopUp) super.getBlockInstance();
		
		b.setIndentation(indentation);
		
		b.setTitle(title);
		b.setMessage(message);
		b.setIsMessage(isMessage);
		b.setIsWarning(isWarning);
		b.setIsError(isError);
		b.setIsBlocking(isBlocking);
		
		b.setPanel();
				
		return (Block) b;
	}

}
