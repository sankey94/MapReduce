package GameData;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


public class GameDataDemo {
	public static void main(String[] args) throws Exception {
		Configuration config=new Configuration();
		Job job =Job.getInstance(config,"Max Attendence");
		FileSystem hdfs=FileSystem.get(config); 
		job.setJarByClass(GameDataDemo.class);
		job.setMapperClass(MapperMixDta.class);
		job.setReducerClass(ReducerMixData.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DoubleWritable.class);
		Path workDirectory=hdfs.getWorkingDirectory();
		Path working=new Path(workDirectory,"/uncleaned_nfl_game_metadata_since_1980.csv");
		Path OutputDir=new Path(workDirectory,"/maxuncleandata");
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		FileInputFormat.addInputPath(job,working);
		FileOutputFormat.setOutputPath(job,OutputDir);
		System.exit(job.waitForCompletion(true)?0:1);
	}

}
