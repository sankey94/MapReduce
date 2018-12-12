package ubergo;

import java.io.IOException;
import java.util.Date;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class UberMapper extends Mapper<LongWritable, Text, Text, IntWritable> 
{
	protected void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException 
	{
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("MM/dd/yyyy");
		String[] days ={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		try {
		String [] uber= value.toString().split(",");
		String driver_code=uber[0];
		Date date= format.parse(uber[1]);
		int trip_no=Integer.parseInt(uber[3]);
		@SuppressWarnings("deprecation")
		String keys = driver_code+ " "+days[date.getDay()];
		context.write(new Text(keys),new IntWritable(trip_no));
		
		}
		catch (Exception e) {}
	}
}
