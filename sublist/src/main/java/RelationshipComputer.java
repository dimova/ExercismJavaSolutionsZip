import java.util.Collections;
import java.util.List;

public class RelationshipComputer<T> {

	
	
	
	public Relationship computeRelationship(List<T> firstList,List<T> secondList) {
		
		/*if(firstList.isEmpty() && !secondList.isEmpty()) {
			return Relationship.SUBLIST;
		}
		if(!firstList.isEmpty() && secondList.isEmpty()) {
			return Relationship.SUPERLIST;
		}*/
		
		if(secondList.size() > firstList.size()) {
			
			if(Collections.indexOfSubList(secondList, firstList) >= 0) {
				return Relationship.SUBLIST;
			}
		}
		else if(firstList.size() > secondList.size()) {
			if(Collections.indexOfSubList(firstList, secondList) >= 0) {
				return Relationship.SUPERLIST;
			}
		}
		else {
			if(Collections.indexOfSubList(firstList, secondList) == 0) {
				return Relationship.EQUAL;
			}
		}
		return Relationship.UNEQUAL;
		
		
	}
	
}
