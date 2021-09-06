package zclvct.spring.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.core.metrics.StartupStep;

import java.util.Collections;
import java.util.Iterator;
import java.util.function.Supplier;

/**
 * @description:
 * @projectName:spring
 * @see:common
 * @author:赵冲
 * @createTime:2021/8/3 15:07
 * @version:1.0
 */
public class MyStartupStep implements ApplicationStartup {
	private final static Log logger = LogFactory.getLog(MyStartupStep.class);
	private static final MyStartupStep.DefaultStartupStep DEFAULT_STARTUP_STEP = new MyStartupStep.DefaultStartupStep();

	@Override
	public MyStartupStep.DefaultStartupStep start(String name) {
		System.out.println();
		logger.info("**********"+name+"*******************");
		return DEFAULT_STARTUP_STEP;
	}


	static class DefaultStartupStep implements StartupStep {

		private final MyStartupStep.DefaultStartupStep.DefaultTags TAGS = new MyStartupStep.DefaultStartupStep.DefaultTags();

		@Override
		public String getName() {
			return "myStartupStep";
		}

		@Override
		public long getId() {
			return 0L;
		}

		@Override
		public Long getParentId() {
			return null;
		}

		@Override
		public Tags getTags() {
			return this.TAGS;
		}

		@Override
		public StartupStep tag(String key, String value) {
			return this;
		}

		@Override
		public StartupStep tag(String key, Supplier<String> value) {
			return this;
		}

		@Override
		public void end() {
			System.out.println("**********"+getName()+"*******************");
			logger.info("**********"+getName()+"*******************");
		}


		static class DefaultTags implements Tags {

			@Override
			public Iterator<Tag> iterator() {
				return Collections.emptyIterator();
			}
		}
	}
}
