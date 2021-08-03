/*
 * Copyright 2002-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.metrics;

/**
 * Instruments the application startup phase using {@link StartupStep steps}.
 * <p>The core container and its infrastructure components can use the {@code ApplicationStartup}
 * to mark steps during the application startup and collect data about the execution context
 * or their processing time.
 *
 * @author Brian Clozel
 * @since 5.3
 */
public interface ApplicationStartup {

	/**
	 * Default "no op" {@code ApplicationStartup} implementation.
	 * <p>这种变体是为最小开销而设计的，并且不记录数据。.
	 */
	ApplicationStartup DEFAULT = new DefaultApplicationStartup();

	/**
	 * 创造新的一步，标志着它的开始。.
	 * 步骤名描述当前操作或阶段。这一技术
	 * <p>A step name describes the current action or phase. This technical
	 * 名称应以“。”命名，并可重用以描述其他实例
	 * name should be "." namespaced and can be reused to describe other instances of
	 * 在应用程序启动过程中执行相同的步骤
	 * the same step during application startup.
	 * @param name the step name
	 */
	StartupStep start(String name);

}
