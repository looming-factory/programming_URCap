package com.upc.EasyProduction.impl;

import java.util.Locale;

import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.program.ContributionConfiguration;
import com.ur.urcap.api.contribution.program.CreationContext;
import com.ur.urcap.api.contribution.program.ProgramAPIProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeService;
import com.ur.urcap.api.domain.data.DataModel;
/**
 * This class implements the service of the program node.
 * @author Enric Lamarca Ferrés.
 *
 */
public class EasyProductionProgramNodeService implements SwingProgramNodeService<EasyProductionProgramNodeContribution, EasyProductionProgramNodeView>{

	@Override
	public String getId() {
		return "EasyProductionNode";
	}

	@Override
	public void configureContribution(ContributionConfiguration configuration) {
		configuration.setChildrenAllowed(false);
	}

	@Override
	public String getTitle(Locale locale) {
		// locale is used to know language of the system
		return "Easy Production";
	}

	@Override
	public EasyProductionProgramNodeView createView(ViewAPIProvider apiProvider) {
		// View API Provider provides access to the system API and user interface API
		return new EasyProductionProgramNodeView(apiProvider);
	}

	@Override
	public EasyProductionProgramNodeContribution createNode(ProgramAPIProvider apiProvider,
			EasyProductionProgramNodeView view, DataModel model, CreationContext context) {
		// Program API Provider provides access to URCap API relevant to the program node
		// instance of view
		// Data Model where we can store the nodes settings
		// Creation Context, we can check if the node was created by loading or it is a brand new node
		return new EasyProductionProgramNodeContribution(apiProvider, view, model);
	}

}
