package com.upc.EasyProduction.impl;

import com.ur.urcap.api.contribution.ProgramNodeContribution;

import com.ur.urcap.api.contribution.program.ProgramAPIProvider;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;
import com.ur.urcap.api.domain.undoredo.UndoRedoManager;
import com.ur.urcap.api.domain.undoredo.UndoableChanges;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.panelManagement.Workflow;

/**
 * This class implements the contribution of the program node.
 * @author Enric Lamarca Ferrés.
 *
 */
public class EasyProductionProgramNodeContribution implements ProgramNodeContribution{
	/**
	 * Program API provider.
	 */
	final private ProgramAPIProvider apiProvider;
	/**
	 * View instance of the node.
	 */
	final private EasyProductionProgramNodeView view;
	/**
	 * DataModel of the node.
	 */
	final private DataModel model;
	// we want to store values of duration and output in our data model
	// data model is what we use to keep track of the settings of this particular node
	// however when working with program nodes is also important to keep track of UndoRedo
	/**
	 * UndoRedoManager of the node.
	 */
	private final UndoRedoManager undoRedoManager;
	
	/**
	 * Workflow key used to save workflow data in DataModel.
	 */
	private static final String WORKFLOW_KEY = "workflow"; // keys that register the changes
	/**
	 * Workflow data saved in DataModel using the corresponding key.
	 */
	private static final String[] DEFAULT_WORKFLOW = Workflow.getInstance().getDEFAULT_WORKFLOWdata(); // default values for each key
	
	/**
	 * Types key used to save types data in DataModel.
	 */
	private static final String TYPES_KEY = "types";
	
	/**
	 * Types data saved in DataModel using the corresponding key.
	 */
	private static final String[] DEFAULT_TYPES = Workflow.getInstance().getDEFAULT_TYPESdata();
	
	/**
	 * gson instance that generates the JSons of the BlockData instances.
	 */
	private final Gson gson = new GsonBuilder().create();
	
	/**
	 * MyStringDeserialization instance that builds BlockData instances from their JSons.
	 */
	private final MyStringDeserialization d = new MyStringDeserialization();
	
	/**
	 * Constructor.
	 * @param apiProvider API provider.
	 * @param view view instance of the node.
	 * @param model DataModel of the node.
	 */
	public EasyProductionProgramNodeContribution(ProgramAPIProvider apiProvider, EasyProductionProgramNodeView view, DataModel model) {
		this.apiProvider = apiProvider;
		this.view = view;
		this.model = model;
		this.undoRedoManager = this.apiProvider.getProgramAPI().getUndoRedoManager();
	}
	
	/**
	 * Called when a change on workflow has to be reflected on the DataModel.
	 * @param wfPositions array of the workflow positions in where there are the changed blocks.
	 */
	public void onChangeInWF(int[] wfPositions) {
		
		undoRedoManager.recordChanges(new MyUndoableChanges(wfPositions));
		
		// debugging
		
		System.out.println("ON CHANGE ________________________________");
		String[] aux = model.get(WORKFLOW_KEY, DEFAULT_WORKFLOW);
		
		for (int i = 0; i < aux.length; i++) {
			System.out.println(aux[i]);
		}
		System.out.println("END ON CHANGE ________________________________");
	}

	@Override
	public void openView() {
				
		String[] blockDataStringArray = model.get(WORKFLOW_KEY, DEFAULT_WORKFLOW);
		String[] typesDataStringArray = model.get(TYPES_KEY, DEFAULT_TYPES);
		
		BlockData[] blockDataArray = new BlockData[blockDataStringArray.length];
								
		for (int i = 0; i < blockDataStringArray.length; i++) {
			
			try {
				
				//blockDataArray[i] = (BlockData) gson.fromJson(blockDataStringArray[i], Class.forName(typesDataStringArray[i]));
				blockDataArray[i] = (BlockData) d.deserializeBlockData(blockDataStringArray[i], typesDataStringArray[i]);
				
			}
			catch(Exception e){
				System.out.println(e.toString());
			}
		}
		
		Workflow.getInstance().setWorkflowData(blockDataArray);
		
		System.out.println("OPEN VIEW ________________________________");
		
		String[] aux = model.get(WORKFLOW_KEY, DEFAULT_WORKFLOW);
		
		for (int i = 0; i < aux.length; i++) {
			System.out.println(aux[i]);
		}
		
		System.out.println("END OPEN VIEW ________________________________");
	}

	@Override
	public void closeView() {
		// in this case nothing (no threads or similar dynamic processes created)
		
	}

	@Override
	public String getTitle() {
		return "EasyProduction"; // name in the program tree
	}

	@Override
	public boolean isDefined() { // eye!!
		// since we have the DEFAULT VALUES!!
		// node able to execute
		return true;
	}

