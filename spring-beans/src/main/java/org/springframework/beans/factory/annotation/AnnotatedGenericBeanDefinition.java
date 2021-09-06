/*
 * Copyright 2002-2019 the original author or authors.
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

package org.springframework.beans.factory.annotation;

import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.type.*;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

/**
 * Extension of the {@link org.springframework.beans.factory.support.GenericBeanDefinition}
 * class, adding support for annotation metadata exposed through the  //类中公开的注释元数据的支持
 * {@link AnnotatedBeanDefinition} interface.
 *
 * <p>This GenericBeanDefinition variant is mainly useful for testing code that expects
 * to operate on an AnnotatedBeanDefinition, for example strategy implementations 操作AnnotatedBeanDefinition，例如策略实现
 * in Spring's component scanning support (where the default definition class is  在Spring的组件扫描支持中(默认定义类所在的位置)
 * {@link org.springframework.context.annotation.ScannedGenericBeanDefinition},
 * which also implements the AnnotatedBeanDefinition interface).  它也实现了AnnotatedBeanDefinition接口
 *
 * @author Juergen Hoeller
 * @author Chris Beams
 * @since 2.5
 * @see AnnotatedBeanDefinition#getMetadata()
 * @see org.springframework.core.type.StandardAnnotationMetadata
 */
@SuppressWarnings("serial")
public class AnnotatedGenericBeanDefinition extends GenericBeanDefinition implements AnnotatedBeanDefinition {

	private final AnnotationMetadata metadata;

	@Nullable
	private MethodMetadata factoryMethodMetadata;


	/**  为给定的bean类创建一个新的AnnotatedGenericBeanDefinition
	 * Create a new AnnotatedGenericBeanDefinition for the given bean class.
	 * @param beanClass the loaded bean class
	 */
	public AnnotatedGenericBeanDefinition(Class<?> beanClass) {
		setBeanClass(beanClass);
						// AnnotationMetadata    注释元数据   introspect(反省 反思) 这一步使用工厂模式创建 AnnotationMetadata
		//  AnnotatedTypeMetadata  对注解元素的封装适配    保存类和注解的基本信息
		this.metadata = AnnotationMetadata.introspect(beanClass);
	}

	/**
	 * Create a new AnnotatedGenericBeanDefinition for the given annotation metadata,
	 * allowing for ASM-based processing and avoidance of early loading of the bean class.
	 * Note that this constructor is functionally equivalent to
	 * {@link org.springframework.context.annotation.ScannedGenericBeanDefinition
	 * ScannedGenericBeanDefinition}, however the semantics of the latter indicate that a
	 * bean was discovered specifically via component-scanning as opposed to other means.
	 * @param metadata the annotation metadata for the bean class in question
	 * @since 3.1.1
	 */
	public AnnotatedGenericBeanDefinition(AnnotationMetadata metadata) {
		Assert.notNull(metadata, "AnnotationMetadata must not be null");
		if (metadata instanceof StandardAnnotationMetadata) {
			setBeanClass(((StandardAnnotationMetadata) metadata).getIntrospectedClass());
		}
		else {
			setBeanClassName(metadata.getClassName());
		}
		this.metadata = metadata;
	}

	/**
	 * Create a new AnnotatedGenericBeanDefinition for the given annotation metadata,
	 * based on an annotated class and a factory method on that class.
	 * @param metadata the annotation metadata for the bean class in question
	 * @param factoryMethodMetadata metadata for the selected factory method
	 * @since 4.1.1
	 */
	public AnnotatedGenericBeanDefinition(AnnotationMetadata metadata, MethodMetadata factoryMethodMetadata) {
		this(metadata);
		Assert.notNull(factoryMethodMetadata, "MethodMetadata must not be null");
		setFactoryMethodName(factoryMethodMetadata.getMethodName());
		this.factoryMethodMetadata = factoryMethodMetadata;
	}


	@Override
	public final AnnotationMetadata getMetadata() {
		return this.metadata;
	}

	@Override
	@Nullable
	public final MethodMetadata getFactoryMethodMetadata() {
		return this.factoryMethodMetadata;
	}

}
