package GUIs;
//test
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;

public class Bewerbung_Level1 extends JFrame {

	private JPanel contentPaneB1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bewerbung_Level1 frame = new Bewerbung_Level1();
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
	public Bewerbung_Level1() {
		initComponents();
		createEvents();
	}
	
	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		setTitle("Men\u00FC - Bewerbungen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPaneB1 = new JPanel();
		contentPaneB1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneB1);
		
		JButton btnZurückB1 = new JButton("Zum Hauptmen\u00FC");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnHinzufügenB1 = new JButton("Hinzuf\u00FCgen");
		
		JButton btnBearbeitenB1 = new JButton("Bearbeiten");
		
		JButton btnLöschenB1 = new JButton("L\u00F6schen");
		GroupLayout gl_contentPaneB1 = new GroupLayout(contentPaneB1);
		gl_contentPaneB1.setHorizontalGroup(
			gl_contentPaneB1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneB1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneB1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPaneB1.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPaneB1.createSequentialGroup()
							.addComponent(btnZurückB1)
							.addGap(3))))
				.addGroup(gl_contentPaneB1.createSequentialGroup()
					.addGap(54)
					.addComponent(btnHinzufügenB1, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnBearbeitenB1, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnLöschenB1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(71))
		);
		gl_contentPaneB1.setVerticalGroup(
			gl_contentPaneB1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneB1.createSequentialGroup()
					.addComponent(btnZurückB1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneB1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBearbeitenB1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnHinzufügenB1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLöschenB1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		);
		
		JList lstBewerbungenB1 = new JList();
		scrollPane.setViewportView(lstBewerbungenB1);
		contentPaneB1.setLayout(gl_contentPaneB1);
	}
	
	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
		
	}

}
