package co.com.tns.rest;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import co.com.tns.dto.LoadDTO;
import co.com.tns.services.LazyLoadService;
import rx.schedulers.Schedulers;

@Path("/lazy")
public class LazyLoadRestService {

	@Inject
	private LazyLoadService lazyLoadService;

	@Path("/load")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void lazyLoad(@Context HttpServletRequest request, @Suspended final AsyncResponse response,
			LoadDTO loadDTO) {
		this.lazyLoadService.getLazyLoad(loadDTO).subscribeOn(Schedulers.computation()).subscribe(response::resume,
				e -> response.resume(new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR)));
	}

}
