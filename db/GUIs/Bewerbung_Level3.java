package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Bewerbung;

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

public class Bewerbung_Level3 extends JFrame {

	private JPanel contentPaneB3;
	private JTextField txtFKundenIDB3;
	private JTextField txtFWohnungsIDB3;
	private JTextField txtFDatumB3;
	private JButton btnZurückB3;
	private JButton btnHinzufügenB3;
	private Bewerbung bewerbung;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Bewerbung_Level3() throws ClassNotFoundException, SQLException {
		setTitle("Bewerbung hinzufügen");
		initComponents();
		createEvents();
		bewerbung = new Bewerbung();
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 215);
		contentPaneB3 = new JPanel();
		contentPaneB3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneB3);
		
		btnZurückB3 = new JButton("Zum Bewerbungs-Men\u00FC");
		
		JLabel lblKundenIDB3 = new JLabel("Kunden-ID:");
		
		txtFKundenIDB3 = new JTextField();
		txtFKundenIDB3.setColumns(10);
		
		JLabel lblWohnungsIDB3 = new JLabel("Wohnungs-ID");
		
		txtFWohnungsIDB3 = new JTextField();
		txtFWohnungsIDB3.setColumns(10);
		
		JLabel lblDatumB3 = new JLabel("Datum:");
		
		txtFDatumB3 = new JTextField();
		txtFDatumB3.setHorizontalAlignment(SwingConstants.CENTER);
		txtFDatumB3.setColumns(10);
		
		btnHinzufügenB3 = new JButton("Bewerbung hinzuf\u00FCgen");
		GroupLayout gl_contentPaneB3 = new GroupLayout(contentPaneB3);
		gl_contentPaneB3.setHorizontalGroup(
			gl_contentPaneB3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneB3.createSequentialGroup()
					.addComponent(btnZurückB3)
					.addContainerGap(281, Short.MAX_VALUE))
				.addGroup(gl_contentPaneB3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneB3.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDatumB3)
						.addComponent(lblWohnungsIDB3)
						.addComponent(lblKundenIDB3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneB3.createParallelGroup(Alignment.LEADING)
						.addComponent(txtFWohnungsIDB3, 264, 268, Short.MAX_VALUE)
						.addComponent(txtFKundenIDB3, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
						.addGroup(gl_contentPaneB3.createSequentialGroup()
							.addComponent(txtFDatumB3, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(193)))
					.addGap(95))
				.addGroup(gl_contentPaneB3.createSequentialGroup()
					.addGap(131)
					.addComponent(btnHinzufügenB3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(154))
		);
		gl_contentPaneB3.setVerticalGroup(
			gl_contentPaneB3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneB3.createSequentialGroup()
					.addComponent(btnZurückB3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPaneB3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKundenIDB3)
						.addComponent(txtFKundenIDB3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneB3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWohnungsIDB3)
						.addComponent(txtFWohnungsIDB3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneB3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDatumB3)
						.addComponent(txtFDatumB3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnHinzufügenB3)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		contentPaneB3.setLayout(gl_contentPaneB3);
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
////////////////////////////////////////////////////////////////////
//Enthält den Code für den "Zurück" Button
////////////////////////////////////////////////////////////////////
		btnZurückB3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Bewerbung_Level1 bewerbung1;
				try {
					bewerbung1 = new Bewerbung_Level1();
					bewerbung1.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
////////////////////////////////////////////////////////////////////
//Enthält den Code für den "Hinzufügen" Button
////////////////////////////////////////////////////////////////////
		btnHinzufügenB3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bewerbung.set_bewerbung(Integer.parseInt(txtFKundenIDB3.getText()), Integer.parseInt(txtFWohnungsIDB3.getText()),
							txtFDatumB3.getText());
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Die Bewerbung wurde hinzugefügt.");
				//Code für das Zurückkehren auf Bewerbung lvl 1
				dispose();
				Bewerbung_Level1 bewerbung1;
				try {
					bewerbung1 = new Bewerbung_Level1();
					bewerbung1.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}
}
