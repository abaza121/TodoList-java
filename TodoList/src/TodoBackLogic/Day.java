package TodoBackLogic;

public class Day implements java.io.Serializable{
	public int month;
	public int year;
	public int day;
	public static Boolean SameDay(Day x, Day y)
	{
		if(x.month == y.month)
			if(x.year == y.year)
				if(x.day == y.day)
					return true;
		return false;
				
	}
	public Day(int day, int month, int year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (!Day.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    final Day other = (Day) obj;
	    if(this.month == other.month)
			if(this.year == other.year)
				if(this.day == other.day)
					return true;
		return false;
	}
}
