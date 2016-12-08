package FinalProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;


public class statusPanel extends JPanel {
	private static final int START_X = 10;
	private static final int START_Y = 20;
	private static final int OFFSET_Y = 25;
	private static final int BAR_LENGTH_MAX = 200;
	private static final int STAT_MAX = 255;

	private PokeTableModel model;
	private Vector<Integer> stats;
	private String[] statsName = {"HP: ","Attack: ","Defense: ", "Sp.Atk: ","Sp.Def: ","Speed: "};
	private Color[] statsColor = {Color.RED, Color.ORANGE, Color.YELLOW, Color.BLUE,Color.GREEN, Color.MAGENTA};

	public statusPanel(PokeTableModel model) {
		this.model = model;
		initialize();
	}

	private void initialize(){
		// Set the size and do the query
		setPreferredSize(new Dimension(250, 200));

		stats = model.getSelectedPokemonStatus(1);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		for (int i=0;i< statsName.length ;i++){
			CreateStatsBar(statsName,stats,statsColor, i,g );

		}
	}

	private void CreateStatsBar(String[] statsName, Vector<Integer> stats, Color[] c, int i, Graphics g) {
		int width = (int) (((float)stats.get(i)) / STAT_MAX * BAR_LENGTH_MAX);
		g.setColor(c[i]);
		g.fillRect(START_X,  START_Y +  i*OFFSET_Y, width, 10);
		g.setColor(Color.BLACK);
		g.drawString(statsName[i] + stats.get(i), START_X, START_Y +  i*OFFSET_Y);

	}
}