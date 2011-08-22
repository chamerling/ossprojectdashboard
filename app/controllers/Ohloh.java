/**
 * Copyright 2011 Christophe Hamerling
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package controllers;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import play.libs.WS;
import play.libs.WS.HttpResponse;
import play.libs.XPath;
import play.mvc.Controller;

/**
 * @author chamerling
 *
 */
public class Ohloh extends Controller {

	
	/**
	 * Get some stats about the given ohloh id from the ohloh.com service
	 * 
	 * @param id
	 */
	public static void getStats(String id) {
		//HttpResponse response = WS.url("http://www.ohloh.net/p/%s.xml?api_key=Md9cZL7rCCr1jCnOK1jP3Q", id).get();
		//Document doc = response.getXml();
		//render(doc);
	}
}