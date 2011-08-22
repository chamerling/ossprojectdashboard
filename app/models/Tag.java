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
package models;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Model;

/**
 * @author chamerling
 * 
 */
@Entity
public class Tag extends Model implements Comparable<Tag> {

	@Required
	public String name;

	private Tag(String name) {
		this.name = name;
	}

	public static Tag findOrCreateByName(String name) {
		Tag tag = Tag.find("byName", name).first();
		if (tag == null) {
			tag = new Tag(name);
		}
		return tag;
	}

	public static List<Map> getCloud() {
		List<Map> result = Tag
				.find("select new map(t.name as tag, count(p.id) as pound) from Project p join p.tags as t group by t.name")
				.fetch();
		return result;
	}

	public String toString() {
		return name;
	}

	public int compareTo(Tag otherTag) {
		return name.compareTo(otherTag.name);
	}

	public static Tag findByName(String name) {
		return Tag.find("byName", name).first();
	}
	
	

}
