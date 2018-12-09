package perday;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PerDayReducer extends Reducer<Text, Text, Text, Text>{

	@Override
	protected void reduce(Text key, Iterable<Text> value,Context ctx)
			throws IOException, InterruptedException 
	{
		//Double sal=0.0;
		 float max = 0;
		String date="";
		for(Text  v:value) {
		    if(max<Float.parseFloat(v.toString().split(" ")[1])) {
		    	max=Float.parseFloat(v.toString().split(" ")[1]);
		    	date=v.toString().split(" ")[0];
		    }
		}
	
		ctx.write(key, new Text(date+" "+max));
	}
	

}
