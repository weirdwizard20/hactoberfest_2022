package hotel;

import java.io.*;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;


/**
 *
 * @author Avik
 */

@WebServlet(name = "Room_Management", urlPatterns = {"/Room_Management"})
public class Room_Management extends HttpServlet
{
    
    static ArrayList std_name=new ArrayList();
    static ArrayList std_id=new ArrayList();
    static ArrayList std_pwd=new ArrayList();
    static ArrayList room=new ArrayList();

    String name,id,pwd,room_id,room_type,room_loc,room_price;
    static String chng,user;
    static int f,n,d,sg,rmchk;
    static String err="<html>\n" +
"	<head>\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"		<title>Student Login Error Page</title>\n" +
"		<link rel=\"stylesheet\" type=\"text/css\" href=\"signup_style.css\">  \n" +
"	</head>\n" +
"\n" +
"	<body>\n" +
"\n" +
"                <script>";
    
    public void sign_up(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        
        name = req.getParameter("name");
        id= req.getParameter("std_id");
        pwd= req.getParameter("pwd");
        int chk=0;
        for(int i=0;i<std_id.size();i++)
        {
            if(id.equals(std_id.get(i)))
            {
                chk=1;
                break;
            }
        }
        if(chk==0)
        {
            sg=1;
            pw.println(err);
                pw.println("alert(\"Account with this student id created succesfully.\");\n" +
"\n" +
"                    location.replace(\"login.html\");\n" +
"\n" +
"                </script>\n" +
"\n" +
"\n" +
"\n" +
"	</body>\n" +
"</html>");
        }
        else
        {
            pw.println(err);
                pw.println("alert(\"Account with this student id already exists.\");\n" +
"\n" +
"                    location.replace(\"login.html\");\n" +
"\n" +
"                </script>\n" +
"\n" +
"\n" +
"\n" +
"	</body>\n" +
"</html>");
        }
    }
    
    
    public void student_room(HttpServletRequest req, HttpServletResponse res,String s) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html>\n" +
"	<head>\n" +
"		<title>Student Room Page</title>\n" +
"		<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">  \n" +
"               <link rel=\"stylesheet\" type=\"text/css\" href=\"dropdown.css\">\n" +
"               <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"	</head>\n" +
"        \n" +
"	<body>\n" +
"\n" +
                "<div id=\"signup_header\" style=\"line-height: 60px; font-size: 40px; margin-top: 0px; padding-left: 30px; background-color:#af7762 ;\">\n" +
"			Student Room Details\n" +
"		</div>"+
"                <div class=\"navbar\"> \n" +
"			<a href=\"home.html\">Home</a> \n" +
"                        <a href=\"#\"><form action=\"Room_Management\" method=\"POST\"><button type=\"submit\" style=\"color: white; background-color: #333; margin-top: 3px;\"  value=\"chk room\" name=\"submit\">Available Room</button> </form></a>\n" +
"			<a href=\"#contact\">Contact Us</a>  \n" +
"                        <a href=\"login.html\">Log Out</a> \n" +
"		</div> \n" +
"         \n" +
"        <br> \n" +
" \n" +
                
