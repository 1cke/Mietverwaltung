package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Kontakt;
import datentypen.Kontaktdaten;
import datentypen.Person;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Kontaktpunkt_Level1 extends JFrame {

	private JPanel contentPaneKP1;
	private JButton btnZurückKP1;
	private JButton btnHinzufügenKP1;
	private JButton btnBearbeitenKP1;
	private JButton btnLöschenKP1;
	private JList lstKontaktpunkteKP1;
	private ArrayList<Kontaktdaten> daten;
	private String[] ktlst;
	private String text;

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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Kontaktpunkt_Level1() throws ClassNotFoundException, SQLException {
		Kontakt kontakt = new Kontakt();
		daten = kontakt.display_kontakt();
		ktlst = new String[daten.size()];
		for (int i=0; i<daten.size(); i++) {
			text = kontakt.parseString(daten.get(i));
			ktlst[i] = text.replaceAll(",", " "); 
		}
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
		
		btnZurückKP1 = new JButton("Zum Hauptmen\u00FC");
		
		btnHinzufügenKP1 = new JButton("Hinzuf\u00FCgen");
		
		btnBearbeitenKP1 = new JButton("Bearbeiten");
		
		btnLöschenKP1 = new JButton("L\u00F6schen");
		
		JScrollPane scrollPaneKP1 = new JScrollPane();
		GroupLayout gl_contentPaneKP1 = new GroupLayout(contentPaneKP1);
		gl_contentPaneKP1.setHorizontalGroup(
			gl_contentPaneKP1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneKP1.createSequentialGroup()
					.addGap(45)
					.addComponent(btnHinzufügenKP1, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnBearbeitenKP1, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnLöschenKP1, GroupLayout.PREFERRED_SIZE, 91, Short.MAX_VALUE)
					.addGap(58))
				.addGroup(gl_contentPaneKP1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnZurückKP1)
					.addContainerGap(305, Short.MAX_VALUE))
				.addGroup(gl_contentPaneKP1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneKP1, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
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
						.addComponent(btnHinzufügenKP1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBearbeitenKP1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLöschenKP1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		);
		
		lstKontaktpunkteKP1 = new JList();
		lstKontaktpunkteKP1.setModel(new AbstractListModel() {
			String[] values = ktlst;
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
		btnZurückKP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUI hauptmenü = new GUI();
				hauptmenü.setVisible(true);
			}
		});
		btnHinzufügenKP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Kontaktpunkt_Level3 kontakt3;
				
				try {
					kontakt3 = new Kontaktpunkt_Level3();
					kontakt3.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnBearbeitenKP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Kontaktpunkt_Level2 kontakt2;
				try {
					kontakt2 = new Kontaktpunkt_Level2(lstKontaktpunkteKP1.getSelectedValue().toString());
					kontakt2.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnLöschenKP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Kontaktpunkt_Level2 kontakt2;
				try {
					kontakt2 = new Kontaktpunkt_Level2(lstKontaktpunkteKP1.getSelectedValue().toString());
					kontakt2.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
	}

}
