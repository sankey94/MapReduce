package stadium;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AttendanceReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {

	protected void reduce(Text key, Iterable<FloatWritable> value,Context ctx)
			throws IOException, InterruptedException 
	{
		 float max = 0;
      	 for(FloatWritable  v:value)
      	 {
      		String [] data=v.toString().split(" ");
      		float attendance=Float.parseFloat(data[data.length-1]);
      		String teamname = "0";
      		if(max>attendance) {
      			max=attendance;
      			teamname=data[0];
      		}
      		ctx.write(new Text(teamname),new FloatWritable(max) );
		 }

	}

}
