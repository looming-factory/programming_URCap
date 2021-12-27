
package com.upc.EasyProduction.panelManagement;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import com.upc.EasyProduction.blocks.Block;

/**
 * This class implements the OptionsPanel.
 * @author Enric Lamarca Ferrés
 *
 */
public class OptionsPanel extends JPanel {
	
	/**
	 * JPanel that manages the drag and drop.
	 */
	private JPanel dragDropPanel;
	
	/**
	 * Instance of the inner class.
	 */
	private MouseListener mouseListener;
	
	/**
	 * List of Options in OptionsPanel.
	 */
	private LinkedList<Option> options;
	
	/**
	 * Scroll pane that makes OptionsPanel scrollable.
	 */
	private JScrollPane scroll;
	
	/**
	 * Workflow singleton instance.
	 */
	private Workflow wf;
	
	/**
	 * GridBagConstraints of the GridBagLayout.
	 */
	private GridBagConstraints c = new GridBagConstraints();
	
	/**
	 * Auxiliary boolean used when a new Option is added in the OptionsPanel.
	 */
	private boolean count = false;
	
	// singleton
	/**
	 * Singleton pattern.
	 */
	private static OptionsPanel singleton = new OptionsPanel();
	
	/**
	 * Constructor.
	 */
	private OptionsPanel() {
		
		this.wf = Workflow.getInstance();
		
		initialize();
		
		addDefaultOptions();
		
		scroll = new JScrollPane(this);
		
		scroll.setPreferredSize(new Dimension(406, 254));
		scroll.setSize(new Dimension(406, 254));
		scroll.setLocation(200, 0);
				
	}
	
	/**
	 * Getter of the singleton instance of this class.
	 * @return singleton instance of this class.
	 */
	public static OptionsPanel getInstance() {
		return singleton;
	}
	
	// end singleton
	
	/**
	 * Initializes some attributes.
	 */
	private void initialize() {
		
		mouseListener = new MouseListener();
		
		options = new LinkedList();
		
		// this JPanel which contains the different options
		
		this.setLayout(new GridBagLayout());
		
		//this.setSize(400, 400);
		//this.setPreferredSize(new Dimension(400, 400)); // 406x407
		
		this.setLocation(200, 0);
				
		// aux JPanel which is used for drag and drop
		
		dragDropPanel = new JPanel();
		dragDropPanel.setLayout(null);
		
		dragDropPanel.setSize(606, 407);
		dragDropPanel.setPreferredSize(new Dimension(606, 407));
		dragDropPanel.setOpaque(false);
		dragDropPanel.setLocation(0, 0);
		
	}
	
	/**
	 * Adds default Options.
	 */
	private void addDefaultOptions() {
		
		addOption("Sleep");
		addOption("PopUp");
		addOption("SetDigitalOutput");
		addOption("SetAnalogOutput");
		
	}
	
	// getters
	
	/**
	 * Getter of the scrollable OptionsPanel.
	 * @return scrollable OptionsPanel.
	 */
	public JScrollPane getScrollPanel() {
		return scroll;
	}
	
	/**
	 * Getter of the drag and drop panel.
	 * @return JPanel that manages the drag and drop.
	 */
	public JPanel getDragDropPanel() {
		return dragDropPanel;
	}
	
	// methods
	
	/**
	 * Adds a new Option in the OptionsPanel.
	 * @param name name of the new Option.
	 */
	private void addOption(String name) {
		
		Option opt = new Option(name);
		
		
		opt.getDragLabel().addMouseListener(mouseListener);
		opt.getDragLabel().addMouseMotionListener(mouseListener);
		
		opt.addMouseListener(mouseListener);
		
		if(count) {
			c.gridx = GridBagConstraints.RELATIVE;
			c.gridwidth = GridBagConstraints.REMAINDER;
		}
		else {
			c.gridx = 0; // eye!! xd
			c.gridwidth = 1;
		}
		
		count = !count;
		
		this.add(opt, c);
		
		dragDropPanel.add(opt.getDragLabel());
		
		options.add(opt);
	}
	
	
	// inner classes
	
	/**
	 * This class extends MouseAdapter.
	 * @author Enric Lamarca Ferrés
	 *
	 */
	private class MouseListener extends MouseAdapter {
		
		/**
		 * Internal use.
		 */
		private int prevX;
		/**
		 * Internal use.
		 */
		private int prevY;
		/**
		 * Horizontal offset OptionsPanel.
		 */
		private int offsetOptionsPanelX = 201; // ULL!!
		/**
		 * Vertical offset OptionsPanel.
		 */
		private int offsetOptionsPanelY = 1; // ULL!!
		
		/**
		 * Current Option selected.
		 */
		private Option currentOptionSelected;
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			if (e.getSource() instanceof Option) {
				
				Option opt = (Option) e.getSource();
				
				if (currentOptionSelected != null) {
					currentOptionSelected.getDragLabel().setVisible(false);
				}
				
				opt.getDragLabel().setVisible(true);
				
				opt.getDragLabel().setLocation(opt.getLocation().x + offsetOptionsPanelX, opt.getLocation().y + offsetOptionsPanelY);
				
				currentOptionSelected = opt;
			}
			
			//System.out.println("clicked" + " " + (e.getSource() instanceof Option));
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
						
			prevX = e.getX();
			prevY = e.getY();
				
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			
			JComponent jc = (JComponent) e.getSource();
			int difX = e.getX() - prevX;
			int difY = e.getY() - prevY;
	        jc.setLocation(jc.getLocation().x + difX, jc.getLocation().y + difY);
	        			
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			
			if (!(e.getSource() instanceof Option)) {
				JLabel draggedLabel = (JLabel) e.getSource();
				draggedLabel.setVisible(false);
				
				// detect in which block of the workflow the mouse has been released
												
				//System.out.println(((Block) wf.findComponentAt(OptionsPanel.getInstance().getDragDropPanel().getMousePosition(true))).getWorkflowPosition());
				
				// in this way works in Polyscope...
				PointerInfo a = MouseInfo.getPointerInfo();
				Point point = new Point(a.getLocation());
				SwingUtilities.convertPointFromScreen(point, wf);
				
				
				Component target = wf.findComponentAt(point);
				
				if (target != null && target instanceof Block) {
					wf.addBlock(draggedLabel.getText(), ((Block)target).getWorkflowPosition());
				}
				
			}
			
			//System.out.println("released");
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			//System.out.println("entered"+ ((JLabel)e.getSource()).getText());
		}
	}
	
}