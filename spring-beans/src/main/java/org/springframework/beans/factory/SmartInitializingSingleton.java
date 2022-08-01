/*
 * Copyright 2002-2014 the original author or authors.
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

package org.springframework.beans.factory;

/**
 * 单例预实例化阶段结束时触发的回调接口
 * 在 {@link BeanFactory} 引导期间。这个接口可以通过
 * 单例 bean 以便在常规之后执行一些初始化
 * 单例实例化算法，避免早期意外带来的副作用
 * 初始化（例如来自 {@link ListableBeanFactory#getBeansOfType} 调用）。
 * 从这个意义上说，它是 {@link InitializingBean} 的替代品，它得到
 * 在 bean 的本地构建阶段结束时触发。
 *
 * <p>这个回调变体有点类似于
 * {@link org.springframework.context.event.ContextRefreshedEvent} 但没有
 * 需要实现 {@link org.springframework.context.ApplicationListener}，
 * 无需跨上下文层次结构等过滤上下文引用。
 * 它还意味着对 {@code beans} 包的依赖性更小
 * 并受到独立 {@link ListableBeanFactory} 实现的认可，
 * 不仅仅是在 {@link org.springframework.context.ApplicationContext} 环境中。
 *
 * <p><b>注意：</b>如果您打算启动/管理异步任务，最好
 * 实现 {@link org.springframework.context.Lifecycle} 而不是提供
 * 更丰富的运行时管理模型，并允许分阶段启动/关闭。
 *
 * @author Juergen Hoeller
 * @since 4.1
 * @see org.springframework.beans.factory.config.ConfigurableListableBeanFactory#preInstantiateSingletons()
 */
public interface SmartInitializingSingleton {

	/**
	 * 在单例预实例化阶段结束时调用，
	 * 保证已创建所有常规单例 bean
	 * 已经。 {@link ListableBeanFactory#getBeansOfType} 调用
	 * 此方法不会在引导过程中触发意外的副作用。
	 * <p><b>注意：</b> 不会为单例 bean 触发此回调
	 * 在 {@link BeanFactory} 引导后按需延迟初始化，
	 * 也不适用于任何其他 bean 范围。 小心将其用于豆类
	 * 仅具有预期的引导语义。
	 */
	void afterSingletonsInstantiated();

}
