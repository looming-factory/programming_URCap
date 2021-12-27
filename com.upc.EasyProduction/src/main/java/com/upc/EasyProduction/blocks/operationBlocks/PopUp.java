package com.upc.EasyProduction.blocks.operationBlocks;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.PopUpData;
import com.upc.EasyProduction.panelManagement.Workflow;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardInputCallback;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardTextInput;

/**
 * This class represents the PopUp block.
 * @author Enric Lamarca Ferrés
 *
 */
public class PopUp extends Operation implements ActionListener{
	
	/**
	 * Title JLabel of the parameters panel.
	 */
	private JLabel titleLabel = new JLabel("Title");
	/**
	 * Message JLabel of the parameters panel.
	 */
	private JLabel messageLabel = new JLabel("Message");
	
	/**
	 * Title JTextField of the parameters panel.
	 */
	private JTextField titleField = new JTextField();
	/**
	 * Message JTextField of the parameters panel.
	 */
	private JTextField messageField = new JTextField();
	
	/**
	 * Message JRadioButton of the parameters panel.
	 */
	private JRadioButton messageButton = new JRadioButton("Message");
	/**
	 * Warning JRadioButton of the parameters panel.
	 */
	private JRadioButton warningButton = new JRadioButton("Warning");
	/**
	 * Error JRadioButton of the parameters panel.
	 */
	private JRadioButton errorButton = new JRadioButton("Error");
	/**
	 * Blocking JRadioButton of the parameters panel.
	 */
	private JRadioButton blockingButton = new JRadioButton("Blocking");
	
	/**
	 * Title of the popup.
	 */
	private String title = "";
	/**
	 * Message of the popup.
	 */
	private String message = "";
	
	/**
	 * Boolean that indicates if the popup is a message.
	 */
	private boolean isMessage = true;
	/**
	 * Boolean that indicates if the popup is a warning.
	 */
	private boolean isWarning = false;
	/**
	 * Boolean that indicates if the popup is an error.
	 */
	private boolean isError = false;
	/**
	 * Boolean that indicates if the popup is blocking.
	 */
	private boolean isBlocking = false;
	
	/**
	 * Auxiliary boolean that is used to avoid updating the contribution DataModel when it is not the intention.
	 */
	private boolean controlUpdateDataModel = true;
	
