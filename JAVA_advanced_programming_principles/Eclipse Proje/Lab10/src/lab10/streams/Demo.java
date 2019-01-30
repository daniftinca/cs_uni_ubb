package lab10.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Demo {

	public static void main(String[] args) throws IOException {
		
		//1. Filter + map
		
		List<String> strings = Arrays.asList("a1","a2","a3","b3","b3","b2","b1","c1");
		
		System.out.println("Before: "+strings);
		
		List<String> stringsR = strings
			.stream() //List>>Stream
			.filter(str -> str.contains("b")) //Filter after "b"
			.distinct() //Eliminate duplicates
			.sorted()  // Sorting
			.map(str -> str.toUpperCase())
			.collect(Collectors.toList()); //Stream >> List
		
		System.out.println("After: "+ stringsR);
		//2. Reduce
		
		Set<Integer> ints = IntStream
				.iterate(0,nr -> nr+3)
				.limit(3)
				.mapToObj(nr->nr)
				.collect(Collectors.toSet());
		System.out.println("Before: "+ints);
		
		Integer intsR = ints.stream()
		.reduce(15, (sum, nr) -> {
						return sum+=nr;
				});
		System.out.println("After: "+ intsR);
		
		//3. FlatMap
		
		List<List<String>> listInList = Arrays.asList(Arrays.asList("aa","bb"), Arrays.asList("11","22","33"));
		System.out.println("Before: "+listInList);
		


		List<String> flat =  listInList.stream()
		.flatMap(Collection::stream)
		.collect(Collectors.toList());
		System.out.println("After: "+flat);	
		
		//4. Reading from a  file + ForEach
		
		Stream <String> lines = Files.lines(Paths.get(System.getProperty("user.dir")+"\\resources\\test.txt"));
		
		
		System.out.println("Lines:");
		lines.forEach(System.out::println);
		
		
		
	}

}
