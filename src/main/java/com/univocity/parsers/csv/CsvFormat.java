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
package com.univocity.parsers.csv;

import com.univocity.parsers.common.*;

/**
 * The CSV format configuration. In addition to the default configuration in {@link Format}, the CSV format defines:
 *
 * <ul>
 *  <li><b>delimiter <i>(defaults to ',')</i>: </b> the field delimiter character. Used to separate individual fields in a CSV record (where the record is usually a line of text with multiple fields).
 *  	<p>e.g. the value  a , b  is parsed as [ a ][ b ]</li>
 *  <li><b>quote <i>(defaults to '"')</i>:</b> character used for escaping values where the field delimiter is part of the value.
 *  	<p>e.g. the value " a , b " is parsed as [ a , b ] (instead of [ a ][ b ]</li>
 *  <li><b>quoteEscape  <i>(defaults to '"')</i>:</b> character used for escaping the quote character inside an already quoted value
 *  	<p>e.g. the value " "" a , b "" " is parsed as [ " a , b " ]  (instead of [ " a ][ b " ] or [ "" a , b "" ])</li>
 * </ul>
 *
 * @see com.univocity.parsers.common.Format
 *
 * @author uniVocity Software Pty Ltd - <a href="mailto:parsers@univocity.com">parsers@univocity.com</a>
 *
 */
public class CsvFormat extends Format {
	private char quote = '"';
	private char quoteEscape = '"';
	private char delimiter = ',';

	/**
	 * Returns the character used for escaping values where the field delimiter is part of the value. Defaults to '"'
	 * @return the quote character
	 */
	public char getQuote() {
		return quote;
	}

	/**
	 * Defines the character used for escaping values where the field delimiter is part of the value. Defaults to '"'
	 * @param quote the quote character
	 */
	public void setQuote(char quote) {
		this.quote = quote;
	}

	/**
	 * Identifies whether or not a given character is used for escaping values where the field delimiter is part of the value
	 * @param ch the character to be verified
	 * @return true if the given character is the character used for escaping values, false otherwise
	 */
	public boolean isQuote(char ch) {
		return this.quote == ch;
	}

	/**
	 * Returns the character used for escaping quotes inside an already quoted value. Defaults to '"'
	 * @return the quote escape character
	 */
	public char getQuoteEscape() {
		return quoteEscape;
	}

	/**
	 * Defines the character used for escaping quotes inside an already quoted value. Defaults to '"'
	 * @param quoteEscape the quote escape character
	 */
	public void setQuoteEscape(char quoteEscape) {
		this.quoteEscape = quoteEscape;
	}

	/**
	 * Identifies whether or not a given character is used for escaping quotes inside an already quoted value.
	 * @param ch the character to be verified
	 * @return true if the given character is the quote escape character, false otherwise
	 */
	public boolean isQuoteEscape(char ch) {
		return this.quoteEscape == ch;
	}

	/**
	 * Returns the field delimiter character. Defaults to ','
	 * @return the field delimiter character
	 */
	public char getDelimiter() {
		return delimiter;
	}

	/**
	 * Defines the field delimiter character. Defaults to ','
	 * @param delimiter the field delimiter character
	 */
	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}

	/**
	 * Identifies whether or not a given character represents a field delimiter
	 * @param ch the character to be verified
	 * @return true if the given character is the field delimiter character, false otherwise
	 */
	public boolean isDelimiter(char ch) {
		return this.delimiter == ch;
	}
}
