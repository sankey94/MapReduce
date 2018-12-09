package Q1;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Q1Map extends Mapper<LongWritable, Text, Text, Text>{

	public void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException 
	{
		try 
		{
			String [] str=value.toString().split(",");
			String statecode=str[4];
			int eligible_adults=Integer.parseInt(str[10]);
			//System.out.println(eligible_adults);
			int eligible_childrens=Integer.parseInt(str[17]);
			String eligible=String.valueOf(eligible_adults+eligible_childrens);
			//System.out.println(eligible);
			context.write(new Text(statecode), new Text(eligible));
		}
		catch (Exception e) {}
	}
	
}
