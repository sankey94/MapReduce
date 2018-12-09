package Problem1;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TitanicReducer extends Reducer<Text, Text, Text, FloatWritable> {

	protected void reduce(Text key, Iterable<Text> value,Context context) throws IOException, InterruptedException {
		float sum=0;
		int count=0;
		
		for(Text v:value) {
			count+=1;
			sum+=Float.parseFloat(v.toString());
			
		}
		float avg_age=sum/count;
		System.out.println(avg_age);
		context.write(key, new FloatWritable(avg_age));
	
	
	
	
	
	
	}

}
