import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordReducer extends Reducer <Text,IntWritable,Text,IntWritable>
{
	public void reduce (Text Key,Iterable <IntWritable> values,Context ctc) throws IOException, InterruptedException 
	{
		int count=0;
		for(IntWritable v:values)
		{
			count++;
		}
		
		ctc.write(Key,new IntWritable(count));
	}

}
