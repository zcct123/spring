/*
 * Copyright 2002-2018 the original author or authors.
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

package org.springframework.validation;

/**
 * 应用程序特定对象的验证器。
 * <p>这个界面完全脱离了任何基础设施或上下文；
 * 也就是说，它不只验证 Web 层、数据访问层或任何层中的对象。
 * 因此，它适用于应用程序的任何层，并支持封装验证逻辑作为一等公民。
 * <p>在下面找到一个简单但完整的 {@code Validator} 实现，
 * 它验证 {@code UserLogin} 实例的各种 {@link String}
 * 属性不为空（即它们不是 {@code null} 和不完全由空格组成），
 * 并且存在的任何密码的长度至少为 {@code 'MINIMUM_PASSWORD_LENGTH'} 个字符
 *
 * <pre class="code"> public class UserLoginValidator implements Validator {
 *
 *    private static final int MINIMUM_PASSWORD_LENGTH = 6;
 *
 *    public boolean supports(Class clazz) {
 *       return UserLogin.class.isAssignableFrom(clazz);
 *    }
 *
 *    public void validate(Object target, Errors errors) {
 *       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "field.required");
 *       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required");
 *       UserLogin login = (UserLogin) target;
 *       if (login.getPassword() != null
 *             && login.getPassword().trim().length() < MINIMUM_PASSWORD_LENGTH) {
 *          errors.rejectValue("password", "field.min.length",
 *                new Object[]{Integer.valueOf(MINIMUM_PASSWORD_LENGTH)},
 *                "The password must be at least [" + MINIMUM_PASSWORD_LENGTH + "] characters in length.");
 *       }
 *    }
 * }</pre>
 *
 * <p>See also the Spring reference manual for a fuller discussion of
 * the {@code Validator} interface and its role in an enterprise
 * application.
 *
 * @author Rod Johnson
 * @see SmartValidator
 * @see Errors
 * @see ValidationUtils
 */
public interface Validator {

	/**
	 * 这个 {@link Validator} {@link validate(Object, Errors) 可以验证所提供的 {@code clazz} 的实例吗？
	 * <p>这个方法<i>通常<i>是这样实现的
	 * ：<pre class="code">return Foo.class.isAssignableFrom(clazz);<pre>
	 *     （其中{@code Foo}是类（或实际对象实例的超类）
	 *     {@link validate(Object, Errors) 验证}。）
	 *     @param clazz {@link 类}，该 {@link Validator}
	 *     被询问是否可以{@link 验证(Object, Errors) validate}
	 *     @return {@code true} 如果这个 {@link Validator}
	 *     确实可以 {@link validate(Object, Errors) validate} 提供的 {@code clazz} 实例
	 */
	boolean supports(Class<?> clazz);

	/**
	 * Validate the supplied {@code target} object, which must be
	 * of a {@link Class} for which the {@link #supports(Class)} method
	 * typically has (or would) return {@code true}.
	 * <p>The supplied {@link Errors errors} instance can be used to report
	 * any resulting validation errors.
	 * @param target the object that is to be validated
	 * @param errors contextual state about the validation process
	 * @see ValidationUtils
	 */
	void validate(Object target, Errors errors);

}
