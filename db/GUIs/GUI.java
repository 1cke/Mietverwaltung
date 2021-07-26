package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JButton btnWohnungHM;
	private JButton btnBewerbungHM;
	private JButton btnVertragHM;
	private JButton btnKontaktpunktHM;
	private JButton btnKundeHM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		initComponents();
		createEvents();	
	}
	
	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen und
	// Initialisieren von Komponenten
	////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		setTitle("Hauptmen\u00FC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		btnWohnungHM = new JButton("Wohnung");
		
		btnBewerbungHM = new JButton("Bewerbung");
		
		btnVertragHM = new JButton("Vertrag");
		
		btnKontaktpunktHM = new JButton("Kontaktpunkt");
		
		btnKundeHM = new JButton("Kunde");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(149)
					.addComponent(btnKontaktpunktHM, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(182))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnWohnungHM, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBewerbungHM, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnKundeHM, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnVertragHM, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(118)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnKundeHM)
						.addComponent(btnWohnungHM))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVertragHM)
						.addComponent(btnBewerbungHM))
					.addGap(18)
					.addComponent(btnKontaktpunktHM)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	////////////////////////////////////////////////////////////////////
	// Enth�lt den Code zum Erzeugen von Events
	////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
////////////////////////////////////////////////////////////////////
//Enthält den Code für den "Wohnung" Button
////////////////////////////////////////////////////////////////////
		btnWohnungHM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Wohnung_Level1 wohnung1;
				try {
					wohnung1 = new Wohnung_Level1();
					wohnung1.setVisible(true);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
////////////////////////////////////////////////////////////////////
//Enthält den Code für den "Kunde" Button
////////////////////////////////////////////////////////////////////
		btnKundeHM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Kunde_Level1 kunde1;
				try {
					kunde1 = new Kunde_Level1();
					kunde1.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
////////////////////////////////////////////////////////////////////
//Enthält den Code für den "Bewerbung" Button
////////////////////////////////////////////////////////////////////
		btnBewerbungHM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Bewerbung_Level1 bewerbung1;
				try {
					bewerbung1 = new Bewerbung_Level1();
					bewerbung1.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
////////////////////////////////////////////////////////////////////
//Enthält den Code für den "Vertrag" Button
////////////////////////////////////////////////////////////////////
		btnVertragHM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Vertrag_Level1 vertrag1;
				try {
					vertrag1 = new Vertrag_Level1();
					vertrag1.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
////////////////////////////////////////////////////////////////////
//Enthält den Code für den "Kontaktpunkt" Button
////////////////////////////////////////////////////////////////////
		btnKontaktpunktHM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Kontaktpunkt_Level1 kontaktpunkt1;
				try {
					kontaktpunkt1 = new Kontaktpunkt_Level1();
					kontaktpunkt1.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	
		
	}
	
	
}
