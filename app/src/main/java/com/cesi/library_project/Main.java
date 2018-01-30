package com.cesi.library_project;

import com.cesi.library_project.database.db.DatabaseController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Main {

  public static void main(String[] args) {
    DatabaseController.getInstance().init();

    Display display = new Display();
    Image image = display.getSystemImage(SWT.ICON_QUESTION);
    Shell shell = new Shell(display);
    shell.setLayout (new GridLayout());
    Button button = new Button(shell, SWT.PUSH);
    button.setImage(image);
    button.setText("Button");
    shell.setSize(300, 300);
    shell.open();
    while (!shell.isDisposed ()) {
      if (!display.readAndDispatch ()) display.sleep ();
    }
    display.dispose ();


    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }

    display.dispose();
  }
  
}
