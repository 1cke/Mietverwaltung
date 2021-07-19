package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kontaktpunkt_Level2 frame = new Kontaktpunkt_Level2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Kontaktpunkt_Level2() {
		setTitle("Kontaktpunkt bearbeiten/löschen");
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 302);
		contentPaneKP2 = new JPanel();
		contentPaneKP2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneKP2);
		
		btnZurückKP2 = new JButton("Zum Kontaktpunkte-Menü");
		
		JLabel lblAuswahlKP2 = new JLabel("Ausgewählter Kontaktpunkt:");
		
		JTextArea txtArAuswahlKP2 = new JTextArea();
		
		JSeparator separatorKP2 = new JSeparator();
		
		JLabel lblVertragsIDKP2 = new JLabel("Vertrags-ID:");
		
		txtFVertragsIDKP2 = new JTextField();
		txtFVertragsIDKP2.setColumns(10);
		
		JLabel lblDatumKP2 = new JLabel("Gemeldet am:");
		
		txtFDatumKP2 = new JTextField();
		txtFDatumKP2.setHorizontalAlignment(SwingConstants.CENTER);
		txtFDatumKP2.setColumns(10);
		
		JLabel lblGrundKP2 = new JLabel("Grund:");
		
		txtFGrundKP2 = new JTextField();
		txtFGrundKP2.setColumns(10);
		
		JLabel lblBeschreibungKP2 = new JLabel("Beschreibung:");
		
		txtFBeschreibungKP2 = new JTextField();
		txtFBeschreibungKP2.setColumns(10);
		
		btnSaveKP2 = new JButton("\u00C4nderungen speichern");
		
		btnLöschenKP2 = new JButton("Kontaktpunkt löschen");
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
							.addComponent(txtArAuswahlKP2, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
							.addGap(26))
						.addComponent(separatorKP2, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
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
						.addGroup(Alignment.TRAILING, gl_contentPaneKP2.createSequentialGroup()
							.addComponent(txtFDatumKP2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(260))
						.addGroup(Alignment.TRAILING, gl_contentPaneKP2.createSequentialGroup()
							.addGroup(gl_contentPaneKP2.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtFGrundKP2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
								.addComponent(txtFVertragsIDKP2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
							.addGap(95))
						.addGroup(gl_contentPaneKP2.createSequentialGroup()
							.addComponent(txtFBeschreibungKP2, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
							.addGap(40))))
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
						.addComponent(txtFVertragsIDKP2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(txtFBeschreibungKP2, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneKP2.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(btnLöschenKP2)
						.addComponent(btnSaveKP2))
					.addGap(1))
		);
		contentPaneKP2.setLayout(gl_contentPaneKP2);
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
		btnZurückKP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Kontaktpunkt_Level1 kontakt1 = new Kontaktpunkt_Level1();
				kontakt1.setVisible(true);
			}
		});
		
	}
}
