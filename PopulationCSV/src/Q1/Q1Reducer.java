package Q1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Q1Reducer extends Reducer<Text, Text, Text, IntWritable> {

	public void reduce(Text key, Iterable<Text> value, Context context)
			throws IOException, InterruptedException {
		int sum=0;
		for(Text v:value) {
			String population=v.toString();
			int eligible_population=Integer.parseInt(population);
			sum+=eligible_population;
			
		}
		context.write(key, new IntWritable(sum));

	}
	
	
	

}
