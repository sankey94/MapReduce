package perschoolagregate;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class AggregateMapper extends Mapper<LongWritable, Text, Text, Text> 
{
	protected void map(LongWritable key, Text value,Context ctx)
			throws IOException, InterruptedException 
	{
		try 
		{
				String [] data=value.toString().split(",");
				String name = data[2];
				System.out.println(name);
				String register = data[data.length-2].trim();
				//System.out.println(register);
				String percentage=data[data.length-1].trim();
				//String year=data[1];	
				String year=data[0].trim();
				ctx.write(new Text(name), new Text(register +" "+percentage+" "+year));
		}
		catch (Exception e) 
		{
		}
	}
}
