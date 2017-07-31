package co.com.tns.rest;

import static co.com.tns.constants.Constant.OUTPUT;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.tns.dto.LoadDTO;
import co.com.tns.services.LazyLoadService;
import rx.Observable;

@RunWith(MockitoJUnitRunner.class)
public class LazyLoadRestServiceTest {
	@Mock
	private AsyncResponse response;
	@Mock
	private HttpServletRequest request;
	@Mock
	private LazyLoadService lazyLoadService;
	@InjectMocks
	private LazyLoadRestService lazyLoadRestService;

	@Test
	public void lazyLoad() {
		LoadDTO salida = new LoadDTO();
		salida.setFile(OUTPUT);
		salida.setNumeroDocumento("12312321");

		LoadDTO in = new LoadDTO();

		Mockito.when(this.lazyLoadService.getLazyLoad(in)).thenReturn(Observable.just(salida));

		this.lazyLoadRestService.lazyLoad(request, response, in);

		Mockito.verify(response, Mockito.timeout(5000)).resume(Mockito.any(Response.class));
		Mockito.verify(response, Mockito.timeout(500)).resume(salida);
	}
}
