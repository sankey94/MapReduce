package GameData;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
//import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

class ReducerMixData extends Reducer <Text,DoubleWritable,Text,DoubleWritable> 
{
	public void reducer(Text key,Iterable<DoubleWritable> value,Context ctx) throws IOException, InterruptedException 
	{
		 double max=0;
			for(DoubleWritable v:value)
			{
					max=Math.max(max, v.get());
			}
			ctx.write(key,new DoubleWritable(max));
	}
}

