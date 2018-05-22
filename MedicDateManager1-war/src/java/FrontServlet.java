/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author forjaser
 */
@WebServlet(urlPatterns = {"/FrontServlet"})
public class FrontServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try {
            FrontCommand command = getCommand(req);
            command.init(getServletContext(),req,resp);
            command.process();
        } catch (Exception ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private FrontCommand getCommand(HttpServletRequest req) throws Exception{
        try {
            Class type = Class.forName(req.getParameter("command"));
            return (FrontCommand) type.asSubclass(FrontCommand.class).newInstance();
        } catch (Exception e) {
            return new UnknownCommand();
        }
    }
}

