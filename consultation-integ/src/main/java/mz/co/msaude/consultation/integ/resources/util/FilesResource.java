/**
 *
 */
package mz.co.msaude.consultation.integ.resources.util;

import static mz.co.msaude.consultation.integ.resources.util.FilesResource.NAME;

import java.io.File;
import java.io.InputStream;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Service;

/**
 * @author Stélio Moiane
 *
 */
@Path("files")
@Service(NAME)
public class FilesResource {

	@Inject
	private Storage storage;

	public static final String NAME = "mz.co.msaude.consultation.integ.resources.util.FilesResource";

	@POST
	@Path("upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response upload(@FormDataParam("file") final InputStream inputStream,
	        @FormDataParam("file") final FormDataContentDisposition fileDetails) {

		final String upload = this.storage.upload(inputStream, fileDetails);

		return Response.ok(upload).build();
	}

	@GET
	@Path("download/{filename}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response download(@PathParam("filename") final String filename) {

		final File file = this.storage.download(filename);

		if (file == null) {
			return Response.status(Status.NOT_FOUND).entity("FILE NOT FOUND: " + filename).type(MediaType.TEXT_PLAIN)
			        .build();
		}

		return Response.ok(file).build();
	}
}
