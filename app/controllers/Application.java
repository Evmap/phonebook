package controllers;

import java.util.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;


import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import views.html.*;

import models.Record;

public class Application extends Controller {
  static Form<Record> recordForm = form(Record.class);

  public Result index() {
    return redirect(routes.Application.records());
  }

  public Result records() {
    return ok(views.html.index.render(Record.all(), recordForm));
  }

  public Result newrecord() {
    Form<Record> filledForm = recordForm.bindFromRequest();
    if (filledForm.hasErrors()) {
      return badRequest(
              views.html.index.render(Record.all(), filledForm)
      );
    } else {
      Record.create(filledForm.get());
      return redirect(routes.Application.records());
    }
  }

    public Result deleterecord(Long id) {
      Record.delete(id);
    return redirect(routes.Application.records());
  }



}



