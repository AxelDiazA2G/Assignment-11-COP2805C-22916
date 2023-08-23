import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

abstract class DisplayPanel extends JPanel implements Runnable {
		private static final long serialVersionUID = 1L;
		protected static final int BORDER_WIDTH = 10;
		  private static final Dimension sizeofPanel= new Dimension(460, 340);
		  protected int[] list;
		  protected int sleep;
		  protected int size;
		  private String typesort;
		  
		  public DisplayPanel(String type, int[] listJpanel, int sleep) {
		   this.typesort = type;
		   this.size = listJpanel.length;
		   this.sleep = sleep;
		   this.list = java.util.Arrays.copyOf(listJpanel, size);
		   setBackground(Color.WHITE);
		   Thread thread = new Thread(this);
		   thread.start();
		  }
		  
		  @Override
		  public Dimension getPreferredSize() {
		   return sizeofPanel;
		  }
		  
		  @Override
		  protected void paintComponent(Graphics g) {
		   super.paintComponent(g);
		   
		   //Draw a title
		   
		   Font font = new Font("Sansserif", Font.PLAIN, 18);
		   FontMetrics fontmetrics = getFontMetrics(font);  
		   g.setColor(Color.WHITE);
		   g.fillRect((getWidth() - fontmetrics.stringWidth(typesort)) / 2, 0, fontmetrics.stringWidth(typesort), BORDER_WIDTH + fontmetrics.getAscent() / 3);
		   g.setColor(Color.BLACK);
		   g.setFont(font);
		   g.drawString(typesort, (getWidth() - fontmetrics.stringWidth(typesort)) / 2, BORDER_WIDTH + fontmetrics.getAscent() / 3);

		  }

		  @Override
		  public abstract void run();

		 }
