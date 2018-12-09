package Q2;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Q2Reducer extends Reducer<Text, Text, Text, FloatWritable> 
{
	protected void reduce(Text key, Iterable<Text> value, Context context)throws IOException, InterruptedException 
	{
		
		float eligible_population_percentage=0.0f;
		for(Text v:value) 
		{
			String [] data = v.toString().split(",");
			int population=Integer.parseInt(data[0]);
			System.out.println(population);
			int eligible_population=Integer.parseInt(data[1]);
			System.out.println(eligible_population);
			eligible_population_percentage=(eligible_population*100/population);
			System.out.println(eligible_population_percentage);
 		}
		context.write(key, new FloatWritable(eligible_population_percentage));
	}
}
