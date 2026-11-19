package businesslogic;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class Irakurri {

	public static String irakurriJAR(String jar) throws IOException {
		// Classpath-etik saiatu lehendabizi.
		InputStream is = Irakurri.class.getResourceAsStream(jar);
		if (is == null && !jar.startsWith("/"))
			is = Irakurri.class.getResourceAsStream("/" + jar);
		if (is != null)
			try (InputStream in = is) {
				return new String(in.readAllBytes(), StandardCharsets.UTF_8);
			}

		// Working dir eta main/resources-etik bestela
		Path wd = Paths.get(System.getProperty("user.dir"));
		Path[] hautagaiak = {
				wd.resolve(jar),
				wd.resolve("src").resolve("main").resolve("resources").resolve(jar),
				wd.resolve("resources").resolve(jar) };
		for (Path p : hautagaiak)
			if (Files.exists(p))
				return Files.readString(p, StandardCharsets.UTF_8);
		throw new FileNotFoundException("Ezin izan da topatu...");
	}
}
