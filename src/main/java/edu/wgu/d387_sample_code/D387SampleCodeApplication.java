package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.rest.MessageMapping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@SpringBootApplication
public class D387SampleCodeApplication {
	static ExecutorService messageExecutor = newFixedThreadPool(5);
	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);

		MessageMapping messageMapping = new MessageMapping();

		messageExecutor.execute(()-> {
			try {
				Locale locale = Locale.US;
				String message = messageMapping.getWelcomeMessage(locale);
				System.out.println("EN Thread: " + message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		messageExecutor.execute(()-> {
			try {
				Locale locale = Locale.CANADA_FRENCH;
				String message = messageMapping.getWelcomeMessage(locale);
				System.out.println("FR Thread: " + message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
