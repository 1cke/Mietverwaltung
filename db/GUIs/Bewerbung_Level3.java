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

public class Bewerbung_Level3 extends JFrame {

	private JPanel contentPaneB3;
	private JTextField txtFKundenIDB3;
	private JTextField txtFWohnungsIDB3;
	private JTextField txtFDatumB3;
	private JButton btnZurückB3;
	private JButton btnHinzufügenB3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bewerbung_Level3 frame = new Bewerbung_Level3();
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
	public Bewerbung_Level3() {
		setTitle("Bewerbung hinzuf\u00FCgen");
		initComponents();
		createEvents();
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
		
		JCheckBox czbStatusB3 = new JCheckBox("abgeschlossen");
		GroupLayout gl_contentPaneB3 = new GroupLayout(contentPaneB3);
		gl_contentPaneB3.setHorizontalGroup(
			gl_contentPaneB3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneB3.createSequentialGroup()
					.addComponent(btnZurückB3)
					.addContainerGap(281, Short.MAX_VALUE))
				.addGroup(gl_contentPaneB3.createSequentialGroup()
					.addGap(132)
					.addComponent(btnHinzufügenB3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(169))
				.addGroup(gl_contentPaneB3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneB3.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDatumB3)
						.addComponent(lblWohnungsIDB3)
						.addComponent(lblKundenIDB3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneB3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPaneB3.createSequentialGroup()
							.addComponent(czbStatusB3, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(252))
						.addGroup(gl_contentPaneB3.createSequentialGroup()
							.addGroup(gl_contentPaneB3.createParallelGroup(Alignment.LEADING)
								.addComponent(txtFWohnungsIDB3, 264, 268, Short.MAX_VALUE)
								.addComponent(txtFKundenIDB3, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
								.addGroup(gl_contentPaneB3.createSequentialGroup()
									.addComponent(txtFDatumB3, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
									.addGap(193)))
							.addGap(95))))
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(czbStatusB3)
					.addPreferredGap(ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
					.addComponent(btnHinzufügenB3)
					.addContainerGap())
		);
		contentPaneB3.setLayout(gl_contentPaneB3);
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
		btnZurückB3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Bewerbung_Level1 bewerbung1 = new Bewerbung_Level1();
				bewerbung1.setVisible(true);
			}
		});
	}
}