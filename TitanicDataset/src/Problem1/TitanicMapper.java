package Problem1;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TitanicMapper extends Mapper<LongWritable, Text, Text, Text>{

	protected void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException 
	{
		try 
		{
			String [] titanic = value.toString().split(",");
			String gender = titanic[4];
			int deaths = Integer.parseInt(titanic[1]);
			String age=titanic[5];
			if(deaths==1) {
				if(age.length()>1) 
				{
					System.out.println(age);
					context.write(new Text(gender),new Text(age));
				}
			}
		}
		catch(Exception e) {
			
		}
	
	
	
	
	}

}
