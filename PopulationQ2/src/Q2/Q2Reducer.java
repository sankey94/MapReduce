package Q2;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Q2Reducer extends Reducer<Text, FloatWritable, Text, FloatWritable> 
{
	public void reduce(Text key, Iterable<FloatWritable> value, Context context)throws IOException, InterruptedException 
	{
		System.out.println(key);
		float population=0;
		for(FloatWritable v:value) 
		{
			System.out.println(v);
			population=Float.parseFloat(v.toString());
			System.out.println(population);
			
 		}
		context.write(key, new FloatWritable(population));
	}
}
