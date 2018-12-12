package StateProfyl;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class KaggleReducer extends Reducer<Text,Text,Text,Text>
{
	public void reduce(Text Key,Iterable<Text> values,Context ctx) throws IOException, InterruptedException
	{
		 
		 Double sal=0.0;
		 int i = 0;
		 
		for(Text  v:values) {
			
			String [] data=v.toString().split(" ");
			if(data[data.length-1].equals("NA")) {
				data[data.length-1]="0";
			}
			Double salary=Double.parseDouble(data[data.length-1]);
			 
			// System.out.println(salary);
			sal+=salary;
			i++;
		}
		Double avg=sal/i;
		String av=avg.toString();
		ctx.write(Key, new Text(av));
		
	}

}
