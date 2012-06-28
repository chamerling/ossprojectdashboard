/**
 * 
 */
package controllers;

import models.News;
import play.mvc.With;

/**
 * @author chamerling
 * 
 */
@CRUD.For(News.class)
@With(Secure.class)
public class AdminNews extends CRUD {

}
