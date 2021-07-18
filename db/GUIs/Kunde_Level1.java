package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class Kunde_Level1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kunde_Level1 frame = new Kunde_Level1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Kunde_Level1() {
		initComponents();
		createEvents();
		
	}
	
	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		setTitle("Men\u00FC - Kunde");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnHinzufügenK1 = new JButton("Hinzuf\u00FCgen");
		
		JButton btnBearbeitenK1 = new JButton("Bearbeiten");
		
		JButton btnLöschenK1 = new JButton("L\u00F6schen");
		
		JScrollPane scrKundenlisteK1 = new JScrollPane();
		
		JButton btnZurückK1 = new JButton("Zum Hauptmen\u00FC");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addComponent(btnHinzufügenK1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnBearbeitenK1, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnLöschenK1, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addGap(87))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrKundenlisteK1, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
					.addGap(8))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnZurückK1)
					.addContainerGap(305, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnZurückK1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(scrKundenlisteK1, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBearbeitenK1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLöschenK1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnHinzufügenK1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		);
		
		JList lstKundenK1 = new JList();
		lstKundenK1.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrKundenlisteK1.setViewportView(lstKundenK1);
		contentPane.setLayout(gl_contentPane);
	}
	
	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	private void createEvents() {
		// TODO Auto-generated method stub
		
	}
}
