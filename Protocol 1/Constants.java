public class Constants {
	public static final int buffersize = 13;
	public static final int lostframes = 5;
	public static final int timeout = 1000;
}

/*
 * This will be the main genie pig file:
 * 
 * The default will be:
 * 		Buffersize: 13 
 * 		lostframes: 0
 * 		timeout:	1000
 * 
 * Timeout will be tested 3 times: 10 ms, 2500 ms, 5000 ms
 * Buffersize will be tested 3 times: 1, 1000, 2000
 * Lostframes will be tested 3 times: 5, 10000, 20000
 * 
 * During testing for each, the other variables will be reduced to the defaults
 */