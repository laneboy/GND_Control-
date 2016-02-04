import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;


public class GND_Control_GUI_HUB extends JFrame{
	JPanel main = new JPanel(new BorderLayout());
	JLayeredPane p0 = new JLayeredPane();
	JTabbedPane p1 = new JTabbedPane();
	JPanel p2 = new Profile_HUB_GUI();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JLabel l1 = new JLabel("(C) 2016 Software Engineering Team: Lucas Rivera, Andrii Hlyvko, Russell Epstein, Jonathan Zelaya, Prerak Mehta, Thomas Ippolito, and Kevin Wu");
	JMenuBar bar = new JMenuBar();
	JMenu m1 = new JMenu("FILE");
	JMenu m2 = new JMenu("SETTINGS");
	JMenu m3 = new JMenu("UPDATES");
	JMenu m4 = new JMenu("ABOUT");
	JMenuItem i1 = new JMenuItem("Ex1");
	JButton b1 = new JButton("");
	//SpringLayout spring = new SpringLayout();
	ImageIcon icon5;
	ImageIcon icon6;
	public GND_Control_GUI_HUB() throws IOException{
		m1.add(i1);
		bar.add(m1);
		bar.add(m2);
		bar.add(m3);
		bar.add(m4);
		URL img1 = this.getClass().getResource("quadicon.png");
		URL img2 = this.getClass().getResource("routes.png");
		URL img3 = this.getClass().getResource("waves.png");
		URL img4 = this.getClass().getResource("control.png");
		URL img5 = this.getClass().getResource("connect.png");
		URL img6 = this.getClass().getResource("disconnect.png");
		Image g1 = ImageIO.read(img1);
		Image g2 = ImageIO.read(img2);
		Image g3 = ImageIO.read(img3);
		Image g4 = ImageIO.read(img4);
		Image g5 = ImageIO.read(img5);
		Image g6 = ImageIO.read(img6);
		g1 = g1.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		g2 = g2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		g3 = g3.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		g4 = g4.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		g5 = g5.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		g6 = g6.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon icon1 = new ImageIcon(g1);
		ImageIcon icon2 = new ImageIcon(g2);
		ImageIcon icon3 = new ImageIcon(g3);
		ImageIcon icon4 = new ImageIcon(g4);
		icon5 = new ImageIcon(g5);
		icon6 = new ImageIcon(g6);
		p1.addTab("", icon1, p2,"Drone Profile");
		p1.addTab("", icon2, p3,"Google Maps");
		p1.addTab("", icon3, p4,"Whoi Controls");
		p1.addTab("", icon4, p5,"Drone Controls");
		p1.addTab("", null, null, "Upload Firmware");
		p1.addTab("", null,null,"PLEASE Donate!");
		b1.setIcon(icon5);
		
		main.add(bar,BorderLayout.NORTH);
		main.add(p1,BorderLayout.CENTER);
		main.add(l1,BorderLayout.SOUTH);
		this.addComponentListener(new ChangeSize());
		main.setSize(584,460);
	    main.setLocation(0, 0);
	    main.setOpaque(false);
		p0.add(main,1);
		b1.addActionListener(new connect());
		b1.setLocation(main.getSize().width-112, 32);
		b1.setSize(72, 64);
		p0.add(b1,0);
		add(p0);
		this.setLocationRelativeTo(null);
		this.setSize(600, 500);
		this.setMinimumSize(this.getSize());
		this.setTitle("GND Control");
		URL imgurl = this.getClass().getResource("gnd.png");
		Image g = ImageIO.read(imgurl);
		g = g.getScaledInstance(64, 64, Image.SCALE_SMOOTH);
		this.setIconImage(g);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public class ChangeSize implements ComponentListener{
		@Override
		public void componentHidden(ComponentEvent arg0){}
		@Override
		public void componentMoved(ComponentEvent arg0) {}
		@Override
		public void componentResized(ComponentEvent e) {
			Component c = (Component)e.getSource();
			Dimension D = GND_Control_GUI_HUB.this.getSize();
			//c.setSize(D.width-40,D.height-40);
			GND_Control_GUI_HUB.this.main.setSize(D.width-16, D.height-40);
			GND_Control_GUI_HUB.this.b1.setLocation(main.getSize().width-112, 32);
			System.out.println("width = "+D.width +" height = " + D.height);
		}
		@Override
		public void componentShown(ComponentEvent arg0) {}
	}
	public class connect implements ActionListener{
		boolean connection = false;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(connection){
				GND_Control_GUI_HUB.this.b1.setIcon(icon5);
				connection = false;
			}
			else{
				GND_Control_GUI_HUB.this.b1.setIcon(icon6);
				connection = true;
			}
		}
	}
	public static void main(String[] args) {
		try {
			new GND_Control_GUI_HUB();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
