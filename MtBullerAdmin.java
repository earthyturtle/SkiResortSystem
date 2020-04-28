package mtbuller;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MtBullerAdmin {
	
	public static void main(String[] args) {
		MtBullerResort mbr = new MtBullerResort();
		mbr.startup();
		mbr.run();
		mbr.close();
	}

}
