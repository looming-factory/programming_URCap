package com.upc.EasyProduction.blocks.productionBlocks.defFuncs;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.DefPutFuncsData;
import com.upc.EasyProduction.panelManagement.Workflow;


/**
 * This class represents the DefPutFuncs block.
 * @author Enric Lamarca Ferrés
 *
 */
public class DefPutFuncs extends Block implements ChangeListener{
	
	/**
	 * Default level velocity of the robot movement to the approximation point that defines the function.
	 */
	private final Double DEFAULT_VELOCITY = 4.363323129985823;
	/**
	 * Default level acceleration of the robot movement to the approximation point that defines the function.
	 */
	private final Double DEFAULT_ACCELERATION = 8.726646259971647;
	
	/**
	 * Slow level velocity of the robot movement to the approximation point that defines the function.
	 */
	private final Double SLOW_VELOCITY = DEFAULT_VELOCITY/2.0;
	/**
	 * Slow level acceleration of the robot movement to the approximation point that defines the function.
	 */
	private final Double SLOW_ACCELERATION = DEFAULT_ACCELERATION/2.0;
	
	/**
	 * Ultra slow level velocity of the robot movement to the approximation point that defines the function.
	 */
	private final Double ULTRA_SLOW_VELOCITY = DEFAULT_VELOCITY/8.0;
	/**
	 * Ultra slow level acceleration of the robot movement to the approximation point that defines the function.
	 */
	private final Double ULTRA_SLOW_ACCELERATION = DEFAULT_ACCELERATION/8.0;
	
	/**
	 * Velocity of the robot movement to the approximation point that defines the function.
	 */
	protected Double velocity = DEFAULT_VELOCITY;
	/**
	 * Acceleration of the robot movement to the approximation point that defines the function.
	 */
	protected Double acceleration = DEFAULT_ACCELERATION;
	
	/**
	 * Velocity tag (0 corresponds to ultra slow level, 1 corresponds to slow level and 2 corresponds to default level).
	 */
	protected int velocity_tag = 2; // evitar errors de precisió
	/**
	 * Acceleration tag (0 corresponds to ultra slow level, 1 corresponds to slow level and 2 corresponds to default level).
	 */
	protected int acceleration_tag = 2;
	
	/**
	 * Velocity JSlider of the parameters panel.
	 */
	private JSlider velocitySlider = new JSlider(JSlider.HORIZONTAL, 0, 2, 2);
	/**
	 * Acceleration JSlider of the parameters panel.
	 */
	private JSlider accelerationSlider = new JSlider(JSlider.HORIZONTAL, 0, 2, 2);
	
	/**
	 * Used to put labels in the sliders of the parameters panel.
	 */
	private Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
	/**
	 * Ultra slow level JLabel of the parameters panel.
	 */
	private JLabel ultraSlowLabel = new JLabel("UltraSlow");
	/**
	 * Slow level JLabel of the parameters panel.
	 */
	private JLabel slowLabel = new JLabel("Slow");
	/**
	 * Default level JLabel of the parameters panel.
	 */
	private JLabel defaultLabel = new JLabel("Default");
	
	/**
	 * Velocity JLabel of the parameters panel.
	 */
	private JLabel velocityLabel = new JLabel("Velocity");
	/**
	 * Acceleration JLabel of the parameters panel.
	 */
	private JLabel accelerationLabel = new JLabel("Acceleration");
	
	/**
	 * Auxiliary boolean that is used to avoid updating the contribution DataModel when it is not the intention.
	 */
	private boolean controlUpdateDataModel = true;
	
	/**
	 * Constructor.
	 */
	public DefPutFuncs() {
		
		panel.setLayout(new GridLayout(0, 1, 0, -5));
		// vertical gap -5 perquè sinó, no sé per què, es solapa amb el punter de slider...
		
		Font labelFont = ultraSlowLabel.getFont();
		
		velocityLabel.setHorizontalAlignment(JLabel.CENTER);
		accelerationLabel.setHorizontalAlignment(JLabel.CENTER);
		
		
		ultraSlowLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 10));
		slowLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 10));
		defaultLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 10));
		
		// velocity
		
		velocitySlider.addChangeListener(this);
		velocitySlider.setMajorTickSpacing(1);
		velocitySlider.setPaintTicks(true);
		
		labelTable.put(0, ultraSlowLabel);
		labelTable.put(1, slowLabel);
		labelTable.put(2, defaultLabel);
		
		velocitySlider.setLabelTable(labelTable);
		
		velocitySlider.setPaintLabels(true);
		
		// acceleration
		
		accelerationSlider.addChangeListener(this);
		accelerationSlider.setMajorTickSpacing(1);
		accelerationSlider.setPaintTicks(true);
		
		accelerationSlider.setLabelTable(labelTable);
		
		accelerationSlider.setPaintLabels(true);
		
		// param panel
		
		panel.add(velocityLabel);
		panel.add(velocitySlider);
		panel.add(accelerationLabel);
		panel.add(accelerationSlider);
		
	}
	
	@Override
	public BlockData getBlockData() {
		return new DefPutFuncsData(getClassName(), isSelected, velocity, acceleration, velocity_tag, acceleration_tag);
	}
	
	@Override
	public void setPanel() {
		
		controlUpdateDataModel = false; // per evitar que faci update de la datamodel al fer setValue...
		
		velocitySlider.setValue(velocity_tag);
		accelerationSlider.setValue(acceleration_tag);
				
		controlUpdateDataModel = true;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		JSlider source = (JSlider)e.getSource();
		
		if (!source.getValueIsAdjusting()) { // IMPORTANT!!
		
			if (source == velocitySlider) {
				switch (velocitySlider.getValue()) {
				case 0:
					velocity = ULTRA_SLOW_VELOCITY;
					velocity_tag = 0;
					break;
				case 1:
					velocity = SLOW_VELOCITY;
					velocity_tag = 1;
					break;
				case 2:
					velocity = DEFAULT_VELOCITY;
					velocity_tag = 2;
					break;
				default:
					velocity = DEFAULT_VELOCITY;
					break;
				}
			}
			else { // acceleration
				
				switch (accelerationSlider.getValue()) {
				case 0:
					acceleration = ULTRA_SLOW_ACCELERATION;
					acceleration_tag = 0;
					break;
				case 1:
					acceleration = SLOW_ACCELERATION;
					acceleration_tag = 1;
					break;
				case 2:
					acceleration = DEFAULT_ACCELERATION;
					acceleration_tag = 2;
					break;
				default:
					acceleration = DEFAULT_ACCELERATION;
					break;
				}
				
			}
			
			if (controlUpdateDataModel) {
				Workflow.getInstance().updateDataModel(new int[] {wfPos});
			}
		}
		
	}
	
	// setters
	
	/**
	 * Setter of the velocity.
	 * @param velocity velocity value.
	 * @param velocity_tag the correspondent velocity tag.
	 */
	public void setVelocity(Double velocity, int velocity_tag) {
		this.velocity = velocity;
		this.velocity_tag = velocity_tag;
	}
	
	/**
	 * Setter of the acceleration.
	 * @param acceleration acceleration value.
	 * @param acceleration_tag the correspondent acceleration tag.
	 */
	public void setAcceleration(Double acceleration, int acceleration_tag) {
		this.acceleration = acceleration;
		this.acceleration_tag = acceleration_tag;
	}

}
