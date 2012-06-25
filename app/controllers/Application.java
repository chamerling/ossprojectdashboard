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

import java.util.List;

import models.Category;
import models.Project;
import models.Status;
import models.Tag;
import play.mvc.Controller;

public class Application extends Controller {

	public static void index() {
		List<Project> projects = Project.findAll();
		List<Tag> tags = Tag.findAll();
		List<Category> categories = Category.findAll();
		List<Status> status = Status.findAll();
		render(projects, tags, categories, status);
	}

	public static void project(String name) {
		Project project = Project.findByName(name);
		render(project);
	}

	public static void listTagged(String name) {
		List<Project> projects = Project.findTaggedWith(name);
		Tag tag = Tag.findByName(name);
		render(tag, projects);
	}

	public static void listCategory(String name) {
		List<Project> projects = Project.findCategoryIs(name);
		Category category = Category.findByName(name);
		render(category, projects);
	}

	public static void listStatus(Long id) {
		List<Project> projects = Project.find("status.id", id).fetch();
		Status status = Status.findById(id);
		render(status, projects);
	}
	
	public static void newsFeed() {
		request.format = "rss";
    	//List<News> news = News.allByDate();
    	response.setContentTypeIfNotSet("application/rss+xml");
    	render();
	}

	public static void about() {
		render();
	}

}