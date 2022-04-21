package tenco.com.data_structure;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class DataStructureTest3 {

	public static void main(String[] args) {
		Set set;
		
		HashSet<Integer> set1 = new HashSet<>();
		// 중복값 허용 하지 않는다. >> 중복된 value가 있으면 같은 value라고 인식
		
		set1.add(1);
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(3);
		set1.add(3);
		set1.add(4);
		System.out.println(set1.size());
		
		set1.remove(1);
		
		System.out.println(set1);
		
		set1.clear();
		
		System.out.println(set1);
		
		Iterator<Integer> iter = set1.iterator();
		while(iter.hasNext()) {
			System.out.println("값 확인 : " + iter.next());
		}
		System.out.println("==================");
		HashSet<Integer> set2 = new HashSet<>();
		
//		while(set2.size() < 6) {
//			set2.add(getRandom());
//		}
//		
		for(int i = 0; i < 6; i++) {
			set2.add(getRandom());
			if(set2.size() == i) {
				i = i -1;
			}
	
		}
		
		System.out.println(set2);
		System.out.println(set2.size());
	} // end of main
	
	public static int getRandom() {
		Random r = new Random();
		int value = r.nextInt(45) + 1;
		return value;
		
	}
}
