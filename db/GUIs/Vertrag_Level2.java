package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Vertrag;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Vertrag_Level2 extends JFrame {

	private JPanel contentPaneV2;
	private JTextField txtFKundenIDV2;
	private JTextField txtFWohnungsIDV2;
	private JTextField txtFZeitraumV2;
	private JTextField txtFSchuldenV2;
	private JButton btnZurückV2;
	private JButton btnSaveV2;
	private JButton btnLöschenV2;
	private Vertrag vertrag;
	private JTextArea txtArAuswahlV2;
	private JCheckBox czbAktivV2;
	private String auswahl;
	private String nrV2;
	private int nr;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Vertrag_Level2(String chosen_one) throws ClassNotFoundException, SQLException {
		auswahl = chosen_one;
		vertrag = new Vertrag();
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() throws ClassNotFoundException, SQLException {
		nrV2 = auswahl.substring(0, auswahl.indexOf(" "));
		nr = Integer.parseInt(nrV2);
		vertrag.lade_vertrags_daten(nr);
		
		setTitle("Vertrag bearbeiten/löschen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 276);
		contentPaneV2 = new JPanel();
		contentPaneV2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneV2);
		
		btnZurückV2 = new JButton("Zum Vertrags-Menü");
		
		JLabel lblAuswahlV2 = new JLabel("Ausgewählter Vertrag:");
		
		txtArAuswahlV2 = new JTextArea();
		txtArAuswahlV2.setText(auswahl);
		
		JSeparator separatorV2 = new JSeparator();
		
		JLabel lblKundenIDV2 = new JLabel("Kunden-ID:");
		
		txtFKundenIDV2 = new JTextField();
		txtFKundenIDV2.setColumns(10);
		txtFKundenIDV2.setText(String.valueOf(vertrag.get_kd_id()));
		
		JLabel lblWohnungsIDV2 = new JLabel("Wohnungs-ID:");
		
		txtFWohnungsIDV2 = new JTextField();
		txtFWohnungsIDV2.setColumns(10);
		txtFWohnungsIDV2.setText(String.valueOf(vertrag.get_whg_id()));
		
		JLabel lblZeitraumV2 = new JLabel("Zeitraum:");
		
		txtFZeitraumV2 = new JTextField();
		txtFZeitraumV2.setHorizontalAlignment(SwingConstants.CENTER);
		txtFZeitraumV2.setColumns(10);
		txtFZeitraumV2.setText(vertrag.get_zeitraum());
		
		JLabel lblSchuldenV2 = new JLabel("Schulden:");
		
		txtFSchuldenV2 = new JTextField();
		txtFSchuldenV2.setColumns(10);
		txtFSchuldenV2.setText(String.valueOf(vertrag.get_schulden()));
		
		btnSaveV2 = new JButton("\u00C4nderungen speichern");
		
		btnLöschenV2 = new JButton("Vertrag löschen");
		
		czbAktivV2 = new JCheckBox("aktiver Vertrag");
		czbAktivV2.setSelected(true);
		if (vertrag.get_aktiv()) {
			czbAktivV2.setSelected(true);
		} else {
			czbAktivV2.setSelected(false);
		}
		
		GroupLayout gl_contentPaneV2 = new GroupLayout(contentPaneV2);
		gl_contentPaneV2.setHorizontalGroup(
			gl_contentPaneV2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneV2.createSequentialGroup()
					.addGroup(gl_contentPaneV2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnZurückV2)
						.addGroup(gl_contentPaneV2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAuswahlV2)
							.addGap(18)
							.addComponent(txtArAuswahlV2, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
						.addComponent(separatorV2, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
					.addGap(7))
				.addGroup(gl_contentPaneV2.createSequentialGroup()
					.addGap(59)
					.addComponent(btnSaveV2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnLöschenV2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(110))
				.addGroup(gl_contentPaneV2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneV2.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblZeitraumV2)
						.addComponent(lblWohnungsIDV2)
						.addComponent(lblKundenIDV2)
						.addComponent(lblSchuldenV2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneV2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPaneV2.createSequentialGroup()
							.addComponent(czbAktivV2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPaneV2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPaneV2.createSequentialGroup()
								.addComponent(txtFSchuldenV2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addGap(251))
							.addGroup(gl_contentPaneV2.createSequentialGroup()
								.addGroup(gl_contentPaneV2.createParallelGroup(Alignment.LEADING)
									.addComponent(txtFWohnungsIDV2, 264, 264, Short.MAX_VALUE)
									.addComponent(txtFKundenIDV2, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
								.addGap(95))
							.addGroup(gl_contentPaneV2.createSequentialGroup()
								.addComponent(txtFZeitraumV2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))))
		);
		gl_contentPaneV2.setVerticalGroup(
			gl_contentPaneV2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneV2.createSequentialGroup()
					.addComponent(btnZurückV2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneV2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAuswahlV2)
						.addComponent(txtArAuswahlV2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separatorV2, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneV2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKundenIDV2)
						.addComponent(txtFKundenIDV2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneV2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWohnungsIDV2)
						.addComponent(txtFWohnungsIDV2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneV2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZeitraumV2)
						.addComponent(txtFZeitraumV2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneV2.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFSchuldenV2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSchuldenV2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(czbAktivV2)
					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
					.addGroup(gl_contentPaneV2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSaveV2)
						.addComponent(btnLöschenV2)))
		);
		contentPaneV2.setLayout(gl_contentPaneV2);
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
		btnZurückV2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Vertrag_Level1 vertrag1 = new Vertrag_Level1();
				vertrag1.setVisible(true);
			}
		});
		////////////////////////////////////////////////////////////////////
		// Enthält den Code für den "Änderungen speichern" Button
		////////////////////////////////////////////////////////////////////
		btnSaveV2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectionStatus = czbAktivV2.isSelected() ? 1 : 0;
				
				try {
					
					vertrag.change_kundennummer(nr, Integer.parseInt(txtFKundenIDV2.getText()));
					vertrag.change_wohnungsnummer(nr, Integer.parseInt(txtFWohnungsIDV2.getText()));
					vertrag.change_zeitraum(nr, txtFZeitraumV2.getText());
					vertrag.change_schulden(nr, Double.parseDouble(txtFSchuldenV2.getText()));
					vertrag.change_aktiv(nr, selectionStatus);
					
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
////////////////////////////////////////////////////////////////////
// Enthält den Code für den "Vertrag löschen" Button
////////////////////////////////////////////////////////////////////
		btnLöschenV2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					vertrag.delete(nr);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
