import java.awt.Color;
import java.awt.Graphics;
public class BubbleSortingJPanel extends DisplayPanel {
	private static final long serialVersionUID = 1L;
	  private int redColumn = -1;
	  private int blueColumn = -1;
	  private int greenColumn = -1;
	  
	  public BubbleSortingJPanel(String type, int[] listJpanel, int sleep) {
	   super(type, listJpanel, sleep);
	  }

	  @Override
	  public void run() {
	   try {
	    boolean conditionNext = true;
	    for (int y = 1; y < list.length && conditionNext; y++) {
	     conditionNext = false;
	     for (int x = 0; x < list.length - y; x++) {
	      redColumn = x;
	      blueColumn = x + 1;
	      repaint();
	      Thread.sleep(3 * sleep);
	      if (list[x] > list[x + 1]) {
	       redColumn = x + 1;
	       blueColumn = -1;
	       int temp = list[x];
	       list[x] = list[x + 1];
	       list[x + 1] = temp;
	       repaint();
	       Thread.sleep(4 * sleep);
	       conditionNext = true;
	      }
	     }
	     greenColumn = size - y;
	    }
	    greenColumn = 0;
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
	   for (int i = 0; i < (greenColumn == -1 ? list.length : greenColumn); i++) {
	    g.setColor(Color.BLACK);
	    g.fillRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);
	    g.setColor(Color.WHITE);
	    g.drawRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);   
	   }
	   if(greenColumn != -1) {
	    for (int i = greenColumn; i < list.length; i++) {
	     g.setColor(Color.GREEN);
	     g.fillRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);
	     g.setColor(Color.WHITE);
	     g.drawRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);   
	    }
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

