package TodoBackLogic;

public class CalendarHandler {
		Day currentDay;
		
		public void OnDayChanged(int day,int month,int year)
		{
			
			this.currentDay = new Day(day,month,year);
		}
}
