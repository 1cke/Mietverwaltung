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

public class Bewerbung_Level2 extends JFrame {
	private JPanel contentPaneB2;
	private JTextField txtFKundenIDB2;
	private JTextField txtFWohnungsIDB2;
	private JTextField txtFDatumB2;
	private JButton btnZurückB2;
	private JButton btnSaveB2;
	private JButton btnLöschenB2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bewerbung_Level2 frame = new Bewerbung_Level2();
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
	public Bewerbung_Level2() {
		setTitle("Bewerbung bearbeiten/l\u00F6schen");
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 252);
		contentPaneB2 = new JPanel();
		contentPaneB2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneB2);
		
		btnZurückB2 = new JButton("Zum Bewerbungs-Men\u00FC");
		
		JLabel lblAuswahlB2 = new JLabel("Ausgew\u00E4hlte Bewerbung:");
		
		JTextArea txtArAuswahlB2 = new JTextArea();
		
		JSeparator separatorB2 = new JSeparator();
		
		JLabel lblKundenIDB2 = new JLabel("Kunden-ID:");
		
		txtFKundenIDB2 = new JTextField();
		txtFKundenIDB2.setColumns(10);
		
		JLabel lblWohnungsIDB2 = new JLabel("Wohnungs-ID");
		
		txtFWohnungsIDB2 = new JTextField();
		txtFWohnungsIDB2.setColumns(10);
		
		JLabel lblDatumB2 = new JLabel("Datum:");
		
		txtFDatumB2 = new JTextField();
		txtFDatumB2.setHorizontalAlignment(SwingConstants.CENTER);
		txtFDatumB2.setColumns(10);
		
		btnSaveB2 = new JButton("\u00C4nderungen speichern");
		
		btnLöschenB2 = new JButton("Bewerbung l\u00F6schen");
		
		JCheckBox czbStatusB2 = new JCheckBox("abgeschlossen");
		czbStatusB2.setSelected(true);
		GroupLayout gl_contentPaneB2 = new GroupLayout(contentPaneB2);
		gl_contentPaneB2.setHorizontalGroup(
			gl_contentPaneB2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneB2.createSequentialGroup()
					.addGroup(gl_contentPaneB2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnZurückB2)
						.addGroup(gl_contentPaneB2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAuswahlB2)
							.addGap(18)
							.addComponent(txtArAuswahlB2, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
						.addComponent(separatorB2, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
					.addGap(7))
				.addGroup(gl_contentPaneB2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneB2.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDatumB2)
						.addComponent(lblWohnungsIDB2)
						.addComponent(lblKundenIDB2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneB2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPaneB2.createSequentialGroup()
							.addComponent(czbStatusB2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPaneB2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPaneB2.createSequentialGroup()
								.addGroup(gl_contentPaneB2.createParallelGroup(Alignment.LEADING)
									.addComponent(txtFWohnungsIDB2, 264, 264, Short.MAX_VALUE)
									.addComponent(txtFKundenIDB2, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
								.addGap(95))
							.addGroup(gl_contentPaneB2.createSequentialGroup()
								.addComponent(txtFDatumB2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addGap(288)))))
				.addGroup(gl_contentPaneB2.createSequentialGroup()
					.addGap(55)
					.addComponent(btnSaveB2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnLöschenB2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(114))
		);
		gl_contentPaneB2.setVerticalGroup(
			gl_contentPaneB2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneB2.createSequentialGroup()
					.addComponent(btnZurückB2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneB2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAuswahlB2)
						.addComponent(txtArAuswahlB2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separatorB2, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneB2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKundenIDB2)
						.addComponent(txtFKundenIDB2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneB2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWohnungsIDB2)
						.addComponent(txtFWohnungsIDB2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneB2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDatumB2)
						.addComponent(txtFDatumB2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(czbStatusB2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPaneB2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSaveB2)
						.addComponent(btnLöschenB2))
					.addContainerGap(103, Short.MAX_VALUE))
		);
		contentPaneB2.setLayout(gl_contentPaneB2);
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
		btnZurückB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Bewerbung_Level1 bewerbung1 = new Bewerbung_Level1();
				bewerbung1.setVisible(true);
			}
		});
	}
}
