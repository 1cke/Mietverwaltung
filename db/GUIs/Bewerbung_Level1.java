package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;

public class Bewerbung_Level1 extends JFrame {

	private JPanel contentPaneB1;
	private JButton btnZurückB1;
	private JButton btnHinzufügenB1;
	private JButton btnBearbeitenB1;
	private JButton btnLöschenB1;
	private JList lstBewerbungenB1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bewerbung_Level1 frame = new Bewerbung_Level1();
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
	public Bewerbung_Level1() {
		initComponents();
		createEvents();
	}
	
	
	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		setTitle("Men\u00FC - Bewerbungen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPaneB1 = new JPanel();
		contentPaneB1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneB1);
		
		btnZurückB1 = new JButton("Zum Hauptmen\u00FC");
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnHinzufügenB1 = new JButton("Hinzuf\u00FCgen");
		
		btnBearbeitenB1 = new JButton("Bearbeiten");
		
		btnLöschenB1 = new JButton("L\u00F6schen");
		
		GroupLayout gl_contentPaneB1 = new GroupLayout(contentPaneB1);
		gl_contentPaneB1.setHorizontalGroup(
			gl_contentPaneB1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneB1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneB1.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
						.addComponent(btnZurückB1))
					.addGap(10))
				.addGroup(gl_contentPaneB1.createSequentialGroup()
					.addGap(54)
					.addComponent(btnHinzufügenB1, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnBearbeitenB1, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnLöschenB1, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
					.addGap(71))
		);
		gl_contentPaneB1.setVerticalGroup(
			gl_contentPaneB1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneB1.createSequentialGroup()
					.addComponent(btnZurückB1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneB1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBearbeitenB1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnHinzufügenB1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLöschenB1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		);
		
		lstBewerbungenB1 = new JList();
		lstBewerbungenB1.setModel(new AbstractListModel() {
			String[] values = new String[] {"1"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(lstBewerbungenB1);
		contentPaneB1.setLayout(gl_contentPaneB1);
	}
	
	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
		btnZurückB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				GUI hauptmenü = new GUI();
				hauptmenü.setVisible(true);
			}
		});
		btnHinzufügenB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Bewerbung_Level3 bewerbung3;
				try {
					bewerbung3 = new Bewerbung_Level3();
					bewerbung3.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnBearbeitenB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Bewerbung_Level2 bewerbung2;
				
				try {
					bewerbung2 = new Bewerbung_Level2(lstBewerbungenB1.getSelectedValue().toString());
					bewerbung2.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnLöschenB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Bewerbung_Level2 bewerbung2;
				try {
					bewerbung2 = new Bewerbung_Level2(lstBewerbungenB1.getSelectedValue().toString());
					bewerbung2.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}

}
