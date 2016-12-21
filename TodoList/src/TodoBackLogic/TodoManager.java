package TodoBackLogic;
import java.io.IOException;
import java.util.ArrayList;

public class TodoManager {

	public ArrayList<Todo> AvailableTodos;
	public void AddTodo(Todo todo)
	{
		this.AvailableTodos.add(todo);
	}
	public void RemoveTodo(Todo todo)
	{
		System.out.println(this.AvailableTodos.remove(todo));
	}
	public void EditTodo(Todo todo, Todo newTodo)
	{
		this.AvailableTodos.remove(todo);
		this.AvailableTodos.add(newTodo);
		try {
			SaveAvailableTodos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("unable to save new Todo List after removing older");
		}
	}
	public void LoadTodoList() throws ClassNotFoundException, IOException
	{
		this.AvailableTodos = FileUtil.LoadFile();
	}
	public void SaveAvailableTodos() throws IOException
	{
		FileUtil.SaveToFile(this.AvailableTodos);	
	}
	public Todo[] GetForDay(Day x)
	{
		return this.AvailableTodos.stream().filter(y -> Day.SameDay(y.getDay(), x)).toArray(size -> new Todo[size]);
	}
	public TodoManager() throws ClassNotFoundException, IOException
	{
	   this.AvailableTodos = FileUtil.LoadFile();
	}
}
