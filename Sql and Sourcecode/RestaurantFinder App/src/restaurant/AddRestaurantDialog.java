package restaurant;
import java.awt.BorderLayout;




import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormSpecs;
public class AddRestaurantDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField ridtextField;
	private JTextField nametextField;
	private JTextField cuisinetextField;
	private JTextField addrtextField;
	private JTextField ziptextField;
	private JTextField ratingtextField;
	private JTextField rangetextField;

	/**
	 * Launch the application.
	 */



	private restdao rdao;

	private Restaurantfinderadmin search;
	
	private rest oldrest=null;
	private boolean updatemode=false;

	public AddRestaurantDialog(Restaurantfinderadmin theSearch,restdao therdao,rest theoldrest,boolean theUpdateMode) { 
		
		this();
		
		rdao=therdao;
		theSearch=search;
		
		oldrest=theoldrest;
				
		updatemode = theUpdateMode;

		if (updatemode) {
			setTitle("Update Row");
			
			populateGui(oldrest);
		}
	}

	
	private void populateGui(rest therest) {

		int id;
		id=therest.getId();
		String rid = Integer.toString(id);
		ridtextField.setText(rid);
		nametextField.setText(therest.getRName());
		cuisinetextField.setText(therest.getcuisine());
		addrtextField.setText(therest.getaddr());
		int zip;
		zip=therest.getzip();
		String rzip=Integer.toString(zip);
		ziptextField.setText(rzip);
		double rate;
		rate=therest.getrating();
		String rating =Double.toString(rate);
		ratingtextField.setText(rating);
		rangetextField.setText(therest.getrange());
		
				
	}

	public AddRestaurantDialog(Restaurantfinderadmin thelookup,restdao dao)
	{
		this(thelookup, dao, null, false);
	}


	/**
	 * Create the dialog.
	 */
	public AddRestaurantDialog() {
		setTitle("Add New Restaurant");
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		{
			JLabel lblEnterRestaurantId = new JLabel("Enter Restaurant Id");
			contentPanel.add(lblEnterRestaurantId, "2, 2");
		}
		{
			ridtextField = new JTextField();
			contentPanel.add(ridtextField, "6, 2, fill, default");
			ridtextField.setColumns(10);
		}
		{
			JLabel lblEnterName = new JLabel("Enter Name");
			contentPanel.add(lblEnterName, "2, 4");
		}
		{
			nametextField = new JTextField();
			contentPanel.add(nametextField, "6, 4, fill, default");
			nametextField.setColumns(10);
		}
		{
			JLabel lblEnterCuisine = new JLabel("Enter Cuisine");
			contentPanel.add(lblEnterCuisine, "2, 6");
		}
		{
			cuisinetextField = new JTextField();
			cuisinetextField.setText("");
			contentPanel.add(cuisinetextField, "6, 6, fill, default");
			cuisinetextField.setColumns(10);
		}
		{
			JLabel lblEnterAddress = new JLabel("Enter Address");
			contentPanel.add(lblEnterAddress, "2, 8");
		}
		{
			addrtextField = new JTextField();
			contentPanel.add(addrtextField, "6, 8, fill, default");
			addrtextField.setColumns(10);
		}
		{
			JLabel lblEnterZip = new JLabel("Enter Zip");
			contentPanel.add(lblEnterZip, "2, 10");
		}
		{
			ziptextField = new JTextField();
			contentPanel.add(ziptextField, "6, 10, fill, default");
			ziptextField.setColumns(10);
		}
		{
			JLabel lblEnterRating = new JLabel("Enter Rating");
			contentPanel.add(lblEnterRating, "2, 12");
		}
		{
			ratingtextField = new JTextField();
			contentPanel.add(ratingtextField, "6, 12, fill, default");
			ratingtextField.setColumns(10);
		}
		{
			JLabel lblEnterRanging = new JLabel("Enter Price Range");
			contentPanel.add(lblEnterRanging, "2, 14");
		}
		{
			rangetextField = new JTextField();
			contentPanel.add(rangetextField, "6, 14, fill, default");
			rangetextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						savedata();
						
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

	protected void savedata() {
		// TODO Auto-generated method stub
		
		// get the  info from the GUI
				String rid1=ridtextField.getText();
				int id =Integer.parseInt(rid1);
				
				String name=nametextField.getText();
				
				String cuisine =cuisinetextField.getText();
				
				String addr=addrtextField.getText();
				
				String zipc=ziptextField.getText();
				int zip =Integer.parseInt(zipc);
				
								
				String rate=ratingtextField.getText();
				double rating =Double.parseDouble(rate);
				
				String range=rangetextField.getText();
				
			
				rest temp = null;
				
				if (updatemode) {
					temp=oldrest;
					
					temp.setRName(name);
					temp.setcuisine(cuisine);
					temp.setaddr(addr);
					temp.setzip(zip);
					temp.setrating(rating);
					temp.setrange(range);
					
					
				} else {
					temp = new rest(id,name,cuisine,addr,zip,rating,range);
				}

									
				try {
					// save to the database
					if (updatemode) {
						rdao.updaterest(temp);
						
					} else {
						rdao.add_rest(temp);
						
					}

					// close dialog
					setVisible(false);
					dispose();

					// refresh gui list
					//search.refreshrestView();
					

					// show success message
					JOptionPane.showMessageDialog(search,"Added succesfully.","Restaurant Added",JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(search,"Error saving data "+ exc.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
				}

		
	}

}
