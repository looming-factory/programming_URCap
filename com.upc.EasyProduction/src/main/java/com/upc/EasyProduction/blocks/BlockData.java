package com.upc.EasyProduction.blocks;

/**
 * 
 * This class is the superclass of the classes that represent the data of a block.
 * 
 * @author Enric Lamarca Ferrés
 *
 */
public class BlockData{
	
	/**
	 * Class name of the corresponding block class.
	 */
	protected String className;
	
	/**
	 * Boolean that indicates if the block is selected or not.
	 */
	protected Boolean isSelected = false;
	
	/**
	 * Getter of the class name.	
	 * @return class name.
	 */
	public String getClassName() {
		return className;
	}
	
	/**
	 * Getter of the corresponding block instance (with the corresponding parameters).
	 * @return the corresponding block instance.
	 */
	public Block getBlockInstance() {
		
		Block b = null;
		
		try {
			
			b = (Block) Class.forName(className).getDeclaredConstructor().newInstance();
			
			b.setIsSelected(isSelected);
			
		}
		catch (Exception e) {
			
			System.out.println(e.toString());
			
		}
		
		return b;
	}
}
