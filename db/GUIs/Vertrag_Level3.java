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

public class Vertrag_Level3 extends JFrame {

	private JPanel contentPaneV3;
	private JTextField txtFKundenIDV3;
	private JTextField txtFWohnungsIDV3;
	private JTextField txtFZeitraumV3;
	private JTextField txtFSchuldenV3;
	private JButton btnZurückV3;
	private JButton btnHinzufügenV2;
	private Vertrag vertrag;
	private JCheckBox czbAktivV3;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Vertrag_Level3() throws ClassNotFoundException, SQLException {
		initComponents();
		createEvents();
		vertrag = new Vertrag();
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		setTitle("Vertrag hinzufügen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 245);
		contentPaneV3 = new JPanel();
		contentPaneV3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneV3);
		
		btnZurückV3 = new JButton("Zum Vertrags-Menü");
		
		JLabel lblKundenIDV3 = new JLabel("Kunden-ID:");
		
		txtFKundenIDV3 = new JTextField();
		txtFKundenIDV3.setColumns(10);
		
		JLabel lblWohnungsIDV3 = new JLabel("Wohnungs-ID:");
		
		txtFWohnungsIDV3 = new JTextField();
		txtFWohnungsIDV3.setColumns(10);
		
		JLabel lblZeitraumV3 = new JLabel("Zeitraum:");
		
		txtFZeitraumV3 = new JTextField();
		txtFZeitraumV3.setHorizontalAlignment(SwingConstants.CENTER);
		txtFZeitraumV3.setColumns(10);
		
		JLabel lblSchuldenV3 = new JLabel("Schulden:");
		
		txtFSchuldenV3 = new JTextField();
		txtFSchuldenV3.setColumns(10);
		
		btnHinzufügenV2 = new JButton("Vertrag hinzufügen");
		
		czbAktivV3 = new JCheckBox("aktiver Vertrag");
		czbAktivV3.setSelected(true);
		GroupLayout gl_contentPaneV3 = new GroupLayout(contentPaneV3);
		gl_contentPaneV3.setHorizontalGroup(
			gl_contentPaneV3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneV3.createSequentialGroup()
					.addComponent(btnZurückV3)
					.addContainerGap(299, Short.MAX_VALUE))
				.addGroup(gl_contentPaneV3.createSequentialGroup()
					.addGap(151)
					.addComponent(btnHinzufügenV2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(164))
				.addGroup(gl_contentPaneV3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneV3.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblZeitraumV3)
						.addComponent(lblWohnungsIDV3)
						.addComponent(lblKundenIDV3)
						.addComponent(lblSchuldenV3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneV3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPaneV3.createSequentialGroup()
							.addComponent(czbAktivV3, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPaneV3.createSequentialGroup()
							.addGroup(gl_contentPaneV3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPaneV3.createSequentialGroup()
									.addComponent(txtFSchuldenV3, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
									.addGap(156))
								.addComponent(txtFWohnungsIDV3, 264, 276, Short.MAX_VALUE)
								.addComponent(txtFKundenIDV3, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
								.addGroup(gl_contentPaneV3.createSequentialGroup()
									.addComponent(txtFZeitraumV3, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 127, GroupLayout.PREFERRED_SIZE)))
							.addGap(67))))
		);
		gl_contentPaneV3.setVerticalGroup(
			gl_contentPaneV3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneV3.createSequentialGroup()
					.addComponent(btnZurückV3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPaneV3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKundenIDV3)
						.addComponent(txtFKundenIDV3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneV3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWohnungsIDV3)
						.addComponent(txtFWohnungsIDV3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneV3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZeitraumV3)
						.addComponent(txtFZeitraumV3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneV3.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFSchuldenV3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSchuldenV3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(czbAktivV3)
					.addGap(7)
					.addComponent(btnHinzufügenV2)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPaneV3.setLayout(gl_contentPaneV3);
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
////////////////////////////////////////////////////////////////////
// Enthält den Code für den "Zurück" Button
////////////////////////////////////////////////////////////////////
		btnZurückV3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Vertrag_Level1 vertrag1;
				try {
					vertrag1 = new Vertrag_Level1();
					vertrag1.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
////////////////////////////////////////////////////////////////////
//Enthält den Code für den "Hinzufügen" Button
////////////////////////////////////////////////////////////////////
		btnHinzufügenV2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int selection = czbAktivV3.isSelected() ? 1 : 0;
					vertrag.set_db_value(Integer.parseInt(txtFKundenIDV3.getText()),
							Integer.parseInt(txtFWohnungsIDV3.getText()), Double.parseDouble(txtFSchuldenV3.getText()),
							txtFZeitraumV3.getText(), selection);
				} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Der Vertrag wurde hinzugefügt.");
				//Code für das Zurückkehren auf Vertrag lvl 1
				dispose();
				Vertrag_Level1 vertrag1;
				try {
					vertrag1 = new Vertrag_Level1();
					vertrag1.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
}
