import java.util.ArrayList;

import javax.swing.AbstractListModel;

import TodoBackLogic.Todo;

public class TodolistModel extends AbstractListModel<Todo>
{

	ArrayList<Todo> values = new ArrayList<Todo>();
	public int getSize() {
		return values.size();
	}
	public Todo getElementAt(int index) {
		return values.get(index);
	}
	public void addElement(Todo newtodo) {
		values.add(newtodo);
		fireContentsChanged(this, 0, getSize());
	}
}
