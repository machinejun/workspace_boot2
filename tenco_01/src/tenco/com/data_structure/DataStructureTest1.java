package tenco.com.data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataStructureTest1 {
	public static void main(String[] args) {
		List lis0;
		// list 계열 : 중간의 데이터를 추가 하거나 삭제가 용이하다.
		// 순서가 있고(인덱스 연산 가능), 중복 가능
		
		//선언 방법
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<>();
		
		//선언과 동시에 초기화
		ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3));
		
		//값 추가 방법
		list3.add(4);
		list3.add(null);
		System.out.println(list3);
		list3.add(1, 10);
		System.out.println(list3);
		list3.remove(5);
		System.out.println(list3);
//		list3.clear();
//		System.out.println(list3);
		
		// 추가적인 메서드확인
		System.out.println(list3.size());
		
		//출력 방법
		System.out.println(list3.get(2));
		System.out.println(list3.isEmpty());
		
		//for
		for (Integer integer : list3) {
			System.out.println("i: " + integer);
		}
		
		// while
		// 요소 순회(반복자): 컬렉션 프레임워크에 저장된 요소들을 하나씩 꺼내서 참조한다.
		Iterator<Integer> iter = list3.iterator();
		while(iter.hasNext()) {
			System.out.println("while: " + iter.next());
		}
		
		// 값이 있으면 인젝스 번호를 반환, 없으면 -1를 반환 
		System.out.println(list3.contains(10));
		System.out.println(list3.indexOf(0));
		System.out.println(list3.indexOf(1));
		System.out.println(list3.indexOf(4));
	}
}
