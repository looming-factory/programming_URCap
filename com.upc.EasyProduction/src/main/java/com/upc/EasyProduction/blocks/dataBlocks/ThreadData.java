package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.productionBlocks.threads.Thread;

/**
 * This class represents the data of the Thread block.
 * @author Enric Lamarca Ferrés
 *
 */
public class ThreadData extends BlockData {
	
	/**
	 * Boolean that indicates if the Thread block is activated.
	 */
	private Boolean activateThread = false;
	
	/**
	 * Constructor.
	 * @param className class name of the Thread block.
	 * @param isSelected boolean that indicates if the Thread block is selected.
	 * @param activateThread boolean that indicates if the Thread block is activated.
	 */
	public ThreadData(String className, Boolean isSelected, Boolean activateThread) {
		
		this.className = className; // només per aconseguir instància del bloc
		this.isSelected = isSelected; // s'encarrega el workflow
		this.activateThread = activateThread; // s'ha de fer set d'això a la nova instància
	}
	
	@Override
	public Block getBlockInstance() {
				
		Thread b = (Thread) super.getBlockInstance();
		
		b.setActivateThread(activateThread); // order is important!!
		
		b.setPanel(); // order is important!!
						
		return (Block) b;
	}

}
