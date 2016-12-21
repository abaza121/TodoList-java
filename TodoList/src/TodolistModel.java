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
	public void ChangeList(ArrayList<Todo> newvalues) {
		values = newvalues;
	}
	public void ChangeList(Todo[] newvalues) {
		ArrayList<Todo> newTodovalues = new ArrayList<Todo>();
		for (Todo item : newvalues) {
		    System.out.println(item.message + item.getDay().day);
		    newTodovalues.add(item);
		}
		values = newTodovalues;
		fireContentsChanged(this, 0, getSize());
	}
	public void ClearList() {
		values = new ArrayList<Todo>();
		fireContentsChanged(this, 0, getSize());
	}
}
