package TodoBackLogic;
import java.io.*;
import java.util.ArrayList;

public final class FileUtil {
		public static final String CachePath = "Cache";
		public static void SaveToFile(ArrayList<Todo> TodoList) throws IOException
		{
			FileOutputStream fos = new FileOutputStream(CachePath);
			ObjectOutputStream out = new ObjectOutputStream(fos);	
			out.writeObject(TodoList);
		}
		public static ArrayList<Todo> LoadFile()
		{
			File yourFile = new File(CachePath);
			if(!yourFile.exists())
			{
				try {
					yourFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
				return new ArrayList<Todo>();
				}
			}
			ArrayList<Todo> ret = new ArrayList<Todo>();
			try
			{
			FileInputStream fos = new FileInputStream(CachePath);
			ObjectInputStream in = new ObjectInputStream(fos);	
			ret = (ArrayList<Todo>) in.readObject();
			}
			catch(Exception ex)
			{
				ret = new ArrayList<Todo>();
			}
			finally{
			return ret;
			}
		}
}
