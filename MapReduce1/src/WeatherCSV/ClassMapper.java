package WeatherCSV;
import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ClassMapper extends Mapper  <LongWritable,Text,IntWritable,DoubleWritable>  
{
	public void map(LongWritable key , Text Value, Context ctx) throws IOException, InterruptedException
	{
		//StringTokenizer token=new StringTokenizer(Value.toString(),",");
		String line[]=Value.toString().split(",");
		//IntWritable i=new IntWritable();
				
			int year=Integer.parseInt(line[2]);
			year=year/10000;
			IntWritable keyyear=new IntWritable(year);
			String maxtemp=line[11];
			int a=maxtemp.length();
			String o ;
			DoubleWritable valuetemp;
			if(maxtemp.contains("*") )
			{
				o=maxtemp.substring(0, 3);
				valuetemp=new DoubleWritable(Double.parseDouble(o));
			}
			else 
			{
				o=maxtemp.substring(0, 2);
				valuetemp=new DoubleWritable(Double.parseDouble(o));
			}
			ctx.write(keyyear,valuetemp);
		

				
		
	}
}
