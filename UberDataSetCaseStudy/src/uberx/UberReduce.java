package uberx;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class UberReduce extends Reducer<Text, IntWritable, Text, IntWritable> 
{
	protected void reduce(Text key, Iterable<IntWritable> value,Context context) throws IOException, InterruptedException 
	{  
		int val=0;
		for(IntWritable v:value) {
			val+=Integer.parseInt(v.toString());
		}
		context.write(key, new IntWritable(val));

	}
	
	

}
