package java_fundation_exer;

import java.awt.*;


public class java_graphics {

	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(800, 800);
		
		Graphics g = panel.getGraphics();
		g.drawRect(10,30,60,35);
		Color brown = new Color(192, 128, 64);
		g.setColor(brown);
		g.fillRect(10,30,60,35);
		g.drawLine(100, 100, 200, 200);
		drawDiamond(g, 78, 22);
			
		g.setColor(Color.GREEN);

		Polygon poly = new Polygon();
		poly.addPoint(10, 90);
		poly.addPoint(50, 10);
		poly.addPoint(90, 90);
		g.fillPolygon(poly);
		
		g.setFont(new Font("Monospaced",
		Font.BOLD + Font.ITALIC, 36));
		g.drawString("Too big", 20, 40);
		g.setFont(new Font("SansSerif", Font.PLAIN, 10));
		g.drawString("Too small", 30, 60);
		g.setFont(new Font("Serif", Font.ITALIC, 18));
		g.drawString("Just right", 40, 80);
		g.setColor(Color.BLUE);

		for (int x = 1; x <= 4; x++) {
		    for (int y = 1; y <= 9; y++) {
		        g.drawString("Java", x * 40, y * 25);
		    }
		}
		
		
	}
	
	public static void drawDiamond(Graphics g, int x, int y) {
		g.drawRect(x, y, 50, 50);
		g.drawLine(x, y + 25, x + 25, y);
		g.drawLine(x + 25, y, x + 50, y + 25);
		g.drawLine(x + 50, y + 25, x + 25, y + 50);
		g.drawLine(x + 25, y + 50, x, y + 25);
	}

}
