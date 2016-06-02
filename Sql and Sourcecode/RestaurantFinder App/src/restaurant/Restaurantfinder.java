package restaurant;
import java.awt.BorderLayout;
import java.awt.Dialog;

import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import java.util.List;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SwingConstants;



public class Restaurantfinder extends JFrame {

	private JPanel contentPane;
	private static restdao rdao;
	private static userdao udao; 
	private String userId;
	
	private JLabel loggedInUserLabel;
	private JPanel restaurantPanel;
	private JTabbedPane tabbedPane;

	
	private final JLabel lblEnterZipCode = new JLabel(" Zip :");
	private final JTextField zipTextField = new JTextField();
	private JScrollPane scrollPane;
	private static JTable table;
	private JPanel panel_1;
	private JButton btnNewButton;
	private final JLabel lblNewLabel = new JLabel("Cusine");
	private JTextField cuisinetextField;
	private JButton btnSearch;
	private boolean admin;
	public int op;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					
					userdao udao=  new userdao();
					
					
					UserLoginDialog dialog = new UserLoginDialog();
					dialog.setUserDAO(udao);
					dialog.setrestDAO(rdao);
					
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				
															
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Restaurantfinder() {
		
				
		// create the DAO
		// create the DAO
				try {
						rdao = new restdao();
					
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
				}

			

				
		setTitle("Restaurant Finder App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.add(lblEnterZipCode);
		panel.add(zipTextField);
		zipTextField.setColumns(10);
		panel.add(lblNewLabel);
		
		cuisinetextField = new JTextField();
		panel.add(cuisinetextField);
		cuisinetextField.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String zipcode = zipTextField.getText();
					String cuisine =cuisinetextField.getText();
					int zip = Integer.parseInt(zipcode);
					List<rest> restaurants = null;

					if (zipcode != null && zipcode.trim().length() > 0) {
						restaurants = rdao.searchrestaurants(zipcode,cuisine);
						
					} else if ((zipcode  == null && cuisine == null) || (zipcode != null ||(cuisine == "any" ||cuisine == "Any"))) {
						restaurants = rdao.getAllrest();
						
					}
					
					// create the model and update the "table"
					resttablemodel model = new resttablemodel(restaurants);
				
					
					table.setModel(model);
					
					
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(Restaurantfinder.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
				}

			}
		});
		panel.add(btnSearch);
		
		scrollPane = new JScrollPane();

		contentPane.add(scrollPane, BorderLayout.CENTER);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("View Review");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				// get the selected item
				int row = table.getSelectedRow();
				
				// make sure a row is selected
				if (row < 0) {
					JOptionPane.showMessageDialog(Restaurantfinder.this, "You must select a row", "Error",
							JOptionPane.ERROR_MESSAGE);				
					return;
				}
				
				// get the current row data
				rest temp = (rest)table.getValueAt(row,resttablemodel.OBJECT_COL);
				
				System.out.println("Rest Temp created");
				try {
					// get review for this row
					int rId = temp.getId();
					List<Reviews> reviewlist = rdao.getreview(rId);
					System.out.println("Reviews List created");

			
			
					System.out.println("Dialog Created");
					
					// show review dialog
					
					Reviewtablemodel model = new Reviewtablemodel(reviewlist);
					
					table.setModel(model);
			
				}
				catch (Exception exc) {
					exc.printStackTrace();
					JOptionPane.showMessageDialog(Restaurantfinder.this, "Error retrieving reviews", "Error",
							JOptionPane.ERROR_MESSAGE);				
					return;					
				}
				

			}
		});
		panel_1.add(btnNewButton);
	}

	public void setLoggedInUserName(String firstName, String lastName) {
		loggedInUserLabel.setText(firstName + " " + lastName);
	}
	
	public  void refreshrestView() {
		// TODO Auto-generated method stub
		
		try {
			List<rest> restaurants = rdao.getAllrest();

			// create the model and update the "table"
			resttablemodel model = new resttablemodel(restaurants);
			
			table.setModel(model);
			
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",JOptionPane.ERROR_MESSAGE);
		}

		
	}
	

		
		
		

	
}
