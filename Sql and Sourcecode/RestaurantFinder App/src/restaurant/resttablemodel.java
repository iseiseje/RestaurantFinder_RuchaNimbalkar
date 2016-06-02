package restaurant;
import java.util.List;



import javax.swing.table.AbstractTableModel;


public class resttablemodel extends AbstractTableModel{
	
	public static final int OBJECT_COL = -1;

	private static final int col_Rid = 0;
	private static final int col_Rname = 1;
	private static final int col_cuisine = 2;
	private static final int col_addr =3;
	private static final int col_zip = 4;
	private static final int col_rating =5;
	private static final int col_range = 6;
	
	private String[] columnNames = { "Rid","name" ,"cuisine","address","zipcode","rating","pricerange"};
	private List<rest> re;

	public resttablemodel(List<rest> therestaurants) {
		re = therestaurants;
	}


	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return re.size();
	}

	@Override
	public String getColumnName(int col) {
		// TODO Auto-generated method stub
		return columnNames[col];
	}
	
	@Override
	public Object getValueAt(int row, int col) {

		rest temp = re.get(row);

		switch (col) {
		
		
		case col_Rid:
			return temp.getId();
			
		case col_Rname:
			return temp.getRName();
		
		case col_cuisine:
			return temp.getcuisine();
			
		case col_addr:
			return temp.getaddr();
		
		case col_zip:
			return temp.getzip();
		
		case col_rating:
			return temp.getrating();
		
		case col_range:
			return temp.getrange();
			
		case OBJECT_COL:
			return temp;

		default :
				return temp.getRName();
				
		}
	 }
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}

	
	
	

	


