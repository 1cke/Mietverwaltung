package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Kunden;
import backend.Vertrag;
import datentypen.Vertragsdaten;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;

public class Vertrag_Level1 extends JFrame {

	private JPanel contentPane;
	private JButton btnZurückV1;
	private JButton btnHinzufügenV1;
	private JButton btnBearbeitenV1;
	private JButton btnLöschenV1;
	private JList lstVerträgeV1;
	private Vertrag vertrag;
	private ArrayList<Vertragsdaten> daten;
	private String[] vtlst;
	private String text;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Vertrag_Level1() throws ClassNotFoundException, SQLException {
		vertrag = new Vertrag();
		daten = vertrag.get_all();
		vtlst = new String[daten.size()];
		for (int i=0; i<daten.size(); i++) {
			text = vertrag.parseString(daten.get(i));
			vtlst[i] = text.replaceAll(",", " "); 
		}
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		setTitle("Men\u00FC - Vertr\u00E4ge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnZurückV1 = new JButton("Zum Hauptmen\u00FC");
		
		btnHinzufügenV1 = new JButton("Hinzuf\u00FCgen");
		
		btnBearbeitenV1 = new JButton("Bearbeiten");
		
		btnLöschenV1 = new JButton("L\u00F6schen");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(59)
							.addComponent(btnHinzufügenV1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnBearbeitenV1, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnLöschenV1, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
							.addGap(78))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnZurückV1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnZurückV1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnHinzufügenV1)
						.addComponent(btnBearbeitenV1)
						.addComponent(btnLöschenV1)))
		);
		
		lstVerträgeV1 = new JList();
		lstVerträgeV1.setModel(new AbstractListModel() {
			String[] values = vtlst;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(lstVerträgeV1);
		contentPane.setLayout(gl_contentPane);
	}
	
	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////

	private void createEvents() {
////////////////////////////////////////////////////////////////////
//Enthält den Code für den "Zurück" Button
////////////////////////////////////////////////////////////////////
		btnZurückV1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUI hauptmenü = new GUI();
				hauptmenü.setVisible(true);
			}
		});
////////////////////////////////////////////////////////////////////
//Enthält den Code für den "Hinzufügen" Button
////////////////////////////////////////////////////////////////////
		btnHinzufügenV1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Vertrag_Level3 vertrag3;
				try {
					vertrag3 = new Vertrag_Level3();
					vertrag3.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
////////////////////////////////////////////////////////////////////
//Enthält den Code für den "Bearbeiten" Button
////////////////////////////////////////////////////////////////////
		btnBearbeitenV1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Vertrag_Level2 vertrag2;
				try {
					vertrag2 = new Vertrag_Level2(lstVerträgeV1.getSelectedValue().toString());
					vertrag2.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
////////////////////////////////////////////////////////////////////
//Enthält den Code für den "Löschen" Button
////////////////////////////////////////////////////////////////////
		btnLöschenV1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Vertrag_Level2 vertrag2;
				try {
					vertrag2 = new Vertrag_Level2(lstVerträgeV1.getSelectedValue().toString());
					vertrag2.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
	}

}
