package gr.com.eurotrade.tools;

import java.text.SimpleDateFormat;
import java.util.Random;

public interface Constants {
	public static final Random RANDOM_GENERATOR = new Random(100);
	
	// PATTERNS
	public final static String PATTERN_DAY = "dd/MM/yyyy";
	public final static String PATTERN_EVENT_DAY = "yyyy-MM-dd";
	public final static String PATTERN_DAY_FOR_DB = "dd-MM-yyyy";
	public final static String PATTERN_DAYTIME = "dd/MM/yyyy HH:mm:ss";
	public final static String PATTERN_TIME = "HH:mm";
	
	// FORMAT
	public final static SimpleDateFormat FORMAT_TO_TIME = new SimpleDateFormat(PATTERN_TIME);
	public final static SimpleDateFormat FORMAT_TO_DAY_FOR_DB = new SimpleDateFormat(PATTERN_DAY_FOR_DB);
	
	public final static String QUERY_TEST = "HH:mm";
}
