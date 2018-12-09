package Q1;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


public class Q1Driver {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf=new Configuration();
		@SuppressWarnings("deprecation")
		Job job=new Job(conf);
		//*************************************************
		
		job.setJarByClass(Q1Driver.class);
		job.setMapperClass(Q1Map.class);
		job.setReducerClass(Q1Reducer.class);
		
		//*************************************************
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputKeyClass(IntWritable.class);
		
		//*************************************************
		Path inputPath=new Path("/",new Path("SSA-SA-FYWL.csv"));
		Path outputPath=new Path("/",new Path("max_statewise_population"));
		//*************************************************
		FileInputFormat.addInputPath(job, inputPath);
		FileOutputFormat.setOutputPath(job, outputPath);
		//*************************************************
	
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		//*************************************************
		
		System.exit(job.waitForCompletion(true)?0:1);
	}

}
