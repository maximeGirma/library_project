package com.cesi.library_project;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Main {

  public static void main(String[] args) {

    Display display = new Display();

    Shell shell = new Shell(display, SWT.RESIZE | SWT.CLOSE | SWT.MIN);
    shell.setText("Login:");

    RowLayout layout = new RowLayout();
    layout.wrap = true;
    shell.setLayout(layout);

    Text txt1 = new Text(shell, SWT.BORDER);

    shell.pack();
    shell.open();


    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }

    display.dispose();
  }
  
}
