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
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class Kontaktpunkt_Level1 extends JFrame {

	private JPanel contentPaneKP1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kontaktpunkt_Level1 frame = new Kontaktpunkt_Level1();
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
	public Kontaktpunkt_Level1() {
		initComponents();
		createEvents();
		
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		setTitle("Men\u00FC - Kontaktpunkte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPaneKP1 = new JPanel();
		contentPaneKP1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneKP1);
		
		JButton btnZurückKP1 = new JButton("Zum Hauptmen\u00FC");
		
		JButton btnHinzufügenKP1 = new JButton("Hinzuf\u00FCgen");
		
		JButton btnBearbeitenKP1 = new JButton("Bearbeiten");
		
		JButton btnLöschenKP1 = new JButton("L\u00F6schen");
		
		JScrollPane scrollPaneKP1 = new JScrollPane();
		GroupLayout gl_contentPaneKP1 = new GroupLayout(contentPaneKP1);
		gl_contentPaneKP1.setHorizontalGroup(
			gl_contentPaneKP1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneKP1.createSequentialGroup()
					.addGap(45)
					.addComponent(btnHinzufügenKP1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnBearbeitenKP1, GroupLayout.PREFERRED_SIZE, 91, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnLöschenKP1, GroupLayout.PREFERRED_SIZE, 91, Short.MAX_VALUE)
					.addGap(66))
				.addGroup(gl_contentPaneKP1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnZurückKP1)
					.addContainerGap(309, Short.MAX_VALUE))
				.addGroup(gl_contentPaneKP1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneKP1, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPaneKP1.setVerticalGroup(
			gl_contentPaneKP1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneKP1.createSequentialGroup()
					.addComponent(btnZurückKP1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneKP1, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneKP1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBearbeitenKP1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLöschenKP1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnHinzufügenKP1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		);
		
		JList lstKontaktpunkteKP1 = new JList();
		lstKontaktpunkteKP1.setModel(new AbstractListModel() {
			String[] values = new String[] {"Kontaktpunkte vielleicht clickable machen zum ins Detail gehen."};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPaneKP1.setViewportView(lstKontaktpunkteKP1);
		contentPaneKP1.setLayout(gl_contentPaneKP1);
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
		// TODO Auto-generated method stub
		
	}

}
