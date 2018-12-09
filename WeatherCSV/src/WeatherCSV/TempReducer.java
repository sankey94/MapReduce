package WeatherCSV;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class TempReducer extends Reducer <IntWritable,DoubleWritable,IntWritable,DoubleWritable> 
{
	@Override
	public void reduce(IntWritable key,Iterable<DoubleWritable> values,Context ctx) throws IOException, InterruptedException
	{
	    double max=0.0;
		for(DoubleWritable v:values)
		{
				max=Math.max(max, v.get());
		}
		ctx.write(key,new DoubleWritable(max));
	}
}








