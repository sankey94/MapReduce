package GameData;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class MapperMixDta extends Mapper<LongWritable,Text,Text,IntWritable> 
{
	public void map(LongWritable key,Text value,Context ctx) throws IOException, InterruptedException
	{
		String [] data=value.toString().split(",");
		String col1=data[0];
		Text team;
		IntWritable attendance;
		if(col1.equals("Attendance"))
		{
			String teamname=data[data.length-1].substring(9, 12);
			System.out.println(teamname);
			String att=data[1];
			team=new Text(teamname);
			System.out.println(att);
			attendance=new IntWritable(Integer.parseInt(att));
			ctx.write(team,attendance);
		}
	}
}
	


