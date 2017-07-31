package co.com.tns.services;

import static co.com.tns.constants.Constant.INPUT;
import static co.com.tns.constants.Constant.OUTPUT;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.tns.business.ProcessLazyLoad;
import co.com.tns.dto.LoadDTO;
import co.com.tns.repository.LazyLoadLogRepository;
import rx.Observable;

@RunWith(MockitoJUnitRunner.class)
public class LazyLoadServiceTest {
	@Mock
	private ProcessLazyLoad processLazyLoad;
	@Mock
	private LazyLoadLogRepository lazyLoadLogRepository;
	@InjectMocks
	private LazyLoadService lazyLoadService;

	@Test
	public void getLazyLoadTest() {
		LoadDTO load = new LoadDTO();
		load.setNumeroDocumento("11111");
		load.setFile(INPUT);

		Mockito.doNothing().when(this.lazyLoadLogRepository).almacenar(Mockito.any());
		Mockito.when(this.processLazyLoad.process(load.getFile())).thenReturn(OUTPUT);

		Observable<LoadDTO> resp = this.lazyLoadService.getLazyLoad(load);

		resp.subscribe(l -> {
			Assert.assertNotNull("La respuesta es nulla", l);
			Assert.assertEquals("El valor de salida no coincide", OUTPUT, l.getFile());
		});
	}

}
