package restaurant;
import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

public class ReviewsDialog extends JDialog {
	private JTable table;
	private JLabel Reviewlabel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReviewsDialog dialog = new ReviewsDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void populate(rest temp, List<Reviews> reviewList) {
		
		System.out.println("In Populate");
		//Reviewlabel.setText(temp.getId() + " " + temp.getRName());
		System.out.println("Label text Set");
		Reviewtablemodel model = new Reviewtablemodel(reviewList);
		
		table.setModel(model);
		
			
	}
	/**
	 * Create the dialog.
	 */
	public ReviewsDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			getContentPane().add(scrollPane, BorderLayout.CENTER);
		}
	}

}


