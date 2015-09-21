/* ======================================================================================================
 * SystemDynamics: Java application for modeling, visualization and execution of System Dynamics models
 * ======================================================================================================
 *
 * (C) Copyright 2007-2008, Joachim Melcher, Institut AIFB, Universitaet Karlsruhe (TH), Germany
 *
 * Project Info:  http://sourceforge.net/projects/system-dynamics
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program; if
 * not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA  02110-1301, USA.
 */

package de.uka.aifb.com.systemDynamics.gui.systemDynamicsGraph;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import org.jgraph.graph.*;

/**
 * This class implements a specialized graph cell for a System Dynamics rate node.
 * 
 * @author Joachim Melcher, Institut AIFB, Universitaet Karlsruhe (TH), Germany
 * @version 1.0
 */
public class RateNodeGraphCell extends DefaultGraphCell {
   
   private static final long serialVersionUID = 1L;
   
   private static final double LENGTH = 40;
   private static Color BORDER_COLOR = Color.BLACK;
   private Color purple = new Color(171,0,255); 
   /**
    * Constructor.
    * 
    * @param name node's name
    * @param x x coordinate of node's origin
    * @param y y coordinate of node's origin
 * @param learnerChangeable 
    */
   public RateNodeGraphCell(String name, double x, double y, AttributeMap vals, boolean learnerChangeable, boolean shared) {
      super(name, vals);
      
      if (name == null) {
         throw new IllegalArgumentException("'name' must not be null.");
      }
      if(learnerChangeable){
    	  BORDER_COLOR = purple;
      }
      else{
    	  BORDER_COLOR = Color.black;
      }
      if(shared){
    	  GraphConstants.setBackground(getAttributes(), Color.LIGHT_GRAY);
      }
      // add one standard port
      addPort();
      
      // layout
      GraphConstants.setBounds(getAttributes(), new Rectangle2D.Double(x, y, LENGTH, LENGTH));
      GraphConstants.setSizeable(getAttributes(), false);
      GraphConstants.setBorderColor(getAttributes(), BORDER_COLOR);
      GraphConstants.setOpaque(getAttributes(), true);
   }
}