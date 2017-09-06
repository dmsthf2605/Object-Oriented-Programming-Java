import java.util.*;

public class ExampleCollections {

	public static void main(String[] args) {
	
		List<String> oss = new ArrayList<>();
		oss.add("Windows");
		oss.add("Unix");
		oss.add("MacOS");
		oss.add("Android");
		oss.add("Linux");
		
		Collections.sort(oss);
		for (String os : oss)
			System.out.println(os);

	}

}
