package GameData;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

class ReducerMixData extends Reducer <Text,IntWritable,Text,IntWritable> 
{
	public void reducer(Text key,Iterable<IntWritable> value,Context ctx) throws IOException, InterruptedException 
	{
		 int max=0;
			for(IntWritable v:value)
			{
					max=Math.max(max, v.get());
			}
			ctx.write(key,new IntWritable(max));
	}
}

