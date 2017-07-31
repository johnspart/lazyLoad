
package co.com.tns.services;

import javax.inject.Inject;

import co.com.tns.business.ProcessLazyLoad;
import co.com.tns.dto.LoadDTO;
import co.com.tns.orm.LazyLoadLog;
import co.com.tns.repository.LazyLoadLogRepository;
import co.com.tns.util.BusinessException;
import rx.Observable;

public class LazyLoadService {

	@Inject
	private ProcessLazyLoad processLazyLoad;

	@Inject
	private LazyLoadLogRepository lazyLoadLogRepository;

	public Observable<LoadDTO> getLazyLoad(LoadDTO load) {
		try {
			LazyLoadLog lazyLoadLog = this.getLazyLoadLog(load);
			this.lazyLoadLogRepository.almacenar(lazyLoadLog);
			load.setFile(lazyLoadLog.getOutputFileContent());
			return Observable.just(load);
		} catch (BusinessException e) {
			return Observable.error(e);
		}
	}

	private LazyLoadLog getLazyLoadLog(LoadDTO load) {
		LazyLoadLog lazyLoadLog = new LazyLoadLog();

		lazyLoadLog.setNumeroDocumento(load.getNumeroDocumento());
		lazyLoadLog.setInputFileContent(load.getFile());
		lazyLoadLog.setOutputFileContent(this.processLazyLoad.process(load.getFile()));

		return lazyLoadLog;
	}

}
