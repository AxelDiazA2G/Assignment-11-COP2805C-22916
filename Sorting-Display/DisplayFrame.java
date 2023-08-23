import javax.swing.*;

import java.awt.*;

public class DisplayFrame<extend> extends JFrame {

 private static final long serialVersionUID = 1L;
 private DisplayPanel[] SortJPanel = new DisplayPanel[3];
 private int size = 50;
 private int sleep = 20;
 

 public DisplayFrame() {
  setLayout(new  GridLayout(0, 3, 0, 0));
  int[] sizeGrid = new int[size];
  for (int i = 0; i < sizeGrid.length; i++) {
   sizeGrid[i] = i + 1;
  }
  for (int i = 0; i < sizeGrid.length; i++) {
   int index = (int) (Math.random() * sizeGrid.length);
   int temp = sizeGrid[i];
   sizeGrid[i] = sizeGrid[index];
   sizeGrid[index] = temp;
  }
  
  //Creates sort objects passing the size, type of sort and time 
  SortJPanel[0] = new SelectionSortingJPanel(" Selection Sort ", sizeGrid, sleep);
  SortJPanel[1] = new InsertionSortingJPanel(" Insertion Sort ", sizeGrid, sleep);
  SortJPanel[2] = new BubbleSortingJPanel(" Bubble Sort ", sizeGrid, sleep);
  //For loop adds the sort classes to the display
  for (int i = 0; i < SortJPanel.length; i++) {
   add(SortJPanel[i]);    
  }

 }}
