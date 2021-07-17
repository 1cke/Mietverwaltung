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
import javax.swing.JCheckBox;

public class Wohnung_Level3 extends JFrame {

	private JPanel contentPane;
	private JTextField txtFStrasseW3;
	private JTextField txtFOrtW3;
	private JTextField txtFMieteW3;
	private JTextField txtFZimmerW3;
	private JTextField txtFBaederW3;
	private JTextField txtFPLZW3;
	private JTextField txtFHNW3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wohnung_Level3 frame = new Wohnung_Level3();
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
	public Wohnung_Level3() {
		setTitle("Wohnung hinzuf\u00FCgen");
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////////////
	// Enthält den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnZurückW3 = new JButton("Zum Wohnungs-Men\u00FC");
		
		JLabel lblStrasseW3 = new JLabel("Stra\u00DFe:");
		
		txtFStrasseW3 = new JTextField();
		txtFStrasseW3.setColumns(10);
		
		JLabel lblHNW3 = new JLabel("Nummer :");
		
		JLabel lblOrtW3 = new JLabel("Ort:");
		
		txtFOrtW3 = new JTextField();
		txtFOrtW3.setColumns(10);
		
		JLabel lblPLZW3 = new JLabel("PLZ:");
		
		JCheckBox czbEbkW3 = new JCheckBox("Einbauk\u00FCche");
		
		JLabel lblMieteW3 = new JLabel("Mietpreis:");
		
		txtFMieteW3 = new JTextField();
		txtFMieteW3.setColumns(10);
		
		JLabel lblZimmerW3 = new JLabel("Zimmer:");
		
		txtFZimmerW3 = new JTextField();
		txtFZimmerW3.setColumns(10);
		
		JLabel lblBaederW3 = new JLabel("B\u00E4der:");
		
		txtFBaederW3 = new JTextField();
		txtFBaederW3.setColumns(10);
		
		JCheckBox czbStatusW3 = new JCheckBox("vermietet");
		
		JButton btnHinzufügenW3 = new JButton("Wohnung hinzuf\u00FCgen");
		
		txtFPLZW3 = new JTextField();
		txtFPLZW3.setColumns(10);
		
		txtFHNW3 = new JTextField();
		txtFHNW3.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnZurückW3)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblMieteW3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtFMieteW3, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
									.addGap(249))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(1)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblOrtW3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblStrasseW3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(txtFStrasseW3, 206, 206, 206)
												.addComponent(txtFOrtW3, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
											.addGap(18)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblHNW3)
												.addComponent(lblPLZW3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
											.addGap(4))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblZimmerW3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(txtFZimmerW3, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
													.addGap(38)
													.addComponent(lblBaederW3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(txtFBaederW3))
												.addComponent(czbEbkW3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
												.addComponent(czbStatusW3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtFHNW3, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
										.addComponent(txtFPLZW3, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(150)
							.addComponent(btnHinzufügenW3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(135)))
					.addGap(8))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnZurückW3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStrasseW3)
						.addComponent(txtFStrasseW3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHNW3)
						.addComponent(txtFHNW3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOrtW3)
						.addComponent(txtFOrtW3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPLZW3)
						.addComponent(txtFPLZW3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMieteW3)
						.addComponent(txtFMieteW3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZimmerW3)
						.addComponent(txtFZimmerW3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBaederW3)
						.addComponent(txtFBaederW3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(czbEbkW3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(czbStatusW3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnHinzufügenW3)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	////////////////////////////////////////////////////////////////////
	// Enthält den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
		// TODO Auto-generated method stub
		
	}
}
