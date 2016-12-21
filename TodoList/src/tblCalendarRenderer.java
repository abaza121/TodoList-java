import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import TodoBackLogic.Day;

class tblCalendarRenderer extends DefaultTableCellRenderer{
		public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
			super.getTableCellRendererComponent(table, value, selected, focused, row, column);
			if (column == 5 || column == 6){ //Week-end
				setBackground(new Color(255, 220, 220));
			}
			else{ //Week
				setBackground(new Color(255, 255, 255));
			}
			if (value != null){
				if (Integer.parseInt(value.toString()) == calendarProgram.realDay && calendarProgram.currentMonth == calendarProgram.realMonth && calendarProgram.currentYear == calendarProgram.realYear){ //Today
					setBackground(new Color(220, 220, 255));
					
					if(table.getSelectedRow() == -1){
					calendarProgram.CurrDay = new Day(calendarProgram.realDay,calendarProgram.realMonth + 1,calendarProgram.realYear);
					System.out.println(calendarProgram.realMonth + 1);
					selected = true;
					calendarProgram.listModel.ChangeList(calendarProgram.todomanager.GetForDay(calendarProgram.CurrDay));
					}
				}
				if (selected){
					setBackground(new Color(220, 100, 255));
				}
			}
			setBorder(null);
			setForeground(Color.black);
			return this;  
		}
	}
    