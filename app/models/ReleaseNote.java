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
public class ReleaseNote extends Model {

	@Required
	public String title;

	@Required
	public String version;

	@Required
	public Date date;

	@Required
	public String description;

	@Required
	public String downloadURL;

	@ManyToOne
	public Project project;
}
