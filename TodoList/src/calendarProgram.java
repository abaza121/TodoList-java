import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import TodoBackLogic.Day;
import TodoBackLogic.Todo;
import TodoBackLogic.TodoManager;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.border.TitledBorder;

class calendarProgram {
	
	//Declarations//
	static JLabel lblMonth, lblYear;
	static JButton btnPrev, btnNext;
	static JTable tblCalendar;
	static JComboBox cmbYear;
	static JFrame frmMain;
	static Container pane;
	static DefaultTableModel mtblCalendar; //Table model
	static JScrollPane stblCalendar; //The scroll pane
	static JPanel pnlCalendar; //The panel
	static int realDay, realMonth, realYear, currentMonth, currentYear;
	static int firstrow, firstclm; //To return current selected day
	private static JTextField textField;
	static JPanel pnlDay;
	static TodoManager todomanager;
	static TodolistModel listModel;
	static JList list;
	//Declarations//
	 
    public static void main (String args[]) {
    	// Setting the Look and Feel//
    	try {
    	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    	}
		catch (ClassNotFoundException e) { }
		catch (InstantiationException e) { }
		catch (IllegalAccessException e) { }
		catch (UnsupportedLookAndFeelException e) { }
    	//Setting the Look and Feel//
    	
    	//Preparing the frame//
    	frmMain = new JFrame("ToDo List"); //Create frame
    	frmMain.setSize(657, 375); //Two arguments: width and height
    	pane = frmMain.getContentPane(); //Get content pane
    	pane.setLayout(null); //Apply null Layout
    	frmMain.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //Close when X is Clicked
    	//Preparing the frame//
    	
    	//Creating the components//
    	lblMonth = new JLabel ("January");
    	lblYear = new JLabel ("Change year:");
    	cmbYear = new JComboBox();
    	btnPrev = new JButton ("<<");
    	btnNext = new JButton (">>");
    	mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}}; //Can't edit days
    	
    	GregorianCalendar cal = new GregorianCalendar(); //Create calendar
    	realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
    	realMonth = cal.get(GregorianCalendar.MONTH); //Get month
    	realYear = cal.get(GregorianCalendar.YEAR); //Get year
    	
    	//Current Day
    	pnlDay = new JPanel();
    	pnlDay.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ToDo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    	pnlDay.setBounds(330, 0, 320, 346);
    	frmMain.getContentPane().add(pnlDay);
    	pnlDay.setLayout(null);
    	try {
			todomanager = new TodoManager();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	JButton addTask = new JButton("Add Task");
    	addTask.setBounds(230, 305, 80, 30);
    	pnlDay.add(addTask);
    	
    	textField = new JTextField();
    	textField.setBounds(10, 305, 215, 30);
    	pnlDay.add(textField);
    	list = new JList();
    	listModel = new TodolistModel();
    	list.setModel(listModel);
    	list.setBounds(10, 25, 300, 272);
    	list.setCellRenderer(new CheckboxListCellRenderer<Todo>());
    	listModel.addElement(new Todo("refe",false,new Day(27,12,2016)));
    	pnlDay.add(list);
    	
    	textField.setColumns(10);	
    	tblCalendar = new JTable(mtblCalendar); //Table using the above model
    	stblCalendar = new JScrollPane(tblCalendar); //The scroll pane of the above table
    	pnlCalendar = new JPanel(null); //Create the "panel" to place components
    	//Creating the components//
    	
    	//Setting the border of the panel//
    	pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar")); //Set border
    	//Setting the border of the panel//
    	
    	//Adding the components to the Container//
    	pane.add(pnlCalendar);
    	pnlCalendar.add(lblMonth);
    	pnlCalendar.add(lblYear);
    	pnlCalendar.add(cmbYear);
    	pnlCalendar.add(btnPrev);
    	pnlCalendar.add(btnNext);
    	pnlCalendar.add(stblCalendar);
    	//Adding the components to the Container//
    	
    	//Positioning the controls//
    	pnlCalendar.setBounds(0, 0, 320, 335);
    	lblMonth.setBounds(160-lblMonth.getPreferredSize().width/2, 25, 100, 25);
    	lblYear.setBounds(10, 305, 80, 20);
    	cmbYear.setBounds(230, 305, 80, 20);
    	btnPrev.setBounds(10, 25, 50, 25);
    	btnNext.setBounds(260, 25, 50, 25);
    	stblCalendar.setBounds(10, 50, 300, 250);
    	//Positioning the controls//
    	
    	//Making the frame visible//
    	frmMain.setResizable(false);
    	frmMain.setVisible(true);
    	//Making the frame visible//
    	
    	//Getting the real month and year//
    	
    	currentMonth = realMonth; //Match month and year
    	currentYear = realYear;
    	//Getting the real month and year//
    	
    	//Preparing the calendar//
    	String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //Adding all headers
    	for (int i=0; i<7; i++){
    		mtblCalendar.addColumn(headers[i]);
    	}
    	tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background
    	tblCalendar.getTableHeader().setResizingAllowed(false); //No resize/reorder
    	tblCalendar.getTableHeader().setReorderingAllowed(false); //No resize/reorder
    	tblCalendar.setColumnSelectionAllowed(true); //Single cell selection
    	tblCalendar.setRowSelectionAllowed(true); //Single cell selection
    	tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); //Single cell selection
    	tblCalendar.setRowHeight(38); //Set row/column count
    	
    	//Current Day//
    	
    	mtblCalendar.setColumnCount(7); //Set row/column count
    	mtblCalendar.setRowCount(6); //Set row/column count
    	
    	
    	for (int i=realYear-100; i<=realYear+100; i++) { //Populating the combo box
    		cmbYear.addItem(String.valueOf(i));
    	}
    	//Preparing the calendar//
    	
    	refreshCalendar(realMonth, realYear); //Refresh calendar
    	
    	//Register action listeners
    	btnPrev.addActionListener(new btnPrev_Action());
    	btnNext.addActionListener(new btnNext_Action());
    	cmbYear.addActionListener(new cmbYear_Action());
    	tblCalendar.addMouseListener(new tbl_Action()); //Return current selected day
    	addTask.addActionListener(new AddTaskBtnAction());
    	list.addMouseListener(null);
    }

	//Refreshing the calendar//
    public static void refreshCalendar(int month, int year) {
    	String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    	int nod, som; //Number Of Days, Start Of Month
    		
    	btnPrev.setEnabled(true); //Prepare and enable buttons
    	btnNext.setEnabled(true);
    	if (month == 0 && year <= realYear-100 )  {btnPrev.setEnabled(false);} //Too early
    	if (month == 11 && year >= realYear+100) {btnNext.setEnabled(false);} //Too late
    	lblMonth.setText(months[month]); //Refresh the month label (at the top)
    	lblMonth.setBounds(160-lblMonth.getPreferredSize().width/2, 25, 180, 25); //Re-align label with calendar
    	cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box
    
    	//Get first day of month and number of days
    	GregorianCalendar cal = new GregorianCalendar(year, month, 1);
    	nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
    	som = cal.get(GregorianCalendar.DAY_OF_WEEK);
    	
    	//Clear table
    	for (int i=0; i<6; i++){
    		for (int j=0; j<7; j++){
    			mtblCalendar.setValueAt(null, i, j);
    		}
    	}
    	//Draw calendar
    	for (int i=1; i<=nod; i++){
    		int row = new Integer((i+som-2)/7);
    		int column  =  (i+som-2)%7;
    		mtblCalendar.setValueAt(i, row, column);
    	}
    	
    	firstclm = (1+som-2)%7;
    	tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer()); //Apply renderer
    	
    }
    //Refreshing the calendar//
    
  
    static class btnPrev_Action implements ActionListener{
    	public void actionPerformed (ActionEvent e){
    		if (currentMonth == 0){ //Back one year
    			currentMonth = 11;
    			currentYear -= 1;
    		}
    		else{ //Back one month
    			currentMonth -= 1;
    		}
    		refreshCalendar(currentMonth, currentYear);
    	}
    }

    static class btnNext_Action implements ActionListener{
    	public void actionPerformed (ActionEvent e){
    		if (currentMonth == 11){ //Foward one year
    			currentMonth = 0;
    			currentYear += 1;
    		}
    		else{ //Forward one month
    			currentMonth += 1;
    		}
    		refreshCalendar(currentMonth, currentYear);
    	}
    }
    static class AddTaskBtnAction implements ActionListener{
    	public void actionPerformed (ActionEvent e){
    		listModel.addElement(new Todo("Efecd",false,new Day(27,12,2016)));
    		 System.out.println("added");
    	}
    }
    static class cmbYear_Action implements ActionListener{
    	public void actionPerformed (ActionEvent e){
    		if (cmbYear.getSelectedItem() != null){
    			String b = cmbYear.getSelectedItem().toString();
    			currentYear = Integer.parseInt(b); //Get the numeric value
    			refreshCalendar(currentMonth, currentYear); //Refresh
    		}
    	}
    }
    
    static class tbl_Action implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
            
            int row = tblCalendar.getSelectedRow();
            int clm = tblCalendar.getSelectedColumn();  
            int day = ((row*7) + (clm-firstclm))+1;
            System.out.println("Day: "+day+" Month: "+(currentMonth+1)+ " Year: "+ currentYear );
        }

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    	
    }
}