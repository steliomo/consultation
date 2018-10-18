/**
 *
 */
package mz.co.msaude.consultation.integ.resources.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Stélio Moiane
 *
 */
@Component
public class Storage {

	@Value("${files.dir}")
	private String filesDir;

	public String upload(final InputStream inputStream, final FormDataContentDisposition fileDetails) {

		final Path path = Paths.get(this.filesDir + fileDetails.getFileName());

		try (final OutputStream out = Files.newOutputStream(path)) {

			final byte[] buffer = new byte[1024];

			int lengthRead;

			while ((lengthRead = inputStream.read(buffer)) > 0) {
				out.write(buffer, 0, lengthRead);
				out.flush();
			}
		}
		catch (final IOException e) {
			e.printStackTrace();
		}

		return path.getFileName().toString();
	}

	public File download(final String filename) {
		final Path path = Paths.get(this.filesDir + filename);

		if (path.toFile().exists()) {
			return path.toFile();
		}

		return null;
	}

}
