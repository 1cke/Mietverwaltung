package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Kontakt;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Kontaktpunkt_Level2 extends JFrame {

	private JPanel contentPaneKP2;
	private JTextField txtFVertragsIDKP2;
	private JTextField txtFDatumKP2;
	private JTextField txtFGrundKP2;
	private JTextField txtFBeschreibungKP2;
	private JButton btnZurückKP2;
	private JButton btnSaveKP2;
	private JButton btnLöschenKP2;
	private Kontakt kontakt;
	private JTextArea txtArAuswahlKP2;
	private JCheckBox czbStatusKP2;
	private String auswahl;
	private String nrKP2;
	private int nr;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Kontaktpunkt_Level2(String chosen_one) throws ClassNotFoundException, SQLException {
		auswahl = chosen_one;
		kontakt = new Kontakt();
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////////////
	// Enthält den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() throws ClassNotFoundException, SQLException {
		
		nrKP2 = auswahl.substring(0, auswahl.indexOf(" "));
		nr = Integer.parseInt(nrKP2);
		kontakt.lade_daten(nr);
		
		setTitle("Kontaktpunkt bearbeiten/löschen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 311);
		contentPaneKP2 = new JPanel();
		contentPaneKP2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneKP2);
		
		btnZurückKP2 = new JButton("Zum Kontaktpunkte-Menü");
		
		JLabel lblAuswahlKP2 = new JLabel("Ausgewählter Kontaktpunkt:");
		
		txtArAuswahlKP2 = new JTextArea();
		txtArAuswahlKP2.setText(auswahl);
		
		JSeparator separatorKP2 = new JSeparator();
		
		JLabel lblVertragsIDKP2 = new JLabel("Vertrags-ID:");
		
		txtFVertragsIDKP2 = new JTextField();
		txtFVertragsIDKP2.setColumns(10);
		txtFVertragsIDKP2.setText(String.valueOf(kontakt.get_vertrags_id()));
		
		JLabel lblDatumKP2 = new JLabel("Gemeldet am:");
		
		txtFDatumKP2 = new JTextField();
		txtFDatumKP2.setHorizontalAlignment(SwingConstants.CENTER);
		txtFDatumKP2.setColumns(10);
		txtFDatumKP2.setText(kontakt.get_wann());
		
		JLabel lblGrundKP2 = new JLabel("Grund:");
		
		txtFGrundKP2 = new JTextField();
		txtFGrundKP2.setColumns(10);
		txtFGrundKP2.setText(kontakt.get_grund());
		
		JLabel lblBeschreibungKP2 = new JLabel("Beschreibung:");
		
		txtFBeschreibungKP2 = new JTextField();
		txtFBeschreibungKP2.setColumns(10);
		txtFBeschreibungKP2.setText(kontakt.get_beschreibung());
		
		btnSaveKP2 = new JButton("\u00C4nderungen speichern");
		
		btnLöschenKP2 = new JButton("Kontaktpunkt löschen");
		
		czbStatusKP2 = new JCheckBox("Behoben");
		GroupLayout gl_contentPaneKP2 = new GroupLayout(contentPaneKP2);
		gl_contentPaneKP2.setHorizontalGroup(
			gl_contentPaneKP2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneKP2.createSequentialGroup()
					.addGroup(gl_contentPaneKP2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnZurückKP2)
						.addGroup(gl_contentPaneKP2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAuswahlKP2)
							.addGap(18)
							.addComponent(txtArAuswahlKP2, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
							.addGap(63))
						.addComponent(separatorKP2, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
					.addGap(7))
				.addGroup(gl_contentPaneKP2.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_contentPaneKP2.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBeschreibungKP2)
						.addComponent(lblVertragsIDKP2)
						.addComponent(lblGrundKP2)
						.addComponent(lblDatumKP2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPaneKP2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPaneKP2.createSequentialGroup()
							.addComponent(txtFGrundKP2, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
							.addGap(95))
						.addGroup(Alignment.TRAILING, gl_contentPaneKP2.createSequentialGroup()
							.addGroup(gl_contentPaneKP2.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPaneKP2.createSequentialGroup()
									.addGroup(gl_contentPaneKP2.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtFVertragsIDKP2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
										.addComponent(txtFDatumKP2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
									.addGap(85)
									.addComponent(czbStatusKP2))
								.addComponent(txtFBeschreibungKP2, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
							.addGap(78))))
				.addGroup(gl_contentPaneKP2.createSequentialGroup()
					.addGap(70)
					.addComponent(btnSaveKP2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnLöschenKP2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(99))
		);
		gl_contentPaneKP2.setVerticalGroup(
			gl_contentPaneKP2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneKP2.createSequentialGroup()
					.addComponent(btnZurückKP2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneKP2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAuswahlKP2)
						.addComponent(txtArAuswahlKP2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separatorKP2, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneKP2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVertragsIDKP2)
						.addComponent(txtFVertragsIDKP2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(czbStatusKP2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneKP2.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFDatumKP2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDatumKP2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneKP2.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFGrundKP2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGrundKP2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneKP2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBeschreibungKP2)
						.addComponent(txtFBeschreibungKP2, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneKP2.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(btnLöschenKP2)
						.addComponent(btnSaveKP2))
					.addGap(1))
		);
		contentPaneKP2.setLayout(gl_contentPaneKP2);
	}

	////////////////////////////////////////////////////////////////////
	// Enthält den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
		////////////////////////////////////////////////////////////////////
		//Enthält den Code für den "Zurück" Button
		////////////////////////////////////////////////////////////////////
		btnZurückKP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Kontaktpunkt_Level1 kontakt1;
				try {
					kontakt1 = new Kontaktpunkt_Level1();
					kontakt1.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		////////////////////////////////////////////////////////////////////
		//Enthält den Code für den "Änderungen speichern" Button
		////////////////////////////////////////////////////////////////////
		btnSaveKP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectionStatus = czbStatusKP2.isSelected() ? 1 : 0;
				
				try {
					kontakt.change_beschreibung(nr, txtFBeschreibungKP2.getText());
					kontakt.change_behoben(nr, selectionStatus);
					JOptionPane.showMessageDialog(null, "Die Änderungen wurden gespeichert.");
					dispose();
					Kontaktpunkt_Level1 kontakt1;
					kontakt1 = new Kontaktpunkt_Level1();
					kontakt1.setVisible(true);
				} catch (ClassNotFoundException | SQLException | NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Die Werte konnten nicht gespeichert werden."
							+ " Überprüfen Sie die Datentypen und versuchen Sie erneut.");
				}
			}
		});	
		////////////////////////////////////////////////////////////////////
		//Enthält den Code für den "Löschen" Button
		////////////////////////////////////////////////////////////////////
		btnLöschenKP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(null, "Löschen konnte nicht durchgeführt werden.");
			}
		});
		
	}
}
