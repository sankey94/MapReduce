package attendance;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class IntegratedAttendance 
{
	public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException 
	{
			Configuration config=new Configuration();
			Job job =Job.getInstance(config,"Max Temp");
			FileSystem hdfs=FileSystem.get(config); 
			job.setJarByClass(IntegratedWeather.class);
			job.setMapperClass(ClassMapper.class);
			job.setReducerClass(TempReducer.class);
			job.setOutputKeyClass(TextInputFormat.class);
			job.setOutputValueClass(DoubleWritable.class);
			Path workDirectory=hdfs.getWorkingDirectory();
			Path working=new Path(workDirectory,"/Weather.csv");
			Path OutputDir=new Path(workDirectory,"/weathermaxout");
			job.setInputFormatClass(TextInputFormat.class);
			job.setOutputFormatClass(TextOutputFormat.class);
			FileInputFormat.addInputPath(job,working);
			FileOutputFormat.setOutputPath(job,OutputDir);
			System.exit(job.waitForCompletion(true)?0:1);
	}
}
