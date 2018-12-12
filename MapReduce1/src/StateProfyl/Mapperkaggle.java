package StateProfyl;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Mapperkaggle extends Mapper<LongWritable,Text,Text,Text>
{
	public void map (LongWritable key,Text value ,Context ctx)
		{
			try 
			{
				if (key.get() == 0 &&  value.toString().contains("CASE_STATUS") ) 
				{
					return;
				}
				else 
				{
					String [] data=value.toString().split(",");
					String salary=(data[data.length-6]);
					//System.out.println(salary);
					String state=data[data.length-3];
					//System.out.println(state);
					String soc=data[3].toUpperCase();
					//Text sal=new Text(salary);
					String conc = soc+" "+salary;
					ctx.write(new Text(state),new Text((conc)));
				}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
