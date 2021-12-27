
package com.upc.EasyProduction.panelManagement;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 * This class represents an Option that can be placed in OptionsPanel.
 * @author Enric Lamarca Ferrés
 *
 */
public class Option extends JLabel {
	
	/*
	 * Option name.
	 */
	private String name;
	/*
	 * Width of the Option.
	 */
	private final int WIDTH = 190;
	/**
	 * Height of the Option.
	 */
	private final int HEIGHT = 40;
	
	/**
	 * JLabel that is showed when the Option is Selected. Is the JLabel that is dragged and dropped.
	 */
	private JLabel dragOption;
	
	/**
	 * Constructor.
	 * @param name Option name.
	 */
	public Option(String name){
		
		this.name = name;
		
		initialize();
	}
	
	/**
	 * Initializes some attributes.
	 */
	private void initialize() {
		
		this.dragOption = new JLabel();
		this.dragOption.setText(this.name);
		this.dragOption.setOpaque(true);
		this.dragOption.setVerticalAlignment(JLabel.CENTER);
		this.dragOption.setHorizontalAlignment(JLabel.CENTER);
		this.dragOption.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.dragOption.setSize(new Dimension(WIDTH, HEIGHT));
		this.dragOption.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		this.dragOption.setBackground(Color.LIGHT_GRAY);
		this.dragOption.setVisible(false);
		
		
				
		this.setText(name);
		
		this.setVerticalAlignment(JLabel.CENTER);
		this.setHorizontalAlignment(JLabel.CENTER);
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setSize(new Dimension(WIDTH, HEIGHT));
		
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
				
		this.setOpaque(true);
		
	}
	
	// getters
	
	/**
	 * Getter of the Option name.
	 * @return Option name.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Getter of the JLabel that is showed when the Option is Selected.
	 * @return JLabel that is showed when the Option is Selected.
	 */
	public JLabel getDragLabel() {
		return this.dragOption;
	}	
}