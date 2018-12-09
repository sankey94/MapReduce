package Problem2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TitanicMapper extends Mapper<LongWritable, Text, Text, IntWritable>
{
	private final static IntWritable one = new IntWritable(1);
	protected void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException 
	{
		
		try 
		{
			String [] titanic = value.toString().split(",");
			if(titanic.length>6)
			{
			String people= titanic[1]+" "+titanic[4]+" "+titanic[5];
			context.write(new Text(people), one);
			}
		}
		catch(Exception e){}	
	}
}
