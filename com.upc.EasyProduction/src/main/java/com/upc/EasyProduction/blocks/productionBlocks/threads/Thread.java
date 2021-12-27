package com.upc.EasyProduction.blocks.productionBlocks.threads;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JToggleButton;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.ThreadData;
import com.upc.EasyProduction.panelManagement.Workflow;

/**
 * This class represents the Thread block.
 * @author Enric Lamarca Ferrés
 *
 */
public class Thread extends Block implements ItemListener {
	
	/**
	 * Activate Thread JToggleButton of the parameters panel.
	 */
	private JToggleButton toggleButton = new JToggleButton("Activate Thread", false);
	
	/*
	 * Boolean that indicates if the thread is activated.
	 */
	protected boolean activateThread = false;
	
	/**
	 * Auxiliary boolean that is used to avoid updating the contribution DataModel when it is not the intention.
	 */
	private boolean controlUpdateDataModel = true;
	
	/**
	 * Constructor.
	 */
	public Thread() {
		
		this.setBackground(new Color(0xd3caca));
		
		// param panel
		
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridwidth = 3;
		c.gridheight = 3;
		
		c.gridx = 1;
		c.gridy = 1;
		
		toggleButton.addItemListener(this);
				
		this.setEnabled(false);
		
		panel.add(toggleButton, c);
	}
	
	@Override
	public BlockData getBlockData() {
		return new ThreadData(getClassName(), isSelected, activateThread);
	}
	
	@Override
	public void setPanel() {
		
		controlUpdateDataModel = false;
		
		toggleButton.setSelected(activateThread); // this does not trigger an action event
		this.setEnabled(activateThread);
		
		controlUpdateDataModel = true;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		int state = e.getStateChange();
		
		if (state == ItemEvent.SELECTED) {
			activateThread = true;
			this.setEnabled(true);
		}
		else {
			activateThread = false;
			
			this.setEnabled(false);
		}
		
		if(controlUpdateDataModel) {
			Workflow.getInstance().updateDataModel(new int[] {wfPos});
		}
	}
	
	// setters
	/**
	 * Setter of the boolean that indicates if the thread is activated.
	 * @param activateThread boolean that indicates if the thread is activated.
	 */
	public void setActivateThread(Boolean activateThread) {
		this.activateThread = activateThread;
	}
}
