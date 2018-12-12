import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ClassMapper extends Mapper<Text, Text, Text, IntWritable> 
{
	public void map(Text key,Text value,Context ctc)throws IOException, InterruptedException{
		StringTokenizer token=new StringTokenizer(value.toString());
		while(token.hasMoreTokens()) {
			ctc.write(new Text(token.nextToken()), new IntWritable(1));
		}
		
	}

}
