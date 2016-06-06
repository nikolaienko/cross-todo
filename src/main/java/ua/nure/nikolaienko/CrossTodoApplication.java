package ua.nure.nikolaienko;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import org.bouncycastle.crypto.prng.RandomGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class CrossTodoApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CrossTodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

	public class WeightSegmentChooser<T extends Weightable> implements SegmentChooser<T>{
		private final RandomGenerator ranGen;

		public WeightSegmentChooser(RandomGenerator ranGen) {
			this.ranGen = ranGen;
		}

		@Override
		public T chooseSegment(Collection<T> bonusSegment){
			Iterable<T> filteredSegment = Iterables.filter(bonusSegment, new Predicate<T>() {
				@Override
				public boolean apply(@Nullable T input) {
					return input.getWeight() > 0;
				}
			});
			NavigableMap<Integer,T> weightedMap = new TreeMap<Integer, T>(Maps.uniqueIndex(filteredSegment, new Function<T, Integer>() {
				private int total = 0;
				@Nullable
				@Override
				public Integer apply(@Nullable T input) {
					total+=input.getWeight();
					return total;
				}
			}));
			int total = Collections.min(weightedMap.keySet());
			int random = ranGen.nextInt(total);
			return weightedMap.higherEntry(random).getValue();
		}
	}
}
