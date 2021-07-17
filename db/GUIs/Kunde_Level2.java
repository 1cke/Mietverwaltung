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

public class Kunde_Level2 extends JFrame {

	private JPanel contentPaneK2;
	private JTextField txtFVornameK2;
	private JTextField txtFNachnameK2;
	private JTextField txtFGeburtstagK2;
	private JTextField txtFTelefonK2;
	private JTextField txtFEmailK2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kunde_Level2 frame = new Kunde_Level2();
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
	public Kunde_Level2() {
		setTitle("Kunde bearbeiten/l\u00F6schen");
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 344);
		contentPaneK2 = new JPanel();
		contentPaneK2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneK2);
		
		JButton btnZurückK2 = new JButton("Zum Kunden-Men\u00FC");
		
		JLabel lblAuswahlK2 = new JLabel("Ausgew\u00E4hlter Kunde:");
		
		JTextArea txtArAuswahlK2 = new JTextArea();
		
		JSeparator separatorK2 = new JSeparator();
		
		JLabel lblVornameK2 = new JLabel("Vorname: ");
		
		txtFVornameK2 = new JTextField();
		txtFVornameK2.setColumns(10);
		
		JLabel lblNachnameK2 = new JLabel("Nachname:");
		
		txtFNachnameK2 = new JTextField();
		txtFNachnameK2.setColumns(10);
		
		JLabel lblGeburtstagK2 = new JLabel("Geboren am:");
		
		txtFGeburtstagK2 = new JTextField();
		txtFGeburtstagK2.setHorizontalAlignment(SwingConstants.CENTER);
		txtFGeburtstagK2.setColumns(10);
		
		JLabel lblTelefonK2 = new JLabel("Telefon:");
		
		txtFTelefonK2 = new JTextField();
		txtFTelefonK2.setColumns(10);
		
		JLabel lblEmailK2 = new JLabel("E-Mail:");
		
		txtFEmailK2 = new JTextField();
		txtFEmailK2.setColumns(10);
		
		JCheckBox czbInteressentK2 = new JCheckBox("Interessent");
		
		JButton btnSaveK2 = new JButton("\u00C4nderungen speichern");
		
		JButton btnLöschenK2 = new JButton("Kunden l\u00F6schen");
		
		JCheckBox czbAktivK2 = new JCheckBox("aktiver Kunde");
		czbAktivK2.setSelected(true);
		GroupLayout gl_contentPaneK2 = new GroupLayout(contentPaneK2);
		gl_contentPaneK2.setHorizontalGroup(
			gl_contentPaneK2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPaneK2.createSequentialGroup()
					.addGroup(gl_contentPaneK2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnZurückK2)
						.addGroup(gl_contentPaneK2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAuswahlK2)
							.addGap(18)
							.addComponent(txtArAuswahlK2, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
						.addComponent(separatorK2, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
					.addGap(7))
				.addGroup(Alignment.LEADING, gl_contentPaneK2.createSequentialGroup()
					.addGap(59)
					.addComponent(btnSaveK2, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnLöschenK2, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
					.addGap(110))
				.addGroup(Alignment.LEADING, gl_contentPaneK2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneK2.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblGeburtstagK2)
						.addComponent(lblNachnameK2)
						.addComponent(lblVornameK2)
						.addComponent(lblTelefonK2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmailK2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneK2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPaneK2.createSequentialGroup()
							.addComponent(czbAktivK2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
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
		// TODO Auto-generated method stub
		
	}
}
