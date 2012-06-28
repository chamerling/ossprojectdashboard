/**
 * 
 */
package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

/**
 * @author chamerling
 * 
 */
@Entity
public class News extends Model {

	@Required
	public String title;

	@Required
	public Date date;

	@Required
	public String description;

	public String link;

	@ManyToOne
	public Project project;

}
