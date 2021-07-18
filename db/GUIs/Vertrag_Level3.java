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

public class Vertrag_Level3 extends JFrame {

	private JPanel contentPaneV3;
	private JTextField txtFKundenIDV3;
	private JTextField txtFWohnungsIDV3;
	private JTextField txtFZeitraumV3;
	private JTextField txtFSchuldenV3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vertrag_Level3 frame = new Vertrag_Level3();
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
	public Vertrag_Level3() {
		setTitle("Vertrag hinzufügen");
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 233);
		contentPaneV3 = new JPanel();
		contentPaneV3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneV3);
		
		JButton btnZurückV3 = new JButton("Zum Vertrags-Menü");
		
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
		
		JButton btnHinzufügenV2 = new JButton("Vertrag hinzufügen");
		
		JCheckBox czbAktivV3 = new JCheckBox("aktiver Vertrag");
		czbAktivV3.setSelected(true);
		GroupLayout gl_contentPaneV3 = new GroupLayout(contentPaneV3);
		gl_contentPaneV3.setHorizontalGroup(
			gl_contentPaneV3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneV3.createSequentialGroup()
					.addComponent(btnZurückV3)
					.addContainerGap(315, Short.MAX_VALUE))
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
							.addComponent(czbAktivV3, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 165, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPaneV3.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPaneV3.createSequentialGroup()
								.addComponent(txtFSchuldenV3, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addGap(156))
							.addGroup(gl_contentPaneV3.createParallelGroup(Alignment.LEADING)
								.addComponent(txtFWohnungsIDV3, 264, 264, Short.MAX_VALUE)
								.addComponent(txtFKundenIDV3, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
							.addGroup(gl_contentPaneV3.createSequentialGroup()
								.addComponent(txtFZeitraumV3, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 115, GroupLayout.PREFERRED_SIZE))))
					.addGap(79))
				.addGroup(gl_contentPaneV3.createSequentialGroup()
					.addGap(151)
					.addComponent(btnHinzufügenV2, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
					.addGap(164))
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(czbAktivV3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnHinzufügenV2)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		contentPaneV3.setLayout(gl_contentPaneV3);
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
		// TODO Auto-generated method stub
		
	}
}
