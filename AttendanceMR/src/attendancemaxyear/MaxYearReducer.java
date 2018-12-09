package attendancemaxyear;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxYearReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> 
{

	@Override
	protected void reduce(Text key, Iterable<FloatWritable> value,Context context) throws IOException, InterruptedException {
		float max=0;
		for(FloatWritable v:value) {
			max=Math.max(max, v.get());
			
		}
		context.write(key,new FloatWritable(max));

	}
	
	

}
