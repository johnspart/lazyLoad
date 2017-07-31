package co.com.tns.business;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import co.com.tns.util.BusinessException;

public class ProcessLazyLoad {
	private static final String SEPARATOR = "\n";
	private static final String CASE = "Case #%d: %d";
	private static final Integer PESO_MINIMO = 50;

	public String process(String input) {
		StringBuilder output = new StringBuilder();

		List<Integer> lInput = this.getInputList(input);
		Integer dias = lInput.get(0);
		Integer maxViajes = null;
		Integer poscicion = 1;
		List<Integer> pesosDia = null;
		for (int dia = 1; dia <= dias; dia++) {
			pesosDia = this.getElementsByDay(lInput, poscicion);

			maxViajes = this.getCantViajes(pesosDia, null);

			output.append(String.format(CASE, dia, maxViajes));
			output.append(SEPARATOR);

			poscicion = poscicion + lInput.get(poscicion) + 1;
		}

		return output.toString();
	}

	private List<Integer> getElementsByDay(List<Integer> lInput, Integer poscicion) {
		return lInput.subList(poscicion + 1, poscicion + lInput.get(poscicion) + 1).stream().sorted()
				.collect(Collectors.toList());
	}

	private List<Integer> getInputList(String input) {
		try {
			return Arrays.stream(input.split(SEPARATOR)).map(Integer::valueOf).collect(Collectors.toList());
		} catch (Exception e) {
			throw new BusinessException("Error al obtener elementos numéricos del archivo de carga", e);
		}
	}

	private Integer getCantViajes(List<Integer> lInput, AtomicInteger viajes) {
		if (viajes == null) {
			viajes = new AtomicInteger(0);
		}

		Integer max = this.getValue(lInput, Collections::max);

		this.getCargaViaje(lInput, 0, new AtomicInteger(1), max);
		viajes.incrementAndGet();
		if (!lInput.isEmpty()) {
			this.getCantViajes(lInput, viajes);
		}

		return viajes.get();
	}

	private Integer getCargaViaje(List<Integer> lInput, Integer peso, AtomicInteger cant, Integer max) {
		peso = max * cant.get();
		if (peso >= PESO_MINIMO) {
			return peso;
		}
		this.getValue(lInput, Collections::min);
		peso = max * cant.getAndIncrement();

		if (!lInput.isEmpty() && peso < PESO_MINIMO && lInput.size() * Collections.max(lInput) > PESO_MINIMO) {
			this.getCargaViaje(lInput, peso, cant, max);
		} else {
			lInput.clear();
		}

		return peso;
	}

	private Integer getValue(List<Integer> lInput, Function<List<Integer>, Integer> function) {
		Integer value = function.apply(lInput);
		lInput.remove(lInput.indexOf(value));
		return value;
	}

}
