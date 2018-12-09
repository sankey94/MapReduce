package attendance;


import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class AttendanceMapper  extends Mapper<LongWritable,Text,Text,Text> 
{
	public void map(LongWritable key,Text value,Context ctx) throws IOException, InterruptedException 
	{
		String [] data=value.toString().split(",");
		String att;
		String col1=data[0];
		String teamname;
		if (key.get() == 0 &&  value.toString().contains("Stadium") ) 
		{
			return;
		}
		else 
		{
			if(col1.equals("Attendance")) 
			{
					teamname=data[data.length-1].substring(9, 12);
					//System.out.println(teamname);
					att=data[1];
					ctx.write(new Text(teamname), new Text(att));
			}
		}
	}
}
