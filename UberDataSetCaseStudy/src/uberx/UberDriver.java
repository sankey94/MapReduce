package uberx;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class UberDriver {

	public static void main(String[] args) throws Exception {
		Configuration config=new Configuration();
		@SuppressWarnings("deprecation")
		Job job=new Job(config);
		job.setJarByClass(UberDriver.class);
		job.setMapperClass(UberMapper.class);
		job.setReducerClass(UberReduce.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		Path inputPath=new Path("/",new Path("uber.csv"));
		Path outputPath= new Path("/",new Path("UberDestination2"));
		FileInputFormat.setInputPaths(job, inputPath);
		FileOutputFormat.setOutputPath(job, outputPath);
		System.exit(job.waitForCompletion(true)?0:1);
		
		
	}

}