	@Override
	public void generateScript(ScriptWriter writer) {
		
		writer.appendRaw(Workflow.getInstance().generateCode());
		
	}
	
	
	// inner class per poder passar paràmetre a la constructora de UndoableChanges(), el param és la posició del bloc que ha fet canvis
	
	/**
	 * Inner class that implements UndoableChanges.
	 * @author Enric Lamarca Ferrés
	 *
	 */
	private class MyUndoableChanges implements UndoableChanges{
		
		/**
		 * Array of the changed workflow positions.
		 */
		private int[] wfPositions; // changed positions, only the case of select has two changed positions, the rest only 1 changed position!!
		
		// in the case of two positions, if the second is -1, means that we select a block, and no block was selected before
		
		/**
		 * Constructor.
		 * @param wfPositions array of the changed workflow positions.
		 */
		MyUndoableChanges(int[] wfPositions){
			
			this.wfPositions = wfPositions;
			
		}
		
		@Override
		public void executeChanges() { // record changes in data model
			
			if (wfPositions[0] == -2 && wfPositions.length == 1) { // update all
				
				// no s'utilitza, però per si de cas es volgués actualitzar tot el workflow...
				
				BlockData[] blockDataArray = Workflow.getInstance().getWorkflowData();
				
				String[] blockDataStringArray = new String[blockDataArray.length];
				String[] typesDataStringArray = new String[blockDataArray.length];
				
				for (int i = 0; i < blockDataArray.length; i++) {
					
					blockDataStringArray[i] = gson.toJson(blockDataArray[i]);
					typesDataStringArray[i] = blockDataArray[i].getClass().getName();
					
				}
				
				model.set(WORKFLOW_KEY, blockDataStringArray);
				model.set(TYPES_KEY, typesDataStringArray);
				
			}
			
			else {
				
				String[] currentWfData = model.get(WORKFLOW_KEY, DEFAULT_WORKFLOW);
				String[] currentTypesData = model.get(TYPES_KEY, DEFAULT_TYPES);
				
				int realWfLen = Workflow.getInstance().getLen();
				
				int currentWfDataLen = currentWfData.length;
				
				
				
				if (realWfLen == currentWfDataLen) { // param changed in pos block
					
					String[] newWfData = new String[currentWfData.length]; // si no ho faig així problemes de referència, es canvia l'array default...
					//String[] newTypesData = new String[currentTypesData.length];
					
					Boolean changed = false;
					
					for (int i = 0; i < newWfData.length; i++) {
						
						changed = false;
						
						for (int j = 0; j < wfPositions.length; j++) { // només 2 iteracions
							if (i == wfPositions[j]) { // ja es té en compte que si una posició és -1 no s'actualitza perk no existeix
								newWfData[i] = gson.toJson(Workflow.getInstance().getWorkflowDataBlock(i));
								changed = true;
							}
						}
						
						if (!changed) {
							newWfData[i] = currentWfData[i];
						}
						
					}
					
					model.set(WORKFLOW_KEY, newWfData);
									
				}
				else if (realWfLen > currentWfDataLen && wfPositions.length == 1) { // block added in wf in pos
					
					BlockData bd = Workflow.getInstance().getWorkflowDataBlock(wfPositions[0]);
					
					String[] newWfData = new String[currentWfData.length + 1];
					String[] newTypesData = new String[currentTypesData.length + 1];
					
					Boolean added = false;
					
					for (int i = 0; i < newWfData.length; i++) {
						if (i == wfPositions[0]) {
							newWfData[i] = gson.toJson(bd);
							newTypesData[i] = bd.getClass().getName();
							added = true;
						}
						else {
							if (!added) {
								newWfData[i] = currentWfData[i];
								newTypesData[i] = currentTypesData[i];
							}
							else {
								newWfData[i] = currentWfData[i-1];
								newTypesData[i] = currentTypesData[i-1];
							}
						}
					}
					
					model.set(WORKFLOW_KEY, newWfData);
					model.set(TYPES_KEY, newTypesData);
					
				}
				else if (realWfLen < currentWfDataLen && wfPositions.length == 1) { // block deleted in wf in pos
					
					String[] newWfData = new String[currentWfData.length - 1];
					String[] newTypesData = new String[currentTypesData.length - 1];
					
					Boolean deleted = false;
					
					for (int i = 0; i < currentWfData.length; i++) {
						
						if (i == wfPositions[0]) {
							deleted = true;
						}
						
						else {
							
							if (!deleted) {
								newWfData[i] = currentWfData[i];
								newTypesData[i] = currentTypesData[i];
							}
							else {
								newWfData[i - 1] = currentWfData[i];
								newTypesData[i - 1] = currentTypesData[i];
							}	
						}	
					}
					
					model.set(WORKFLOW_KEY, newWfData);
					model.set(TYPES_KEY, newTypesData);
				}
			}
		}
	}
}
