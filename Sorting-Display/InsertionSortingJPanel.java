import java.awt.Color;
import java.awt.Graphics;

class InsertionSortingJPanel extends DisplayPanel {
	  private static final long serialVersionUID = 1L;
	  private int red = -1;
	  private int blue = -1;
	  private int green = -1;
	  
	  public InsertionSortingJPanel(String type, int[] listJPanel, int sleep) {
	   super(type, listJPanel, sleep);
	  }

	  @Override
	  public void run() {
	   try {
	    for (int x = 1; x < list.length; x++) {
	     green = x;
	     Thread.sleep(3 * sleep);
	     repaint();
	     red = green;
	     blue = -1;
	     int k;
	     for (k = x - 1; k >= 0 && list[k] > list[k + 1]; k--) {
	      red = k + 1;
	      blue = k;
	      repaint();
	      Thread.sleep(4 * sleep);
	      int tmp = list[k + 1]; 
	      list[k + 1] = list[k];
	      list[k] = tmp;
	     }
	     red = k + 1;
	     blue = k;
	     repaint();
	    }
	    red = -1;
	    blue = -1;
	   } catch (InterruptedException e) {
	   }
	   repaint();
	  }
	  
	  @Override
	  protected void paintComponent(Graphics g) {
	   super.paintComponent(g);
	   int columnWidth = (getWidth() - 4 * BORDER_WIDTH) / size;
	   int columnHeight = (getHeight() - 4 * BORDER_WIDTH) / size;
	   
	   for (int x = (green == -1 ? 0 : green); x < list.length; x++) {
	    g.setColor(Color.BLACK);
	    g.fillRect(2 * BORDER_WIDTH + columnWidth * x, getHeight() - list[x] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[x] * columnHeight);
	    g.setColor(Color.WHITE);
	    g.drawRect(2 * BORDER_WIDTH + columnWidth * x, getHeight() - list[x] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[x] * columnHeight);   
	   }
	   for (int x = 0; x <= green; x++) {
	    g.setColor(Color.GREEN);
	    g.fillRect(2 * BORDER_WIDTH + columnWidth * x, getHeight() - list[x] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[x] * columnHeight);
	    g.setColor(Color.WHITE);
	    g.drawRect(2 * BORDER_WIDTH + columnWidth * x, getHeight() - list[x] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[x] * columnHeight);   
	   }
	   if(red != -1) {
	    g.setColor(Color.RED);
	    g.fillRect(2 * BORDER_WIDTH + columnWidth * red, getHeight() - list[red] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[red] * columnHeight);
	    g.setColor(Color.WHITE);
	    g.drawRect(2 * BORDER_WIDTH + columnWidth * red, getHeight() - list[red] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[red] * columnHeight);
	   }
	   if(blue != -1) {
	    g.setColor(Color.BLUE);
	    g.fillRect(2 * BORDER_WIDTH + columnWidth * blue, getHeight() - list[blue] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[blue] * columnHeight);
	    g.setColor(Color.WHITE);
	    g.drawRect(2 * BORDER_WIDTH + columnWidth * blue, getHeight() - list[blue] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[blue] * columnHeight);
	   }
	  }

	 }
