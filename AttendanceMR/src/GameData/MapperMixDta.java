package GameData;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class MapperMixDta extends Mapper<LongWritable,Text,Text,DoubleWritable> 
{
	public void map(LongWritable key,Text value,Context ctx) throws IOException, InterruptedException
	{
		String [] data=value.toString().split(",");
		
		//int a=data[2].length();
		//int b=data[2].indexOf("0");
		String teamname=data[data.length-1].substring(9, 12);
		System.out.println(teamname);
		String col1=data[0];
		Text team;
		DoubleWritable attendance;
		if(col1.equals("Attendance"))
		{
			String att=data[1];
			team=new Text(teamname);
			attendance=new DoubleWritable(Double.parseDouble(att));
			System.out.println(att);
			ctx.write(team,attendance);
		}
		else 
			return;
		
		
	}
}
	


