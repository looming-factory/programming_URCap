package com.upc.EasyProduction.panelManagement;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.upc.EasyProduction.impl.EasyProductionProgramNodeContribution;
import com.ur.urcap.api.contribution.ContributionProvider;
import com.ur.urcap.api.domain.SystemAPI;
import com.ur.urcap.api.domain.userinteraction.UserInteraction;

/**
 * This class implements the MainPanel.
 * @author Enric Lamarca Ferrés
 *
 */
public class MainPanel extends JLayeredPane{
	
	/**
	 * JPanel in which the parameters panel of the selected Block is placed.
	 */
	private JPanel paramPanel = new JPanel();
	
	/**
	 * Contribution provider.
	 */
	private ContributionProvider<EasyProductionProgramNodeContribution> provider;
	/**
	 * System API.
	 */
	private SystemAPI sysAPI;
	/**
	 * UserInteraction.
	 */
	private UserInteraction userInteraction;
	
	/**
	 * Singleton pattern.
	 */
	private static MainPanel singleton = new MainPanel();
	
	/**
	 * Constructor.
	 */
	private MainPanel() {
		
		this.setLayout(null);
		
		this.add(OptionsPanel.getInstance().getScrollPanel(), JLayeredPane.DEFAULT_LAYER);
		
		this.add(OptionsPanel.getInstance().getDragDropPanel(), JLayeredPane.DRAG_LAYER);
		
		this.add(Workflow.getInstance().getScrollPanel(), JLayeredPane.DRAG_LAYER);
		
		 
		paramPanel.setBounds(200, 254, 405, 149);
		paramPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		this.add(paramPanel, JLayeredPane.DEFAULT_LAYER);
		
		this.setBounds(0, 0, 606, 407);
				
	}
	
	/**
	 * Getter of the singleton instance of this class.
	 * @return singleton instance of this class.
	 */
	public static MainPanel getInstance() {
		return singleton;
	}
	
	/**
	 * Updates the parameters panel.
	 * @param panel new Block parameter panel to place.
	 */
	public void updateParamPanel(JScrollPane panel) {
		paramPanel.removeAll();
		
		paramPanel.setLayout(null);
		paramPanel.add(panel);
		
		paramPanel.revalidate();
		paramPanel.repaint();
		
	}
	
	/**
	 * Empties the parameter panel.
	 */
	public void clearParamPanel() {
		paramPanel.removeAll();
		paramPanel.revalidate();
		paramPanel.repaint();
	}
	
	// setters
	
	/**
	 * Setter of the Contribution Provider.
	 * @param provider Contribution Provider of the node.
	 */
	public void setProvider(ContributionProvider<EasyProductionProgramNodeContribution> provider) {
		this.provider = provider;
		Workflow.getInstance().setProvider(provider);
	}
	
	/**
	 * Setter of the System API.
	 * @param sysAPI System API.
	 */
	public void setSystemAPI(SystemAPI sysAPI) {
		this.sysAPI = sysAPI;
		Workflow.getInstance().setSystemAPI(sysAPI);
	}
	
	/**
	 * Setter of the UserInteraction.
	 * @param userInteraction UserInteraction.
	 */
	public void setUserInteraction(UserInteraction userInteraction){
		this.userInteraction = userInteraction;
		Workflow.getInstance().setUserInteraction(userInteraction);
	}
}
