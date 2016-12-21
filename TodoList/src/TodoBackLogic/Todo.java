package TodoBackLogic;

public class Todo implements java.io.Serializable{
	public String message;
	public Boolean isDone;
	private Day day;
	public Day getDay()
	{
		return day;
	}
	public Todo(String message, Boolean isDone, Day day)
	{
		this.message = message;
		this.isDone = isDone;
		this.day = day;
	}
	public Todo(String message, Boolean isDone, int day, int month, int year)
	{
		this.message = message;
		this.isDone = isDone;
		this.day = new Day(day,month,year);
	}
	public Todo(Todo ref)
	{
		this.message = ref.message;
		this.isDone = ref.isDone;
		this.day = ref.day;
	}
	public void FlipDone()
	{
		isDone = !isDone;
	}
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (!Todo.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    final Todo other = (Todo) obj;
	    if ((this.message == null) ? (other.message != null) : !this.message.equals(other.message)) {
	        return false;
	    }
	    if ((this.day == null) ? (other.day != null) : !this.day.equals(other.day)) {
	        return false;
	    }
	    return true;
	}
}
