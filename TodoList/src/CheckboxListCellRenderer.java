import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import TodoBackLogic.Todo;

public class CheckboxListCellRenderer<E> extends JCheckBox implements
		ListCellRenderer<E> {
 
	private static final long serialVersionUID = 3734536442230283966L;
 
	@Override
	public Component getListCellRendererComponent(JList<? extends E> list,
			E value, int index, boolean isSelected, boolean cellHasFocus) {
		Todo TodoValue = (Todo) value;
		setComponentOrientation(list.getComponentOrientation());
 
		setFont(list.getFont());
		setText(TodoValue.message);
 
		setBackground(list.getBackground());
		setForeground(list.getForeground());
		setSelected(TodoValue.isDone);
		setEnabled(list.isEnabled());
		return this;
	}
 
}