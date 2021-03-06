/*******************************************************************************
 * Copyright 2014 uniVocity Software Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.univocity.parsers.common.processor;

import com.univocity.parsers.common.*;

/**
 *
 * A {@link RowProcessor} implementation for converting rows extracted from any implementation of {@link AbstractParser} into java objects.
 * <p>The class type of the object must contain the annotations provided in {@link com.univocity.parsers.annotations}.
 *
 * <p> For each row processed, a java bean instance of a given class will be created with its fields populated.
 * <p> This instance will then be sent to the {@link BeanProcessor#beanProcessed(Object, ParsingContext)} method, where the user can access it.
 *
 * @see AbstractParser
 * @see RowProcessor
 *
 * @param <T> the annotated class type.
 *
 * @author uniVocity Software Pty Ltd - <a href="mailto:parsers@univocity.com">parsers@univocity.com</a>
 *
 */
public abstract class BeanProcessor<T> extends BeanConversionProcessor<T> implements RowProcessor {

	/**
	 * Creates a processor for java beans of a given type.
	 * @param beanType the class with its attributes mapped to fields of records parsed by an {@link AbstractParser} or written by an {@link AbstractWriter}.
	 */
	public BeanProcessor(Class<T> beanType) {
		super(beanType);
	}

	/**
	 * Converts a parsed row to a java object
	 */
	@Override
	public final void rowProcessed(String[] row, ParsingContext context) {
		T instance = createBean(row, context);
		beanProcessed(instance, context);
	}

	/**
	 * Invoked by the processor after all values of a valid record have been processed and converted into a java object.
	 *
	 * @param bean java object created with the information extracted by the parser for an individual record.
	 * @param context A contextual object with information and controls over the current state of the parsing process
	 */
	public abstract void beanProcessed(T bean, ParsingContext context);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processStarted(ParsingContext context) {
		super.initialize();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processEnded(ParsingContext context) {
	}
}
