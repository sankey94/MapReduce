package Problem2;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.io.IntWritable;


public class TitanicDriver {
	public static void main(String[] args) throws Exception {
		Configuration conf= new Configuration();
		@SuppressWarnings("deprecation")
		Job job=new Job(conf);
		//*****************************************
		job.setJarByClass(TitanicDriver.class);
		job.setMapperClass(TitanicMapper.class);
		job.setReducerClass(TitanicReducer.class);
		//*************************************************
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		//**************************************************
		Path inputPath=new Path("/",new Path("TitanicData.csv"));
		Path outputPath=new Path("/",new Path("Output_Case_Study_2"));
		//****************************************************
		FileInputFormat.addInputPath(job, inputPath);
		FileOutputFormat.setOutputPath(job, outputPath);
		//*************************************************
	
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		//*************************************************
		
		System.exit(job.waitForCompletion(true)?0:1);
	}

}
