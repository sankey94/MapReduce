package attendance;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AttendanceReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {

	protected void reduce(Text key, Iterable<FloatWritable> inputValues,Context ctx) throws IOException, InterruptedException {
		float max=0;
		for(FloatWritable value:inputValues) {
			max=Math.max(max, value.get());
		}
		ctx.write(new Text("Max val"), new FloatWritable(max));
	}
	

}
