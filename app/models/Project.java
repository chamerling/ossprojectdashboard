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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.data.validation.Required;
import play.db.jpa.Model;

/**
 * @author chamerling
 * 
 */
@Entity
public class Project extends Model {

	/* Standard information */

	@Required
	public String name;

	public String homepage;

	public String logoURL;

	@Lob
	public String description;

	@Required
	@ManyToOne
	public Licence licence;

	@ManyToOne
	public Category category;

	@ManyToMany(cascade = CascadeType.PERSIST)
	public Set<Tag> tags;

	@ManyToMany(cascade = CascadeType.PERSIST)
	public Set<Standard> standards;

	@Required
	@ManyToOne
	public Status status;
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    public List<News> news;
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    public List<ReleaseNote> notes;
	
	public Date since;

	/* SOCIAL INFORMATION */
	/**
	 * Twitter id
	 */
	public String twitter;

	/**
	 * A public RSS url so we can fetch news...
	 */
	public String rssURL;

	/* Forge information */
	/**
	 * Continuous integration URL
	 */
	public String ciURL;

	/**
	 * public SCM url since we focus on open source products
	 */
	public String scmURL;
	
	public String bugtrackerURL;

	/* Third party tools */
	/**
	 * If the project is on OHLOH, we will get data from this service...
	 */
	public String ohlohId;

	public String mailingList;

	public Project() {
		this.tags = new HashSet<Tag>();
		this.standards = new HashSet<Standard>();
	}

	public static Project findByName(String name) {
		return Project.find("name", name).first();
	}

	public static List<Project> findTaggedWith(String tag) {
		return Project
				.find("select distinct p from Project p join p.tags as t where t.name = ?",
						tag).fetch();
	}

	public static List<Project> findStandardIs(String standard) {
		return Project
				.find("select distinct p from Project p join p.standards as s where s.name = ?",
						standard).fetch();
	}

	public static List<Project> findCategoryIs(String category) {
		return Project
				.find("select distinct p from Project p join p.category as c where c.name = ?",
						category).fetch();
	}

	public Project tagItWith(String name) {
		tags.add(Tag.findOrCreateByName(name));
		return this;
	}

	@Override
	public String toString() {
		return name;
	}

}
