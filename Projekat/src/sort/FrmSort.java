package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Stack.DlgStack;
import geometry.Rectangle;
import geometry.Point;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Color;

public class FrmSort extends JFrame {

	private JPanel contentPane;
	DefaultListModel <Rectangle> dlm = new DefaultListModel<Rectangle>();
	ArrayList <Rectangle> list = new ArrayList<Rectangle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = new FrmSort();
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
	public FrmSort() {
		setTitle("Sandra Melovic IT43/2019");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(Color.BLACK);
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		
		JLabel lblstack = new JLabel("Stack with sort ");
		lblstack.setForeground(Color.PINK);
		pnlNorth.add(lblstack);
		
		JPanel pnlCentar = new JPanel();
		pnlCentar.setBackground(Color.PINK);
		contentPane.add(pnlCentar, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		pnlCentar.add(scrollPane);
		
		JList lstRectangle = new JList();
		scrollPane.setViewportView(lstRectangle);
		lstRectangle.setModel(dlm);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(Color.BLACK);
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.PINK);
		btnAdd.setBackground(Color.BLACK);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DlgStack dlgStack = new DlgStack();
				dlgStack.setVisible(true); 
				if(dlgStack.isOk)
				{
					try {
						int x = Integer.parseInt(dlgStack.getTxtX().getText()); 
						int y = Integer.parseInt(dlgStack.getTxtY().getText());
						int width = Integer.parseInt(dlgStack.getTxtWidth().getText());
						int height = Integer.parseInt(dlgStack.getTxtHeight().getText());
						
						Rectangle rct = new Rectangle(new Point(x,y), height, width); 
						
						dlm.add(0, rct);
						list.add(rct);
						
					}
					 catch(Exception NumberFormatException) {
						 
						 JOptionPane.showMessageDialog(null,"Please, insert values!");
						 
					 }
					
				}
			}
				
			
		});
		pnlSouth.add(btnAdd);
		
		JButton btnNewButton = new JButton("Sort");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "List is empty! ", "ERROR", JOptionPane.WARNING_MESSAGE);
				} else {
					
					list.sort(null);
					dlm.clear();
					for(int i=0; i<list.size();i++) {
						dlm.addElement(list.get(i));
						
					}
				}
			}
		});
		pnlSouth.add(btnNewButton);
	}

}
