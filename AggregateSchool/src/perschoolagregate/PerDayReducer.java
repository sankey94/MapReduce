package perschoolagregate;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PerDayReducer extends Reducer<Text, Text, Text, Text> {

	@Override
	protected void reduce(Text key, Iterable<Text> value,Context ctx)
			throws IOException, InterruptedException {
		try 
		{
			float max=0;
			String maxs;
			for(Text  v:value) 
			{
				String [] data =v.toString().split(" ");
				float register=Float.parseFloat(data[0]);
				//System.out.println(register);
				float percentage=Float.parseFloat(data[1]);
				//System.out.println(percentage);
				float aggregateper=register*(percentage/100);
				String year=data[2];
				if(max<aggregateper) 
				{
					max=aggregateper;
					maxs=String.valueOf(max);
					ctx.write(key, new Text(maxs+"    "+year));
				}
				
				
			}
		}
		catch (Exception e) 
		{
		}
	}
	

}
