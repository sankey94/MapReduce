package Q2;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Q2Mapper extends Mapper<LongWritable, Text, Text, Text> 
{
	protected void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException 
	{
		try 
		{
			String [] str=value.toString().split(",");
			String statecode=str[4];
			int adult_population=Integer.parseInt(str[7]);
			int child_population=Integer.parseInt(str[17]);
			int population=adult_population+child_population;
			int eligible_adult_population=Integer.parseInt(str[10]);
			int eligible_child_population=Integer.parseInt(str[20]);
			int eligible_population=eligible_adult_population+eligible_child_population;
			String eligible_aggregate=String.valueOf((eligible_population/population)*100);
			context.write(new Text(statecode), new Text(eligible_aggregate));
		}
		catch (Exception e) {}
		
	}
}
