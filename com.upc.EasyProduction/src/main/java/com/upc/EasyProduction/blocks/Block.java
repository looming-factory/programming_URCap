package com.upc.EasyProduction.blocks;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.upc.EasyProduction.blocks.operationBlocks.Operation;
import com.upc.EasyProduction.panelManagement.MainPanel;
import com.upc.EasyProduction.panelManagement.Workflow;

/**
 * This class represents a block of the workflow.
 * 
 * @author Enric Lamarca Ferrés
 *
 */
public class Block extends JLabel{
	
	/**
	 * Name of the block.
	 */
	protected String name;
	/**
	 * Default code of the block.
	 */
	protected String defaultCode;
	/**
	 * Code generated with the parameters of the block.
	 */
	protected String code;
	/**
	 * Indentation of the block.
	 */
	protected String indentation = "";
	
	/**
	 * Parameter panel of the block.
	 */
	protected JPanel panel = new JPanel();
	/**
	 * Scroll parameter panel of the block.
	 */
	protected JScrollPane scroll = new JScrollPane(panel);
	
	/**
	 * Instance of the inner class.
	 */
	protected MouseListener mouseListener = new MouseListener();
	
	/**
	 * Width of the label that represents the block.
	 */
	protected final int WIDTH = 180;
	/**
	 * Height of the label that represents the block.
	 */
	protected final int HEIGHT = 40;
	
	/**
	 * Workflow position of the block.
	 */
	protected int wfPos = -1;
	
	/**
	 * Boolean that indicates if the block is selected in the workflow.
	 */
	protected Boolean isSelected = false;
		
	
	/**
	 * Constructor.
	 */
	public Block() {

		scroll.setBounds(0, 0, 406, 150);		
		
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
		
		setOpaque(true);
		setVerticalAlignment(JLabel.CENTER);
		setHorizontalAlignment(JLabel.CENTER);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setSize(new Dimension(WIDTH, HEIGHT));
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		setBackground(Color.LIGHT_GRAY);
				
	}
	
	
	// getters
	
	/**
	 * Getter of the block name.
	 * @return name of the block.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter of the block default code.
	 * @return default code of the block.
	 */
	public String getDefaultCode() {
		return defaultCode;
	}
	
	/**
	 * Generates the code with the parameters of the block.
	 * @return code generated with the parameters of the block.
	 */
	public String generateCode() {
		code = "";
		
		return code;
	}
	
	/**
	 * Getter of the block generated code.
	 * @return code generated with the parameters of the block.
	 */
	public String getCode() {
		return generateCode();
	}
	
	/**
	 * Getter of the block indentation.
	 * @return indentation of the block.
	 */
	public String getIndentation() {
		return indentation;
	}
	
	/**
	 * Getter of the block workflow position.
	 * @return workflow position of the block.
	 */
	public int getWorkflowPosition() {
		return wfPos;
	}
	
	/**
	 * Getter of the BlockData instance of the block.
	 * @return a new instance of BlockData.
	 */
	public BlockData getBlockData() { // EYE!!!!
		return null;
	}
	
	/**
	 * Getter of the class name.
	 * @return class name.
	 */
	public String getClassName() {
		return this.getClass().getName();
	}
	
	/**
	 * Getter of the block boolean that indicates if the block is selected or not.
	 * @return boolean that indicates if the block is selected or not.
	 */
	public Boolean getIsSelected() {
		return isSelected;
	}
	
	
	// setters
	
	/**
	 * Setter of the block workflow position.
	 * @param pos position of the block in the workflow.
	 */
	public void setWorkflowPosition(int pos) {
		wfPos = pos;
	}
	
	/**
	 * Setter of the block indentation.
	 * @param indentation indentation of the block.
	 */
	public void setIndentation(String indentation) {
		this.indentation = indentation;
	}
	
	/**
	 * Setter of the boolean that indicates if the block is selected in the workflow.
	 * @param isSelected boolean that indicates if the block is selected in the workflow.
	 */
	public void setIsSelected(Boolean isSelected) {
		
		this.isSelected = isSelected;
		
		if (isSelected) {
			
			MainPanel.getInstance().updateParamPanel(scroll);
			selectBlock();
		}
		else {
			unselectBlock();
		}
	}
	
	/**
	 * Updates the block parameters panel to show the correct visualization that corresponds to the current parameters of the block.
	 */
	public void setPanel() {}
	
	
	// methods
	
	/**
	 * Selects the block.
	 */
	protected void selectBlock() {
		this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		isSelected = true;
	}
	
	/**
	 * Unselects the block.
	 */
	protected void unselectBlock() {
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
		isSelected = false;
	}
	
	
	// inner class
	
	/**
	 * Class that extends MouseAdapter.
	 * 
	 * @author Enric Lamarca Ferrés
	 *
	 */
	protected class MouseListener extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) { // select block
						
			Block b = (Block) e.getSource();
			
			// save position of the selected block before the change
			int beforeSelectedBlockPos = Workflow.getInstance().getCurrentSelectedBlockPos();
				
			Workflow.getInstance().setSelectedBlock(b);
			
			Workflow.getInstance().updateDataModel(new int[]{wfPos, beforeSelectedBlockPos});
			
		}
		
		@Override
		public void mouseDragged(MouseEvent e) { // delete block
			
			if (e.getSource() instanceof Operation) {
				
				Workflow wf = Workflow.getInstance();
				
				wf.deleteBlock(((Block)e.getSource()).getWorkflowPosition());
				
			}
	        			
		}
	}
}
