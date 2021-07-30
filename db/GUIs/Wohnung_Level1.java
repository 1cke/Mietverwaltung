package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Wohnung;
import datentypen.Person;
import datentypen.Wohnungsdaten;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;

public class Wohnung_Level1 extends JFrame {

	private JPanel contentPane;
	private JButton btnZurückW1;
	private JButton btnHinzufügenW1;
	private JButton btnBearbeitenW1;
	private JButton btnLöschenW1;
	private JList lstWohnungenW1;
	private ArrayList<Wohnungsdaten> daten;
	private String[] wglst;
	private String text;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Wohnung_Level1() throws ClassNotFoundException, SQLException {
		Wohnung wohnung = new Wohnung();
		daten = wohnung.display();
		wglst = new String[daten.size()];
		for (int i=0; i<daten.size(); i++) {
			text = wohnung.parseString(daten.get(i));
			wglst[i] = text.replaceAll(",", " "); 
		}
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////////////
	// Enthält den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		setTitle("Men\u00FC - Wohnungen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnHinzufügenW1 = new JButton("Hinzuf\u00FCgen");
		
		btnBearbeitenW1 = new JButton("Bearbeiten");
		
		btnLöschenW1 = new JButton("L\u00F6schen");
		
		btnZurückW1 = new JButton("Zum Hauptmen\u00FC");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addComponent(btnHinzufügenW1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnBearbeitenW1, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnLöschenW1, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
					.addGap(77))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnZurückW1)
					.addContainerGap(305, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
					.addGap(20))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnZurückW1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(btnHinzufügenW1)
						.addComponent(btnBearbeitenW1)
						.addComponent(btnLöschenW1)))
		);
		
		lstWohnungenW1 = new JList();
		lstWohnungenW1.setModel(new AbstractListModel() {
			String[] values = wglst;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(lstWohnungenW1);
		contentPane.setLayout(gl_contentPane);
	}
	
	////////////////////////////////////////////////////////////////////
	// Enthält den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
		////////////////////////////////////////////////////////////////////
		//Enthält den Code für den "Zurück" Button
		////////////////////////////////////////////////////////////////////
		btnZurückW1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUI hauptmenü = new GUI();
				hauptmenü.setVisible(true);
			}
		});
		////////////////////////////////////////////////////////////////////
		//Enthält den Code für den "Hinzufügen" Button
		////////////////////////////////////////////////////////////////////
		btnHinzufügenW1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Wohnung_Level3 wohnung3;
				try {
					wohnung3 = new Wohnung_Level3();
					wohnung3.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				} 
				
			}
		});
		////////////////////////////////////////////////////////////////////
		//Enthält den Code für den "Bearbeiten" Button
		////////////////////////////////////////////////////////////////////
		btnBearbeitenW1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wohnung_Level2 wohnung2;
				try {
					wohnung2 = new Wohnung_Level2(lstWohnungenW1.getSelectedValue().toString());
					wohnung2.setVisible(true);
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				} catch (NullPointerException en) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Wohnung aus.");
				}
				
			}
		});
		////////////////////////////////////////////////////////////////////
		//Enthält den Code für den "Löschen" Button
		////////////////////////////////////////////////////////////////////
		btnLöschenW1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wohnung_Level2 wohnung2;
				try {
					wohnung2 = new Wohnung_Level2(lstWohnungenW1.getSelectedValue().toString());
					wohnung2.setVisible(true);
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				} catch (NullPointerException en) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Wohnung aus.");
				}
				
			}
		});
		
		
		
	}

	
}
