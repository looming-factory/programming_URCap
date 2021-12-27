package com.upc.EasyProduction.blocks.operationBlocks;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.SetAnalogOutputData;
import com.upc.EasyProduction.blocks.dataBlocks.SetDigitalOutputData;
import com.upc.EasyProduction.panelManagement.Workflow;

/**
 * This class represents the SetAnalogOutput block.
 * @author Enric Lamarca Ferrés
 *
 */
public class SetAnalogOutput extends Operation implements ActionListener, ChangeListener{
	
	/**
	 * Out 0 JRadioButton of the parameters panel.
	 */
	private JRadioButton out0 = new JRadioButton("0");
	/**
	 * Out 1 JRadioButton of the parameters panel.
	 */
	private JRadioButton out1 = new JRadioButton("1");
	
	/**
	 * Outs JLabel of the parameters panel.
	 */
	private JLabel outsLabel = new JLabel("Select analog output:");
	/**
	 * Value JLable of the parameters panel.
	 */
	private JLabel valueLabel = new JLabel("Select value (1.0 = 10v or 20mA, see I/O tab): 0.50");
	
	/**
	 * Value JSLider of the parameters panel.
	 */
	private JSlider valueSlider = new JSlider();
	/**
	 * Used to put labels in the value slider.
	 */
	private Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
	
	/**
	 * Selected out.
	 */
	private String out = "0";
	/**
	 * Value.
	 */
	private String value = "0.50"; // false -> low, true -> high
	
	/**
	 * Auxiliary boolean that is used to avoid updating the contribution DataModel when it is not the intention.
	 */
	private boolean controlUpdateDataModel = true;
	
	/**
	 * Constructor.
	 */
	public SetAnalogOutput() {
		
		defaultCode = "set_standard_analog_out(0, 0.50)";
		
		name = "SetAnalogOutput"; // can be whatever
				
		this.setText(name);
		
		// param panel
		
		valueSlider.setMinimum(0);
		valueSlider.setMaximum(100);
		
		// abans de posar listener així que no cal controlUpdateDataModel
		valueSlider.setValue(50);
		
		valueSlider.addChangeListener(this);
		
		valueSlider.setMajorTickSpacing(50);
		valueSlider.setPaintTicks(true);
		
		labelTable.put(0, new JLabel("0.00"));
		labelTable.put(50, new JLabel("0.50"));
		labelTable.put(100, new JLabel("1.00"));
		
		valueSlider.setLabelTable(labelTable);
		
		valueSlider.setPaintLabels(true);
		
		//__
		
		out0.setSelected(true);
		
		out0.addActionListener(this);
		out1.addActionListener(this);
		
		out0.setAlignmentX(JRadioButton.CENTER_ALIGNMENT);
		out1.setAlignmentX(JRadioButton.CENTER_ALIGNMENT);
		
		ButtonGroup buttonGroup1 = new ButtonGroup();
		ButtonGroup buttonGroup2 = new ButtonGroup();
		
		buttonGroup1.add(out0);
		buttonGroup1.add(out1);
		
		
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.ipady = 10;
		
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		
		panel.add(outsLabel, c);
		
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		
		panel.add(valueLabel, c);
		
		c.gridwidth = 1;
		
		c.gridx = 0;
		c.gridy = 1;
		
		panel.add(out0, c);
		
		c.gridx = 1;
		c.gridy = 1;
		
		panel.add(out1, c);
		
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 3;
		
		panel.add(valueSlider, c);
		
		
	}
	
	@Override
	public String generateCode() {
		code = "set_standard_analog_out(" + out + ", " + value + ")\n";
		
		return "\n" + indentation + code;
	}
	
	@Override
	public BlockData getBlockData() {
		return new SetAnalogOutputData(getClassName(), isSelected, indentation, out, value);
	}
	
	@Override
	public void setPanel() {
		
		controlUpdateDataModel = false; // per evitar que faci update de la datamodel al fer setValue...
		
		out0.setSelected(out.equals("0"));
		out1.setSelected(out.equals("1"));
		
		valueSlider.setValue((int)(Float.parseFloat(value) * 100));
						
		controlUpdateDataModel = true;
	}

	@Override
	public void actionPerformed(ActionEvent e) { // radioButtons
		
		JRadioButton source = (JRadioButton) e.getSource();
		
		if (source == out0) {
			out = "0";
		}
		else if(source == out1) {
			out = "1";
		}
		
		if (controlUpdateDataModel) {
			Workflow.getInstance().updateDataModel(new int[] {wfPos});
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) { // slider
		
		JSlider source = (JSlider) e.getSource();
		
		if (!source.getValueIsAdjusting()) { 
			
			value = String.valueOf((float)source.getValue()/(100.0));
			
			valueLabel.setText("Select value (1.0 = 10v or 20mA, see I/O tab): " + value);
			
			if (controlUpdateDataModel) {
				Workflow.getInstance().updateDataModel(new int[] {wfPos});
			}
		}
		
	}
	
	// setters
	
	/**
	 * Setter of the selected out.
	 * @param out selected out.
	 */
	public void setOut(String out) {
		this.out = out;
	}
	
	/**
	 * Setter of the value.
	 * @param value value of the out.
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
