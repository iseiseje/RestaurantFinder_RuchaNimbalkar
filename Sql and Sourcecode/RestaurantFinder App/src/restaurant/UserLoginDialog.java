package restaurant;
import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.*;


import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import com.jgoodies.forms.layout.FormSpecs;


public class UserLoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	//	private JComboBox<String> UserComboBox;

	private restdao newdao;
	private userdao udao;
	private JTextField UserTextfield;
	private JPasswordField passwordfield;
	public static boolean admincheck;
	private String uid;
	public int opt;
	
	public void setUserDAO(userdao theUserDAO) {
		udao = theUserDAO;
	}
	public void setrestDAO(restdao rdao) {
		newdao=rdao;
		
	}
	
	public void operation (int op)
	{
		opt=op;
	}
	
	public boolean getadmin()
	{
		return admincheck;
	}
	public String getuserid()
	{
		return uid;
	}
	
	@SuppressWarnings("unchecked")
	/*public void populateUsers(List<Users> users) {
		
		UserComboBox.setModel(new DefaultComboBoxModel(users.toArray(new Users[0])));
}*/
	
	/**
	 * Create the dialog.
	 */
	public UserLoginDialog() {
		setTitle("Restaurant Finder");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		{
			JLabel lblUser = new JLabel("UserId");
			contentPanel.add(lblUser, "2, 2");
		}
		{
			UserTextfield = new JTextField();
			contentPanel.add(UserTextfield, "6, 2, fill, default");
			UserTextfield.setColumns(10);
		}
		{
			JLabel lblPassword = new JLabel("Password");
			contentPanel.add(lblPassword, "2, 6");
		}
		{
			passwordfield = new JPasswordField();
			contentPanel.add(passwordfield, "6, 6, fill, default");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						 performUserLogin();
						
					}

					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	

	

	private void performUserLogin() {
		
		
		// TODO Auto-generated method stub
		
		try {
			 	
			String userId = UserTextfield.getText();
			Users theUser = new Users(userId);
			
			// get the password from the passwordfield
			String Pwd = new String(passwordfield.getPassword());
			theUser.setPassword(Pwd);
			System.out.println("Check Password??" );
			// check the user's password against the copy in the database
			boolean isValidPassword = udao.authenticate(theUser);
			
			System.out.println("Authenticate User "+isValidPassword);
			
			
			
			if (isValidPassword) {
				
				// hide the login window
				setVisible(false);
				System.out.println("Valid Password");
				String admins = udao.getadmin(userId);
				boolean admin=  Boolean.parseBoolean(admins);
				admincheck=admin;
				System.out.println("Admin userdialog "+admincheck);
				if(admin){
					
						Restaurantfinderadmin frame = new Restaurantfinderadmin();
						frame.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "You are not admin ","Only Admin Access to Database",
							JOptionPane.ERROR_MESSAGE);
						Restaurantfinder frame = new Restaurantfinder();
						frame.setVisible(true);
				
				}			
			//	frame.setVisible(true);
				
			}
			else {
							// show error message
							JOptionPane.showMessageDialog(this, "Invalid login", "Invalid Login",
									JOptionPane.ERROR_MESSAGE);

							return ;			
				}
			}
			catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error during login", "Error",
					JOptionPane.ERROR_MESSAGE);			
			}

		
		
		
}
}
	

		

		
	
	

