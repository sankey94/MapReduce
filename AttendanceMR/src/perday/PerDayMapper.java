package perday;

import java.io.IOException;

//import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PerDayMapper extends Mapper<LongWritable, Text, Text, Text> 
{
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException 
	{

	
	try
	{
		if (key.get() == 0 &&  value.toString().contains("SCHOOL_YEAR") ) 
		{
			return;
		}
		else 
		{
		String[] inputValues=value.toString().split(",");
		String date=inputValues[1];
		//float number =0;
		String num;
		System.out.println(date);
		String schoolname=inputValues[2];
		System.out.println(schoolname);
		num=inputValues[inputValues.length-1];
		System.out.println(num);
		context.write(new Text(schoolname),new Text(date+" "+num));
		}
	}
	catch (Exception e) {
		//approach 1: replace information
		//approach 2: ignore data
		//return;
		
	}
	
	
}

}
