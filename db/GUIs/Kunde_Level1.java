package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Kunden;
import datentypen.Person;

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
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Kunde_Level1 extends JFrame {

	private JPanel contentPane;
	private JButton btnHinzufügenK1;
	private JButton btnBearbeitenK1;
	private JButton btnLöschenK1;
	private JButton btnZurückK1;
	private JList lstKundenK1;
	private Kunden kunde;
	private ArrayList<Person> daten;
	private String[] kdlst;
	private String text;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Kunde_Level1() throws ClassNotFoundException, SQLException {
		kunde = new Kunden();
		daten = kunde.get_all();
		kdlst = new String[daten.size()];
		for (int i=0; i<daten.size(); i++) {
			text = kunde.parseString(daten.get(i));
			kdlst[i] = text.replaceAll(",", " "); 
		}
		initComponents();
		createEvents();
	}
	
	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() throws ClassNotFoundException, SQLException {
		setTitle("Men\u00FC - Kunde");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnHinzufügenK1 = new JButton("Hinzuf\u00FCgen");
		
		btnBearbeitenK1 = new JButton("Bearbeiten");
		
		btnLöschenK1 = new JButton("L\u00F6schen");
		
		JScrollPane scrKundenlisteK1 = new JScrollPane();
		
		btnZurückK1 = new JButton("Zum Hauptmen\u00FC");
		
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
		
		lstKundenK1 = new JList();
		lstKundenK1.setModel(new AbstractListModel() {
			String[] values = kdlst; 
			
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
////////////////////////////////////////////////////////////////////
//Enthält den Code für den "Zurück" Button
////////////////////////////////////////////////////////////////////
		btnZurückK1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUI hauptmenü = new GUI();
				hauptmenü.setVisible(true);
			}
		});
////////////////////////////////////////////////////////////////////
//Enthält den Code für den "Hinzufügen" Button
////////////////////////////////////////////////////////////////////
		btnHinzufügenK1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Kunde_Level3 kunde3;
				try {
					kunde3 = new Kunde_Level3();
					kunde3.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
////////////////////////////////////////////////////////////////////
//Enthält den Code für den "Bearbeiten" Button
////////////////////////////////////////////////////////////////////
		btnBearbeitenK1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Kunde_Level2 kunde2;
				try {
					kunde2 = new Kunde_Level2(lstKundenK1.getSelectedValue().toString());
					kunde2.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
////////////////////////////////////////////////////////////////////
//Enthält den Code für den "Löschen" Button
////////////////////////////////////////////////////////////////////
		btnLöschenK1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Kunde_Level2 kunde2;
				try {
					kunde2 = new Kunde_Level2(lstKundenK1.getSelectedValue().toString());
					kunde2.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
	}
}
