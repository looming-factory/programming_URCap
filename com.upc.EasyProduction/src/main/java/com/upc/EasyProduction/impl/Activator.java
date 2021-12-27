package com.upc.EasyProduction.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeService;

/**
 * Hello world activator for the OSGi bundle URCAPS contribution
 *
 */

/**
 * This class implements the activator of the program node.
 * @author Enric Lamarca Ferrés.
 *
 */
public class Activator implements BundleActivator {
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("EasyProduction registering");
		// register our service to the bundle context
		// generic class and particular class of service to register, last argument null because we don't want to configure any properties
		bundleContext.registerService(SwingProgramNodeService.class, new EasyProductionProgramNodeService(), null);
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Activator says Goodbye World!");
	}
}

