/**
 * 
 */
package controllers;

import models.News;
import models.ReleaseNote;
import play.mvc.With;

/**
 * @author chamerling
 * 
 */
@CRUD.For(ReleaseNote.class)
@With(Secure.class)
public class AdminReleaseNotes extends CRUD {

}
