import java.util.ArrayList;
import java.util.List;

public class Flattener {

	
	ArrayList<Object> result;
	
	public Flattener(){
		super();
		result = new ArrayList<>();
	}
	
	
	
	public List<Object> flatten(List<Object> temp){
		
		for (Object object : temp) {
			if(object instanceof List<?>){
				flatten((List<Object>)object);
			}
			else
			{	if(object != null){
					result.add(object);
				}
			}
		}
		return result;
		
	}
	
}