	/**
	 * Constructor.
	 */
	public PopUp() {
				
		defaultCode = "popup(\"Demo message\")";
		
		name = "PopUp"; // can be whatever
				
		this.setText(name);
		
		// param panel
		
		titleField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				KeyboardTextInput keyboardInput = Workflow.getInstance().getUserInteraction().getKeyboardInputFactory().createStringKeyboardInput().setInitialValue(title);
				keyboardInput.show(titleField, new KeyboardInputCallback<String>() {
					
					@Override
					public void onOk(String value) {
						
						title = value;
						titleField.setText(value);
						
						if (controlUpdateDataModel) {
							Workflow.getInstance().updateDataModel(new int[] {wfPos});
						}
						
					}
				});
			}
		});
		
		titleField.setPreferredSize(new Dimension(300, titleField.getPreferredSize().height));
		
		messageField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				KeyboardTextInput keyboardInput = Workflow.getInstance().getUserInteraction().getKeyboardInputFactory().createStringKeyboardInput().setInitialValue(message);
				keyboardInput.show(messageField, new KeyboardInputCallback<String>() {
					
					@Override
					public void onOk(String value) {
						
						message = value;
						messageField.setText(value);
						
						if (controlUpdateDataModel) {
							Workflow.getInstance().updateDataModel(new int[] {wfPos});
						}
						
					}
				});
			}
		});
		
		messageField.setPreferredSize(new Dimension(300, messageField.getPreferredSize().height));
		
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.ipadx = 5;
		c.ipady = 5;
		
		c.gridheight = 1;
		c.gridwidth = 1;
		
		c.gridx = 0;
		c.gridy = 0;
		
		panel.add(titleLabel, c);
		
		c.gridheight = 1;
		c.gridwidth = 4;
		
		c.gridx = 1;
		c.gridy = 0;
		
		panel.add(titleField, c);
		
		c.gridheight = 1;
		c.gridwidth = 1;
		
		c.gridx = 0;
		c.gridy = 1;
		
		panel.add(messageLabel, c);
		
		
		c.gridheight = 1;
		c.gridwidth = 4;
		
		c.gridx = 1;
		c.gridy = 1;
		
		panel.add(messageField, c);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		buttonGroup.add(messageButton);
		buttonGroup.add(warningButton);
		buttonGroup.add(errorButton);
		
		messageButton.addActionListener(this);
		warningButton.addActionListener(this);
		errorButton.addActionListener(this);
		blockingButton.addActionListener(this);
		
		c.gridheight = 1;
		c.gridwidth = 1;
		
		c.gridx = 1;
		c.gridy = 2;
		
		messageButton.setSelected(true);
		
		panel.add(messageButton, c);
		
		c.gridheight = 1;
		c.gridwidth = 1;
		
		c.gridx = 2;
		c.gridy = 2;
		
		panel.add(warningButton, c);
		
		c.gridheight = 1;
		c.gridwidth = 1;
		
		c.gridx = 3;
		c.gridy = 2;
		
		panel.add(errorButton, c);
		
		c.gridheight = 1;
		c.gridwidth = 1;
		
		c.gridx = 0;
		c.gridy = 3;
		
		
		panel.add(blockingButton, c);
		
	}
	
	@Override
	public String generateCode() {
		
		String auxIsWarning = String.valueOf(isWarning).substring(0, 1).toUpperCase() + String.valueOf(isWarning).substring(1);
		String auxIsError = String.valueOf(isError).substring(0, 1).toUpperCase() + String.valueOf(isError).substring(1);
		String auxIsBlocking = String.valueOf(isBlocking).substring(0, 1).toUpperCase() + String.valueOf(isBlocking).substring(1);
		
		code = "popup(" + "\"" + message + "\"" + ", title=" + "\"" + title + "\"" + ", warning=" + auxIsWarning +
				", error=" + auxIsError + ", blocking=" + auxIsBlocking + ")\n";
		
		return "\n" + indentation + code;
	}
	
	@Override
	public BlockData getBlockData() {
		return new PopUpData(getClassName(), isSelected, indentation, title, message, isMessage, isWarning, isError, isBlocking);
	}
	
	@Override
	public void setPanel() {
		
		controlUpdateDataModel = false; // per evitar que faci update de la datamodel al fer setValue...
		
		messageButton.setSelected(isMessage); // diria que no fan action event però per si de cas
		warningButton.setSelected(isWarning);
		errorButton.setSelected(isError);
		blockingButton.setSelected(isBlocking);
		
		titleField.setText(title);
		messageField.setText(message);

		controlUpdateDataModel = true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JRadioButton source = (JRadioButton) e.getSource();
		if (source != blockingButton) {
			isMessage = (source == messageButton);
			isWarning = (source == warningButton);
			isError = (source == errorButton);
		}
		else {
		isBlocking = !isBlocking;
		}
		
		if (controlUpdateDataModel) {
			Workflow.getInstance().updateDataModel(new int[] {wfPos});
		}
	}
	
	// setters
	
	/**
	 * Setter of the message text.
	 * @param message message text.
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * Setter of the title text.
	 * @param title title text.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * Setter of the boolean that indicates if the popup is a message.
	 * @param isMessage boolean that indicates if the popup is a message.
	 */
	public void setIsMessage(boolean isMessage) {
		this.isMessage = isMessage;
	}
	/**
	 * Setter of the boolean that indicates if the popup is a warning.
	 * @param isWarning boolean that indicates if the popup is a warning.
	 */
	public void setIsWarning(boolean isWarning) {
		this.isWarning = isWarning;
	}
	/**
	 * Setter of the boolean that indicates if the popup is an error.
	 * @param isError boolean that indicates if the popup is an error.
	 */
	public void setIsError(boolean isError) {
		this.isError = isError;
	}
	/**
	 * Setter of the boolean that indicates if the popup is blocking.
	 * @param isBlocking boolean that indicates if the popup is blocking
	 */
	public void setIsBlocking(boolean isBlocking) {
		this.isBlocking = isBlocking;
	}
	
}
