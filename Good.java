import java.awt.*;
import java.awt.event.*;

import static java.util.Collections.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.util.NoSuchElementException;

/**
 * Assignment 2:
 *
 * This implementation violates a number of design principles, isn't extensible, and its
 * components can't be tested in isolation. Your job is to change that :)
 */
public class Good {
    static TextField txtip ;
    static Button btnadd ;
    static Button btnreset ;
    static TextField txtnum ;
    static TextField txtmean ;
    static TextField txtmed ;
    static JTextArea txtarea;
    static model mod;
    
    public static void main(String ... args) {
        /**
         * Create a simple GUI that includes:
         * - a text field and a button that allows the user to enter numbers.
         * - a button that allows the user to clear all entered numbers.
         * - a panel with labels and text fields for count, median, and mean.
         * - a text area that shows all numbers.
         */
        // Create the main frame of the application, and set size and position
        
    	txtip = new TextField("", true);
        btnadd = new Button("Add number");
        btnreset = new Button("Reset");
        txtnum = new TextField("Numbers:",false);
        txtmean = new TextField("Mean:", false);
        txtmed = new TextField("Median:", false);
        mod = new model();
        txtarea = new JTextArea(10, 50);
        txtarea.setEditable(false);
    	
        //uses composite pattern for view
    	//add required statistics
    	ComposedView cvip = new ComposedView();
    	ComposedView.setMainFrame();

        // Panel that shows stats about the numbers
        JPanel jpInput = new JPanel(new FlowLayout(FlowLayout.CENTER));
        cvip.addView(txtip);
        cvip.addView(btnadd);
        cvip.addView(btnreset);
        cvip.draw(jpInput);
        ComposedView.setPanelPosition((Component)jpInput, (Object)BorderLayout.NORTH);
        
        ComposedView.setPanelPosition((Component)txtarea, (Object)BorderLayout.SOUTH);
        
        ComposedView cvstat = new ComposedView();
        JPanel jpStats = new JPanel(new FlowLayout(FlowLayout.CENTER));
        cvstat.addView(txtnum);
        cvstat.addView(txtmean);
        cvstat.addView(txtmed);
        cvstat.draw(jpStats);
        ComposedView.setPanelPosition((Component)jpStats, (Object)BorderLayout.CENTER);
        
        ComposedView.makeVisible();
        
        btnreset.OnClickListener(Controller.ResetAll);
        btnadd.OnClickListener(Controller.AddNumbers);

    }
}
