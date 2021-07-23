package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Kunden;

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

public class Kunde_Level2 extends JFrame {

	private JPanel contentPaneK2;
	private JTextField txtFVornameK2;
	private JTextField txtFNachnameK2;
	private JTextField txtFGeburtstagK2;
	private JTextField txtFTelefonK2;
	private JTextField txtFEmailK2;
	private JButton btnZurückK2;
	private JButton btnSaveK2;
	private JButton btnLöschenK2;
	private Kunden kunde;
	private JTextArea txtArAuswahlK2;
	private JCheckBox czbInteressentK2;
	private JCheckBox czbAktivK2;
	private String auswahl;
	private String nrK2;
	private int nr;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Kunde_Level2(String chosen_one) throws ClassNotFoundException, SQLException {
		auswahl = chosen_one;
		kunde = new Kunden();
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() throws ClassNotFoundException, SQLException{

		nrK2 = auswahl.substring(0, auswahl.indexOf(" "));
		nr = Integer.parseInt(nrK2);
		kunde.lade_kunden_daten(nr);
		
		setTitle("Kunde bearbeiten/l\u00F6schen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 344);
		contentPaneK2 = new JPanel();
		contentPaneK2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneK2);
		
		btnZurückK2 = new JButton("Zum Kunden-Men\u00FC");
		
		JLabel lblAuswahlK2 = new JLabel("Ausgew\u00E4hlter Kunde:");
		
		txtArAuswahlK2 = new JTextArea();
		txtArAuswahlK2.setText(auswahl);
		
		JSeparator separatorK2 = new JSeparator();
		
		JLabel lblVornameK2 = new JLabel("Vorname: ");
		
		txtFVornameK2 = new JTextField();
		txtFVornameK2.setColumns(10);
		txtFVornameK2.setText(kunde.get_vorname());
		
		JLabel lblNachnameK2 = new JLabel("Nachname:");
		
		txtFNachnameK2 = new JTextField();
		txtFNachnameK2.setColumns(10);
		txtFNachnameK2.setText(kunde.get_nachname());
		
		JLabel lblGeburtstagK2 = new JLabel("Geboren am:");
		
		txtFGeburtstagK2 = new JTextField();
		txtFGeburtstagK2.setHorizontalAlignment(SwingConstants.CENTER);
		txtFGeburtstagK2.setColumns(10);
		txtFGeburtstagK2.setText(kunde.get_geburtstag());
		
		JLabel lblTelefonK2 = new JLabel("Telefon:");
		
		txtFTelefonK2 = new JTextField();
		txtFTelefonK2.setColumns(10);
		txtFTelefonK2.setText(kunde.get_telefon());
		
		JLabel lblEmailK2 = new JLabel("E-Mail:");
		
		txtFEmailK2 = new JTextField();
		txtFEmailK2.setColumns(10);
		txtFEmailK2.setText(kunde.getEmail());
		
		czbInteressentK2 = new JCheckBox("Interessent");
		if (kunde.get_interessent()) {
			czbInteressentK2.setSelected(true);
		} else {
			czbInteressentK2.setSelected(false);
		}
		
		btnSaveK2 = new JButton("\u00C4nderungen speichern");
		
		btnLöschenK2 = new JButton("Kunden l\u00F6schen");
		
		czbAktivK2 = new JCheckBox("aktiver Kunde");
		czbAktivK2.setSelected(true);
		if (kunde.get_aktiv()) {
			czbAktivK2.setSelected(true);
		} else {
			czbAktivK2.setSelected(false);
		}
		
		GroupLayout gl_contentPaneK2 = new GroupLayout(contentPaneK2);
		gl_contentPaneK2.setHorizontalGroup(
			gl_contentPaneK2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneK2.createSequentialGroup()
					.addGroup(gl_contentPaneK2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnZurückK2)
						.addGroup(gl_contentPaneK2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAuswahlK2)
							.addGap(18)
							.addComponent(txtArAuswahlK2, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(separatorK2, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
					.addGap(7))
				.addGroup(gl_contentPaneK2.createSequentialGroup()
					.addGap(59)
					.addComponent(btnSaveK2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnLöschenK2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(110))
				.addGroup(gl_contentPaneK2.createSequentialGroup()
					.addGap(3)
					.addGroup(gl_contentPaneK2.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblGeburtstagK2)
						.addComponent(lblNachnameK2)
						.addComponent(lblVornameK2)
						.addComponent(lblEmailK2)
						.addGroup(gl_contentPaneK2.createSequentialGroup()
							.addGap(23)
							.addComponent(lblTelefonK2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneK2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPaneK2.createSequentialGroup()
							.addComponent(czbAktivK2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(263))
						.addGroup(gl_contentPaneK2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPaneK2.createSequentialGroup()
								.addComponent(czbInteressentK2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_contentPaneK2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPaneK2.createSequentialGroup()
									.addComponent(txtFTelefonK2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
									.addGap(251))
								.addGroup(gl_contentPaneK2.createSequentialGroup()
									.addGroup(gl_contentPaneK2.createParallelGroup(Alignment.LEADING)
										.addComponent(txtFNachnameK2, 264, 264, Short.MAX_VALUE)
										.addComponent(txtFVornameK2, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
										.addComponent(txtFEmailK2, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
									.addGap(95))
								.addGroup(gl_contentPaneK2.createSequentialGroup()
									.addComponent(txtFGeburtstagK2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
									.addGap(288))))))
		);
		gl_contentPaneK2.setVerticalGroup(
			gl_contentPaneK2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneK2.createSequentialGroup()
					.addComponent(btnZurückK2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneK2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAuswahlK2)
						.addComponent(txtArAuswahlK2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separatorK2, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneK2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVornameK2)
						.addComponent(txtFVornameK2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneK2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNachnameK2)
						.addComponent(txtFNachnameK2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneK2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGeburtstagK2)
						.addComponent(txtFGeburtstagK2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneK2.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFTelefonK2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefonK2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneK2.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFEmailK2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmailK2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(czbInteressentK2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(czbAktivK2)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(gl_contentPaneK2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSaveK2)
						.addComponent(btnLöschenK2)))
		);
		contentPaneK2.setLayout(gl_contentPaneK2);
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
		btnZurückK2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Kunde_Level1 kunde1 = new Kunde_Level1();
				kunde1.setVisible(true);
			}
		});
////////////////////////////////////////////////////////////////////
// Enthält den Code für den Button "Änderungen speichern
////////////////////////////////////////////////////////////////////
		btnSaveK2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectionInteressent = czbInteressentK2.isSelected() ? 1 : 0;
				int selectionAktiv = czbAktivK2.isSelected() ? 1 : 0;
				
				try {
					kunde.change_vorname(nr, txtFVornameK2.getText());
					kunde.change_nachname(nr, txtFNachnameK2.getText());
					kunde.change_geburtstag(nr, txtFGeburtstagK2.getText());
					kunde.change_telefon(nr, txtFTelefonK2.getText());
					kunde.change_email(nr, txtFEmailK2.getText());
					kunde.change_interessent(nr, selectionInteressent);
					kunde.change_aktiv(nr, selectionAktiv);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
}
