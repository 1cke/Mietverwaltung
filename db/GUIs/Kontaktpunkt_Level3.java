package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Kontakt;
import backend.Vertrag;

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

public class Kontaktpunkt_Level3 extends JFrame {

	private JPanel contentPaneKP3;
	private JTextField txtFVertragsIDKP3;
	private JTextField txtFDatumKP3;
	private JTextField txtFGrundKP3;
	private JTextField txtFBeschreibungKP3;
	private JButton btnZurückKP3;
	private JButton btnHinzufügenKP3;
	private Kontakt kontaktp;
	private Vertrag vertrag;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Kontaktpunkt_Level3() throws ClassNotFoundException, SQLException {
		kontaktp = new Kontakt();
		vertrag = new Vertrag();
		initComponents();
		createEvents(); 
	}

	////////////////////////////////////////////////////////////////////
	// Enthält den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		setTitle("Kontaktpunkt hinzufügen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 276);
		contentPaneKP3 = new JPanel();
		contentPaneKP3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneKP3);
		
		btnZurückKP3 = new JButton("Zum Kontaktpunkte-Menü");
		
		JLabel lblVertragsIDKP3 = new JLabel("Vertrags-ID:");
		
		txtFVertragsIDKP3 = new JTextField();
		txtFVertragsIDKP3.setColumns(10);
		
		JLabel lblDatumKP3 = new JLabel("Gemeldet am:");
		
		txtFDatumKP3 = new JTextField();
		txtFDatumKP3.setHorizontalAlignment(SwingConstants.CENTER);
		txtFDatumKP3.setColumns(10);
		
		JLabel lblGrundKP3 = new JLabel("Grund:");
		
		txtFGrundKP3 = new JTextField();
		txtFGrundKP3.setColumns(10);
		
		JLabel lblBeschreibungKP3 = new JLabel("Beschreibung:");
		
		txtFBeschreibungKP3 = new JTextField();
		txtFBeschreibungKP3.setColumns(10);
		
		btnHinzufügenKP3 = new JButton("Kontaktpunkt hinzufügen");
		
		GroupLayout gl_contentPaneKP3 = new GroupLayout(contentPaneKP3);
		gl_contentPaneKP3.setHorizontalGroup(
			gl_contentPaneKP3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneKP3.createSequentialGroup()
					.addComponent(btnZurückKP3)
					.addContainerGap(308, Short.MAX_VALUE))
				.addGroup(gl_contentPaneKP3.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPaneKP3.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBeschreibungKP3)
						.addComponent(lblVertragsIDKP3)
						.addComponent(lblGrundKP3)
						.addComponent(lblDatumKP3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPaneKP3.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPaneKP3.createSequentialGroup()
							.addComponent(txtFDatumKP3, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(220))
						.addGroup(gl_contentPaneKP3.createSequentialGroup()
							.addGroup(gl_contentPaneKP3.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtFGrundKP3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
								.addComponent(txtFVertragsIDKP3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
							.addGap(55))
						.addComponent(txtFBeschreibungKP3, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
					.addGap(38))
				.addGroup(Alignment.TRAILING, gl_contentPaneKP3.createSequentialGroup()
					.addGap(144)
					.addComponent(btnHinzufügenKP3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(131))
		);
		gl_contentPaneKP3.setVerticalGroup(
			gl_contentPaneKP3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneKP3.createSequentialGroup()
					.addComponent(btnZurückKP3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPaneKP3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVertragsIDKP3)
						.addComponent(txtFVertragsIDKP3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneKP3.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFDatumKP3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDatumKP3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneKP3.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFGrundKP3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGrundKP3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneKP3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBeschreibungKP3)
						.addComponent(txtFBeschreibungKP3, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnHinzufügenKP3))
		);
		contentPaneKP3.setLayout(gl_contentPaneKP3);
	}

	////////////////////////////////////////////////////////////////////
	// Enthält den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
		////////////////////////////////////////////////////////////////////
		//Enthält den Code für den "Zurück" Button
		////////////////////////////////////////////////////////////////////
		btnZurückKP3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Kontaktpunkt_Level1 kontakt1;
				try {
					kontakt1 = new Kontaktpunkt_Level1();
					kontakt1.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		////////////////////////////////////////////////////////////////////
		//Enthält den Code für den "Hinzufügen" Button
		////////////////////////////////////////////////////////////////////
		btnHinzufügenKP3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					vertrag.lade_vertrags_daten(Integer.parseInt(txtFVertragsIDKP3.getText()));
					int check = vertrag.get_kd_id();
					if (check != 0) {
					kontaktp.set_kontakt_value(Integer.parseInt(txtFVertragsIDKP3.getText()), txtFDatumKP3.getText(),
							txtFGrundKP3.getText(), txtFBeschreibungKP3.getText());
					JOptionPane.showMessageDialog(null, "Der Kontaktpunkt wurde hinzugefügt.");
					dispose();
					Kontaktpunkt_Level1 kontakt1;
					kontakt1 = new Kontaktpunkt_Level1();
					kontakt1.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Überprüfen Sie die Vertrags-ID.");
					}
				} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
					JOptionPane.showMessageDialog(null, "Etwas lief beim Hinzufügen schief."
							+ " Überprüfen Sie Ihre Eingabewerte und versuchen Sie erneut.");
				}
			}
		});
		
	}
}
