package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Adresse;
import backend.Wohnung;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Wohnung_Level2 extends JFrame {

	private JPanel contentPaneW2;
	private JTextField txtFStrasseW2;
	private JTextField txtFOrtW2;
	private JTextField txtFMieteW2;
	private JTextField txtFZimmerW2;
	private JTextField txtFBaederW2;
	private JTextField txtFPLZW2;
	private JTextField txtFHNW2;
	private JButton btnZurückW2;
	private JButton btnSaveW2;
	private JButton btnLöschenW2;
	private Wohnung wohnung;
	private JTextArea txtArAuswahlW2;
	private JCheckBox czbEbkW2;
	private JCheckBox czbStatusW2;
	private String auswahl;
	private String nrW2;
	private int nr;
	private Adresse adresse;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Wohnung_Level2(String chosen_one) throws ClassNotFoundException, SQLException {
		auswahl = chosen_one;
		wohnung = new Wohnung();
		adresse = new Adresse();
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////////////
	// Enthält den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() throws ClassNotFoundException, SQLException {
		nrW2 = auswahl.substring(0, auswahl.indexOf(" "));
		nr = Integer.parseInt(nrW2);
		wohnung.lade_daten(nr);
		adresse.lade_adresse(wohnung.get_adress_id());
		
		setTitle("Wohnung bearbeiten/l\u00F6schen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 348);
		contentPaneW2 = new JPanel();
		contentPaneW2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneW2);
		
		btnZurückW2 = new JButton("Zum Wohnungs-Men\u00FC");
		
		JLabel lblAuswahlW2 = new JLabel("Ausgew\u00E4hlte Wohnung:");
		
		txtArAuswahlW2 = new JTextArea();
		txtArAuswahlW2.setText(auswahl);
		
		JSeparator separatorW2 = new JSeparator();
		
		JLabel lblStrasseW2 = new JLabel("Stra\u00DFe:");
		
		txtFStrasseW2 = new JTextField();
		txtFStrasseW2.setColumns(10);
		txtFStrasseW2.setText(adresse.get_strasse());
		
		JLabel lblHNW2 = new JLabel("Nummer :");
		
		JLabel lblOrtW2 = new JLabel("Ort:");
		
		txtFOrtW2 = new JTextField();
		txtFOrtW2.setColumns(10);
		txtFOrtW2.setText(adresse.get_ort());
		
		JLabel lblPLZW2 = new JLabel("PLZ:");
		
		czbEbkW2 = new JCheckBox("Einbauk\u00FCche");
		if (wohnung.get_ebk()) {
			czbEbkW2.setSelected(true);
		} else {
			czbEbkW2.setSelected(false);
		}
		
		JLabel lblMieteW2 = new JLabel("Miete:");
		
		txtFMieteW2 = new JTextField();
		txtFMieteW2.setColumns(10);
		txtFMieteW2.setText(String.valueOf(wohnung.get_miete()));
		
		JLabel lblZimmerW2 = new JLabel("Zimmer:");
		
		txtFZimmerW2 = new JTextField();
		txtFZimmerW2.setColumns(10);
		txtFZimmerW2.setText(String.valueOf(wohnung.get_zimmer()));
		
		JLabel lblBaederW2 = new JLabel("B\u00E4der:");
		
		txtFBaederW2 = new JTextField();
		txtFBaederW2.setColumns(10);
		txtFBaederW2.setText(String.valueOf(wohnung.get_baeder()));
		
		czbStatusW2 = new JCheckBox("vermietet");
		if (wohnung.get_vermietet()) {
			czbStatusW2.setSelected(true);
		} else {
			czbStatusW2.setSelected(false);
		}
		
		btnSaveW2 = new JButton("\u00C4nderungen speichern");
		
		btnLöschenW2 = new JButton("Wohnung l\u00F6schen");
		
		txtFPLZW2 = new JTextField();
		txtFPLZW2.setColumns(10);
		txtFPLZW2.setText(adresse.get_plz());
		
		txtFHNW2 = new JTextField();
		txtFHNW2.setColumns(10);
		txtFHNW2.setText(adresse.get_hn());
		
		GroupLayout gl_contentPaneW2 = new GroupLayout(contentPaneW2);
		gl_contentPaneW2.setHorizontalGroup(
			gl_contentPaneW2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneW2.createSequentialGroup()
					.addComponent(btnZurückW2)
					.addContainerGap(312, Short.MAX_VALUE))
				.addGroup(gl_contentPaneW2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMieteW2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtFMieteW2, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
					.addGap(294))
				.addGroup(gl_contentPaneW2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblZimmerW2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneW2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPaneW2.createSequentialGroup()
							.addComponent(txtFZimmerW2, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
							.addGap(38)
							.addComponent(lblBaederW2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtFBaederW2))
						.addGroup(Alignment.LEADING, gl_contentPaneW2.createSequentialGroup()
							.addComponent(czbEbkW2, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
							.addGap(244))
						.addComponent(czbStatusW2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
					.addGap(57))
				.addGroup(gl_contentPaneW2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneW2.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPaneW2.createSequentialGroup()
							.addComponent(lblAuswahlW2)
							.addGap(18)
							.addComponent(txtArAuswahlW2, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
							.addGap(8))
						.addComponent(separatorW2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE))
					.addGap(22))
				.addGroup(gl_contentPaneW2.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPaneW2.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblOrtW2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStrasseW2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneW2.createParallelGroup(Alignment.LEADING)
						.addComponent(txtFStrasseW2)
						.addComponent(txtFOrtW2, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPaneW2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPaneW2.createSequentialGroup()
							.addGap(26)
							.addComponent(lblPLZW2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtFPLZW2, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
						.addGroup(gl_contentPaneW2.createSequentialGroup()
							.addComponent(lblHNW2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtFHNW2, 0, 0, Short.MAX_VALUE)))
					.addGap(41))
				.addGroup(Alignment.TRAILING, gl_contentPaneW2.createSequentialGroup()
					.addGap(75)
					.addComponent(btnSaveW2, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnLöschenW2, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
					.addGap(82))
		);
		gl_contentPaneW2.setVerticalGroup(
			gl_contentPaneW2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneW2.createSequentialGroup()
					.addComponent(btnZurückW2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPaneW2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAuswahlW2)
						.addComponent(txtArAuswahlW2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separatorW2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneW2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStrasseW2)
						.addComponent(txtFStrasseW2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHNW2)
						.addComponent(txtFHNW2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneW2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOrtW2)
						.addComponent(txtFOrtW2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFPLZW2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPLZW2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneW2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMieteW2)
						.addComponent(txtFMieteW2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneW2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZimmerW2)
						.addComponent(txtFZimmerW2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBaederW2)
						.addComponent(txtFBaederW2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(czbEbkW2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(czbStatusW2)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(gl_contentPaneW2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSaveW2)
						.addComponent(btnLöschenW2))
					.addContainerGap())
		);
		contentPaneW2.setLayout(gl_contentPaneW2);
	}
	
	////////////////////////////////////////////////////////////////////
	// Enthält den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
		////////////////////////////////////////////////////////////////////
		//Enthält den Code für den "Zurück" Button
		////////////////////////////////////////////////////////////////////
		btnZurückW2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Wohnung_Level1 wohnung1;
				try {
					wohnung1 = new Wohnung_Level1();
					wohnung1.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		////////////////////////////////////////////////////////////////////
		// Enthält den Code für den Button "änderungen speichern
		////////////////////////////////////////////////////////////////////
		btnSaveW2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectionEbk = czbEbkW2.isSelected() ? 1 : 0;
				int selectionStatus = czbStatusW2.isSelected() ? 1 : 0;
				
				try {
					int adr_id = adresse.get_adress_id(txtFPLZW2.getText(), txtFOrtW2.getText(),
							txtFStrasseW2.getText(), txtFHNW2.getText());
					if (adr_id == 0) {
						adresse.set_address_value(txtFPLZW2.getText(), txtFOrtW2.getText(),
							txtFStrasseW2.getText(), txtFHNW2.getText());
					} else {
						wohnung.change_adress_id(nr, adr_id);
					}
					wohnung.change_miete(nr, Double.parseDouble(txtFMieteW2.getText()));
					wohnung.change_zimmer(nr, Double.parseDouble(txtFZimmerW2.getText()));
					wohnung.change_baeder(nr, Double.parseDouble(txtFBaederW2.getText()));
					wohnung.change_ebk(nr, selectionEbk);
					wohnung.change_vermietet(nr, selectionStatus);
					JOptionPane.showMessageDialog(null, "Die Änderungen wurden gespeichert.");
					dispose();
					Wohnung_Level1 wohnung1;
					wohnung1 = new Wohnung_Level1();
					wohnung1.setVisible(true);
				} catch (ClassNotFoundException | SQLException | NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Die Werte konnten nicht gespeichert werden."
							+ " Überprüfen Sie die Datentypen und versuchen Sie erneut.");
				}
				
			}
		});
		////////////////////////////////////////////////////////////////////
		//Enthält den Code für den Button "Wohnung löschen"
		////////////////////////////////////////////////////////////////////
		btnLöschenW2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					wohnung.delete(nr);
					JOptionPane.showMessageDialog(null, "Die Wohnung wurde gelöscht.");
					dispose();
					Wohnung_Level1 wohnung1;
					wohnung1 = new Wohnung_Level1();
					wohnung1.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}
}
