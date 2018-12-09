package perschoolagregate;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class AggregateMapper extends Mapper<LongWritable, Text, Text, Text> 
{
	protected void map(LongWritable key, DoubleWritable value,Context ctx)
			throws IOException, InterruptedException 
	{
		try 
		{
				String [] data=value.toString().split(",");
				String name = data[data.length-3];
				String register = data[data.length-2];
				String percentage=data[data.length-2];
				//String year=data[1];				
				ctx.write(new Text(name), new Text(register +" "+percentage));
				
				
		}
		catch (Exception e) 
		{
			e.getStackTrace();
		}
	}
}
