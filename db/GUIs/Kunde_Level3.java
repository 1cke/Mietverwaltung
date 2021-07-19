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

public class Kunde_Level3 extends JFrame {

	private JPanel contentPaneK3;
	private JTextField txtFVornameK3;
	private JTextField txtFNachnameK3;
	private JTextField txtFGeburtstagK3;
	private JTextField txtFTelefonK3;
	private JTextField txtFEmailK3;
	private JButton btnHinzufügenK3;
	private JButton btnZurückK3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kunde_Level3 frame = new Kunde_Level3();
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
	public Kunde_Level3() {
		setTitle("Kunde hinzufügen");
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 292);
		contentPaneK3 = new JPanel();
		contentPaneK3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneK3);
		
		btnZurückK3 = new JButton("Zum Kunden-Men\u00FC");
		
		JLabel lblVornameK3 = new JLabel("Vorname: ");
		
		txtFVornameK3 = new JTextField();
		txtFVornameK3.setColumns(10);
		
		JLabel lblNachnameK3 = new JLabel("Nachname:");
		
		txtFNachnameK3 = new JTextField();
		txtFNachnameK3.setColumns(10);
		
		JLabel lblGeburtstagK3 = new JLabel("Geboren am:");
		
		txtFGeburtstagK3 = new JTextField();
		txtFGeburtstagK3.setHorizontalAlignment(SwingConstants.CENTER);
		txtFGeburtstagK3.setColumns(10);
		
		JLabel lblTelefonK3 = new JLabel("Telefon:");
		
		txtFTelefonK3 = new JTextField();
		txtFTelefonK3.setColumns(10);
		
		JLabel lblEmailK3 = new JLabel("E-Mail:");
		
		txtFEmailK3 = new JTextField();
		txtFEmailK3.setColumns(10);
		
		JCheckBox czbInteressentK3 = new JCheckBox("Interessent");
		
		btnHinzufügenK3 = new JButton("Kunden hinzufügen");
		
		JCheckBox czbAktivK3 = new JCheckBox("aktiver Kunde");
		czbAktivK3.setSelected(true);
		GroupLayout gl_contentPaneK3 = new GroupLayout(contentPaneK3);
		gl_contentPaneK3.setHorizontalGroup(
			gl_contentPaneK3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneK3.createSequentialGroup()
					.addComponent(btnZurückK3)
					.addContainerGap(303, Short.MAX_VALUE))
				.addGroup(gl_contentPaneK3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneK3.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblGeburtstagK3)
						.addComponent(lblNachnameK3)
						.addComponent(lblVornameK3)
						.addComponent(lblEmailK3)
						.addGroup(gl_contentPaneK3.createSequentialGroup()
							.addGap(10)
							.addComponent(lblTelefonK3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneK3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPaneK3.createSequentialGroup()
							.addComponent(czbAktivK3, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
							.addGap(165))
						.addGroup(gl_contentPaneK3.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPaneK3.createSequentialGroup()
								.addComponent(czbInteressentK3, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 172, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPaneK3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPaneK3.createSequentialGroup()
									.addComponent(txtFTelefonK3, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
									.addGap(156))
								.addComponent(txtFNachnameK3, 264, 271, Short.MAX_VALUE)
								.addComponent(txtFVornameK3, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
								.addComponent(txtFEmailK3, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
								.addGroup(gl_contentPaneK3.createSequentialGroup()
									.addComponent(txtFGeburtstagK3, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
									.addGap(193)))))
					.addGap(86))
				.addGroup(gl_contentPaneK3.createSequentialGroup()
					.addGap(122)
					.addComponent(btnHinzufügenK3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(181))
		);
		gl_contentPaneK3.setVerticalGroup(
			gl_contentPaneK3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneK3.createSequentialGroup()
					.addComponent(btnZurückK3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPaneK3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVornameK3)
						.addComponent(txtFVornameK3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneK3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNachnameK3)
						.addComponent(txtFNachnameK3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneK3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGeburtstagK3)
						.addComponent(txtFGeburtstagK3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneK3.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFTelefonK3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefonK3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneK3.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFEmailK3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmailK3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(czbInteressentK3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(czbAktivK3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnHinzufügenK3)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPaneK3.setLayout(gl_contentPaneK3);
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
		btnZurückK3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Kunde_Level1 kunde1 = new Kunde_Level1();
				kunde1.setVisible(true);
			}
		});
	}
}
