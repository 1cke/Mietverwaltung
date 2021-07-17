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

public class Bewerbung_Level2 extends JFrame {

	private JPanel contentPaneB3;
	private JTextField txtFKundenIDK3;
	private JTextField txtFWohnungsIDB3;
	private JTextField txtFDatumB3;

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
		setTitle("Bewerbung hinzuf\u00FCgen");
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////////////
	// Enthält den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 217);
		contentPaneB3 = new JPanel();
		contentPaneB3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneB3);
		
		JButton btnZurückB3 = new JButton("Zum Bewerbung-Men\u00FC");
		
		JLabel lblKundenIDB3 = new JLabel("Kunden-ID:");
		
		txtFKundenIDK3 = new JTextField();
		txtFKundenIDK3.setColumns(10);
		
		JLabel lblWohnungsIDB3 = new JLabel("Wohnungs-ID:");
		
		txtFWohnungsIDB3 = new JTextField();
		txtFWohnungsIDB3.setColumns(10);
		
		JLabel lblDatumB3 = new JLabel("Datum:");
		
		txtFDatumB3 = new JTextField();
		txtFDatumB3.setColumns(10);
		
		JCheckBox czbStatusB3 = new JCheckBox("abgeschlossen");
		
		JButton btnHinzufügenB3 = new JButton("Bewerbung hinzuf\u00FCgen");
		GroupLayout gl_contentPaneB3 = new GroupLayout(contentPaneB3);
		gl_contentPaneB3.setHorizontalGroup(
			gl_contentPaneB3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneB3.createSequentialGroup()
					.addComponent(btnZurückB3)
					.addContainerGap(312, Short.MAX_VALUE))
				.addGroup(gl_contentPaneB3.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPaneB3.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDatumB3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWohnungsIDB3)
						.addComponent(lblKundenIDB3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneB3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPaneB3.createSequentialGroup()
							.addComponent(czbStatusB3, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 176, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPaneB3.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPaneB3.createParallelGroup(Alignment.LEADING)
								.addComponent(txtFWohnungsIDB3, 264, 275, Short.MAX_VALUE)
								.addComponent(txtFKundenIDK3, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
							.addGroup(gl_contentPaneB3.createSequentialGroup()
								.addComponent(txtFDatumB3, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 141, GroupLayout.PREFERRED_SIZE))))
					.addGap(57))
				.addGroup(gl_contentPaneB3.createSequentialGroup()
					.addGap(129)
					.addComponent(btnHinzufügenB3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(156))
		);
		gl_contentPaneB3.setVerticalGroup(
			gl_contentPaneB3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneB3.createSequentialGroup()
					.addComponent(btnZurückB3)
					.addGap(18)
					.addGroup(gl_contentPaneB3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKundenIDB3)
						.addComponent(txtFKundenIDK3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneB3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWohnungsIDB3)
						.addComponent(txtFWohnungsIDB3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneB3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDatumB3)
						.addComponent(txtFDatumB3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(czbStatusB3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnHinzufügenB3)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPaneB3.setLayout(gl_contentPaneB3);
	}

	////////////////////////////////////////////////////////////////////
	// Enthält den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
		// TODO Auto-generated method stub
		
	}
}
