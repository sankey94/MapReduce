package perday;

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

public class AttendanceDriver 
{
public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
	
	//Step1:Create Configuration and Job
	Configuration conf=new Configuration();
	@SuppressWarnings("deprecation")
	Job job=new Job(conf,"FindMaximum");
	//Step2:Set the Components
	job.setJarByClass(AttendanceDriver.class);
	job.setMapperClass(PerDayMapper.class);
	job.setReducerClass(PerDayReducer.class);
//************************************************************	
	//Step3: Set key/value pa
	job.setMapOutputKeyClass(Text.class);
	job.setMapOutputValueClass(Text.class);
	job.setOutputKeyClass(Text.class);
	job.setOutputValueClass(Text.class);
//************************************************************	
	//Step 4: Set input/output paths
	Path inputPath=new Path("/",new Path("Attendance_4PM_Report.csv"));
	Path outputPath=new Path("/",new Path("attendanceOutput3"));
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
