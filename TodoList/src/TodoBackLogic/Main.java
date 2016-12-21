package TodoBackLogic;
import java.io.IOException;

public class Main {

	public static void mainOLD(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Start");
		TodoManager manager = new TodoManager();
		manager.AddTodo(new Todo("abaza", false, 5, 10, 5));
		manager.SaveAvailableTodos();
		System.out.println(manager.GetForDay(new Day(5,10,5)).length);
		manager.RemoveTodo(new Todo("abaza", false, 5, 10, 5));
		System.out.println(manager.GetForDay(new Day(5,10,5)).length);
		manager.SaveAvailableTodos();
	}

}
