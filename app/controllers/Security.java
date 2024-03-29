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

import play.Play;

/**
 * @author chamerling
 * 
 */
public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
        return username.equals(Play.configuration.getProperty("secure.admin.username"))
                && password.equals(Play.configuration.getProperty("secure.admin.password"));
    }

    static boolean check(String profile) {
        if (profile.equals("Admin")) {
            return session.get("username").equals(Play.configuration.getProperty("secure.admin.username"));
        }
        return false;
    }
}
