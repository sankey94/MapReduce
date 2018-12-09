package perschoolagregate;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PerDayReducer extends Reducer<Text, Text, Text, FloatWritable> {

	@Override
	protected void reduce(Text key, Iterable<Text> value,Context ctx)
			throws IOException, InterruptedException {
		String [] data =value.toString().split(",");
		float register=Float.parseFloat(data[0]);
		float percentage=Float.parseFloat(data[1]);
		float aggregateper=register*(percentage/100);
		ctx.write(key, new FloatWritable(aggregateper));

	}
	

}