                                "<div id=\"profile\" style=\"width: 100px; height: 80px; margin-top: 15px; margin-left: 5%; border-radius: 25px;\">\n" +
"			\n" +
"		</div>"+
"			<p style=\"color: white; margin-left: 5%;\">User: "+user+
                        "<br>(Looged In)</p>\n"+
"\n" +

                                
"         \n" +
"\n" +
" \n" +
"		<table id=\"customers\" style=\"width: 450px;  margin-top: 45px; margin-left: 35%; padding-top: 10px; padding-left: 16px; \n" +
"        background-color:black; opacity: 0.8;\"> \n" +
"			<tr> \n" +
"			  <th>Id</th> \n" +
"			  <th>Type</th> \n" +
"			  <th>Location</th> \n" +
"			  <th>Price</th> \n" +
"			  <th>Payment</th>\n" +
"			  <th>Checked</th>");
        
        
                for(int i=0;i<room.size();)
                {
                    if(room.get(i+4).equals(s))
                    {
                    
                        pw.println("			</tr>\n" +
    "			<tr>\n" +
    "			  <td>"+room.get(i)+"</td>\n" +
    "			  <td>"+room.get(i+1)+"</td>\n" +
    "			  <td>"+room.get(i+2)+"</td>\n" +
    "			  <td>"+room.get(i+3)+"</td>\n" +
    "			  <td>Not Paid</td>\n" +
    "                     <td><form action=\"Room_Management\" method=\"POST\"><button type=\"submit\"  value=\"check out "+room.get(i)+"\" name=\"submit\">Check Out</button></form></td>\n" +
    "			</tr>\n" +
    "\n" +
    "\n" );
                        
                    }
                    
                        i=i+5;
                }

                    pw.println("</table>\n" +
    "\n" +
    "\n" +
    "\n" +
    "\n" +
    "	</body>\n" +
    "</html>");
    }
    
    public void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        
        
            String id= req.getParameter("std_id");
            String pwd= req.getParameter("pwd");
            int c=0;
            for(int i=0;i<std_id.size();i++)
            {
                if(id.equals(std_id.get(i)))  
                {
                    c=2;
                    if(pwd.equals(std_pwd.get(i)))
                    {
                        c=1;
                        chng="";
                        chng="Booked by Id : "+id;
                        
                        user=id;

                        student_room(req,res,"Booked by Id : "+id);
                    }
                }
            }
            if(c==0)
            {
                pw.println(err);
                pw.println("alert(\"Account with this student id does not exists.\");\n" +
"\n" +
"                    location.replace(\"login.html\");\n" +
"\n" +
"                </script>\n" +
"\n" +
"\n" +
"\n" +
"	</body>\n" +
"</html>");
                
            }
            else if(c==2)
            {
                pw.println(err);
                pw.println("alert(\"Invalid Password.\");\n" +
"\n" +
"                    location.replace(\"login.html\");\n" +
"\n" +
"                </script>\n" +
"\n" +
"\n" +
"\n" +
"	</body>\n" +
"</html>");
            }
    }
    
    public void admin_room(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html>\n" +
"	<head>\n" +
"        \n" +
"		<title>Room Control Page</title>\n" +
"		<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">  \n" +
"                <link rel=\"stylesheet\" type=\"text/css\" href=\"dropdown.css\">\n" +
"                <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"	</head>\n" +
"\n" +
"	<body>\n" +
"\n" +
"\n" +
"                <div class=\"navbar\">\n" +
"			<a href=\"home.html\">Home</a>\n" +
"			<a href=\"insert_room.html\">Insert Room</a>\n" +
"			<a href=\"contact.html\">Contact Us</a> \n" +
"                        <a href=\"admin.html\">Log Out</a>\n" +
"		</div>\n" +
"        \n" +
"        <br>\n" +
"\n" +
"        <h1 style=\"margin-left: 40%; Color: black;\">Room Details</h1>\n" +
"        \n" +
"\n" +
"\n" +
"		<table id=\"customers\" style=\"width: 620px;  margin-top: 65px; margin-left: 30%; padding-top: 10px; padding-left: 16px;\n" +
"        background-color:black; opacity: 0.8;\">\n" +
"			<tr>\n" +
"			  <th>Id</th>\n" +
"			  <th>Type</th>\n" +
"			  <th>Location</th>\n" +
"			  <th>Price</th>\n" +
"			  <th>Status</th>\n" +
"			  <th>Payment</th>\n"+
"			  <th>Edit</th>\n"+
"			  <th>Remove</th>\n");
            
                
                int j=0;
                for(int i=0;i<room.size();)
                {
                    pw.println("			</tr>\n" +
"			<tr>\n" +
"			  <td>"+room.get(i)+"</td>\n" +
"			  <td>"+room.get(i+1)+"</td>\n" +
"			  <td>"+room.get(i+2)+"</td>\n" +
"			  <td>"+room.get(i+3)+"</td>\n" +
"			  <td>"+room.get(i+4)+"</td>\n" +
"			  <td>Not Paid</td>\n" +
"                         <td><form action=\"Room_Management\" method=\"POST\"><button type=\"submit\" id=\"ud\" value=\"u"+j+"\" name=\"submit\">Update</button></form></td>\n" +
"			  <td><form action=\"Room_Management\" method=\"POST\"><button type=\"submit\" id=\"ud\" value=\"d"+j+"\" name=\"submit\">Delete</button></form></td>\n" +
"			</tr>\n" +
"\n" +
"\n" );
                    j++;
                    i=i+5;
                }
                
                pw.println("</table>\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"	</body>\n" +
"</html>");
    }
    
    public void admin_login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        
        
        

            String usr= req.getParameter("usr");
            String pwd= req.getParameter("pwd");

            if(usr.equalsIgnoreCase("admin"))
            {
                if(pwd.equals("12345"))
                {
                    admin_room(req,res);
                }
                else
                {
                    pw.println(err);
                pw.println("alert(\"Invalid Password.\");\n" +
"\n" +
"                    location.replace(\"admin.html\");\n" +
"\n" +
"                </script>\n" +
"\n" +
"\n" +
"\n" +
"	</body>\n" +
"</html>");
                }
            }
            else
            {
                pw.println(err);
                pw.println("alert(\"Please enter username as admin.\");\n" +
"\n" +
"                    location.replace(\"admin.html\");\n" +
"\n" +
"                </script>\n" +
"\n" +
"\n" +
"\n" +
"	</body>\n" +
"</html>");
            }
        
        
        
    }
    
    public void room_create(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        
        room_id = req.getParameter("room_id");
        room_type= req.getParameter("room_type");
        room_loc= req.getParameter("room_loc");
        room_price= req.getParameter("room_price");
        int chk=0;
        for(int i=0;i<room.size();i=i+5)
        {
            if(room_id.equals(room.get(i)))
            {
                chk=1;
                break;
            }
        }
        if(chk==0)
        {
            rmchk=1;
        }
        else
        {
            pw.println(err);
                pw.println("alert(\"Room Id already exists.\");\n" +
"\n" +
"                    location.replace(\"insert_room.html\");\n" +
"\n" +
"                </script>\n" +
"\n" +
"\n" +
"\n" +
"	</body>\n" +
"</html>");
        }
        
    }
    
    public void admin_room_delete(HttpServletRequest req, HttpServletResponse res, int n) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        
        if(room.get((n*5)+4).equals("Available"))
        {
            for(int i=0;i<5;i++)
            {
                room.remove(n*5);
            }
            
            
            admin_room(req,res);
        }
        else
        {
            pw.println("\n" +
"<html>\n" +
"	<head>\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"		<title>Delete Error</title>\n" +
"		<link rel=\"stylesheet\" type=\"text/css\" href=\"signup_style.css\">  \n" +
"	</head>\n" +
"\n" +
"	<body>\n" +
"\n" +
"                <script>\n" +
"            \n" +
"                    alert(\"Room is assigned. Hence, cannot be deleted.\");\n" +
"\n" +
"                </script>\n" +
"\n" +
"\n" +
"\n" +
"	</body>\n" +
"</html>\n" +
"\n" +
"\n" +
"\n" +
"");
            
            
            admin_room(req,res);
        }
        
        
        
    }
    
    public void admin_room_update(HttpServletRequest req, HttpServletResponse res, int n) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
  
                       
        pw.println("\n" +
"<html>\n" +
"	<head>\n" +
"        \n" +
"		<title>Room Update Page</title>\n" +
"		<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">  \n" +
"                <link rel=\"stylesheet\" type=\"text/css\" href=\"dropdown.css\">\n" +
"                <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"	</head>\n" +
"\n" +
"	<body>\n" +
"\n" +
"\n" +
"        <div class=\"navbar\">\n" +
"			<a href=\"home.html\">Home</a>\n" +
"			<a href=\"insert.html\">Insert Room</a>\n" +
"                       <a href=\"#\"><form action=\"Room_Management\" method=\"POST\"><button type=\"submit\" name=\"submit\" style=\"color: white; background-color: #333; margin-top: 3px;\" value=\"cancel\" >All Room Details</button></form></a>"+
"			<a href=\"contact.html\">Contact Us</a> \n" +
"            <a href=\"admin.html\">Log Out</a>\n" +
"		</div>\n" +
"        \n" +
"        <br>\n" +
"\n" +
"        \n" +
"\n" +
"\n" +
"		<div id=\"signin\" style=\"width: 370px;  margin-top: 65px; margin-left: 40%; padding-top: 10px; padding-left: 16px;\n" +
"        background-color:black; opacity: 0.8;\">\n" +
"\n" +
"\n" +
"			<form action=\"Room_Management\" method=\"post\">\n" +
"\n" +
"				<h1 style=\"margin-left: 25%; color: white;\">Update Room</h1>\n" +
"				<br>\n" +
"				\n" +
"				<input type=\"number\" value=\""+room.get(n*5)+"\" id=\"room_id\" name=\"room_id\" required disabled >\n" +
"				<br><br>\n" +
"\n" +
"                                <select id=\"room_type\" name=\"room_type\" style=\"width: 90%; height: 7%;\" required >\n" +
"                                    \n" +
"						<option value=\"\" disabled selected hidden>Room Type*</option>\n" +
"						<option>Single</option>\n" +
"						<option>Double</option>\n" +
"						<option>Deluxe</option>\n" +
"						<option>Singlex</option>\n" +
"				</select>\n" +
"				<br><br>\n" +
"\n" +
"                                <select id=\"room_loc\" name=\"room_loc\" style=\"width: 90%; height: 7%;\" required >\n" +
"						\n" +
"                                                <option value=\"\" disabled selected hidden>Room Location*</option>\n" +
"						<option>1st Floor</option>\n" +
"						<option>2nd Floor</option>\n" +
"						<option>3rd Floor</option>\n" +
"						<option>4th Floor</option>\n" +
"				</select>\n" +
"				<br><br>\n" +
"\n" +
"                                <input type=\"number\" id=\"room_price\" name=\"room_price\" required placeholder=\"Room Price*\" >\n" +
"				<br><br>\n" +
"				  \n" +
"			  \n" +
"				<div class=\"clearfix\">\n" +
"					<button type=\"submit\" value=\"edit\" class=\"signupbtn\" id=\"sub\" name=\"submit\">Update</button>\n" +
"				</div>\n" +
"\n" +
"			</form>\n" +
"                    \n" +
"                </div>\n" +
"\n" +
"	</body>\n" +
"</html>");
        
        
        
    }
    
    public void student_room_available(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html>\n" +
"	<head>\n" +
"        \n" +
"		<title>Student Room Available Page</title>\n" +
"		<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">  \n" +
"                <link rel=\"stylesheet\" type=\"text/css\" href=\"dropdown.css\">\n" +
"                <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"	</head>\n" +
"\n" +
"	<body>\n" +
"\n" +
                "<div id=\"signup_header\" style=\"line-height: 60px; font-size: 40px; margin-top: 0px; padding-left: 30px; background-color:#af7762 ;\">\n" +
"			Rooms Available\n" +
"		</div>"+
"\n" +
"                <div class=\"navbar\">\n" +
"			<a href=\"home.html\">Home</a>\n" +
"                        <a href=\"#\"><form action=\"Room_Management\" method=\"POST\"><button type=\"submit\" name=\"submit\" style=\"color: white; background-color: #333; margin-top: 3px;\" value=\"student_cancel\" >Current Room Details</button></form></a>"+
"			<a href=\"contact.html\">Contact Us</a> \n" +
"                        <a href=\"login.html\">Log Out</a>\n" +
"		</div>\n" +
"        \n" +
"        <br>\n" +
"\n" +
"               <div id=\"profile\" style=\"width: 100px; height: 80px; margin-top: 15px; margin-left: 5%; border-radius: 25px;\">\n" +
"			\n" +
"		</div>"+
"			<p style=\"color: white; margin-left: 5%;\">User: "+user+
                        "<br>(Looged In)</p>\n"+
"\n" +

"\n" +
"\n" +
"		<table id=\"customers\" style=\"width: 550px;  margin-top: 45px; margin-left: 30%; padding-top: 10px; padding-left: 16px;\n" +
"        background-color:black; opacity: 0.8;\">\n" +
"			<tr>\n" +
"			  <th>Id</th>\n" +
"			  <th>Type</th>\n" +
"			  <th>Location</th>\n" +
"			  <th>Price</th>\n" +
"			  <th>Status</th>\n" +
"			  <th>Payment</th>\n"+
"			  <th>Checked</th>\n");
            
                
                int j=0;
                for(int i=0;i<room.size();)
                {
                    if(room.get(i+4).equals("Available"))
                    {
                    pw.println("			</tr>\n" +
"			<tr>\n" +
"			  <td>"+room.get(i)+"</td>\n" +
"			  <td>"+room.get(i+1)+"</td>\n" +
"			  <td>"+room.get(i+2)+"</td>\n" +
"			  <td>"+room.get(i+3)+"</td>\n" +
"			  <td>"+room.get(i+4)+"</td>\n" +
"			  <td>Not Paid</td>\n" +
"                         <td><form action=\"Room_Management\" method=\"POST\"><button type=\"submit\" value=\"check in"+j+"\" name=\"submit\">Check In</button></form></td>\n" +			  
"			</tr>\n" +
"\n" +
"\n" );
                    
                    }
                    j++;
                    i=i+5;
                }
                
                pw.println("</table>\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"	</body>\n" +
"</html>");
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
    {
        
        Room_Management ob=new Room_Management();        
        
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        
        String chk_btn=req.getParameter("submit");        
        
        if(chk_btn.equals("Sign Up"))
        {            
            ob.sign_up(req, res);
            
            if(sg==1)
            {
            
                std_name.add(ob.name);
                std_id.add(ob.id);
                std_pwd.add(ob.pwd);
                
                sg=0;
            }
        }
        
        else if(chk_btn.equals("Login"))
        {
            ob.login(req, res);
        }
        
        else if(chk_btn.equals("Admin Login"))
        {
            ob.admin_login(req, res);
        }
        
        else if(chk_btn.equals("Create"))
        {
            ob.room_create(req, res);
            
            if(rmchk==1)
            {
            
                room.add(ob.room_id);
                room.add(ob.room_type);
                room.add(ob.room_loc);
                room.add(ob.room_price);
                room.add("Available");
                
                rmchk=0;
                ob.admin_room(req,res);
            }
        }
        
        else if(chk_btn.startsWith("d"))
        {
            String s=chk_btn.substring(1);

            d=Integer.parseInt(s);
            ob.admin_room_delete(req, res,d);
        }
        
        else if(chk_btn.startsWith("u"))
        {
            String s=chk_btn.substring(1);
            n=Integer.parseInt(s);
            ob.admin_room_update(req, res,n);
        }
        
        else if(chk_btn.equals("edit"))
        {
            room_type= req.getParameter("room_type");
            room_loc= req.getParameter("room_loc");
            room_price= req.getParameter("room_price");
            
            room.set((n*5)+1, room_type);
            room.set((n*5)+2, room_loc);
            room.set((n*5)+3, room_price);

            ob.admin_room(req,res);
        }
        
        else if(chk_btn.equals("chk room"))
        {
            ob.student_room_available(req, res);
        }
        
        else if(chk_btn.startsWith("check in"))
        {
            String s=chk_btn.substring(8);
            int n=Integer.parseInt(s);
            
            room.set((n*5)+4, chng);
            ob.student_room(req, res,chng);
        }
        
        else if(chk_btn.startsWith("check out"))
        {
            String s=chk_btn.substring(10);
            
            for(int i=0;i<room.size();i=i+5)
            {
                if(s.equals(room.get(i)))
                {
                        
                    room.set(i+4, "Available");
                    ob.student_room(req, res,chng);
                }
            }
            
        }
        
        else if(chk_btn.equals("cancel"))
        {
            ob.admin_room(req, res);
        }
        
        else if(chk_btn.equals("student_cancel"))
        {
            ob.student_room(req, res,chng);
        }
        
        pw.close();
    }
}
