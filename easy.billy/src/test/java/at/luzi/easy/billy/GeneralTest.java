package at.luzi.easy.billy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class GeneralTest {

	private static String g;

	public void encode() throws IOException {

		String base64 = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("/Users/lukaszimmermann/dev/Lebenslauf.pdf")));

		g = base64;
		System.out.println(base64);
	}

	public void Xdecode() {
		Base64.getDecoder().decode(g);
	}
}
