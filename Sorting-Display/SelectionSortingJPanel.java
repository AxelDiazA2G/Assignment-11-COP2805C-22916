import java.awt.Color;
import java.awt.Graphics;

public class SelectionSortingJPanel extends DisplayPanel{
	private static final long serialVersionUID = 1L;
	  private int redColumn = -1;
	  private int blueColumn = -1;
	  private int greenColumn = -1;
	  
	  public SelectionSortingJPanel(String type, int[] listJpanel, int sleep) {
	   super(type, listJpanel, sleep);
	  }

	  @Override
	  public void run() {
	   try {
	    for (int i = 0; i < list.length - 1; i++) {
	     int currentMinIndex = i;
	     redColumn = currentMinIndex;
	     for (int j = i + 1; j < list.length; j++) {
	      blueColumn = j;
	      repaint();
	      Thread.sleep(3 * sleep);
	      if (list[currentMinIndex] > list[j]) {
	       currentMinIndex = j;
	       redColumn = currentMinIndex;
	       repaint();
	      }
	     }

	     if (currentMinIndex != i) {
	      int tmp = list[currentMinIndex];
	      list[currentMinIndex] = list[i];
	      list[i] = tmp;
	      repaint();
	      Thread.sleep(4 * sleep);
	     }
	     greenColumn++;
	     repaint();
	    }
	    greenColumn++;
	    redColumn = -1;
	    blueColumn = -1;
	   } catch (InterruptedException e) {
	   }
	   repaint();
	  }
	  
	  @Override
	  protected void paintComponent(Graphics g) {
	   super.paintComponent(g);
	   int columnWidth = (getWidth() - 4 * BORDER_WIDTH) / size;
	   int columnHeight = (getHeight() - 4 * BORDER_WIDTH) / size;
	   
	   //Shows the unsorted part of the array
	   for (int i = (greenColumn == -1 ? 0 : greenColumn); i < list.length; i++) {
	    g.setColor(Color.BLACK);
	    g.fillRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);
	    g.setColor(Color.WHITE);
	    g.drawRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);   
	   }
	   for (int i = 0; i <= greenColumn; i++) {
	    g.setColor(Color.GREEN);
	    g.fillRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);
	    g.setColor(Color.WHITE);
	    g.drawRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);   
	   }
	   if(redColumn != -1) {
	    g.setColor(Color.RED);
	    g.fillRect(2 * BORDER_WIDTH + columnWidth * redColumn, getHeight() - list[redColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[redColumn] * columnHeight);
	    g.setColor(Color.WHITE);
	    g.drawRect(2 * BORDER_WIDTH + columnWidth * redColumn, getHeight() - list[redColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[redColumn] * columnHeight);
	   }
	   if(blueColumn != -1) {
	    g.setColor(Color.BLUE);
	    g.fillRect(2 * BORDER_WIDTH + columnWidth * blueColumn, getHeight() - list[blueColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[blueColumn] * columnHeight);
	    g.setColor(Color.WHITE);
	    g.drawRect(2 * BORDER_WIDTH + columnWidth * blueColumn, getHeight() - list[blueColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[blueColumn] * columnHeight);
	   }

	  }
	 }







