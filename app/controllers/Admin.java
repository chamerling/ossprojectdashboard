package controllers;

import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Admin extends Controller {

}
