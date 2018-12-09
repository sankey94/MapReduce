package attendance;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AttendanceReducer extends Reducer<Text, Text, Text, FloatWritable> {

	protected void reduce(Text key, Iterable<Text> value,Context ctx)
			throws IOException, InterruptedException 
	{
		 float max = 0;
      	 for(Text  v:value)
      	 {
      		String [] data=v.toString().split(" ");
      		float attendance=Float.parseFloat(data[data.length-1]);
      		System.out.println(attendance);
      		//String teamname = "0";
      		if(max<attendance) {
      			max=attendance;
      			//teamname=data[0];
      			ctx.write(key,new FloatWritable(max) );
      			
      		}
      		
      		
		 }

	}

}
