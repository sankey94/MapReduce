package stadium;


import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class AttendanceMapper  extends Mapper<LongWritable,FloatWritable,Text,FloatWritable> 
{
	public void map(LongWritable key,FloatWritable value,Context ctx) throws IOException, InterruptedException 
	{
		String [] data=value.toString().split(",");
		float att=0;
		String col1=data[0];
		String teamname="0";
		try
		{
			if(col1.equals("Attendance")) 
			{
				teamname=data[data.length].substring(9, 12);
				att=Float.parseFloat(data[1]);
			}
		}
		catch (Exception e) {
			att=0.0f;
		}
		ctx.write(new Text(teamname), new FloatWritable(att));
	}
}
