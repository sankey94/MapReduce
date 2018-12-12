package StateProfyl;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;



public class StateDriver {

	public static void main(String[] args) throws Exception {
		Configuration config=new Configuration();
		Job job =Job.getInstance(config,"Max State");
		FileSystem hdfs=FileSystem.get(config); 
		job.setJarByClass(StateDriver.class);
		job.setMapperClass(Mapperkaggle.class);
		job.setReducerClass(KaggleReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		Path workDirectory=(Path) hdfs.getWorkingDirectory();
		Path working=new Path(workDirectory,"/h1b_kaggle.csv");
		Path OutputDir=new Path(workDirectory,"/kagglemaxout");
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		FileInputFormat.addInputPath(job,working);
		FileOutputFormat.setOutputPath(job,OutputDir);
		System.exit(job.waitForCompletion(true)?0:1);
		// TODO Auto-generated method stub

	}

}
