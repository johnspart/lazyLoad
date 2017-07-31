package co.com.tns.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import co.com.tns.orm.LazyLoadLog;
import co.com.tns.util.BusinessException;

public class LazyLoadLogRepository {

	@PersistenceContext(name = "persist.unit")
	private EntityManager entityManager;

	@Transactional
	public void almacenar(LazyLoadLog lazyLoadLog) {
		try {
			this.entityManager.persist(lazyLoadLog);
		} catch (Exception e) {
			throw new BusinessException(String.format("Error en almacenamiento del registro con número de documento %s",
					lazyLoadLog.getNumeroDocumento()), e);
		}
	}
}
