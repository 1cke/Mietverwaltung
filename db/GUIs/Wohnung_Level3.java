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
	private JTextField txtFStrasseW2;
	private JTextField txtFOrtW2;
	private JTextField txtFMieteW3;
	private JTextField txtFZimmerW2;
	private JTextField txtFBaederW2;
	private JTextField txtFPLZW2;
	private JTextField txtFHNW2;

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
		setTitle("Wohnung bearbeiten/l\u00F6schen");
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
		
		JLabel lblStrasseW2 = new JLabel("Stra\u00DFe:");
		
		txtFStrasseW2 = new JTextField();
		txtFStrasseW2.setColumns(10);
		
		JLabel lblHNW2 = new JLabel("Nummer :");
		
		JLabel lblOrtW3 = new JLabel("Ort:");
		
		txtFOrtW2 = new JTextField();
		txtFOrtW2.setColumns(10);
		
		JLabel lblPLZW2 = new JLabel("PLZ:");
		
		JCheckBox czbEbkW2 = new JCheckBox("Einbauk\u00FCche");
		
		JLabel lblMieteW3 = new JLabel("Mietpreis:");
		
		txtFMieteW3 = new JTextField();
		txtFMieteW3.setColumns(10);
		
		JLabel lblZimmerW2 = new JLabel("Zimmer:");
		
		txtFZimmerW2 = new JTextField();
		txtFZimmerW2.setColumns(10);
		
		JLabel lblBaederW2 = new JLabel("B\u00E4der:");
		
		txtFBaederW2 = new JTextField();
		txtFBaederW2.setColumns(10);
		
		JCheckBox czbStatusW2 = new JCheckBox("vermietet");
		
		JButton btnSaveW2 = new JButton("\u00C4nderungen speichern");
		
		JButton btnLöschenW2 = new JButton("Wohnung l\u00F6schen");
		
		txtFPLZW2 = new JTextField();
		txtFPLZW2.setColumns(10);
		
		txtFHNW2 = new JTextField();
		txtFHNW2.setColumns(10);
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
									.addComponent(txtFMieteW3, 109, 109, 109)
									.addGap(249))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(1)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblOrtW3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblStrasseW2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(txtFStrasseW2)
												.addComponent(txtFOrtW2, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
											.addGap(18)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblHNW2)
												.addComponent(lblPLZW2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblZimmerW2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(txtFZimmerW2, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
													.addGap(38)
													.addComponent(lblBaederW2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(txtFBaederW2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addComponent(czbEbkW2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
												.addComponent(czbStatusW2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
												.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
													.addComponent(btnSaveW2)
													.addGap(18)
													.addComponent(btnLöschenW2)))))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtFHNW2, 0, 0, Short.MAX_VALUE)
										.addComponent(txtFPLZW2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnZurückW3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStrasseW2)
						.addComponent(txtFStrasseW2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHNW2)
						.addComponent(txtFHNW2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOrtW3)
						.addComponent(txtFOrtW2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPLZW2)
						.addComponent(txtFPLZW2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMieteW3)
						.addComponent(txtFMieteW3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZimmerW2)
						.addComponent(txtFZimmerW2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBaederW2)
						.addComponent(txtFBaederW2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(czbEbkW2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(czbStatusW2)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSaveW2)
						.addComponent(btnLöschenW2))
					.addContainerGap(24, Short.MAX_VALUE))
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
