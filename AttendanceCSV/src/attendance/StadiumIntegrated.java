package attendance;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;




public class StadiumIntegrated 
{
	public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException 
	{
		//Step1:Create Configuration and Job
		Configuration conf=new Configuration();
		@SuppressWarnings("deprecation")
		Job job=new Job(conf,"FindMaximum");
		//Step2:Set the Components
		job.setJarByClass(StadiumIntegrated.class);
		job.setMapperClass(AttendanceMapper.class);
		job.setReducerClass(AttendanceReducer.class);
	//************************************************************	
		//Step3: Set key/value pa
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FloatWritable.class);
	//************************************************************	
		//Step 4: Set input/output paths
		Path inputPath=new Path("/",new Path("uncleaned_nfl_game_metadata_since_1980.csv"));
		Path outputPath=new Path("/",new Path("attendanceOutput2"));
	//************************************************************	
		//Step 5: Assign Files to the job
		FileInputFormat.addInputPath(job, inputPath);
		FileOutputFormat.setOutputPath(job, outputPath);
	//************************************************************
		//Step 6: Submit the Job
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

	//************************************************************
		//Step 7:Submit Job
		System.exit(job.waitForCompletion(true)?0:1);
	}
}
