package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vertrag_Level1 extends JFrame {

	private JPanel contentPane;
	private JButton btnZurückV1;
	private JButton btnHinzufügenV1;
	private JButton btnBearbeitenV1;
	private JButton btnLöschenV1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vertrag_Level1 frame = new Vertrag_Level1();
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
	public Vertrag_Level1() {
		setTitle("Men\u00FC - Vertr\u00E4ge");
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnZurückV1 = new JButton("Zum Hauptmen\u00FC");
		
		btnHinzufügenV1 = new JButton("Hinzuf\u00FCgen");
		
		btnBearbeitenV1 = new JButton("Bearbeiten");
		
		btnLöschenV1 = new JButton("L\u00F6schen");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(59)
							.addComponent(btnHinzufügenV1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnBearbeitenV1, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnLöschenV1, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
							.addGap(78))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnZurückV1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnZurückV1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnHinzufügenV1)
						.addComponent(btnBearbeitenV1)
						.addComponent(btnLöschenV1)))
		);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		contentPane.setLayout(gl_contentPane);
	}
	
	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////

	private void createEvents() {
		btnZurückV1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUI hauptmenü = new GUI();
				hauptmenü.setVisible(true);
			}
		});
		btnHinzufügenV1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Vertrag_Level3 vertrag3 = new Vertrag_Level3();
				vertrag3.setVisible(true);
			}
		});
		btnBearbeitenV1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Vertrag_Level2 vertrag2 = new Vertrag_Level2();
				vertrag2.setVisible(true);
			}
		});
		btnLöschenV1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Vertrag_Level2 vertrag2 = new Vertrag_Level2();
				vertrag2.setVisible(true);
			}
		});
		
		
		
	}

}
