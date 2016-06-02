package restaurant;
import java.util.List;


import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Reviewtablemodel extends AbstractTableModel{
	
	public static final int OBJECT_COL = -1;
	public static final int User = 0;
	private static final int Review = 1;
	

	private String[] columnNames = { "User", "Review"};
	
	private List<Reviews> reviewList;

	public Reviewtablemodel(List<Reviews> theReviewList) {
		reviewList=theReviewList;
		
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return reviewList.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Reviews temp = reviewList.get(row);
		

		switch (col) {
		case User:			
			return temp.getUserId();
		
		case Review:
			return temp.getreview();
		
		case OBJECT_COL:
			return temp;
			
		default:
			return temp.getrId();
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

}
