package co.com.tns.business;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static co.com.tns.constants.Constant.INPUT;
import static co.com.tns.constants.Constant.OUTPUT;

@RunWith(MockitoJUnitRunner.class)
public class ProcessLazyLoadTest {

	@InjectMocks
	private ProcessLazyLoad processLazyLoad;

	@Test
	public void process() {

		String output = this.processLazyLoad.process(INPUT);

		Assert.assertEquals("La salida no coincide", OUTPUT, output);
	}
}
