/*
Copyright 2012 Selenium committers
Copyright 2012 Software Freedom Conservancy

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/


package org.openqa.selenium.lift.match;

import org.openqa.selenium.WebElement;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Matches the value of an element, for example an input field.
 */
public class ValueMatcher extends TypeSafeMatcher<WebElement> {

  private final Object value;

  public ValueMatcher(Object value) {
    this.value = value;
  }

  @Override
  public boolean matchesSafely(WebElement item) {
    return item.getAttribute("value").equals(value);
  }

  public void describeTo(Description description) {
    description.appendText("should have value ").appendValue(value);
  }

  @Factory
  public static Matcher<WebElement> value(final Object value) {
    return new ValueMatcher(value);
  }
}
